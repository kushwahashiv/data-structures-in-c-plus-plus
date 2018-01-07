// Source : https://leetcode.com/problems/generate-parentheses/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-29

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

#include <string>
#include <iostream>
#include <vector>
using namespace std;

void generator(vector<string> &v, string str, int n, int m) {
  if (n == 0 && m == 0) {
    v.push_back(str);
    return;
  }
  if (m > 0) { generator(v, str + ")", n, m - 1); }
  if (n > 0) { generator(v, str + "(", n - 1, m + 1); }
}

vector<string> generateParenthesis(int n) {
  vector<string> res;
  generator(res, "", n, 0);
  return res;
}

void printResult(vector<string>& result)
{
  for (int i = 0; i < result.size(); i++) {
    std::cout << result[i] << endl;
  }
}

int main(int argc, char** argv)
{
  int n = 4;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  vector<string> r = generateParenthesis(n);
  printResult(r);
  return 0;
}
