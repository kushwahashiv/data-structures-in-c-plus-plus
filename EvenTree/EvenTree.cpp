/*
Problem Statement

You are given a tree (a simple connected graph with no cycles).
You have to remove as many edges from the tree as possible to obtain a forest with the condition that
: Each connected component of the forest should contain an even number of vertices.

Your task is to calculate the number of removed edges in such a forest.
Input Format The first line of input contains two integers N and M. N is the number of vertices
and M is the number of edges. The next M lines contain two integers ui and vi which specifies an edge of the tree.
(1-based index)
Output Format Print the answer, a single integer.

Constraints 2 <= N <= 100.

Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

Sample Input
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
Sample Output
2
Explanation On removing the edges (1, 3) and (1, 6), we can get the desired result.
*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
  vector<int> u, v, n;
  int N, M, i, num = 0, a, b;
  cin >> N >> M;
  for (i = 0; i<M; i++)
  {
    cin >> a >> b;
    u.push_back(a);
    v.push_back(b);
  }


  n = vector<int>(N + 1, 1);
  for (i = 0; i<M; i++)
  {
    n[v[i]]++;
  }

  for (i = N; i > 1; i--)
  {
    if (n[i] % 2 == 0)
    {
      num++;
      for (int j = 0; j < M; j++)
      {
        if (u[j] == i)
          n[v[j]]--;
      }
    }
  }
  cout << num;

  return 0;
}



