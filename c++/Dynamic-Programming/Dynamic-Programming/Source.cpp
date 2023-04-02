#include <iostream>
#include <vector>
using namespace std;

// Recursive solution
/*
int factorial(int n) {
	if (n == 0) return 1;
	return factorial(n - 1) * n;
}*/

// Dynamic Programming solution
int factorial(int n, vector<int>& memo) {

	if (n == 0) return 1;
	if (memo[n] != -1)
		return memo[n];
	memo[n] = factorial(n - 1, memo) * n;
	return memo[n];
}

int factorial(int n) {
	vector<int> temp(n + 1, -1);
	return factorial(n, temp);
}

int main()
{
	cout << factorial(5) << endl;
}