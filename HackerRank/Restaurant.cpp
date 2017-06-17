#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int get_gcd (int a, int b) { // a < b, formatted. Euclidean Algorithm
    int temp;
    while (b) {
        temp = b;
        b = a%temp;
        a = temp;
    }
    return a;
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int a, b;
        cin >> a >> b;
        
        if(a == b)
            cout << 1;
        else {
            int gcd = get_gcd(min(a, b), max(a, b));
            cout << a*b/(gcd*gcd);
        }
        cout << endl;
    }
    return 0;
}
