// https://leetcode.com/problems/combination-sum/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-19
// Date   : 2014-07-19

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
  std::vector<std::vector<int> > combinationSum3(int k, int n) {
    std::vector<std::vector<int> > res;
    std::vector<int> combination;
    combinationSum3(n, res, combination, 1, k);
    return res;
  }
private:
  void combinationSum3(int target, std::vector<std::vector<int> > &res, std::vector<int> &combination, int begin, int need) {
    if (!target) {
      res.push_back(combination);
      return;
    }
    else if (!need)
      return;
    for (int i = begin; i != 10 && target >= i * need + need * (need - 1) / 2; ++i) {
      combination.push_back(i);
      combinationSum3(target - i, res, combination, i + 1, need - 1);
      combination.pop_back();
    }
  }
};

// SF

void printMatrix(vector< vector<int> > &vv)
{
  for (int i = 0; i < vv.size(); i++)
  {
    cout << "[";
    for (int j = 0; j < vv[i].size(); j++)
    {
      cout << " " << vv[i][j];
    }
    cout << "]" << endl;;
  }
}

void printArray(vector<int> &v)
{
  cout << "{";
  for (int i = 0; i < v.size(); i++)
  {
    cout << " " << v[i];
  }
  cout << "}" << endl;
}


int main(int argc, char** argv)
{
  int a[] = { 4, 2, 3, 3, 5, 7 };
  vector<int> v(a, a + sizeof(a) / sizeof(int));
  int target = 7;
  cout << "array  = ";
  printArray(v);
  cout << "target = " << target << endl;

  vector< vector<int> > vv = combinationSum(v, target);
  printMatrix(vv);

  system("pause");
  return 0;
}
