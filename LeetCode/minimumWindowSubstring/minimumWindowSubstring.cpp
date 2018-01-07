// Source : https://leetcode.com/problems/minimum-window-substring/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-22

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

#include <string>
#include <iostream>
#include <string>
using namespace std;

// https://leetcode.com/problems/minimum-window-substring/discuss/26808
string minWindow(string s, string t) {
  vector<int> map(128, 0);
  for (auto c : t) map[c]++;
  int counter = t.size(), begin = 0, end = 0, d = INT_MAX, head = 0;
  while (end < s.size()) {
    if (map[s[end++]]-- > 0) counter--; //in t
    while (counter == 0) { //valid
      if (end - begin < d)  d = end - (head = begin);
      if (map[s[begin++]]++ == 0) counter++;  //make it invalid
    }
  }
  return d == INT_MAX ? "" : s.substr(head, d);
}

int lengthOfLongestSubstring(string s) {
  vector<int> map(128, 0);
  int counter = 0, begin = 0, end = 0, d = 0;
  while (end < s.size()) {
    if (map[s[end++]]++ > 0) counter++;
    while (counter > 0) if (map[s[begin++]]-- > 1) counter--;
    d = max(d, end - begin); //while valid, update d
  }
  return d;
}

int main(int argc, char**argv)
{
  string S = "ADOBECODEBANC";
  string T = "ABC";
  if (argc > 2) {
    S = argv[1];
    T = argv[2];
  }
  cout << "S = \"" << S << "\"  T=\"" << T << "\"" << endl;
  cout << minWindow(S, T) << endl;
  return 0;
}

