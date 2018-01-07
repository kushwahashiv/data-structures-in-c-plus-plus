// Source : https://leetcode.com/problems/sqrtx/description/

/*
Implement int sqrt(int x).
Compute and return the square root of x.
x is guaranteed to be a non-negative integer.
Example 1:
Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
*/
#include <iostream>
using namespace std;


int sqrt(int x) {
long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return r;
}

int main(int argc, char**argv)
{
    int n = 2;
    if( argc > 1 ){
        n = atoi(argv[1]);
    }
    cout << "sqrt(" << n << ") = " << sqrt(n) << endl;
    return 0;
}
