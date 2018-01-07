// Source : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-19

/*
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

#include <string.h>
#include <iostream>
#include <string>
#include <map>
using namespace std;
/*
Idea:
Using a map store each char's index.
So, we can be easy to know the when duplication and the previous duplicated char's index.
Then we can take out the previous duplicated char, and keep tracking the maxiumn length.
*/

int lengthOfLongestSubstring1(string s) {
    map<char, int> m;
    int maxLen = 0;
    int lastRepeatPos = -1;
    for(int i=0; i<s.size(); i++){
        if (m.find(s[i])!=m.end() && lastRepeatPos < m[s[i]]) {
            lastRepeatPos = m[s[i]];
        }
        if ( i - lastRepeatPos > maxLen ){
            maxLen = i - lastRepeatPos;
        }
        m[s[i]] = i;
    }
    return maxLen;
}

int lengthOfLongestSubstring(string s) {
        vector<int> dict(256, -1);
        int maxLen = 0, start = -1;
        for (int i = 0; i != s.length(); i++) {
            if (dict[s[i]] > start)
                start = dict[s[i]];
            dict[s[i]] = i;
            maxLen = max(maxLen, i - start);
        }
        return maxLen;
    }

int main(int argc, char** argv)
{
    string s = "abcabcbb";
    cout << s << " : " << lengthOfLongestSubstring(s) << endl;
    s = "bbbbb";
    cout << s << " : " << lengthOfLongestSubstring(s) << endl;
    s = "bbabcdb";
    cout << s << " : " << lengthOfLongestSubstring(s) << endl;
    if (argc>1){
        s = argv[1];
        cout << s << " : " << lengthOfLongestSubstring(s) << endl;
    }
    return 0;
}
