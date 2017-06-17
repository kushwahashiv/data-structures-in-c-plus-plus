#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int getmin(vector<int> v) {
    if(!v.empty()) {
        int temp = v[0];
        for(int i = 1; i < v.size(); i++)
            if(temp > v[i])
                temp = v[i];
        return temp;        
    }
    else
        return 0;
}

void removezeros(vector<int> &v) {
    for(int i = 0; i < v.size();)
        if(v[i] <= 0)
            v.erase(v.begin()+i);
        else
            i++;
}

int main() {
    int n; 
    cin >> n;
    vector<int> sticks;
    for(int i = 0; i < n; i++) {
        int elem;
        cin >> elem;
        sticks.push_back(elem);
    }
           
    while(!sticks.empty()) {
        int count = sticks.size();
        int min = getmin(sticks);
        for(int i = 0; i < sticks.size(); i++) {
            if(sticks[i] >= min)
                sticks[i] -= min;
            else
                count--;
        }
        removezeros(sticks);
        cout << count << endl;
    }
           
    return 0;
}
