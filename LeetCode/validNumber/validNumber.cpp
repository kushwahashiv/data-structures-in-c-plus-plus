// Source : https://leetcode.com/problems/valid-number/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-08-26

/*
Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated.
If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
*/
#include <iostream>
using namespace std;


bool isNumber(const char *s)
{
    int i = 0;

    // skip the whilespaces
    for(; s[i] == ' '; i++) {}

    // check the significand
    if(s[i] == '+' || s[i] == '-') i++; // skip the sign if exist

    int n_nm, n_pt;
    for(n_nm=0, n_pt=0; (s[i]<='9' && s[i]>='0') || s[i]=='.'; i++)
        s[i] == '.' ? n_pt++:n_nm++;
    if(n_pt>1 || n_nm<1) // no more than one point, at least one digit
        return false;

    // check the exponent if exist
    if(s[i] == 'e') {
        i++;
        if(s[i] == '+' || s[i] == '-') i++; // skip the sign

        int n_nm = 0;
        for(; s[i]>='0' && s[i]<='9'; i++, n_nm++) {}
        if(n_nm<1)
            return false;
    }

    // skip the trailing whitespaces
    for(; s[i] == ' '; i++) {}

    return s[i]==0;  // must reach the ending 0 of the string
}


#define TEST(s) cout << "\"" << s << "\"" << " : " << isNumber(s) << endl
int main(int argc, char** argv)
{
    const char* s="123";
    if(argc>1){
        s = argv[1];
    }
    TEST(s);

    TEST("1.044");
    TEST(" 1.044 ");
    TEST("1.a");
    TEST("abc");
    TEST("e");
    TEST("1e");
    TEST("1e2");
    TEST("");
    TEST(" ");
    TEST("1.");
    TEST(".2");
    TEST(" . ");
    TEST(".");
    TEST("1.2.3");
    TEST("1e2e3");
    TEST("1..");
    TEST("+1.");
    TEST(" -1.");
    TEST("6e6.5");
    TEST("005047e+6");
    

    return 0;
}
