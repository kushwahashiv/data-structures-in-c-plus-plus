// Source : https://leetcode.com/problems/single-number/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-17

/*
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
#include <iostream>

// known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
int singleNumber(int A[], int n) {
  int result = 0;
  for (int i = 0; i < n; i++)
  {
    result ^= A[i];
  }
  return result;
}

int main()
{
  int a[] = { 1,1,2,2,3 };
  printf("%d\n", singleNumber(a, 5));
  return 0;
}
