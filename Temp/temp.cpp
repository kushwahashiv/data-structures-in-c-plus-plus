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

  for (auto s : arr)
  {
    int a = 1, b = 1, c = 1;
    bool found = false;
    for (a = 1; a < s; a++)
    {
      for (b = 1; b < s; b++)
      {
        c = s - a - b;
        if (a*a + b*b == c*c)
        {
          found = true;
          break;
        }
      }
      if (found)
      {
        break;
      }
    }

    int mul = a*b*c;
    if (mul < 0)
      mul = -1;

    //std::cout << a << " " << b << " " << c << std::endl;
    std::cout << mul << std::endl;
  }

  return 0;
}