// Source : https://leetcode.com/problems/unique-binary-search-trees/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-25

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

#include <iosteram>

int numTrees(int n) {
    int dp[n+1];
    dp[0] = dp[1] = 1;
    for (int i=2; i<=n; i++) {
        dp[i] = 0;
        for (int j=1; j<=i; j++) {
            dp[i] += dp[j-1] * dp[i-j];
        }
    }
    return dp[n];
}

// 2
int numTrees2(int n) {
    if (n<=0) return 0;
    if (n == 1 ) return 1;
    int sum=0;
    for (int i=1; i<=n; i++){
        if (i==1||i==n){
            sum += numTrees(n-1);
        }else{
            sum += (numTrees(i-1) * numTrees(n-i));
        }
    }
    return sum;
}


int main(int argc, char** argv) 
{
    int n=2;
    if (argc>1){
        n = atoi(argv[1]);
    }
    printf("%d=%d\n", n, numTrees(n));
    return 0;
}
