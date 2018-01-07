// Source : https://leetcode.com/problems/valid-parentheses/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-30

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

#include <iostream>
#include <string>
#include<stack>

using namespace std;

bool isValid(string s) {
  stack<char> paren;
  for (char& c : s) {
    switch (c) {
    case '(':
    case '{':
    case '[': paren.push(c); break;
    case ')': if (paren.empty() || paren.top() != '(') return false; else paren.pop(); break;
    case '}': if (paren.empty() || paren.top() != '{') return false; else paren.pop(); break;
    case ']': if (paren.empty() || paren.top() != '[') return false; else paren.pop(); break;
    default:; // pass
    }
  }
  return paren.empty();
}


int main(int argc, char**argv)
{
  string s = "{{}{[]()}}";
  if (argc > 1) {
    s = argv[1];
  }
  cout << "str = \"" << (s) << "\"" << endl;
  cout << isValid(s) << endl;
}
