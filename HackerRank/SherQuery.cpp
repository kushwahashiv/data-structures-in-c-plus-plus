#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

/*
IDEA: Use a map to avoid recalculating known outcomes of j+1 % B[i] and since i is common to B and C, also map this key to C[i] multiplication.
*/

void some_operation(vector<long long int> &A, vector<long long int> B, vector<long long int> C, map<int, int> lookup) {
    for(int i = 0; i < B.size(); i++) {
        // Dont recalculate, take the j+1 % B[i] in here with the C[i] already found
        int prev = lookup.count(B[i]); // I got B[i] ?
        if(prev) // i already mapped this
            prev = lookup[B[i]];
        else // nope, first time mapping it
            prev = 1;
        lookup[B[i]] = prev * C[i] % 1000000007; // now save this multiplication
    }
    
    for(map<int,int>::iterator it = lookup.begin(); it != lookup.end(); it++) {
        int curr = it->first; // the key of the map, the B[i]
        for(int i = curr - 1; i < A.size(); i+=curr) { // curr - 1 because things are shifted in problem
            A[i] = A[i] * it->second % 1000000007; // key's mapped value, the saved value C[i]
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<long long int> A;
    vector<long long int> B;
    vector<long long int> C;
    map<int, int> lookup;
    for(int i = 0; i < n; i++) {
        long long int ax;
        cin >> ax;
        A.push_back(ax);
    }
    
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < m; j++) {
            long long int x;
            cin >> x;
            if(!i)
                B.push_back(x);
            else
                C.push_back(x);
        }
    }
    
    some_operation(A, B, C, lookup);
    
    for(int i = 0; i < n; i++) {
        cout << A[i] << " ";
    }
    
    cin >> n;
    return 0;
}
