/*
Source : https://leetcode.com/problems/valid-anagram/description/
Author : Shiv S. Kushwaha
Date   : 2014-07-18

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

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
  std::vector<string>  words = { "anagram", "nagaram", "rat", "car" };
  auto result = anagrams(words);

  for (std::string item : result)
  {
    std::cout << item << std::endl;
  }

  system("pause");
  return 0;
}