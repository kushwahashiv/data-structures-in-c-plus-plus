// Source : https://leetcode.com/problems/valid-palindrome/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-26

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/

#include<iostream>
#include<string>

using namespace std;

bool isPalindrome(string s) {
  for (int i = 0, j = s.size() - 1; i < j; i++, j--) { // Move 2 pointers from each end until they collide
    while (isalnum(s[i]) == false && i < j) i++; // Increment left pointer if not alphanumeric
    while (isalnum(s[j]) == false && i < j) j--; // Decrement right pointer if no alphanumeric
    if (toupper(s[i]) != toupper(s[j])) return false; // Exit and return error if not match
  }

  return true;
}

// 2

bool isPalindrome(string s) {
  int start = 0, end = s.length() - 1;
  while (start < end) {
    if (!isalnum(s[start])) start++;
    else if (!isalnum(s[end])) end--;
    else {
      if (tolower(s[start++]) != tolower(s[end--])) return false;
    }
  }
  return true;
}


int main()
{
  return 0;
}