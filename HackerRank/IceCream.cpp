#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int m, n, x;
        cin >> m >> n;
        vector<int> A;
        for(int j = 0; j < n; j++) {
            cin >> x;
            A.push_back(x);
        }
        bool exit = false;
        for(int j = 0; !exit && j < n-1; j++) {
            int val = A[j];
            for(int k = j+1; !exit && k < n; k++) {
                if(A[k] > m)
                    continue;
                if(A[k] == m-val) {
                    cout << j+1 << " " << k+1 << endl;
                    exit = true;
                }
            }
        }
    }
    return 0;
}
