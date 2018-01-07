// Source : https://oj.leetcode.com/problems/palindrome-number/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-18

/*
Determine whether an integer is a palindrome. Do this without extra space.
Some hints:
Could negative integers be palindromes? (ie, -1)
If you are thinking of converting the integer to string, note the restriction of using extra space.
You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
There is a more generic way of solving this problem.
*/

#include <iostream>

bool isPalindrome(int x) {
  if (x < 0 || (x != 0 && x == 0)) return false;
  int sum = 0;
  while (x > sum)
  {
    sum = sum * 10 + x;
    x = x / 10;
  }
  return (x == sum) || (x == sum / 10);
}

int main()
{
  printf("%d is %d\n", 0, isPalindrome(0));
  printf("%d is %d\n", -101, isPalindrome(-101));
  printf("%d is %d\n", 1001, isPalindrome(1001));
  printf("%d is %d\n", 1234321, isPalindrome(1234321));
  printf("%d is %d\n", 2147447412, isPalindrome(2147447412));
  printf("%d is %d\n", 2142, isPalindrome(2142));
}
