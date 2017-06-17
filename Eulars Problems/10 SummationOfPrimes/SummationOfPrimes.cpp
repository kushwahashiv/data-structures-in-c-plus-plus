/*
Problem Statement
This problem is a programming version of Problem 10 from projecteuler.net
The sum of the primes below 10 is 2+3+5+7=17.
Find the sum of all the primes not greater than given N.

Input Format
The first line contains an integer T i.e. number of the test cases.
The next T lines will contains an integer N.
Output Format
Print the value corresponding to each test case in seperate line.

Constraints
1≤T≤104
1≤N≤106

Sample Input
2
5
10
Sample Output
10
17
*/

#include <iostream>
#include <vector>

using namespace std;

int generate_primes(int n)
{
  int total = 0;
  std::vector<bool>sieve(n+1, true);
  for (std::size_t i = 2; i < sieve.size(); ++i)
  {
    if (sieve[i])
      for (auto j = i*i; j < sieve.size(); j += i)
        sieve[j] = false;
    
    if (sieve[i])
    {
      total += i;
    }
  }
  
  return total;
}


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

  for (auto number : arr)
  {
    std::cout << generate_primes(number)<<std::endl;
  }

  return 0;
}