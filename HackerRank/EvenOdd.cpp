#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int LL;

vector<LL> A;

int find(int x, int y)
{
    if(x>y) return 1;
    return pow(A[x],find(x+1,y));
}

int main() {
    int n;
    cin >> n;
    A.resize(n);
    for(int i = 0; i < n; i++)
        cin >> A[i];
    LL Q;
    cin >> Q;
    for(LL i = 0; i < Q; i++) {
        LL x, y;
        cin >> x >> y;
        --x;
        --y;
        // Handle exception: There may be a zero element somewhere in the array to ruin all other powers. This is a problem
        // iff the x+1 is 0, as it will turn the answer to 1, an odd integer.
        bool exception = false;
        if(x != y && x < n-1 && A[x+1] == 0) {
            cout << "Odd";
            exception = true;
        }
        if(!exception) {
            if(A[x] % 2)
                cout << "Odd";
            else
                cout << "Even";
        }
        cout << endl;
    }
    return 0;
}
