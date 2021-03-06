#include <iostream>
using namespace std;
/*
 * Complete the function below.
 */

int maxXor(int l, int r) {
    int res = 0;
    for(int i = l; i <= r; i++) {
        for(int j = l; j <= r; j++) {
            if(res < (j ^ i))
                res = j ^ i;
        }
    }
    return res;
}

int main() {
    int res;
    int _l;
    cin >> _l;
    
    int _r;
    cin >> _r;
    
    res = maxXor(_l, _r);
    cout << res;
    
    return 0;
}
