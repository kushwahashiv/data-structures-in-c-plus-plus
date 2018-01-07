/*
Long Encoded String
----------------------------
Consider a string consisting of lowercase English alphabetic letters(i.e., [a - z]) only.We use the following rules to encode all of its characters into string s :
- a is encoded as 1, b is encoded as 2, c is encoded as 3, ..., and i is encoded as 9.
- j is encoded as 10#, k is encoded as 11#, i is encoded as 12#, ..., and z is encoded as 26#.
- If there are two or more consecutive occurrences of any character, then the character count is written within parentheses(i.e., (c), where c is an integer denoting the count of consecutive occurrences being encoded) immediately following the character.For example, consider the following string encodings :

o String "abzx" is encoded as s = "1226#24#".
o String "aabccc" is encoded as s = "1(2)23(3)".
o String "bajj" is encoded as s = "2110#(2)".
o String "wwxyzwww" is encoded as s = "23#(2)24#25#26#23#(3).

Complete the frequency function in the editor below.It has one parameter : a string, s, that was encoded using the rules above and consists of digits(i.e., decimal integers from 0 to 9), # symbols, and parentheses.It must return an array of 26 integ
- The element at index 0 denotes the frequency of character a in the original string.
- The element at index 1 denotes the frequency of character b in the original string.
- The element at index 2 denotes the frequency of character c in the original string.
- The element at index 25 denotes the frequency of character z in the original string.Input Format
Locked stub code in the editor reads encoded string s from stdin and passes it to the function.

Constraints
- String s consists of decimal integers from 0 to 9, #s, and O's only.
- 1 length of s 105
- It is guaranteed that string s is a valid encoded string.
- 2 c 104, where c is a parenthetical count of consecutive occurrences of an encoded character.

Output Format
The function must return an array of 26 integers denoting the respective frequencies of each character(i.e., a through z) in the decoded string.This is printed to stdout by locked stub code in the editor.
Sample Input 0
1226#24#

Sample Output 0
1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1
*/

#include<iostream>
#include<string>
#include<array>

using namespace std;

auto frequency(string s) {
  array<int, 26> res = {};
  int len = s.length();
  int i = 0;
  while (i < len) {
    int val = 0;
    if (i + 2 >= len || s[i + 2] != '#') {//single num
      val = s[i] - '0';
      res[val - 1]++;
      i++;
    }
    else if (s[i + 2] == '#') {//double num
      val = (s[i] - '0') * 10 + (s[i + 1] - '0');
      res[val - 1]++;
      i = i + 3;
    }
    if (i < len) {//update frequency
      if (s[i] == '(') {
        int freq = s[i + 1] - '0';
        res[val - 1] += freq - 1;
        i = i + 3;
      }
    }
  }
  return res;
}


auto main() -> int {
  string s("1226#24#");
  auto result = frequency(s);
  for (auto r: result) {
    std::cout << r;
  }

  return 0;
}