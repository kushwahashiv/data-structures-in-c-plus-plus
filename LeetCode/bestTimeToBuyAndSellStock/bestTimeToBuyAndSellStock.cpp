/*
Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
Date   : 2014-06-18

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
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


int maxProfit(vector<int> &prices) {
  int maxPro = 0;
  int minPrice = INT_MAX;
  for (int i = 0; i < prices.size(); i++) {
    minPrice = min(minPrice, prices[i]);
    maxPro = max(maxPro, prices[i] - minPrice);
  }
  return maxPro;
}

int main()
{
  std::vector<int> prices = { 22, 32, 45, 31, 55, 21, 10, 19 };
  std::cout << maxProfit(prices) << std::endl;
  std::cout << maxProfit2(prices) << std::endl;
  std::cout << maxProfit3(prices) << std::endl;

  system("pause");

  return 0;
}