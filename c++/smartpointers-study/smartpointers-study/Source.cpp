//5 For each of the following parts, write a single C++ statement that performs
//the indicated task or write the output that is produced(g and n only).For
//each part, assume that all previous statements have been executed(e.g.,
//	when doing part e, assume the statements you wrote for parts a through d
//	have been executed).
//	a.Create a shared pointer name sp1 and set it equal to a dynamically
//	created cs30 object
//	b.Create a shared pointer sp2 that is created from sp1
//	c.Using sp1 set the section
//	d.Using sp2 set the numstudents
//	e.Create a shared pointer sp3
//	f.Point sp3 to what sp1 points to
//	g.Reference count is _________
//	h.Create a weak pointer w1 initialized to sp1
//	i.Print section using w1
//	j.Print numstudents using sp1
//	k.Create a unique pointer name up1 and set it equal to a dynamically
//	created cs30 object
//	l.Create a unique pointer up2
//	m.Transfer ownership from up1 to up2
//	n.Reference count is _________
//	Write your answers in the space provided on the next page
#include <iostream>
#include <memory>
	using namespace std;
struct cs30 {
	string section;
	int numstudents;
};
int main() {
	shared_ptr<cs30> sp1 = make_shared<cs30>(); // a
	shared_ptr<cs30> sp2(sp1); // b
	cout << "Enter the section : ";
	cin >> sp1->section; // c
	cout << "Enter the number of students: ";
	cin >> sp1->numstudents; // d
	{
		shared_ptr<cs30> sp3; // e
		sp3 = sp1; // f
		cout << "reference count " << sp1.use_count() << endl; // g
	}
	weak_ptr<cs30> w1 = sp1; // h
	cout << "Section " << w1.lock()->section << endl;// i

	cout << "Num Students " << sp1->numstudents << endl; // j
	unique_ptr<cs30> up1 = make_unique<cs30>(); // k
	unique_ptr<cs30> up2; // l
	up1 = std::move(up2); // m
	cout << "reference count " << sp1.use_count() << endl; // n
}