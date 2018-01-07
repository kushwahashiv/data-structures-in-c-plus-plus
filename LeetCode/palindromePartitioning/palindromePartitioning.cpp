// Source : https://leetcode.com/problems/palindrome-partitioning/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-08-21

/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
[
  ["aa","b"],
  ["a","a","b"]
]
*/

#include <iostream>
#include <vector>
#include <string>
using namespace std;

/*
DFS - Deepth First Search
For example: "aaba"
                    +------+
             +------| aaba |-----+
             |      +------+     |
           +-v-+              +-v--+
           | a |aba           | aa |ba
       +---+---+--+           +--+-+
       |          |              |
     +-v-+     +--v--+         +-v-+
     | a |ba   | aba |\0       | b |a
     +-+-+     +-----+         +-+-+
       |        a, aba           |
     +-v-+                     +-v-+
     | b |a                    | a |\0
     +-+-+                     +---+
       |                      aa, b, a
     +-v-+
     | a |\0
     +---+
   a, a, b, a

  You can see this algorithm still can be optimized, becasue there are some dupliation.
  (  The optimization you can see the "Palindrome Partitioning II" )
*/
vector<vector<string>> partition(string s) {
  vector<vector<string> > ret;
  if (s.empty()) return ret;

  vector<string> path;
  dfs(0, s, path, ret);

  return ret;
}

void dfs(int index, string& s, vector<string>& path, vector<vector<string> >& ret) {
  if (index == s.size()) {
    ret.push_back(path);
    return;
  }
  for (int i = index; i < s.size(); ++i) {
    if (isPalindrome(s, index, i)) {
      path.push_back(s.substr(index, i - index + 1));
      dfs(i + 1, s, path, ret);
      path.pop_back();
    }
  }
}

bool isPalindrome(const string& s, int start, int end) {
  while (start <= end) {
    if (s[start++] != s[end--])
      return false;
  }
  return true;
}

void printMatrix(vector< vector<string> > &matrix)
{
  for (int i = 0; i < matrix.size(); i++) {
    cout << "{ ";
    for (int j = 0; j < matrix[i].size(); j++) {
      cout << matrix[i][j] << ", ";
    }
    cout << "}" << endl;
  }
  cout << endl;
}


int main(int argc, char** argv)
{
  string s("aab");
  if (argc > 1) {
    s = argv[1];
  }

  vector< vector<string> > result = partition(s);

  printMatrix(result);
}
