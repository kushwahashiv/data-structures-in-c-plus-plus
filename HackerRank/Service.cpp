#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, t, width;
    cin >> n >> t;
    vector<int> lane;
    for(int i = 0; i < n; i++) {
        cin >> width;
        lane.push_back(width);
    }
    
    int begin, end;
    for(int i = 0; i < t; i++) {
        cin >> begin >> end;
        vector<int>::iterator it = lane.begin();
        cout << *min_element(it+begin, it+end+1) << endl;
    }
    
    return 0;
}
