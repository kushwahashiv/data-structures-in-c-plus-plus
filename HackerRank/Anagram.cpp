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
        string s;
        cin >> s;
        if(!(s.length()%2)) {
            int count = 0;
            vector<int> L;
            L.resize(26, 0); // lowercase only
            for(int j = 0; j < s.length()/2; j++) // exist on left, but not on right
                L[s[j]-'a']++;
            for(int j = s.length()/2; j < s.length(); j++) // exist on right, but not on left
                L[s[j]-'a']--;
            for(int j = 0; j < 26; j++)
                count += L[j]*(1-2*(L[j] < 0)); // it can be negative if a letter is absent on left
            cout << count/2 << endl; // if they are there, we count twice
        }
        else
            cout << -1 << endl;
    }
    return 0;
}
