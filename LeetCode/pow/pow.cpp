// Source : https://leetcode.com/problems/powx-n/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-25

/*
Implement pow(x, n).
Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100
*/
#include <iostream>

double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
}


double pow(double x, int n) {
    bool sign = false;
    unsigned int exp = n;
    if(n<0){
        exp = -n;
        sign = true;
    }
    double result = 1.0;
    while (exp) {
        if (exp & 1){
            result *= x;
        }
        exp >>= 1;
        x *= x;
    }
    return sign ? 1/result : result;
}

int main(int argc, char** argv){
    double x=2.0;
    int n = 3;
    if (argc==3){
        x = atof(argv[1]);
        n = atoi(argv[2]);
    }
    printf("%f\n", pow(x, n));
    return 0;
}
