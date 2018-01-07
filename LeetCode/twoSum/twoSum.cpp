// Source : https://leetcode.com/problems/two-sum/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-17

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

#include<iostream>
#include<vector>
#include<map>

using namespace std;


vector<int> twoSum(vector<int> &numbers, int target)
{
    //Key is the number and value is its index in the vector.
	unordered_map<int, int> hash;
	vector<int> result;
	for (int i = 0; i < numbers.size(); i++) {
		int numberToFind = target - numbers[i];

            //if numberToFind is found in map, return them
		if (hash.find(numberToFind) != hash.end()) {
                    //+1 because indices are NOT zero based
			result.push_back(hash[numberToFind] + 1);
			result.push_back(i + 1);
			return result;
		}

            //number was not found. Put it in the map.
		hash[numbers[i]] = i;
	}
	return result;
}

// 2
  vector<int> twoSum(vector<int> &numbers, int target) {
    map<int, int> m;
    vector<int> result;
    for (int i = 0; i < numbers.size(); i++){
      // not found the second one
      if (m.find(numbers[i]) == m.end()) {
        // store the first one poisition into the second one's key
        m[target - numbers[i]] = i;
      }
      else {
        // found the second one
        result.push_back(m[numbers[i]] + 1);
        result.push_back(i + 1);
        break;
      }
    }
    return result;
  }



int main()
{

  return 0;
}