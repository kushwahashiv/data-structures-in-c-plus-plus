/*
Problm:
program to take 2 sentences/string and find common letters

*/

#include <iostream>
#include <string>
#include <set>
#include <algorithm>
#include <iterator>
#include <vector>

std::set<char> FindSharedLetters(const std::string &s1, const std::string &s2)
{

  std::set<char> st1(s1.begin(), s1.end());
  std::set<char> st2(s2.begin(), s2.end());

  /* 
  //Case sensitive implementation
  //Comment above two lines

  std::set<char> st1;
  std::set<char> st2;

  for (char c : s1)
  {
    if (std::isalpha(c)) st1.emplace(std::toupper(c));
  }

  for (char c : s2)
  {
    if (std::isalpha(c)) st2.emplace(std::toupper(c));
  }
  */

  std::set<char> st0;

  std::set_intersection(st1.begin(), 
                        st1.end(),
                        st2.begin(), 
                        st2.end(),
                        std::inserter(st0, st0.end()));

  return st0;
}

int main()
{
  std::string s1("DCABD");
  std::string s2("FRDCACD");

  for (char c : FindSharedLetters(s1, s2))
  { 
    std::cout << c << ' ';
  }

  std::cout << std::endl;

  system("pause");

  return 0;
}


//int main()
//{
//  std::vector<std::string> a;
//  int number;
//  std::cin >> number;
//  for (unsigned int i = 0; i < 2 * number; i++)
//  {
//    std::string word;
//    //std::getline(std::cin, word);
//    std::cin >> word;
//    a.push_back(word);
//  }
//
//  for (unsigned int i = 0; i < number; i++)
//  {
//    auto b = FindSharedLetters(a[i], a[i + 1]);
//    if (b.size() > 0)
//      std::cout << "YES" << std::endl;
//    else
//      std::cout << "NO" << std::endl;
//
//  }
//  return 0;
//}