class MyVector {
	int size;
	double* arr;
public:
	MyVector(int i) { arr = new double[i]; }
	// regular copy constructor
	MyVector(const MyVector& rhs) {
		//cout << "MOVE" << endl;
		size = rhs.size;
		arr = new double[size];
		for (int i = 0; i < size; i++) { arr[i] = rhs.arr[i]; }
	}

	// move copy constructor
	MyVector(MyVector&& rhs)noexcept {
		size = rhs.size;
		arr = rhs.arr;
		rhs.arr = nullptr;  // have to set this to nullptr
	}

	// assignment operator
	MyVector& operator=(const MyVector& rhs) {
		delete[] arr;
		size = rhs.size;
		for (int i = 0; i < size; i++) { arr[i] = rhs.arr[i]; }
		return *this;
	}

	// move assignment operator
	MyVector& operator=(MyVector&& rhs) noexcept{
		delete[] arr;
		size = rhs.size;
		arr = rhs.arr;
		rhs.arr = nullptr;  // have to set this to nullptr
		return *this;
	}

	~MyVector() { delete arr; }
};


void foo(MyVector& arg);

void foo(MyVector&& arg);


MyVector createMyVector() { return MyVector(5); }

// Reference Collapsing Rules (c++11)
// 1) T& &   => T&
// 2) T& &&  => T&
// 3) T&& &  => T&
// 4) T&& && => T&&

template
void relay(T&& arg) {   // Universal Type
	foo(std::forward(arg)); // forward it as lvalue or rvalue
}

int main() {

	MyVector reusable = createMyVector();
	relay(reusable); // relay(lvalue)
	// T = MyVector& => MyVector& && => MyVector &
	// ...
	relay(createMyVector()); // relay(rvalue)
	// T = MyVector => MyVector &&

	int x = 27;
	const int cx = x;
	const int rx = x;

	relay(x);  // x is lvalue, T is int&, param's type is int&
	relay(cx); // cx is lvalue, T is const int&,
	// param's type is const int&
	relay(rx); // rx is lvalue, T is const int&,
	// param's type is const int&
	relay(27); // 27 is rvalue, T is int, param's typs is int&&    
}