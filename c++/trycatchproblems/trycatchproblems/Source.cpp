#include <iostream>
using namespace std;
class Person {
public:
	Person(const char* name) : m_name(name) {
		cout << m_name << endl;
		throw - 1;
	}
	~Person() {
		cout << "~" << m_name << endl;
	}
private:
	const char* m_name;
};
void funcB() noexcept {
	cout << "1" << endl;
	throw Person("X");
	cout << "2" << endl; return;
}
void funcA() {
	cout << "3" << endl;
	try {
		funcB();
	}
	catch (int) {
		cout << "4" << endl;
	}
	cout << "5" << endl;
}
int main() {
	try {
		funcA();
	}
	catch (int) {
		cout << "6" << endl;
	}
	catch (...) {
		cout << "7" << endl;
	}
	cout << "8" << endl;
	return 0;
}
