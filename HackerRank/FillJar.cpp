#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    long long int sum = 0;
    for(int i = 0; i < m; i++) {
        long long int a, b, k;
        cin >> a >> b >> k;
        sum += (b-a+1)*k;
    }
    cout << sum/n;
    return 0;
}
