/*
Analysis
The numerator follows a predictable pattern (sequence) and we are exploiting that to solve this problem.
There is a multiplier, m, that follows the sequence (2,1,1), (4,1,1), (6,1,1), (8,1,1), …
starting with the third term and the numerator follows (1, 2, 3, 8, 11, 19, 87, …):

n_i = m_i * n_{i-1} + n_{i-2}, where:n_0=1  and n_1=2

*/

#include<iostream>
#include<vector>

auto ExponentialConvergent(int s)-> int
{
  int d = 1, n = 2;

  for (int i = 2; i <= s; i++)
  {
    int temp = d;
    int c = (i % 3) ? 1 : 2 * (i / 3);
    d = n;
    n = c*d + temp;
  }

  //digit sum
  int sum(0);
  while (n != 0)
  {
    sum += n % 10;
    n = n / 10;
  }

  return sum;
}


auto main() ->int
{
  int n;
  std::cin >> n;
  int x = ExponentialConvergent(n);
  std::cout << x;

  return 0;
}
