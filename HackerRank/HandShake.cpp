#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int LL;

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        LL n;
        cin >> n;
        cout << (n * (n - 1)) / 2 << endl;
    }
    return 0;
}
