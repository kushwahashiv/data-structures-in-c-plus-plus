// Source : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-16

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

#include <vector>
#include <iostream>
using namespace std;


int evalRPN(vector<string>& tokens) {
  string s = tokens.back(); tokens.pop_back();
  if (s != "+" && s != "-" && s != "*" && s != "/") return stoi(s);

  int r2 = evalRPN(tokens), r1 = evalRPN(tokens);

  if (s == "+") return r1 + r2;
  if (s == "-") return r1 - r2;
  if (s == "*") return r1 * r2;
  if (s == "/") return r1 / r2;
}

int main()
{
  Solution s;
  char exps[5][3] = { "42", "9", "6", "-", "+" };
  vector<string> expression;

  cout << "Expression: \n    ";
  for (int i = 0; i < 5; i++) {
    expression.push_back(exps[i]);
    cout << exps[i] << " ";
  }
  cout << endl;
  cout << s.evalRPN(expression) << endl;;

  char exps2[5][3] = { "2", "1", "+", "3", "*" };
  expression.clear();

  cout << "Expression: \n    ";
  for (int i = 0; i < 5; i++) {
    expression.push_back(exps2[i]);
    cout << exps2[i] << " ";
  }
  cout << endl;
  cout << s.evalRPN(expression) << endl;



  return 0;
}
