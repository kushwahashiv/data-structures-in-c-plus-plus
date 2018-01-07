// Source : https://leetcode.com/problems/divide-two-integers/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-20

/*
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
*/

#include <iostream>
using namespace std;


int divide(int dividend, int divisor) {
  if (!divisor || (dividend == INT_MIN && divisor == -1))
    return INT_MAX;
  int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
  long long dvd = labs(dividend);
  long long dvs = labs(divisor);
  int res = 0;
  while (dvd >= dvs) {
    long long temp = dvs, multiple = 1;
    while (dvd >= (temp << 1)) {
      temp <<= 1;
      multiple <<= 1;
    }
    dvd -= temp;
    res += multiple;
  }
  return sign == 1 ? res : -res;
}

int main()
{
  cout << "10/2=" << divide(10, 2) << endl;
  cout << "10/3=" << divide(10, 3) << endl;
  cout << "10/5=" << divide(10, 5) << endl;
  cout << "10/7=" << divide(10, 7) << endl;
  cout << "10/10=" << divide(10, 10) << endl;
  cout << "10/11=" << divide(10, 11) << endl;
  cout << "1/-1=" << divide(1, -1) << endl;
  cout << "-1/-1=" << divide(-1, -1) << endl;
  cout << "2147483647/1=" << divide(2147483647, 1) << endl;
  cout << "-2147483647/1=" << divide(-2147483647, 1) << endl;
  cout << "2147483647/-1=" << divide(2147483647, -1) << endl;
  cout << "-2147483647/-1=" << divide(-2147483647, -1) << endl;
  cout << "2147483647/2=" << divide(2147483647, 2) << endl;
  cout << "2147483647/10=" << divide(2147483647, 10) << endl;
  cout << "-2147483648/1=" << divide(-2147483648, 1) << endl;
}
