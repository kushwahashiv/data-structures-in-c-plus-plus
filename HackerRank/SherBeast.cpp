#include <cmath>
#include <cstdio>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int num;
        cin >> num;
        // Now, check if the input is of the form 3p+5q. Check 5p | num - 3q, we need 5s maximized.
        bool found = false;
        for(int i = num/3; !found && i > 0; i--) {
            int result = num - 3*i; // if number isnt exactly a multiple of 3 only, this won't be true and I'll keep looking
            if(!(result % 5)) {
                for(int j = 0; j < i; j++)
                    cout << 555;
                for(int j = 0; j < result/5; j++)
                    cout << 33333;
                found = true;
            }
        }
        if(!found) {
            // One case left: The number can't be represented as 3p+5q but only as 5q.
            if(!(num % 5)) {
                for(int i = 0; i < num/5; i++)
                    cout << 33333;
            }
            else
                cout << -1;
        }
        cout << endl;
    }
    return 0;
}
