// Source : https://leetcode.com/problems/count-and-say/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-03

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

string countAndSay(int n) {
    if (n == 1){return "1";}
    if (n == 2){return "11";}
    string result = countAndSay(n-1);
    string newresult = "";
    int count = 1;
    for(int i = 1; i < result.size(); ++i){
        if(result[i]!=result[i-1]){
            newresult.push_back('0'+count);
            newresult.push_back(result[i-1]);
            count = 1;
        }else{
            count++;
        }
        if(i == result.size()-1){
            newresult.push_back('0'+count);
            newresult.push_back(result[i]);
        }
    }
    return newresult;
}

int main(int argc, char** argv)
{
    int n = 4;
    if (argc>1){
        n = atoi(argv[1]);
    }
    cout << countAndSay(n) << endl;
    
    return 0;
}
