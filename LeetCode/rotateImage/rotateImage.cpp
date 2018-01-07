// Source : https://leetcode.com/problems/rotate-image/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-27

/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/

#include <iostream>
#include <vector>
using namespace std;

void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int a = 0;
        int b = n-1;
        while(a<b){
            for(int i=0;i<(b-a);++i){
                swap(matrix[a][a+i], matrix[a+i][b]);
                swap(matrix[a][a+i], matrix[b][b-i]);
                swap(matrix[a][a+i], matrix[b-i][a]);
            }
            ++a;
            --b;
        }
 }

void rotate(vector<vector<int> > &matrix) {
    int n = matrix.size();
    for( int i=0; i<n/2; i++ ){
        int low=i, high=n-i-1;
        for (int j=low; j<high; j++){
            int tmp;
            tmp = matrix[i][j];
            // left to top 
            matrix[i][j] = matrix[n-j-1][i];
            // bottom to left
            matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
            // right to bottom
            matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
            // top to right
            matrix[j][n-i-1] = tmp;
        }
    }
}

void printMatrix(vector<vector<int> > &matrix) 
{
    for(int i=0; i<matrix.size(); i++){
        for(int j=0; j< matrix[i].size(); j++) {
            printf("%3d ", matrix[i][j]) ;
        }
        cout << endl;
    }
    cout << endl;
}


int main(int argc, char** argv)
{
    int n = 2;
    if (argc>1){
        n = atoi(argv[1]);
    }
    vector< vector<int> > matrix;
    for (int i=1; i<=n; i++) {
        vector<int> v;
        for(int j=1; j<=n; j++){
            v.push_back( (i-1)*n + j );
        }
        matrix.push_back(v);
    }

    printMatrix(matrix);
    rotate(matrix);
    printMatrix(matrix);

    return 0;
}
