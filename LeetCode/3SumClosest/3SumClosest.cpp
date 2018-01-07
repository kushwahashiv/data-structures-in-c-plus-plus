/*
Source : https://leetcode.com/problems/3sum-closest/description/
Author : Shiv S. Kushwaha
Date   : 12.10.2014

Problem:
Given an array S of n integers, find three integers in S such that the sum is
closest to a given number, target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

solution:  http://en.wikipedia.org/wiki/3SUM
The idea as blow:
1. sort the array.
2. take the element one by one, calculate the two numbers in reset array.

notes: be careful the duplication number.
for example:
[-4,-1,-1,1,2]    target=1

take -4, can cacluate the "two number problem" of the reset array [-1,-1,1,2] while target=5
[(-4),-1,-1,1,2]  target=5  distance=4
^      ^
because the -1+2 = 1 which < 5, then move the `low` pointer(skip the duplication)
[(-4),-1,-1,1,2]  target=5  distance=2
^ ^
take -1(skip the duplication), can cacluate the "two number problem" of the reset array [1,2] while target=2
[-4,-1,(-1),1,2]  target=2  distance=1
^ ^
*/

#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int threeSumClosest(vector<int>& nums, int target) {
  if (nums.size() < 3) return 0;
  int closest = nums[0] + nums[1] + nums[2];
  sort(nums.begin(), nums.end());

  for (int first = 0; first < nums.size() - 2; ++first) {
    if (first > 0 && nums[first] == nums[first - 1]) continue;

    int second = first + 1;
    int third = nums.size() - 1;
    while (second < third) {
      int curSum = nums[first] + nums[second] + nums[third];

      if (curSum == target) return curSum;

      if (abs(target - curSum) < abs(target - closest)) {
        closest = curSum;
      }

      if (curSum > target) {
        --third;
      }
      else {
        ++second;
      }
    }
  }
  return closest;
}

int main()
{
  int target = 1;
  vector<int> n = { -1, 2, 1, -4 };
  cout << threeSumClosest(n, target) << endl;

  system("pause");
  return 0;
}
