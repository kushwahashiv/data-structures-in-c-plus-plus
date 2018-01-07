// Source : https://leetcode.com/problems/remove-element/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-19

/*
Given an array and a value, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given nums = [3,2,2,3], val = 3,
Your function should return length = 2, with the first two elements of nums being 2.
*/

int removeElement(int A[], int n, int elem) {
  int begin = 0;
  for (int i = 0; i < n; i++) if (A[i] != elem) A[begin++] = A[i];
  return begin;
}


int removeElement(int A[], int n, int elem) {
  int tail = n - 1;
  int i = 0;
  while (i <= tail) {
    if (A[i] == elem) {
      A[i] = A[tail--];
      continue;
    }
    i++;
  }

  return tail + 1;
}

int main()
{
  return 0;
}
