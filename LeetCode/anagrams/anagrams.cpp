/*
Source : https://oj.leetcode.com/problems/anagrams/
Author : Shiv S. Kushwaha
Date   : 2014-07-18

Problem:
Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
*/

#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<string>

using namespace std;


vector<string> anagrams(vector<string> &strs)
{
  vector<string> result;
  map<string, int> m;

  for (int i = 0; i < strs.size(); i++)
  {
    string word = strs[i];
    //sort it can easy to check they are anagrams or not
    sort(word.begin(), word.end());

    if (m.find(word) == m.end())
    {
      m[word] = i;
    }
    else
    {
      if (m[word] >= 0)
      {
        result.push_back(strs[m[word]]);
        m[word] = -1;
      }
      result.push_back(strs[i]);
    }
  }
  return result;
}


int main()
{
  std::vector<string>  words = { "hello", "world", "hi", "world" };
  auto result = anagrams(words);

  for (std::string item : result)
  {
    std::cout << item <<std::endl;
  }

  system("pause");
  return 0;
}