// Source : https://leetcode.com/problems/multiply-strings/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-18

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

#include <iostream>
#include <string>
using namespace std;

/*
This is the standard manual multiplication algorithm. We use two nested for loops, working backward from the end of each input number.
We pre-allocate our result and accumulate our partial result in there.
One special case to note is when our carry requires us to write to our sum string outside of our for loop.
At the end, we trim any leading zeros, or return 0 if we computed nothing but zeros.
*/
string multiply(string num1, string num2) {
    string sum(num1.size() + num2.size(), '0');

    for (int i = num1.size() - 1; 0 <= i; --i) {
        int carry = 0;
        for (int j = num2.size() - 1; 0 <= j; --j) {
            int tmp = (sum[i + j + 1] - '0') + (num1[i] - '0') * (num2[j] - '0') + carry;
            sum[i + j + 1] = tmp % 10 + '0';
            carry = tmp / 10;
        }
        sum[i] += carry;
    }

    size_t startpos = sum.find_first_not_of("0");
    if (string::npos != startpos) {
        return sum.substr(startpos);
    }
    return "0";
}

int main(int argc, char**argv)
{
    string s1="20";
    string s2="25";
    if (argc>2){
        s1 = argv[1];
        s2 = argv[2];
    }
    cout << s1 << " * " << s2 << " = " << multiply(s1, s2) << endl;
    return 0;
}
