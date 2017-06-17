/*
Problem Statement

This problem is a programming version of Problem 4 from projecteuler.net
A palindromic number reads the same both ways. The smallest 6 digit palindrome made from the product of two 3-digit numbers is 101101=143×707.
Find the largest palindrome made from the product of two 3-digit numbers which is less than N.

Input Format
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format
Print the required answer for each test case in a new line.

Constraints
1≤T<100
101101<N<1000000

*/


#include<iostream>
#include<vector>

bool isPalin(int n)
{
  int x = n;
  int u = 0;
  while (x)
  {
    u *= 10;
    u += x % 10;
    x /= 10;
  }
  return (n == u);
}


auto main() -> int
{
  int max(0);

  std::vector<int> a = { 101110, 800000 };

  /*int size;
  std::cin >> size;

  if (size < 0 || size> 100)
  return 0;

  std::vector<int> a;

  for (int i = 0; i < size; i++)
  {
  int num;
  std::cin >> num;

  if (num < 101101 || num > 999999)
  return 0;
  a.push_back(num);
  }*/

  for (auto it : a)
  {
    for (int i = 999; i > 100; i--)
      for (int j = i; j > 100; j--)
      {
        int number = i*j;
        if (number < max)
          break;

        if (number > it)
          continue;

        if (isPalin(number))
        {
          max = number;
        }
      }

    std::cout << max << std::endl;
  }

  system("pause");

  return 0;
}


