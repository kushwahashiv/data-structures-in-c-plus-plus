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
        long long int cuts;
        cin >> cuts;
        if(cuts % 2)
            cout << (cuts/2)*(cuts/2+1);
        else
            cout << cuts*cuts/4;
        cout << endl;
    }
    return 0;
}
