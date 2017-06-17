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
        int n;
        cin >> n;
        int path;
        LL result = 1;
        for(int j = 0; j < n-1; j++) {
            cin >> path;
            result = ((result % 1234567) * (path)) % 1234567;
        }
        cout << result << endl;
    }
    return 0;
}
