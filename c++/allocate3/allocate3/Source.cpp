#include <iostream>
#include <stdexcept>
using namespace std;
void allocate3(int*& p1, int*& p2, int*& p3) {
	int* temp1 = new int(0);
	int* temp2{}, * temp3{};
	try {
		temp2 = new int(0);
	}
	catch (bad_alloc) {
		delete temp1;
		throw;
	}

	try {
		temp3 = new int(0);
	}
	catch (bad_alloc) {
		delete temp1, temp2;
		throw;
	}
	delete p1, p2, p3;
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
	allocate3(a, b, c); // a�s previous memory is deleted
	cout << *a << *b << *c << endl; // prints 000
	int* x, * y = nullptr, * z = nullptr;
	x = new int(2);
	try {
		// allocating memory for y throws badalloc below
		allocate3(x, y, z);
	}
	catch (bad_alloc) {}
	cout << *x << endl; // prints 2
}