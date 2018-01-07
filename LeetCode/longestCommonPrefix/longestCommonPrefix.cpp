// Source : https://leetcode.com/problems/longest-common-prefix/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-03

//Write a function to find the longest common prefix string amongst an array of strings.

#include <iostream>
#include <string>
#include <vector>
using namespace std;

string longestCommonPrefix(vector<string>& strs) {
  string prefix = "";
  for (int idx = 0; strs.size() > 0; prefix += strs[0][idx], idx++)
    for (int i = 0; i < strs.size(); i++)
      if (idx >= strs[i].size() || (i > 0 && strs[i][idx] != strs[i - 1][idx]))
        return prefix;
  return prefix;
}

int main()
{
  const char* s[] = { "abab","aba","abc" };
  vector<string> v(s, s + 3);
  cout << longestCommonPrefix(v) << endl;
}
