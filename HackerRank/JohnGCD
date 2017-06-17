#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int get_gcd (int a, int b) {// a < b. Euclidean Algorithm, improved (can also return 1 now)
    int r;
    while (r = b % a) {
        b = a;
        a = r;
    }
    return a;
}

int get_lcm (int a, int b)
{
    return (a * b) / get_gcd(a, b);
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int n;
        cin >> n;
        int A[n];
        int B[n+1];
        for(int j = 0; j < n; j++)
            cin >> A[j];
        cout << (B[0] = A[0]) << " "; // Base case, B[0] = A[0], gcd(B[0], B[1]) returns A[0] since B[1] = lcm(A[0], A[1])
        for(int j = 1; j < n; j++) {
            B[j] = get_lcm(min(A[j-1], A[j]), max(A[j-1], A[j]));
            cout << B[j] << " ";
        }
        cout << (B[n] = A[n-1]) << endl; // Last case, same as above but this time B[n-1], B[n] -> A[n-1]
    }
    return 0;
}
