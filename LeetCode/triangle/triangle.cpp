// Source : https://oj.leetcode.com/problems/triangle/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-18

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

#include <iostream>
#include <vector>
using namespace std;

// https://leetcode.com/problems/triangle/discuss/38730
int minimumTotal(vector<vector<int> > &triangle) {
  int n = triangle.size();
  vector<int> minlen(triangle.back());
  for (int layer = n - 2; layer >= 0; layer--) // For each layer
  {
    for (int i = 0; i <= layer; i++) // Check its every 'node'
    {
      // Find the lesser of its two children, and sum the current value in the triangle with it.
      minlen[i] = min(minlen[i], minlen[i + 1]) + triangle[layer][i];
    }
  }
  return minlen[0];
}


int main()
{
  vector< vector<int> > v;
  vector<int> i;
  i.push_back(-1);
  v.push_back(i);

  i.clear();
  i.push_back(2);
  i.push_back(3);
  v.push_back(i);

  i.clear();
  i.push_back(1);
  i.push_back(-1);
  i.push_back(-3);
  v.push_back(i);

  Solution s;
  cout << s.minimumTotal(v) << endl;;

  v.clear();
  i.clear();
  i.push_back(-1);
  v.push_back(i);

  i.clear();
  i.push_back(3);
  i.push_back(2);
  v.push_back(i);

  i.clear();
  i.push_back(-3);
  i.push_back(1);
  i.push_back(-1);
  v.push_back(i);
  cout << s.minimumTotal(v) << endl;;

  return 0;
}
