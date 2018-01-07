/*
Source : https://leetcode.com/problems/3sum/description/
Author : Shiv S. Kushwaha
Date   : 2014-07-22

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

// method: 1
vector<vector<int> > threeSum(vector<int> &num) {
    vector<vector<int> > res;
    std::sort(num.begin(), num.end());
    for (int i = 0; i < num.size(); i++) {
        int target = -num[i];
        int front = i + 1;
        int back = num.size() - 1;

        while (front < back) {

            int sum = num[front] + num[back];

            // Finding answer which start from number num[i]
            if (sum < target)
                front++;

            else if (sum > target)
                back--;

            else {
                vector<int> triplet(3, 0);
                triplet[0] = num[i];
                triplet[1] = num[front];
                triplet[2] = num[back];
                res.push_back(triplet);

                // Processing duplicates of Number 2
                // Rolling the front pointer to the next different number forwards
                while (front < back && num[front] == triplet[1]) front++;

                // Processing duplicates of Number 3
                // Rolling the back pointer to the next different number backwards
                while (front < back && num[back] == triplet[2]) rear--;
            }

        }

        // Processing duplicates of Number 1
        while (i + 1 < num.size() && num[i + 1] == num[i])
            i++;
    }
    return res;
}


//2.
vector<vector<int>> threeSum(vector<int>& nums) {
	vector<vector<int>> result;
	sort(nums.begin(), nums.end());

	for (auto i = 0; i < nums.size();) {
		auto target = -nums[i];
		int l = i + 1, u = nums.size() - 1;

		while (l < u) {
			auto sum = nums[l] + nums[u];

			if (sum < target)
				while (++l < nums.size() && nums[l] == nums[l - 1]);  // Processing duplicates of Number 2
			else if (sum > target)
				while (--u < nums.size() && nums[u] == nums[u + 1]);  // Processing duplicates of Number 3
			else {
				result.push_back(vector<int>{nums[i], nums[l], nums[u]});
				while (++l < nums.size() && nums[l] == nums[l - 1]);  // Processing duplicates of Number 2
				while (--u < nums.size() && nums[u] == nums[u + 1]);  // Processing duplicates of Number 3
			}
		}
		// Processing duplicates of Number 1
		while (++i < nums.size() && nums[i] == nums[i - 1]);
	}

	return result;
}

void printMatrix(vector<vector<int> > &matrix)
{
  for (int i = 0; i < matrix.size(); i++)
  {
    printf("{");
    for (int j = 0; j < matrix[i].size(); j++)
    {
      printf("%3d ", matrix[i][j]);
    }
    printf("}\n");
  }
  cout << endl;
}


int main()
{
  vector<int> n = { -1, 1, 1, 1, -1, -1, 0, 0, 0 };
  vector< vector<int> > result = threeSum(n);
  printMatrix(result);

  system("pause");
  return 0;
}
