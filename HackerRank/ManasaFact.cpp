#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

typedef unsigned long long int LL;

LL perf_pow_5[24];
LL zeros_perf_pow_5[24];

int find_pow (LL n, int power) {
    int count = 0;
    while (n > 1) {
        n /= power;
        count++;
    }
    return count;
}

int main() {
    int t;
    cin >> t;
    perf_pow_5[0] = 5;
    zeros_perf_pow_5[0] = 1;
    for(LL mul = 1; mul < 24; mul++) {// 5^24 is the max that doesn't exceed 10^16
        perf_pow_5[mul] = perf_pow_5[mul-1] * 5;
        zeros_perf_pow_5[mul] = zeros_perf_pow_5[mul-1] + perf_pow_5[mul-1];
    }
    for(int i = 0; i < t; i++) {
        LL n;
        cin >> n;
        // FACT: 5 > 2, so multiples of 5 in n! is rarer than 2. Now, 5*2 = 10, which contributes a zero to the number
        // If I need to find the zeros, I need to find the fives in a number.
        int j = find_pow(n, 5);
        LL result = 0;
        for(; n > 0;) {
            LL temp = n / zeros_perf_pow_5[j];
            n -= temp * zeros_perf_pow_5[j];
            result = result + temp * perf_pow_5[j];
            if(n > 0 && n < zeros_perf_pow_5[j])
                j--;
        }
        cout << result << endl;
    }
    return 0;
}
