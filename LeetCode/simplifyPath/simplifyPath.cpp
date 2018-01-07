// Source : https://leetcode.com/problems/simplify-path/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-10-09

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;


string simplifyPath(string path) {
  string res, tmp;
  vector<string> stk;
  stringstream ss(path);
  while (getline(ss, tmp, '/')) {
    if (tmp == "" or tmp == ".") continue;
    if (tmp == ".." and !stk.empty()) stk.pop_back();
    else if (tmp != "..") stk.push_back(tmp);
  }
  for (auto str : stk) res += "/" + str;
  return res.empty() ? "/" : res;
}

int main(int argc, char** argv)
{
  string path("/a/./b/../../c/");
  if (argc > 1) {
    path = argv[1];
  }

  cout << path << " : " << simplifyPath(path) << endl;
}
