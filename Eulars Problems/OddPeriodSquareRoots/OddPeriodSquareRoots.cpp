#include<iostream>
#include<math.h>

auto CalcOddPeriod(int n)-> int
{
  int oddPeriod = 0;
  for (int i = 2; i < n+1; i++)
  {
    int r, limit;
    r = limit = int(sqrt(i));
    if (limit*limit == i)
      continue;
    int k=1, period=0;

    while (k != 1 || period == 0)
    {
      k = (i - r * r) / k;
      r = (limit + r) / k * k - r;
      period += 1;
     
    }
    if (period % 2 == 1)
    {
      oddPeriod += 1;
    }
  }
  return oddPeriod;
}

auto main() ->int
{
  int n;
  std::cin >> n;
  std::cout << CalcOddPeriod(n);
  system("pause");
  return 0;
}

//
//from math import sqrt
//
//L = int(input())
//
//odd_period = 0
//
//for N in range(2, L + 1) :
//r = limit = int(sqrt(N))
//if limit**2 == N : continue
//k, period = 1, 0
//while k != 1 or period == 0 :
//k = (N - r * r) // k
//r = (limit + r) // k * k - r
//period += 1
//if period % 2 == 1 : odd_period += 1
//
//print(odd_period);