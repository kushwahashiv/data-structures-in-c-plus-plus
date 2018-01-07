// Source : https://leetcode.com/problems/sudoku-solver/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-09-20

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
A sudoku puzzle...
...and its solution numbers marked in red.

*/

#include <iostream>
#include <vector>
using namespace std;


bool check(vector<vector<char>>& board, int i, int j, char val) {

    for( int h=0;h<9;h++)
        {
        if(board[i][h]==val) return false; /* check row */
        if(board[h][j]==val) return false; /* check col */
        if(board[i-i%3+h/3][j-j%3+h%3]==val)return false; /* check cube */
        }

    return true;
}

/*bool check(vector<vector<char>> &board, int i, int j, char val)
{
    int row = i - i%3, column = j - j%3;
    for(int x=0; x<9; x++) if(board[x][j] == val) return false;
    for(int y=0; y<9; y++) if(board[i][y] == val) return false;
    for(int x=0; x<3; x++)
    for(int y=0; y<3; y++)
        if(board[row+x][column+y] == val) return false;
    return true;
}*/

bool solveSudoku(vector<vector<char>> &board, int i, int j)
{
    if(i==9) return true;
    if(j==9) return solveSudoku(board, i+1, 0);
    if(board[i][j] != '.') return solveSudoku(board, i, j+1);

    for(char c='1'; c<='9'; c++)
    {
        if(check(board, i, j, c))
        {
            board[i][j] = c;
            if(solveSudoku(board, i, j+1)) return true;
            board[i][j] = '.';
        }
    }

    return false;
}

int main() {
    return 0;
}
