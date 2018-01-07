// Source : https://leetcode.com/problems/word-search/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-19

/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
#include <iostream>
#include <vector>
#include <string>
using namespace std;

bool dfs (vector<vector<char>>& board, string &word, int col, int row, int beg)
    {
        bool res(false);
        if (board[col][row] == word[beg])
        {
            if (beg >= word.size()-1)
                return true;
            char temp (board[col][row]);
            board[col][row] = '*';
            if (col+1<board.size() && dfs(board,word,col+1,row,beg+1))
                res = true;
            else if (col>0 && dfs(board,word,col-1,row,beg+1))
                res = true;
            else if (row+1 < board[0].size() && dfs(board,word,col,row+1,beg+1))
                res = true;
            else if (row>0 && dfs(board,word,col,row-1,beg+1))
                res = true;
            board[col][row] = temp;
        }
        return res;
    }
    bool exist(vector<vector<char>>& board, string word) {
        for (int i(0);i!=board.size();++i)
            for (int j(0);j!=board[i].size();++j)
                if (dfs(board,word,i,j,0))
                    return true;
        return false;
    }


    // 2

bool exist(vector<vector<char> > &board, string word) {
    if (board.size()<=0 || word.size()<=0) return false;
    int row = board.size();
    int col = board[0].size();
    //using a mask to mark which char has been selected.
    //do not use vector<bool>, it has big performance issue, could cause Time Limit Error
    vector< vector<int> > mask(row, vector<int>(col, 0));

    for(int i=0; i<board.size(); i++) {
        for(int j=0; j<board[i].size(); j++){
            if ( board[i][j]==word[0] ){
                vector< vector<int> > m = mask;
                if( exist(board, word, 0, i, j, m) ){
                    return true;
                }
            }
        }
    }
    return false;
}


//
vector< vector<char> > buildBoard(char b[][5], int r, int c) {
    vector< vector<char> > board;
    for (int i=0; i<r; i++){
        vector<char> v(b[i], b[i]+c);
        cout << b[i] << endl;
        board.push_back(v);
    }
    cout << "----------" << endl;    
    return board;
}

int main(int argc, char** argv)
{
    string s;
    char b[3][5] ={ "ABCE", "SFCS", "ADEE" };
    vector< vector<char> > board = buildBoard(b, 3, 4);

    s = "SEE";
    cout << s << ":" << exist(board, s) << endl; 
    
    s = "ABCCED";
    cout << s << ":" << exist(board, s) << endl; 
    
    s = "ABCB";
    cout << s << ":" << exist(board, s) << endl; 


    if (argc>1){
        s = argv[1];
        cout << s << ":" << exist(board, s) << endl; 
    }

    cout << endl << "----------" << endl;    
    char b1[3][5] ={ "CAA", "AAA", "BCD" };
    board = buildBoard(b1, 3, 3);

    s = "AAB";
    cout << s << ":" << exist(board, s) << endl; 


    cout << endl << "----------" << endl;    
    char b2[3][5] ={ "ABCE", "SFES", "ADEE" };
    board = buildBoard(b2, 3, 4);

    s = "ABCESEEEFS";
    cout << s << ":" << exist(board, s) << endl; 

    cout << endl << "----------" << endl;    
    char b3[3][5] ={ "aaaa", "aaaa", "aaaa" };
    board = buildBoard(b3, 3, 4);

    s = "aaaaaaaaaaaaa";
    cout << s << ":" << exist(board, s) << endl; 

    return 0;
}
