#include <cstdio>
#include <vector>
#include <map>
#include <cctype>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    string s;
    getline(cin, s);
    if(s.length() < 32)
        cout << "not pangram";
    else {
        bool finish = false;
        map<char, int> Letters;
        for(int i = 0; i < s.length(); i++)
            if(isalpha(s[i]))
                Letters[s[i]] = 1;
        for(int i = 65; !finish && i < 90; i++) { // ascii alphabetic limits
            if(Letters[i] != 1 && Letters[i+32] != 1) {
                cout << "not pangram";
                finish = true;
            }
        }
        if(!finish)
            cout << "pangram";
    }
    return 0;
}
