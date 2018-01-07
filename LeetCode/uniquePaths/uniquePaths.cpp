// Source : https://leetcode.com/problems/unique-paths/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-25

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Above is a 3 x 7 grid. How many possible unique paths are there?
Note: m and n will be at most 100.
*/

#include <iosteram>

int uniquePaths(int m, int n) {
  if (m > n) return uniquePaths(n, m);
  vector<int> cur(m, 1);
  for (int j = 1; j < n; j++)
    for (int i = 1; i < m; i++)
      cur[i] += cur[i - 1];
  return cur[m - 1];
}

void printMatrix(int*a, int m, int n)
{
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      printf("%4d ", a[i*n + j]);
    }
    printf("\n");
  }
  printf("\n");
}

int main(int argc, char** argv)
{
  int m = 3, n = 7;
  if (argc > 2) {
    m = atoi(argv[1]);
    n = atoi(argv[2]);
  }

  printf("uniquePaths=%d\n", uniquePaths(m, n));
  return  0;
}
