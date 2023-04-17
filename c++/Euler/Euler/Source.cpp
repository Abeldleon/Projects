#include <iostream>
#include <cmath>
#include <string>
using namespace std;
//1:
double p1_a(double x, double y) {
    return x * pow(exp(1), 3 * x) - (2 * y);
}
double p1_b(double x, double y) {
    return 1 + pow(x - y, 2);
}
double p1_c(double x, double y) {
    return 1 + (y / x);
}
double p1_d(double x, double y) {
    return cos(2 * x) + sin(3 * x);
}
//2:
double p2_a(double x, double y) {
    return pow(exp(1), x - y);
}
double p2_b(double x, double y) {
    return (1 + x) / (1 + y);
}
double p2_c(double x, double y) {
    return (-1 * y) + (x * sqrt(y));
}
double p2_d(double x, double y) {
    return (sin(2 * x) - (2 * x * y)) / pow(x, 2);
}


void Euler(double a_, double b_, double y0_, int n, double (*f)(double, double)) {
    double a = a_, b = b_, y0 = y0_;
    int N = n;

    double h = (b - a) / N;
    double x = a, w = y0;

    cout << "\t" << "(" << x << ", " << w << ")" << endl;

    for (int i = 1; i <= N; i++) {

        w = w + (h * f(x, w));
        x = a + i * h;
        cout << "\t" << "(" << x << ", " << w << ")" << endl;
    }
}

int main() {
    cout << " 1 a _________________" << endl;
    Euler(0, 1, 0, 10, p1_a);
    cout << " 1 b _________________" << endl;
    Euler(2, 3, 1, 10, p1_b);
    cout << " 1 c _________________" << endl;
    Euler(1, 2, 2, 10, p1_c);
    cout << " 1 d _________________" << endl;
    Euler(0, 1, 1, 10, p1_d);
    cout << " 2 a _________________" << endl;
    Euler(0, 1, 1, 10, p2_a);
    cout << " 2 b _________________" << endl;
    Euler(1, 2, 2, 10, p2_b);
    cout << " 2 c _________________" << endl;
    Euler(2, 3, 2, 10, p2_c);
    cout << " 2 d _________________" << endl;
    Euler(1, 2, 2, 10, p2_d);

    return 0;
}
