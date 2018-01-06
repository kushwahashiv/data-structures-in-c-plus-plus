

#include <iostream>
#include<map>
#include<vector>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
  map<int, int> m;
  for (int i = 0; i <nums.size(); i++) {
    int complement = target - nums[i];
    auto a = m.find(complement);
    if (a != m.end()) {
      vector<int> result = { a->second, i };
      return result;
    }
    m.insert(pair<int, int>(nums[i], i));
  }
  // throw new IllegalArgumentException("No two sum solution");
}


int main()
{
  vector<int> a = { 2, 7, 11, 15 };
  auto o = twoSum(a, 9);

  for (auto a : o) {
    std::cout <<a << endl;
  }

  system("pause");
    return 0;
}

