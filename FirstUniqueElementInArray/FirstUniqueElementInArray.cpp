/*
Problem:
Implement an algorithm that takes an input array and returns only the unique elements in it.

Hints:
If the array is sorted you do not need hashmaps to achieve O(n). 
If you have a random/unsorted array you can use hashmaps to achieve the purpose,
Note that sorting requires O(n log(n)).

Point of interest: the first pass works because the values inside the unordered map (= hash map) are initialised with the default value, 0. 
We are using this fact to increment the values directly without bothering to check whether the value existed in the map beforehand. 
This makes the code more concise and is actually also more efficient.

read more about std::unordered_map:
http://www.cplusplus.com/reference/unordered_map/unordered_map/
*/

#include <iostream>
#include <unordered_map>
#include <vector>

int main() {
  std::unordered_map<int, unsigned> occurrences;

  int a[8] = { 1, 1, 1, 2, 2, 3, 3, 5};
  unsigned const size = sizeof a / sizeof a[0];

  // First pass: count occurrences.
  for (unsigned i = 0; i < size; ++i)
  {
    ++occurrences[a[i]];
  }


  // Second pass: search singleton.
  for (unsigned i = 0; i < size; ++i)
  {
    if (occurrences[a[i]] == 1)
    {
      std::cout << a[i] << " only occurred once." << std::endl;
    }
  }

  system("pause");

  return 0;
}