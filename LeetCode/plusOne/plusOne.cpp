// Source : https://leetcode.com/problems/plus-one/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
*/

#include <iostream>
#include <vector>
using namespace std;

void plusone(vector<int> &digits)
{
  int n = digits.size();
  for (int i = n - 1; i >= 0; --i)
  {
    if (digits[i] == 9)
    {
      digits[i] = 0;
    }
    else
    {
      digits[i]++;
      return;
    }
  }
  digits[0] = 1;
  digits.push_back(0);
}


vector<int> plusOne(vector<int> &digits) {
  int carry = 1;
  vector <int> v;
  while (digits.size() > 0) {
    int x = digits.back();
    digits.pop_back();
    x = x + carry;
    v.insert(v.begin(), x % 10);
    carry = x / 10;
  }
  if (carry > 0) {
    v.insert(v.begin(), carry);
  }
  return v;

}

void printVector(vector<int>& v)
{
  cout << "{ ";
  for (int i = 0; i < v.size(); i++) {
    cout << v[i] << " ";
  }
  cout << "} " << endl;
}


int main()
{
  int a[] = { 9,9,9 };
  vector<int> d(&a[0], &a[0] + sizeof(a) / sizeof(int));
  vector<int> v = plusOne(d);
  printVector(v);
  return 0;
}
