// https://leetcode.com/problems/candy/description/
// Author : Shiv S. Kushwaha

/*
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Solution:
The soluiton is O(2n) run-time complexity
For example:
    ratings[] = { 5, 6, 7, 4, 1, 2, 3, 2, 1, 7 }

1) Go through the ratings from left to right.
   Find the each increasing sub-array, giving the minimal candy
    ratings[] = { 5, 6, 7,   4,   1, 2, 3,   2,   1, 7 }
      candy[] = { 1, 2, 3,   1,   1, 2, 3,   1,   1, 2 }

2) Go through the ratings from right to left.
         ratings[] = { 5,   6,   7, 4, 1,   2,   3, 2, 1,   7 }
      prev_candy[] = { 1,   2,   3, 1, 1,   2,   3, 1, 1,   2 }
           candy[] = { 1,   2,   3, 2, 1,   2,   3, 2, 1,   2 }

3) total candy is 19
*/

#include <time.h>
#include <iostream>
#include <vector>
using namespace std;


int candy(vector<int> &ratings)
{
  int size = ratings.size();
  if (size <= 1)
    return size;
  vector<int> num(size, 1);
  for (int i = 1; i < size; i++)
  {
    if (ratings[i] > ratings[i - 1])
      num[i] = num[i - 1] + 1;
  }
  for (int i = size - 1; i > 0; i--)
  {
    if (ratings[i - 1] > ratings[i])
      num[i - 1] = max(num[i] + 1, num[i - 1]);
  }
  int result = 0;
  for (int i = 0; i < size; i++)
  {
    result += num[i];
    // cout<<num[i]<<" ";
  }
  return result;
}


// SF

void generateRatings(vector<int> &ratings, int n)
{
  srand(time(0));
  for (int i = 0; i < n; i++)
  {
    ratings.push_back(rand() % 10);
  }
}

void print(vector<int> &v)
{
  for (int i = 0; i < v.size(); i++)
  {
    cout << v[i] << " ";
  }
  cout << endl;
}

int main(int argc, char**argv)
{
  int n = 10;
  if (argc > 1)
  {
    n = atoi(argv[1]);
  }
  vector<int> ratings;
  generateRatings(ratings, n);
  print(ratings);

  cout << candy(ratings) << endl;

  cout << "--------------------" << endl;
  vector<int> ra = { 5, 6, 7, 4, 1, 2, 3, 2, 1, 7 };
  print(ra);
  cout << candy(ra) << endl;

  system("pause");
  return 0;
}
