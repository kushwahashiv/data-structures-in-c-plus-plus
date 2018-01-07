// Source : https://leetcode.com/problems/subsets/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-03

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int> > subsets(vector<int> &S) {
        sort (S.begin(), S.end());
        int elem_num = S.size();
        int subset_num = pow (2, elem_num);
        vector<vector<int> > subset_set (subset_num, vector<int>());
        for (int i = 0; i < elem_num; i++)
            for (int j = 0; j < subset_num; j++)
                if ((j >> i) & 1)
                    subset_set[j].push_back (S[i]);
        return subset_set;
    }


void printResult(vector<vector<int> >& result)
{
    for(int i=0; i<result.size(); i++){
        cout << "{";
        for(int j=0; j<result[i].size(); j++){
            cout << " " << result[i][j];
        }
        cout << " }" <<endl;
    }
}

void printArray(vector<int>& v){
    cout << "{";
    for(int i=0; i<v.size(); i++) {
        cout << " " << v[i];
    }
    cout << " }" << endl;
}

int main(int argc, char** argv)
{
    srand(time(nullptr));

    int n = 3;
    if (argc>1){
        n = atoi(argv[1]);
    }
    vector<int> v;
    for(int i=n; i>0; i--){
        v.push_back(i);
    }
    printArray(v);
    vector<vector<int> > r = subsets(v);
    printResult(r);
}
