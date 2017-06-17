/*
Problem Statement

You and your K-1 friends want to buy N flowers. Flower number i has cost ci. 
Unfortunately the seller does not want just one customer to buy a lot of flowers,
so he tries to change the price of flowers for customers who have already bought some flowers.
More precisely, if a customer has already bought x flowers, he should pay (x+1)*ci dollars to buy flower number i.

You and your K-1 friends want to buy all N flowers in such a way that you spend the least amount of money.
You can buy the flowers in any order.

Input:

The first line of input contains two integers N and K (K <= N). The next line contains N space separated positive integers c1,c2,...,cN.

Output:

Print the minimum amount of money you (and your friends) have to pay in order to buy all N flowers.

Constraint :

1 <= N, K <= 100
Any ci is not more than 1,000,000

Sample input #00

3 3
2 5 6
Sample output #00

13

*/

#include <iostream>  
#include <vector>  
#include <algorithm>  
#include <functional>

using namespace std;

int main()
{
  int N; // num of flowers  
  int K; // num of people  
  vector<int> c; // price of each flower  
  vector<int> num_bought; // num of flowers each person bought  
  int money = 0; // min money to pay (output)  
  int i;

  // initialize problem  
  cin >> N >> K;

  c = vector<int>(N, 0); // N flowers  
  for (i = 0; i < N; i++)
    cin >> c[i];

  // body  
  num_bought = vector<int>(K, 0); // K people  

  sort(c.begin(), c.end(), std::greater<int>()); // sort from high to low  

  for (i = 0; i < N; i++) {
    money += (num_bought[i%K] + 1) * c[i];
    num_bought[i%K]++;
  }

  // print output  
  cout << money << endl;

  return 0;
}



/*
using System;
using System.Collections.Generic;
using System.IO;
class Solution
{
  static void Main(String[] args)
  {
    int N, K;
    string NK = Console.ReadLine();
    string[] NandK = NK.Split(new Char[] { ' ', 't', 'n' });
    N = Convert.ToInt32(NandK[0]);
    K = Convert.ToInt32(NandK[1]);

    string[] numbers = Console.ReadLine().Split(' ');
    List<int> number = new List<int>();
    for (int i = 0; i < numbers.Length; i++)
      number.Add(int.Parse(numbers[i]));
    int[] temp = number.ToArray();
    Array.Sort(temp);
    
    number.Clear();
    for (int i = 0; i < temp.Length; i++)
      number.Add(temp[i]);
    int[] friends = new int[K];
    int x = 0;
    int result = 0;
    while (number.Count > 0)
    {
      result += (friends[x] + 1) * number[number.Count - 1];
      number.RemoveAt(number.Count - 1);
      friends[x]++;
      x++;
      if (x == K)
        x = 0;
    }
    Console.WriteLine(result);
  }
}

*/