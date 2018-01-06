/*
Source : https://oj.leetcode.com/problems/4sum/
Author : Shiv S. Kushwaha
Date   : 2014-07-03

Problem:
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in ascending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)

Solution:
1. Sort the array,
2. traverse the array, and solve the problem by using "3Sum" soultion.

*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int> > threeSum(vector<int> num, int target);


vector<vector<int> > fourSum(vector<int> &num, int target)
{
  vector< vector<int> > result;
  if (num.size() < 4) return result;
  sort(num.begin(), num.end());

  for (int i = 0; i < num.size() - 3; i++)
  {
    //skip the duplication
    if (i>0 && num[i - 1] == num[i])
      continue;

    vector<int> n(num.begin() + i + 1, num.end());
    vector<vector<int> > ret = threeSum(n, target - num[i]);

    for (int j = 0; j < ret.size(); j++)
    {
      ret[j].insert(ret[j].begin(), num[i]);
      result.push_back(ret[j]);
    }
  }

  return result;
}

vector<vector<int> > threeSum(vector<int> num, int target)
{
  vector< vector<int> > result;
  //sort the array (if the qrray is sorted already, it won't waste any time)
  sort(num.begin(), num.end());

  int n = num.size();

  for (int i = 0; i < n - 2; i++)
  {
    //skip the duplication
    if (i>0 && num[i - 1] == num[i])
      continue;
    int a = num[i];
    int low = i + 1;
    int high = n - 1;

    while (low < high)
    {
      int b = num[low];
      int c = num[high];
      if (a + b + c == target)
      {
        //got the soultion
        vector<int> v;
        v.push_back(a);
        v.push_back(b);
        v.push_back(c);
        result.push_back(v);
        // Continue search for all triplet combinations summing to zero.
        //skip the duplication
        while (low < n && num[low] == num[low + 1])
          low++;
        while (high > 0 && num[high] == num[high - 1])
          high--;

        low++;
        high--;
      }
      else if (a + b + c > target)
      {
        //skip the duplication
        while (high > 0 && num[high] == num[high - 1])
          high--;

        high--;
      }
      else{
        //skip the duplication
        while (low < n && num[low] == num[low + 1])
          low++;

        low++;
      }
    }
  }
  return result;
}


void printMatrix(vector< vector<int> > &vv)
{
  for (int i = 0; i < vv.size(); i++)
  {
    cout << "[";
    for (int j = 0; j < vv[i].size(); j++)
    {
      cout << " " << vv[i][j];
    }
    cout << "]" << endl;;
  }
}


// method 2
vector<vector<int>> fourSum2(vector<int>& nums, int target) {
	vector<vector<int>> total;
	int n = nums.size();
	if (n < 4)  return total;
	sort(nums.begin(), nums.end());

	for (int i = 0; i < n - 3; i++)
	{
		if (i > 0 && nums[i] == nums[i - 1]) continue;
		if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
		if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;

		for (int j = i + 1; j < n-2; j++)
		{
			if (j > i+1 && nums[j] == nums[j - 1]) continue;
			if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
			if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;

			int left = j + 1, right = n - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i] + nums[j];
				if (sum < target) left++;
				else if (sum > target) right--;
				else {
					total.push_back(vector<int>{nums[i], nums[j], nums[left], nums[right]});
					do { left++; } while (nums[left] == nums[left - 1] && left < right);
					do { right--; } while (nums[right] == nums[right + 1] && left < right);
				}
			}
		}
	}
	return total;
}


int main()
{
  vector<int> n = { 1, 0, -1, 0, -2, 2 };
  int t = 0;
  vector< vector<int> > v = fourSum2(n, t);
  printMatrix(v);

  n.clear();
  int b[] = { -1, -5, -5, -3, 2, 5, 0, 4 };
  n.insert(n.begin(), b, b + 8);
  t = -7;

  v = fourSum2(n, t);
  printMatrix(v);

  system("pause");

  return 0;
}
