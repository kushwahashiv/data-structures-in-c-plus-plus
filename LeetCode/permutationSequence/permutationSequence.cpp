// Source : https://leetcode.com/problems/permutation-sequence/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-08-22

/*
The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

#include <iostream>
using namespace std;

string getPermutation(int n, int k) {
    int i,j,f=1;
    // left part of s is partially formed permutation, right part is the leftover chars.
    string s(n,'0');
    for(i=1;i<=n;i++){
        f*=i;
        s[i-1]+=i; // make s become 1234...n
    }
    for(i=0,k--;i<n;i++){
        f/=n-i;
        j=i+k/f; // calculate index of char to put at s[i]
        char c=s[j];
        // remove c by shifting to cover up (adjust the right part).
        for(;j>i;j--)
            s[j]=s[j-1];
        k%=f;
        s[i]=c;
    }
    return s;
}

int main(int argc, char**argv)
{
    int n=3, k=6;
    if ( argc > 2 ) {
        n = atoi(argv[1]);
        k = atoi(argv[2]);
    }
    cout << "n = " << n << ", k = " << k << " : " << getPermutation(n, k) << endl;

    return 0;
}
