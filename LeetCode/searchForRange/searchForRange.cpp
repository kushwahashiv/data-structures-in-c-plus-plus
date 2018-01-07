// Source : https://leetcode.com/problems/search-for-a-range/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-26

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

#include <iostream>
#include <vector>
using namespace std;

// https://leetcode.com/problems/search-for-a-range/discuss/14699
vector<int> searchRange(int A[], int n, int target) {
  int i = 0, j = n - 1;
  vector<int> ret(2, -1);
  // Search for the left one
  while (i < j)
  {
    int mid = (i + j) / 2;
    if (A[mid] < target) i = mid + 1;
    else j = mid;
  }
  if (A[i] != target) return ret;
  else ret[0] = i;

  // Search for the right one
  j = n - 1;  // We don't have to set i to 0 the second time.
  while (i < j)
  {
    int mid = (i + j) / 2 + 1;	// Make mid biased to the right
    if (A[mid] > target) j = mid - 1;
    else i = mid;				// So that this won't make the search range stuck.
  }
  ret[1] = j;
  return ret;
}

void printVector(vector<int>&  pt)
{
  cout << "{ ";
  for (int j = 0; j < pt.size(); j++) {
    cout << pt[j] << " ";
  }
  cout << "} " << endl;
}


int main()
{
  const int cnt = 6;
  int a[cnt] = { 5, 7, 7, 8, 8, 10 };

  vector<int> v;
  v = searchRange(a, cnt, 8);
  printVector(v);


  int b[cnt] = { 5, 5, 5, 8, 8, 10 };
  v = searchRange(b, cnt, 5);
  printVector(v);

  int c[cnt] = { 5, 5, 5, 5, 5, 5 };
  v = searchRange(c, cnt, 5);
  printVector(v);
  return 0;
}
