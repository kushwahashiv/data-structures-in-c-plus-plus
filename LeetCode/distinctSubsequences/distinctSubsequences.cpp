// Source : https://leetcode.com/problems/distinct-subsequences/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-06

/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/
#include <iostream>
#include <vector>

using namespace std;

int numDistinct(string s, string t) {
     int n = s.length(), m = t.length();
     vector<int> dp(m+1, 0);
     dp[0] = 1;
     for (int j = 1; j <= n; j++){
         for (int i = m; i >= 1; i--){
             dp[i] += s[j-1] == t[i-1] ? dp[i-1] : 0;
         }
     }
    return dp[m];
}

//random invoker
int numDistinct(string S, string T) {
    srand(time(0));
    if (rand()%2){
        cout << "-----Dynamic Programming Method One-----" << endl;
        return numDistinct1(S,T);
    }
    cout << "-----Dynamic Programming Method Two-----" << endl;
    return numDistinct2(S,T);
}


int main(int argc, char** argv)
{
    string s = "rabbbit";
    string t = "rabbit";
    if (argc>2){
        s = argv[1];
        t = argv[2];
    }
    cout << "S=\"" << s << "\"  T=\"" << t << "\"" << endl;
    cout << "numDistinct = " << numDistinct(s, t) << endl;
    return 0;
}
