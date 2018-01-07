// Source : https://leetcode.com/problems/roman-to-integer/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-17

/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

#include <iostream>
#include <string>
using namespace std;

//Problem is simpler to solve by working the string from back to front and using a map. Runtime speed is 88 ms.

int romanToInt(string s)
{
  unordered_map<char, int> T = { { 'I' , 1 },
                                 { 'V' , 5 },
                                 { 'X' , 10 },
                                 { 'L' , 50 },
                                 { 'C' , 100 },
                                 { 'D' , 500 },
                                 { 'M' , 1000 } };

  int sum = T[s.back()];
  for (int i = s.length() - 2; i >= 0; --i)
  {
    if (T[s[i]] < T[s[i + 1]])
    {
      sum -= T[s[i]];
    }
    else
    {
      sum += T[s[i]];
    }
  }

  return sum;
}

int main(int argc, char**argv)
{
  string s("XL");
  if (argc > 1) {
    s = argv[1];
  }
  cout << s << " : " << romanToInt(s) << endl;
  return 0;
}
