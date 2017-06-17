#include <map>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;


class Solution 
{
public:
  std::vector<std::string> anagrams(std::vector<std::string> &);
};

vector<string> Solution::anagrams(vector<string> & strs)
{
  vector<string> res;
  map<string, int> anagrams;

  if (strs.size() <= 1)
    return res;

  for (int i = 0; i < strs.size(); ++i)
  {
    string s = strs[i];
    sort(s.begin(), s.end());
    if (anagrams.find(s) == anagrams.end()) 
    {
      anagrams.insert(make_pair(s, i));
    }
    else
    {
      res.push_back(strs[i]);
      if (anagrams[s] >= 0)
      {
        res.push_back(strs[anagrams[s]]);
        anagrams[s] = -1;
      }
    }
  }
  return res;
}


int main()
{
  Solution obj;
  //obj.anagrams()

  system("pause");
}


