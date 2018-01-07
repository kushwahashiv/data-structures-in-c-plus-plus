// Source : https://leetcode.com/problems/length-of-last-word/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-01

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5
*/
#include <stdio.h>
#include <ctype.h>

int lengthOfLastWord(string s) {
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s[tail] == ' ') tail--;
        while (tail >= 0 && s[tail] != ' ') {
            len++;
            tail--;
        }
        return len;
 }

int main(int argc, char** argv)
{
    const char* p;
    p = "hello world";
    printf("%s, %d\n", p, lengthOfLastWord(p)); 
    p = "a";
    printf("%s, %d\n", p, lengthOfLastWord(p)); 
    
    if(argc>1){
        p = argv[1];
        printf("%s, %d\n", p, lengthOfLastWord(p)); 
    }
}
