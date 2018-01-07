// Source : https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-22

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

//Solution explanation: https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471
*/

#include <stdio.h>

double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
  int N1 = nums1.size();
  int N2 = nums2.size();
  if (N1 < N2) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.

  int lo = 0, hi = N2 * 2;
  while (lo <= hi) {
    int mid2 = (lo + hi) / 2;   // Try Cut 2
    int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly

    double L1 = (mid1 == 0) ? INT_MIN : nums1[(mid1 - 1) / 2];	// Get L1, R1, L2, R2 respectively
    double L2 = (mid2 == 0) ? INT_MIN : nums2[(mid2 - 1) / 2];
    double R1 = (mid1 == N1 * 2) ? INT_MAX : nums1[(mid1) / 2];
    double R2 = (mid2 == N2 * 2) ? INT_MAX : nums2[(mid2) / 2];

    if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
    else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
    else return (max(L1, L2) + min(R1, R2)) / 2;	// Otherwise, that's the right cut.
  }
  return -1;
}


int main()
{
  int r1[] = { 1 };
  int r2[] = { 2 };

  int n1 = sizeof(r1) / sizeof(r1[0]);
  int n2 = sizeof(r2) / sizeof(r2[0]);

  printf("Median is 1.5 = %f\n", findMedianSortedArrays(r1, n1, r2, n2));

  int ar1[] = { 1, 12, 15, 26, 38 };
  int ar2[] = { 2, 13, 17, 30, 45, 50 };

  n1 = sizeof(ar1) / sizeof(ar1[0]);
  n2 = sizeof(ar2) / sizeof(ar2[0]);

  printf("Median is 17 = %f\n", findMedianSortedArrays(ar1, n1, ar2, n2));

  int ar11[] = { 1, 12, 15, 26, 38 };
  int ar21[] = { 2, 13, 17, 30, 45 };

  n1 = sizeof(ar11) / sizeof(ar11[0]);
  n2 = sizeof(ar21) / sizeof(ar21[0]);

  printf("Median is 16 = %f\n", findMedianSortedArrays(ar11, n1, ar21, n2));

  int a1[] = { 1, 2, 5, 6, 8 };
  int a2[] = { 13, 17, 30, 45, 50 };

  n1 = sizeof(a1) / sizeof(a1[0]);
  n2 = sizeof(a2) / sizeof(a2[0]);

  printf("Median is 10.5 = %f\n", findMedianSortedArrays(a1, n1, a2, n2));

  int a10[] = { 1, 2, 5, 6, 8, 9, 10 };
  int a20[] = { 13, 17, 30, 45, 50 };

  n1 = sizeof(a10) / sizeof(a10[0]);
  n2 = sizeof(a20) / sizeof(a20[0]);

  printf("Median is 9.5 = %f\n", findMedianSortedArrays(a10, n1, a20, n2));

  int a11[] = { 1, 2, 5, 6, 8, 9 };
  int a21[] = { 13, 17, 30, 45, 50 };

  n1 = sizeof(a11) / sizeof(a11[0]);
  n2 = sizeof(a21) / sizeof(a21[0]);

  printf("Median is 9 = %f\n", findMedianSortedArrays(a11, n1, a21, n2));

  int a12[] = { 1, 2, 5, 6, 8 };
  int a22[] = { 11, 13, 17, 30, 45, 50 };

  n1 = sizeof(a12) / sizeof(a12[0]);
  n2 = sizeof(a22) / sizeof(a22[0]);

  printf("Median is 11 = %f\n", findMedianSortedArrays(a12, n1, a22, n2));

  int b1[] = { 1 };
  int b2[] = { 2,3,4 };

  n1 = sizeof(b1) / sizeof(b1[0]);
  n2 = sizeof(b2) / sizeof(b2[0]);

  printf("Median is 2.5 = %f\n", findMedianSortedArrays(b1, n1, b2, n2));
  return 0;
}
