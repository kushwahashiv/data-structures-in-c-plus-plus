#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <cstdlib>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;

int lonelyinteger(vector <int> A) {
    for(int i = 1; i < A.size(); i++)
        A[0] ^= A[i];
    return A[0];
}

int main() {
    int n;
    cin >> n;
    vector<int> A;
    int x;
    for(int i = 0; i < n; i++) {
        cin >> x;
        A.push_back(x);
    }
    cout << lonelyinteger(A);
    
    return 0;
}
