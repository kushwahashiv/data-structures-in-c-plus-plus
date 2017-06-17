/*

Problem Statement

Given a 2D array of digits, try to find the location of a given 2D pattern of digits within it. For example, consider the following 2D matrix.

1234567890
0987654321
1111111111
1111111111
2222222222
If we need to look for the following 2D pattern within it:

876543
111111
111111
If we scan through the original array, we observe, that 2D pattern begins from the second row and the third column of the larger grid (the 8 in the second row and third column of the larger grid, is the top-left corner of the pattern we are searching for).

So, a 2D pattern of digits P is said to be present in a larger grid G, if the latter contains a contiguous, rectangular 2D grid of digits matching with the pattern P; similar to the example shown above.

Input Format
The first line contains an integer T, which is the number of tests. T tests follow and the structure of each test is described below:
The first line contains 2 space separated integers R and C indicating the number of rows and columns in the grid G.
This is followed by R lines, each with a string of C digits each; which represent the grid G.
The second line contains 2 tab separated integers r and c indicating the number of rows and columns in the pattern grid P.
This is followed by r lines, each with a string of c digits each; which represent the pattern P.

Constraints
1<=T<=5
1<=R,r,C,c<=1000
1<=r<=R
1<=c<=C

*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void cal(int **big, int **small, int a, int b, int c, int d)
{
  int i = 0, j = 0, k = 0, l = 0, found = 0;
  long long flag;

  for (i = 0; i<a; i++)
    for (j = 0; j<b; j++)
    {
      if (big[i][j] == small[0][0])
      {
        flag = c*d;
        if (i + c<a && j + d<b)
          for (k = i; k<i + c; k++)
            for (l = j; l<j + d; l++)
              if (big[k][l] == small[k - i][l - j]) flag--;
        if (flag == 0)
          found = 1;
      }
    }

  if (found == 1)
    cout << "YES\n";
  else
    cout << "NO\n";
}

int main() {
  int t;
  cin >> t;
  while (t--)
  {
    long long int a, b, c, d;
    int i = 0, j = 0;
    char ch;
    cin >> a;
    cin >> b;
    int **big;

    big = (int **)malloc(a*sizeof(int*));
    for (i = 0; i<b; i++)
      big[i] = (int*)malloc(b*sizeof(int));
    ch = getchar();
    for (i = 0; i<a; i++)
    {
      for (j = 0; j<b; j++)
      {
        ch = getchar();
        big[i][j] = (int)ch - 48;
      }
      ch = getchar();
    }

    cin >> c >> d;
    int **small;

    small = (int **)malloc(c*sizeof(int*));
    for (i = 0; i<b; i++)
      small[i] = (int*)malloc(d*sizeof(int));
    ch = getchar();
    for (i = 0; i<c; i++)
    {
      for (j = 0; j<d; j++)
      {
        ch = getchar();
        small[i][j] = (int)ch - 48;
      }
      ch = getchar();
    }

    cal(big, small, a, b, c, d);

  }

  system("pause");
  return 0;
}