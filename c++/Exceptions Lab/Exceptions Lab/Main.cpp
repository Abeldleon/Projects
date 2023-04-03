#include <vector>
#include <iostream>
#include <stdexcept>
using namespace std;

class InvalidSize: public runtime_error
{
public:
	InvalidSize(const char* s) :runtime_error(s) {}
};

class StackFull: public runtime_error
{
public:
	StackFull(const char * s, int num):runtime_error(s),number(num){}
	int GetValue() { return number; }
private:
	int number;
};

class StackEmpty: public runtime_error
{
public:
	StackEmpty(const char * s):runtime_error(s) {}
};

class IntStack
{
public:
	// MaxSize should be an unsigned int, but for the sake of example...
	IntStack(int MaxSize)
	{
		if (MaxSize < 0)
		{
			//cerr << "Cannot create a negative size stack" << endl;
			//exit(1);
			throw InvalidSize("Cannot create a negative size stack");
		}

		data.resize(MaxSize);
		cur_index = 0;
	}

	void push(int new_data)
	{
		if (cur_index == data.size())
		{
			//cerr << "Push to full stack" << endl;
			//exit(1);
			throw StackFull("Push to full stack", cur_index);
		}
		else
		{
			data.at(cur_index) = new_data;
			cur_index++;
		}
	}

	int pop()
	{
		if (cur_index == 0)
		{
			//cerr << "Pop from empty stack" << endl;
			//exit(1);
			throw StackEmpty("Pop from empty stack");
		}
		else
		{
			// pop off the int and return it
			cur_index--;
			return data.at(cur_index);
		}
	}

private:
	vector<int> data;
	unsigned int cur_index;
};

int main()
{
	// Testing Constructor
	try
	{
		IntStack c_test(-10);
		c_test.push(3);
		c_test.push(4);
		c_test.pop();
		c_test.pop();
	}
	catch (InvalidSize& e)
	{
		cerr << e.what() << endl;
	}

	
	// Testing push
	try
	{
		IntStack push_test(5);

		for (unsigned int i = 0; i < 7; i++) {
			push_test.push(i);
		}
	}
	catch (StackFull& e)
	{
		cerr << e.what() << ", value =  " << e.GetValue() << endl;
	}


	// Testing pop
	try
	{
		IntStack pop_test(2);

		pop_test.push(1);
		pop_test.push(2);
		pop_test.pop();
		pop_test.pop();
		pop_test.pop();
	}
	catch (StackEmpty& e)
	{
		cerr << e.what() << endl;
	}

	cout << "Completed!" << endl;
	
	return 0;
}