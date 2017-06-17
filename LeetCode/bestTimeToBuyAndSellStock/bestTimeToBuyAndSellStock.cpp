/*
Source : https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
Date   : 2014-06-18

Problem:
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Solution:
This solution is O(1) space dynamic programming

We can make sure the max profit at least be ZERO. So,
1) we have two pointers (begin & end )
2) if prices[end] - prices[begin] >  0, then move the "end" pointer to next
3) if prices[end] - prices[begin] <= 0, then move the "begin" pointer to current posstion.
4) tracking the max profit

Notes:
Some people think find the highest-price & lowest-price, this is wrong.
Because the highest-price must be after lowest-price
*/

#include <iostream>
#include <vector>
using namespace std;

struct Node
{
  int val;
  Node *left;
  Node *right;
  Node(int x) : val(x), left(nullptr), right(nullptr) {}
};


int maxProfit(vector<int> &prices)
{
  int max = 0, begin = 0, end = 0, delta = 0;
  for (int i = 0; i < prices.size(); i++)
  {
    end = i;
    delta = prices[end] - prices[begin];
    if (delta <= 0)
    {
      begin = i;
    }
    if (delta > max)
    {
      max = delta;
    }
  }
  return max;
}


extern int maxProfit2(vector<int> &prices);
extern int maxProfit3(vector<int> &prices);

int main()
{
  std::vector<int> prices = {22, 32, 45, 31, 55, 21, 10, 19};
  std::cout<< maxProfit(prices) <<std::endl;
  std::cout << maxProfit2(prices) << std::endl;
  std::cout << maxProfit3(prices) << std::endl;

  system("pause");

  return 0;
}