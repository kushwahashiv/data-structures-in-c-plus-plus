/*
Problem Statement
Smallest Multiple

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible(divisible with no remainder) by all of the numbers from 1 to N?

Input Format
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format
Print the required answer for each test case.

Constraints
1≤T≤10
1≤N≤40

*/

#include<iostream>
#include<vector>

auto gcd(long a, long b) -> int
{
  while (b > 0) 
  {
    a %= b;
    if (a == 0)
      return b;
    b %= a;
  }
  return a;
}

auto FindLCM(int a)->int
{
  int lcm(1);

  for (int i = 1; i <=a; i++)
  {
    lcm = i*lcm / gcd(i, lcm);
  }

  return lcm;
}

auto FindMultiple(std::vector<int> n)-> void
{
  int lcm(0);

  for(auto i: n)
  {
    lcm = FindLCM(i);
    std::cout << lcm << std::endl;
  }
}

auto main() ->int
{
  std::vector<int> a;
  int n;

  std::cin >> n;


  for (int i = 0; i < n; i++)
  {
    int num;
    std::cin >> num ;
    a.push_back(num);
  }

  //n = 2;
  //a = { 3, 10 };

 FindMultiple(a);

  return 0;
}