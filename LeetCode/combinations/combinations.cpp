// https://leetcode.com/problems/combinations/description/
// Author : Shiv S. Kushwaha

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> combine(int n, int k) {
  vector<vector<int>> result;
  int i = 0;
  vector<int> p(k, 0);
  while (i >= 0) {
    p[i]++;
    if (p[i] > n) --i;
    else if (i == k - 1) result.push_back(p);
    else {
      ++i;
      p[i] = p[i - 1];
    }
  }
  return result;
}

void printResult(vector<vector<int> >& result)
{
  for (int i = 0; i < result.size(); i++)
  {
    cout << "[";
    for (int j = 0; j < result[i].size(); j++)
    {
      cout << " " << result[i][j];
    }
    cout << " ]" << endl;
  }
}

int main()
{
  srand(time(nullptr));
  int n = 4, k = 2;
  vector<vector<int> > r = combine(n, k);
  printResult(r);

  system("pause");

  return 0;
}
