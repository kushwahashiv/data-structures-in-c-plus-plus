// Source : https://leetcode.com/problems/permutations/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > permute(vector<int> &num) {
	    vector<vector<int> > result;

	    permuteRecursive(num, 0, result);
	    return result;
    }

    // permute num[begin..end]
    // invariant: num[0..begin-1] have been fixed/permuted
	void permuteRecursive(vector<int> &num, int begin, vector<vector<int> > &result)	{
		if (begin >= num.size()) {
		    // one permutation instance
		    result.push_back(num);
		    return;
		}

		for (int i = begin; i < num.size(); i++) {
		    swap(num[begin], num[i]);
		    permuteRecursive(num, begin + 1, result);
		    // reset
		    swap(num[begin], num[i]);
		}
    }

int main(int argc, char** argv)
{
    int n = 3;
    if (argc>1){
       n = atoi(argv[1]); 
    }

    vector<int> v;
    for (int i=0; i<n; i++) {
        v.push_back(i+1);
    }
    vector<vector<int> > vv;
    vv = permute(v);
    
    for(int i=0; i<vv.size(); i++) {
        cout << "{ ";
        for(int j=0; j<vv[i].size(); j++){
            cout << vv[i][j] << " ";
        }
        cout << "}" <<endl;
    }

    return 0;
}
