#include<iostream>
#include<vector>
using namespace std;


//int fibonacci(int n) {
//	if (n == 0) {
//		return 0;
//	}
//	else if (n == 1) {
//		return 1;
//	}
//	else {
//		return fibonacci(n - 1) + fibonacci(n - 2);
//	}
//}
int fibonacci(int n) {
	vector<int> memo(n + 1, -1);
	return fibonacci(n,memo);
}
int fibonacci(int n, vector<int> memo)
{
	if (memo[n] != -1) {
		return memo[n];
	}
	else if (n == 0) {
		memo[n] = 0;
		return memo[n];
	}
	else if (n == 1) {
		memo[n] = 1;
	}
	else {
		memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
		return memo[n];
	}
}

int main() {
	cout << fibonacci(5) << endl;
}