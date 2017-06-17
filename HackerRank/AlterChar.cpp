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
        int count = 0;
        string s;
        cin >> s;
        for(int j = 1; j < s.length();) {
            if(s[j-1] == s[j]) {
                count++;
                s.erase(j, 1);
            }
            else
                j++;
                
        }
        cout << count << endl;
    }
    return 0;
}
