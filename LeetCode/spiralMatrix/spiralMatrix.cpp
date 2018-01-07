// Source : https://leetcode.com/problems/spiral-matrix/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-30

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

include <iostream>
#include <vector>
using namespace std;

/*
When traversing the matrix in the spiral order, at any time we follow one out of the following four directions: RIGHT DOWN LEFT UP. Suppose we are working on a 5 x 3 matrix as such:
0 1 2 3 4 5
6 7 8 9 10
11 12 13 14 15

Imagine a cursor starts off at (0, -1), i.e. the position at ‘0’, then we can achieve the spiral order by doing the following:
Go right 5 times
Go down 2 times
Go left 4 times
Go up 1 times.
Go right 3 times
Go down 0 times -> quit
Notice that the directions we choose always follow the order ‘right->down->left->up’, and for horizontal movements,
the number of shifts follows:{5, 4, 3}, and vertical movements follows {2, 1, 0}.
Thus, we can make use of a direction matrix that records the offset for all directions,
then an array of two elements that stores the number of shifts for horizontal and vertical movements, respectively.
This way, we really just need one for loop instead of four.
Another good thing about this implementation is that:
If later we decided to do spiral traversal on a different direction (e.g. Counterclockwise),
then we only need to change the Direction matrix; the main loop does not need to be touched.
*/
vector<int> spiralOrder(vector<vector<int>>& matrix) {
  vector<vector<int> > dirs{ {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
  vector<int> res;
  int nr = matrix.size();     if (nr == 0) return res;
  int nc = matrix[0].size();  if (nc == 0) return res;

  vector<int> nSteps{ nc, nr - 1 };

  int iDir = 0;   // index of direction.
  int ir = 0, ic = -1;    // initial position
  while (nSteps[iDir % 2]) {
    for (int i = 0; i < nSteps[iDir % 2]; ++i) {
      ir += dirs[iDir][0]; ic += dirs[iDir][1];
      res.push_back(matrix[ir][ic]);
    }
    nSteps[iDir % 2]--;
    iDir = (iDir + 1) % 4;
  }
  return res;
}


void printArray(vector<int> v)
{
  cout << "[";
  for (int j = 0; j < v.size(); j++) {
    printf(" %02d", v[j]);
  }
  cout << "]" << endl;;
}

void printMatrix(vector< vector<int> > &vv)
{
  for (int i = 0; i < vv.size(); i++) {
    printArray(vv[i]);
  }
  cout << endl;
}

vector< vector<int> > createMatrix(int n, int m)
{
  vector< vector<int> > vv;
  int cnt = 1;
  for (int i = 0; i < n; i++) {
    vector<int> v;
    for (int j = 0; j < m; j++) {
      v.push_back(cnt++);
    }
    vv.push_back(v);
  }
  return vv;
}

int main(int argc, char** argv)
{
  int n = 3, m = 3;
  if (argc > 2) {
    n = atoi(argv[1]);
    m = atoi(argv[2]);
  }
  vector< vector<int> > matrix = createMatrix(n, m);
  printMatrix(matrix);
  vector<int> v = spiralOrder(matrix);
  printArray(v);
  return 0;
}
