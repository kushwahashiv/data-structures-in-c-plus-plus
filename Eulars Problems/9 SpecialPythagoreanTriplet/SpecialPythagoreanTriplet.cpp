// Written by Zack Phoenix
// Project Euler Problem #9
// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2
// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

#include<iostream>
#include<vector>

using namespace std;

int main()
{
  std::vector<int> arr;
  int T;
  std::cin >> T;

  for (int i = 0; i < T; i++)
  {
    int N;
    std::cin >> N;
    arr.push_back(N);
  }

  for (auto sum : arr)
  {
    int a;
    bool isTriplet = false;
    for (a = 1; a <= sum / 3; a++)
    {
      int b;
      for (b = a + 1; b <= sum / 2; b++)
      {
        int c = sum - a - b;
        if (a*a + b*b == c*c)
        {
          std::cout << a*b*c << std::endl;
          isTriplet = true;
        }
      }
    }
    if (!isTriplet)
      std::cout << -1 << std::endl;

  }

  return 0;
}
