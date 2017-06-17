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
        int steps = 0;
        string s;
        if(!i)
            cin.ignore();
        cin >> s;
        for(int i = 0, j = s.length()-1; i <= j; i++, j--) {
            while(s[i] != s[j]) {
                if(s[i] < s[j])
                    s[j]--;
                else
                    s[i]--;
                steps++;
            }
        }
        cout << steps << endl;
    }
    return 0;
}
