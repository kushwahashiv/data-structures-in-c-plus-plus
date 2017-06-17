/*
Problem Statement

You are given a number N. Find the digits in this number that exactly divide N and display their count. 
For N = 24, there are 2 digits - 2 & 4. Both these digits exactly divide 24. So our answer is 2.
Note
If the same number is repeated twice at different positions, it should be counted twice, e.g., For N=122, 
2 divides 122 exactly and occurs at ones' and tens' position. So it should be counted twice. So for this case, our answer is 3.
Division by 0 is undefined.

Input Format
The first line contains T (number of test cases) followed by T lines (each containing an integer N).
Constraints
1 <=T <= 15
0 < N < 1010

Output Format

For each test case, display the count of digits in N that exactly divide N in separate line.
*/

#include<iostream>
#include<vector>
using namespace std;

auto FindDivisors(int N) -> int
{

  int n = N;
  int count(0);

  while (n !=0)
  {
    int digit = n % 10;
    if( digit != 0 && N%digit == 0)
        count++;

    n /= 10;
  }
  return count;
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
    cout << FindDivisors(i)<<std::endl;
  }

  system("pause");

  return 0;
}