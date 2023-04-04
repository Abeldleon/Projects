#include <iostream>
#include <vector>
#include <string>
#include <utility>
#include <map>
using namespace std;

void printContacts(map<string, vector<pair<string, string>>>& contacts){
	for (map<string, vector<pair<string, string>>>::const_iterator it = contacts.begin(); it != contacts.end(); it++) {
		cout << it->first << endl;
		for (vector<pair<string, string>>::const_iterator it2 = it->second.begin(); it2 != it->second.end(); it2++)
		{
			cout << "\t" << it2->first << " " << it2->second << endl;
		}
	}

	for (pair < string, vector<pair<string, string>>> i : contacts) {
		cout << i.first << endl;
		for (pair<string, string> f : i.second) {
			cout << "\t" << f.first << " " << f.second << endl;
		}
	}
}

int main() {
	map<string, vector<pair<string, string>>> contacts;
	// emplace just pushes the two strings as a pair to the
	// back of the vector. It's similar to push_back.
	contacts["Jerry"].emplace_back("home:", "3104444444");
	contacts["Jerry"].emplace_back("cell:", "2135555555");
	contacts["Sarah"].emplace_back("email:", "s@elco.edu");
	contacts["Sarah"].emplace_back("cell:", "8186666666");

	printContacts(contacts);
}