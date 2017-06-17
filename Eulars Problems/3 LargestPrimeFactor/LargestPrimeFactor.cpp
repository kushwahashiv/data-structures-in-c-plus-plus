/*
Problem Statement:

This problem is a programming version of Problem 3 from projecteuler.net
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of a given number N?

Input Format
First line contains T, the number of test cases. This is followed by T lines each containing an integer N.
Output Format
For each test case, display the largest prime factor of N.

Constraints
1≤T≤10
10≤N≤10^12

*/
#include <iostream> 
#include <vector> 


/*
The last prime factor found is the largest and since every composite number has no prime factor greater 
than its square root we only need to check up to √n.

If the number, n, is prime then n is returned as the largest prime factor, which is nice, 
because it is, in fact, itself the largest prime factor.

*/
long long isLargestPrimeFactor(long long n)
{
  int p = 2;
  while (p*p <= n)
  {
    if (n % p == 0)
    {
      n /= p;
    }
    else
    {
      p += p > 2 ? 2 : 1;
    }
  }

  return n;
}



long long largest_factor(long long number)
{
  long long result = 0;
  for (long long i = 2; i * i <= number; ++i)
  {
    if (number % i == 0)
    {
      result = i;
      while (number % i == 0)
        number /= i;
    }
  }
  if (number != 1)
    return number;
  return result;
}

int main()
{
  std::vector<int> a = { 10, 17 };
  /*int number;
  std::cin >> number;

  for (int i = 0; i < number; i++)
  {
  int temp;
  std::cin >> temp;
  a.push_back(temp);
  }*/

  for (auto it : a)
  {
    std::cout << largest_factor(it) << std::endl;
  }


  return 0;
}

