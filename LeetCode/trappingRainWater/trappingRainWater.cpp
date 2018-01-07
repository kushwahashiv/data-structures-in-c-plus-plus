// Source : https://leetcode.com/problems/trapping-rain-water/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-02


/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     ^
     |
   3 |                       +--+
     |                       |  |
   2 |          +--+xxxxxxxxx|  +--+xx+--+
     |          |  |xxxxxxxxx|  |  |xx|  |
   1 |   +--+xxx|  +--+xxx+--+  |  +--+  +--+
     |   |  |xxx|  |  |xxx|  |  |  |  |  |  |
   0 +---+--+---+--+--+---+--+--+--+--+--+--+----->
       0  1   0  2  1   0  1  3  2  1  2  1
 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

#include <iosteram>

/*
instead of calculating area by height*width, we can think it in a cumulative way.
In other words, sum water amount of each bin(width=1).
Search from left to right and maintain a max height of left and right separately,
which is like a one-side wall of partial container. Fix the higher one and flow water from the lower part.
For example, if current height of left is lower, we fill water in the left bin. Until left meets right, we filled the whole container.
*/
int trap(int A[], int n) {
  int left = 0; int right = n - 1;
  int res = 0;
  int maxleft = 0, maxright = 0;
  while (left <= right) {
    if (A[left] <= A[right]) {
      if (A[left] >= maxleft) maxleft = A[left];
      else res += maxleft - A[left];
      left++;
    }
    else {
      if (A[right] >= maxright) maxright = A[right];
      else res += maxright - A[right];
      right--;
    }
  }
  return res;
}


#define TEST(a) printf("%d\n", trap(a, sizeof(a)/sizeof(int)))
int main()
{
  int a[] = { 2,0,2 };
  TEST(a);
  int b[] = { 0,1,0,2,1,0,1,3,2,1,2,1 };
  TEST(b);
  return 0;
}
