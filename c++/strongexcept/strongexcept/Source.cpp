#include <iostream>
#include <exception>
using namespace std;
void allocate3(int*& p1, int*& p2, int*& p3)
{
	int* temp1 = nullptr;
	int* temp2 = nullptr;
	int* temp3 = nullptr;

	try {
		temp1 = new int(0);
		temp2 = new int(0);
		temp3 = new int(0);
	}
	catch (bad_alloc) {
		if (temp1 != nullptr) {
			delete temp1;
		}
		if (temp2 != nullptr) {
			delete temp2;
		}
		if (temp3 != nullptr) {
			delete temp3;
		}

		throw;
	}
	delete p1;
	delete p2;
	delete p3;
	p1 = temp1;
	p2 = temp2;
	p3 = temp3;
	temp1 = nullptr;
	temp2 = nullptr;
	temp3 = nullptr;
}


int main() {
	int* a, * b = nullptr, * c = nullptr;
	a = new int(2);
	allocate3(a, b, c); // a’s previous memory is deleted
	//cout << *a << *b << *c << endl; // prints 000
	int* x, * y = nullptr, * z = nullptr;
	x = new int(2);
	try {
		// allocating memory for y throws badalloc below
		allocate3(x, y, z);
	}
	catch (bad_alloc) {}
	cout << *x << endl; // prints 2
	return 0;
}