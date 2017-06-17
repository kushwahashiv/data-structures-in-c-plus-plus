#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;

std::vector<std::pair<int, int>> find_min_abs_diff(std::vector<int>& arr) {
  // Sort the vector O(nlogn)
  std::sort(arr.begin(), arr.end());

  // Find the difference between every adjacent elements. O(n)
  // Keep track of minimum
  int min_so_far = std::numeric_limits<int>::max();
  std::vector<std::pair<int, int>> pairs;

  for (size_t i = 1; i < arr.size(); i++) {
    int diff = std::abs(arr[i] - arr[i - 1]);
    if (diff <= min_so_far) {
      min_so_far = diff;
      pairs.emplace_back(arr[i], arr[i - 1]);
    }
  }

  // Remove elements that are greater than the minimum found.
  pairs.erase(std::remove_if(pairs.begin(), pairs.end(),
    [&](const std::pair<int, int>& p) {
    return p.first - p.second > min_so_far;
  }), pairs.end());

  return pairs;
}


int main() {
  std::vector<int> arr{ -20, -3916237, -357920, -3620601, 7374819, -7330761,
    30, 6246457, -6461594, 266854, -520, -470 };
  std::vector<std::pair<int, int>> min_pairs = find_min_abs_diff(arr);
  
  for (const auto& item : min_pairs)
  {
    cout << item.second << " " << item.first << " ";
  }

  system("pause");
}



/*
std::vector<std::pair<int, int>> ClosestNumber(vector<int> a){
  int closest(a[0]);
  int diff = 0;
  bool initial = false;
  std::vector<std::pair<int, int>> closestPairs;

  for (unsigned int i = 0; i < a.size(); ++i)
  {
    for (unsigned int j = i + 1; j < a.size(); ++j)
    {
      //int difference = abs(a[i] - a[j]);
      int difference = abs(closest - a[j]);


      if (closest == difference)
      {
        closestPairs.push_back(std::make_pair(a[i], a[j]));
      }
      else if (closest > difference)
      {
        closest = difference;
        closestPairs.clear();
        closestPairs.push_back(std::make_pair(a[i], a[j]));
      }
      else if (!initial)
      {
        closest = difference;
        initial = true;
      }
    }
  }

  return closestPairs;
}


int main() {

  vector<int> dataArray = { -20, - 3916237, - 357920, - 3620601, 7374819, - 7330761, 30, 6246457, - 6461594, 266854, - 520, - 470 };
  auto res = ClosestNumber(dataArray);
  for (auto& item : res)
  {
    cout << item.first << " " << item.second << " ";
  }

  system("pause");

  return 0;
}
*/