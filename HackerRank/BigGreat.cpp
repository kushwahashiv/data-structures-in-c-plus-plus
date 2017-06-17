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
        string s;
        cin >> s;
        int stop = 0;
        if(!s.length()) {
            stop |= 1;
            cout << "no answer" << endl;
        }

        if(next_permutation(s.begin(), s.begin()+s.length()))
           cout << s;
        else
           cout << "no answer";
        cout << endl;
    }
    return 0;
}
