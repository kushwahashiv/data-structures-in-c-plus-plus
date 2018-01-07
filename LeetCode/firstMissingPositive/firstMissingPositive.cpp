// Source : https://leetcode.com/problems/first-missing-positive/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-18

/*
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
*/
#include <iostream>
#include <map>
using namespace std;

int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        for (int i = 0; i < n; i++)
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums[i], nums[nums[i] - 1]);
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }

void printArray(vector<int>& data){
    for(auto d: data) {
        cout << d << ", ";
    }
}

void Test(vector<int>& data, int expected) {
    printArray(data);
    int ret = firstMissingPositive(data);
    cout << "\t   missed = " << ret << "  " << (ret==expected?"passed!":"failed!") << endl;
    printArray(data);
    cout <<endl;
}

int main()
{
    vector<int>a0={1};
    TEST(a0);

    vector<int> a1={1,2,0};
    TEST(a1);

    vector<int> a2 ={3,4,-1,1};
    TEST(a2);

    vector<int> a3={1000,-1};
    TEST(a3);

    vector<int> a4={1000, 200};
    TEST(a4);

    vector<int> a5={2,5,3,-1};
    TEST(a5);

    vector<int> a6={1, 100};
    TEST(a6);

    vector<int> a7={7,8,9,11};
    TEST(a7);

    vector<int> a8={4,3,2,1};
    TEST(a8);

    return 0;
}
