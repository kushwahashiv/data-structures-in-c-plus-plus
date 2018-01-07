// Source : https://leetcode.com/problems/sort-colors/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-25

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/

#include <iostream>
#include <time.h>

/*
The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
It is hard to define what is a “one-pass” solution but this algorithm is bounded by O(2n),
meaning that at most each element will be seen and operated twice (in the case of all 0s).
You may be able to write an algorithm which goes through the list only once, but each step requires multiple operations,
leading the total operations larger than O(2n).
*/
void sortColors(int A[], int n) {
  int second = n - 1, zero = 0;
  for (int i = 0; i <= second; i++) {
    while (A[i] == 2 && i < second) swap(A[i], A[second--]);
    while (A[i] == 0 && i > zero) swap(A[i], A[zero++]);
  }
}

void printArray(int a[], int n) {
  for (int i = 0; i < n; i++) {
    printf("%d ", a[i]);
  }
  printf("\n");
}

int main(int argc, char** argv)
{
  int n = 7;
  if (argc > 1)
    n = atoi(argv[1]);

  srand(time(nullptr));

  int *a = new int[n];
  for (int i = 0; i < n; i++) {
    a[i] = rand() % 3;
  }
  printArray(a, n);
  sortColors(a, n);
  printArray(a, n);

  delete[] a;
}

