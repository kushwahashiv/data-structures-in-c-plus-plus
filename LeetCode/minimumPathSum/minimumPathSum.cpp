// Source : https://leetcode.com/problems/minimum-path-sum/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
*/

#include <limits.h>
#include <iostream>
#include <vector>
using namespace std;

int minPathSum(vector<vector<int>>& grid) {
  int m = grid.size();
  int n = grid[0].size();
  vector<int> cur(m, grid[0][0]);
  for (int i = 1; i < m; i++)
    cur[i] = cur[i - 1] + grid[i][0];
  for (int j = 1; j < n; j++) {
    cur[0] += grid[0][j];
    for (int i = 1; i < m; i++)
      cur[i] = min(cur[i - 1], cur[i]) + grid[i][j];
  }
  return cur[m - 1];
}

int main()
{
  int a[6][2] = { {7,2},{6,6},{8,6},{8,7},{5,0},{6,0} };
  vector< vector<int> > grid;
  for (int i = 0; i < 6; i++) {
    vector<int> v;
    for (int j = 0; j < 2; j++) {
      v.push_back(a[i][j]);
    }
    grid.push_back(v);
  }

  cout << "minPathSum=" << minPathSum(grid) << endl;

  return 0;
}

