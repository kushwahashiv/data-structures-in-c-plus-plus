/*
Problem Statement

You are given an integer, N. Write a program to determine if N is an element of the Fibonacci Sequence.

The first few elements of fibonacci sequence are 0,1,1,2,3,5,8,13.... 
A fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are 0 and 1.

Formally:

fib0 = 0
fib1 = 1
fibn = fibn-1 + fibn-2 ∀ n > 1

Input Format
The first line contains T, number of test cases.
T lines follows. Each line contains an integer N.

Output Format
Display IsFibo if N is a fibonacci number and IsNotFibo 
if it is not a fibonacci number. The output for each test case should be displayed in a new line.
*/

#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

/* 1.
bool isPerfectSquare(int x)
{
  int s = sqrt(x);
  return (s*s == x);
}

bool isFibonacci(int n)
{
  // n is Fibinacci if one of 5*n*n + 4 or 5*n*n - 4 or both is a perferct square
  return isPerfectSquare(5 * n*n + 4) || isPerfectSquare(5 * n*n - 4);
}
 */

bool isFibonacci(long F)
{
  double root5 = sqrt(5);
  double phi = (1 + root5) / 2;

  long nf = (long)(log(F*root5) / log(phi) + 0.5); //take floor
  long Fn = (long)(pow(phi, nf) / root5 + 0.5);    //take floor

  return (F == Fn);
}


int main()
{
  std::vector<int> numbers;

  int t;
  cin >> t;

  for (int i = 0; i < t; i++)
  {
    int n;
    cin >> n;
    numbers.push_back(n);
  }

  for (auto i : numbers)
  {
    isFibonacci(i) ? std::cout << "IsFibo" << std::endl : std::cout << "IsNotFibo" << std::endl;
  }

  system("pause");

  return 0;
}