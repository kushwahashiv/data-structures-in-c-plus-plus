#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool IsPalindrome (string s) {
    for(int p = 0, r = s.length()-1; r > p; p++, r--)
        if(s[p] != s[r])
            return 0;
    return 1;
}
    
int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        string s;
        cin >> s;
        bool found = false;
        for(int p = 0, r = s.length()-1; !found && r > p; p++, r--) {
            if(s[p] != s[r]) {
                string temp = s;
                temp.erase(temp.begin()+p);
                if(IsPalindrome(temp)) {
                    cout << p << endl;
                    found = true;
                }
                else {
                    cout << r << endl;
                    found = true;
                }
            }
        }
        if(!found)
            cout << -1 << endl;
    }
    return 0;
}
