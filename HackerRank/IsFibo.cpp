#include <cmath>
#include <cstdio>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

#define MAXFIB 50

// http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibtable.html
long long int FiboTable[50]; // 50th one exceeds the limit provided in problem

void GenerateFiboTable() { // This table is ordered
    for(int i = 0; i < MAXFIB; i++) {
        if(i == 0 || i == 1) FiboTable[i] = 1;
        if(i >= 2)
            FiboTable[i] = FiboTable[i-1] + FiboTable[i-2];
    }
}

int IsFibo (long long int num) { // Binary Search
    int left = 0, right = MAXFIB-1; // 50 - 1
    int middle = (left+right)/2;
    while(left <= right) {
        if(FiboTable[middle] > num) {
            right = middle-1;
        }
        else
        if(FiboTable[middle] < num) {
            left = middle+1;
            
        }
        else // Must be equal
            return 1;
        middle = (left+right)/2;
    }
    return 0;
}

int main() {
    int n;
    cin >> n;
    GenerateFiboTable();
    for(int i = 0; i < n; i++) {
        long long int num;
        cin >> num;
        int res = IsFibo(num);
        if(res)
            cout << "IsFibo";
        else
            cout << "IsNotFibo";
        cout << endl;
    }
    return 0;
}
