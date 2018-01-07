// Source : https://leetcode.com/problems/wildcard-matching/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-19

/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

#include <iostream>
#include <string>
using namespace std;

bool isMatch(const char *s, const char *p) {
        const char* star=NULL;
        const char* ss=s;
        while (*s){
            //advancing both pointers when (both characters match) or ('?' found in pattern)
            //note that *p will not advance beyond its length
            if ((*p=='?')||(*p==*s)){s++;p++;continue;}

            // * found in pattern, track index of *, only advancing pattern pointer
            if (*p=='*'){star=p++; ss=s;continue;}

            //current characters didn't match, last pattern pointer was *, current pattern pointer is not *
            //only advancing pattern pointer
            if (star){ p = star+1; s=++ss;continue;}

           //current pattern pointer is not star, last patter pointer was not *
           //characters do not match
            return false;
        }

       //check for remaining characters in pattern
        while (*p=='*'){p++;}

        return !*p;
    }


int main(int argc, char** argv)
{
    const char *s = "aab";
    const char *p = "a*a*b";
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;

    s = "abbb";
    p = "a*b";
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;

    s = "abb";
    p = "a*bb";
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;

    s = "abddbbb";
    p = "a*d*b";
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;

    s = "abdb";
    p = "a**";
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;

    s = "a";
    p = "a**";
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;
    if (argc>2){
        s = argv[1];
        p = argv[2];
        cout << s << ", " << p << " : " << isMatch(s, p) << endl;
    }
    return 0;
}
