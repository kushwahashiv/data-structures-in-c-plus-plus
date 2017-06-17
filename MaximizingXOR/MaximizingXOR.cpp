/*
Problem Statement

Given two integers: L and R,
find the maximal values of A xor B given, L ≤ A ≤ B ≤ R

Input Format
The input contains two lines, L is present in the first line.
R in the second line.

Constraints
1 ≤ L ≤ R ≤ 103

Output Format
The maximal value as mentioned in the problem statement.

*/

#include<iostream>
using namespace std;

auto maxXor(int l, int r) -> int 
{

  int sum = 0;
  int pos = 1;

  while (l != r)
  {
    l /= 2;
    r /= 2;
    sum += pos;
    pos *= 2;
  }
  return sum;
}


int main()
{
  int res;
  int _l;
  cin >> _l;

  int _r;
  cin >> _r;

  res = maxXor(_l, _r);
  cout << res;

  system("pause");

  return 0;
}