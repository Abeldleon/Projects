#include <memory>
#include <iostream>
#include <string>
#include <optional>
using namespace std;

struct FootBallPlayer {
	string name;
	int num;
};

class FootBallRoster {
public:
	// Adds a FootBallPlayer to the roster.
	void addPlayer(FootBallPlayer player) {
		if (!root)
		{
			root = make_shared<FootBallPlayerNode>(player);
		}
		else
		{
            shared_ptr<FootBallPlayerNode> temp = root;
            root = make_shared<FootBallPlayerNode>(player);
            root->next = temp;
		}
	}

	// deletes the first FootBallPlayer that matches name
	bool deletePlayer(string name) {
		weak_ptr<FootBallPlayerNode> Iterator = root;
		if (root)
		{
			if (root->player.name == name)
			{
				root = root->next;
				return true;
			}
		}
		while (Iterator.lock()->next)
		{
			if (Iterator.lock()->next->player.name == name)
			{
				Iterator.lock()->next = Iterator.lock()->next->next;
				return true;
			}
			Iterator.lock() = Iterator.lock()->next;
		}
		return false;
	}

	// Uses a weak_ptr to return true if the 
	bool setFavorite(string name) {
		weak_ptr<FootBallPlayerNode> Iterator = root;
		while (Iterator.lock())
		{
			if (Iterator.lock()->player.name == name)
			{
				favorite = Iterator.lock();
				return true;
			}
			Iterator = Iterator.lock()->next;
		}
        return false;
	}

	// Returns an optional parameter if there is a favorite player
	std::optional<FootBallPlayer> getFavorite() const
	{
		if (favorite.lock())
		{
			return optional<FootBallPlayer>{favorite.lock()->player};
        }
		return nullopt;
	}

	// Prints the list of FootBallPlayers on the roster
	void printPlayers() const {
		weak_ptr<FootBallPlayerNode> Iterator = root;
		while(Iterator.lock())
		{
			cout << Iterator.lock()->player.name << " #" << Iterator.lock()->player.num << endl;
			Iterator = Iterator.lock()->next;
		}
	}
private:

	struct FootBallPlayerNode {
		FootBallPlayer player;
		shared_ptr<FootBallPlayerNode> next;
		FootBallPlayerNode(FootBallPlayer p) : player{ p }, next{ nullptr } {}
	};

	shared_ptr<FootBallPlayerNode> root;
	weak_ptr<FootBallPlayerNode> favorite;
};

// prints out the name of the favorite player or a message 
// stating there is no favorite player.
void favoritePlayer(const FootBallRoster& roster)
{
	if (roster.getFavorite()) {
		cout <<"Your favorite player is " <<  roster.getFavorite()->name << endl;
	}
	else {
		cout << "There is no favorite player" << endl;
	}
}

int main() {

	FootBallPlayer fb1{ "Matthew Stafford", 9 };
	FootBallPlayer fb2{ "Aaron Donald", 99 };
	FootBallPlayer fb3{ "Jalen Ramsey", 5 };

	FootBallRoster roster;

	roster.addPlayer(fb1);
	roster.addPlayer(fb2);
	roster.addPlayer(fb3);

	roster.printPlayers();
	roster.setFavorite("Aaron Donald");

	favoritePlayer(roster);

	roster.deletePlayer("Aaron Donald");
	favoritePlayer(roster);
}