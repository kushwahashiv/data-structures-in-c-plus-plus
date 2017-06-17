#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int num;
        int res = 0;
        cin >> num;
        int temp = num;
        for(; num > 0;) {
            if((num % 10) && !(temp % (num % 10)))
               res++;
            num /= 10;
        }
        cout << res << endl;
    }
    return 0;
}
