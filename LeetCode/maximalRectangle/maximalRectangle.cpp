// Source : https://leetcode.com/problems/maximal-rectangle/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-21

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

#include <time.h>
#include <iostream>
#include <vector>
using namespace std;

/*
If you think this algorithm is not easy to understand, you can try this example:
0 0 0 1 0 0 0
0 0 1 1 1 0 0
0 1 1 1 1 1 0
The vector “left” and “right” from row 0 to row 2 are as follows
row 0:

l: 0 0 0 3 0 0 0
r: 7 7 7 4 7 7 7

row 1:
l: 0 0 2 3 2 0 0
r: 7 7 5 4 5 7 7

row 2:
l: 0 1 2 3 2 1 0
r: 7 6 5 4 5 6 7
The vector “left” is computing the left boundary. Take (i,j)=(1,3) for example. On current row 1, the left boundary is at j=2.
However, because matrix[1][3] is 1, you need to consider the left boundary on previous row as well, which is 3.
So the real left boundary at (1,3) is 3.
*/

int maximalRectangle(vector<vector<char> > &matrix) {
  if (matrix.empty()) return 0;
  const int m = matrix.size();
  const int n = matrix[0].size();
  int left[n], right[n], height[n];
  fill_n(left, n, 0); fill_n(right, n, n); fill_n(height, n, 0);
  int maxA = 0;
  for (int i = 0; i < m; i++) {
    int cur_left = 0, cur_right = n;
    for (int j = 0; j < n; j++) { // compute height (can do this from either side)
      if (matrix[i][j] == '1') height[j]++;
      else height[j] = 0;
    }
    for (int j = 0; j < n; j++) { // compute left (from left to right)
      if (matrix[i][j] == '1') left[j] = max(left[j], cur_left);
      else { left[j] = 0; cur_left = j + 1; }
    }
    // compute right (from right to left)
    for (int j = n - 1; j >= 0; j--) {
      if (matrix[i][j] == '1') right[j] = min(right[j], cur_right);
      else { right[j] = n; cur_right = j; }
    }
    // compute the area of rectangle (can do this from either side)
    for (int j = 0; j < n; j++)
      maxA = max(maxA, (right[j] - left[j])*height[j]);
  }
  return maxA;
}


void printArray(vector<int> &v)
{
  cout << "{";
  for (int i = 0; i < v.size(); i++) {
    cout << " " << v[i];
  }
  cout << "}" << endl;
}

void test(int a[], int n)
{
  vector<int> v(a, a + n);
  printArray(v);
  cout << largestRectangleArea(v) << endl;
}

int main(int argc, char** argv)
{
#define TEST(a) test(a, sizeof(a)/sizeof(int))

  int a0[] = { 2,1,3,1 };
  TEST(a0);
  int a1[] = { 2,1,5,6,2,3 };
  TEST(a1);

  cout << "------------------" << endl;
  srand(time(0));

  int r = 3;
  int c = 3;
  if (argc > 2) {
    r = atoi(argv[1]);
    c = atoi(argv[2]);
  }

  vector< vector<char> > matrix;
  for (int i = 0; i < r; i++) {
    vector<char> v;
    cout << "[";
    for (int j = 0; j < c; j++) {
      char ch = rand() % 2 + '0';
      v.push_back(ch);
      cout << " " << ch;
    }
    matrix.push_back(v);
    cout << " ]" << endl;
  }
  cout << "------------------" << endl;
  cout << "maxArea = " << maximalRectangle(matrix) << endl;

  return 0;
}



