#include "smart_ptr.cpp"
#include <iostream>
using namespace std;

int main() {
    int* p{ new int { 42 } };
    smart_ptr<int> sp1{ p };

    cout << "Ref count is " << sp1.ref_count() << endl;	// Ref Count is 1
    {
        smart_ptr<int> sp2{ sp1 };
        cout << "Ref count is " << sp1.ref_count() << endl;	// Ref Count is 2
        cout << "Ref count is " << sp2.ref_count() << endl;	// Ref Count is 2
    }
    cout << "Ref count is " << sp1.ref_count() << endl;	// Ref Count is 1

    smart_ptr<int> sp3;

    cout << "Ref count is " << sp3.ref_count() << endl;	// Ref Count is 0

    sp3 = sp1;

    cout << "Ref count is " << sp1.ref_count() << endl;	// Ref Count is 2
    cout << "Ref count is " << sp3.ref_count() << endl;	// Ref Count is 2

    smart_ptr<int> sp4{ std::move(sp1) };

    cout << *sp4 << " " << *sp3 << endl;        // prints 42 42
   
    try
    {
        cout << *sp1 << endl;
    }
    catch (const null_ptr_exception& e)
    {
        cout << e.what() << endl;
    }                       // throws null_ptr_exception
}