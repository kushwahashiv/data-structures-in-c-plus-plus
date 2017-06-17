#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#define MOD 1000000007

/* This function calculates (a^b)%MOD using Fermat's Little Theorem*/
long long int modpow(int a, int b, int mod) {
    long long int x = 1, y = a;
    while(b > 0) {
        if(b & 1) {
            x = x * y;
            if(x > mod) x %= mod;
        }
        y = y * y;
        if(y > mod) y %= mod;
        b >>= 1;
    }
    return x;
}
 
int modInv(int a, int m) {
    return modpow(a,m-2,m);
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int n, m;
        cin >> n >> m;
        m--;
        int big = max(n, m);
        int small = min(n, m);
        long long int result = 1;
        for(int j = n + m; j > big; j--)
            result = (result * j) % MOD;
        for(int j = small; j > 1; j--)
            result = (result * modInv(j, MOD)) % MOD;
        cout << result << endl;
    }
    return 0;
}
