/*
Source : https://leetcode.com/problems/add-binary/description/
Author : Shiv S. Kushwaha
Date   : 2014-07-05

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

#include <iostream>
#include <string>
using namespace std;

string addBinary(string a, string b)
{
  string s = "";

  int c = 0, i = a.size() - 1, j = b.size() - 1;
  while (i >= 0 || j >= 0 || c == 1)
  {
    c += i >= 0 ? a[i--] - '0' : 0;
    c += j >= 0 ? b[j--] - '0' : 0;
    s = char(c % 2 + '0') + s;
    c /= 2;
  }

  return s;
}


int main(int argc, char** argv)
{
  string a = "11";
  string b = "1";

  if (argc > 2)
  {
    a = argv[1];
    b = argv[2];
  }

  cout << a << "+" << b << "=" << addBinary(a, b) << endl;

  system("pause");

  return 0;
}
