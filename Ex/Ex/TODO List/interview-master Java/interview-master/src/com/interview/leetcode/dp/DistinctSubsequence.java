package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 上午9:58
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 *
 * how many distinct subsequence of S eqauls to T, so at least need contains all the char in T with the same order.
 *
 * State: dp[i][j] the num of subsequence of S(0~ith substring) equals to T(0~jth substring)
 * Init: dp[*][0] = 1    substr of S have 1 distinct subsequence of empty T
 * Produce:
 *      dp[i][j] = dp[i-1][j] + dp[i-1][j-1] when i-th char == j-th char
 *               = dp[i-1][j]                otherwise
 *
 */
public class DistinctSubsequence {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int[][] nums = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];  //default equals to num[i-1][j]  S.substr(0,i-1) ~ T.substr(0,j) solution
                if (S.charAt(i - 1) == T.charAt(j - 1)) {  //if i-th char = j-th char, = num[i-1][j] + num[i-1][j-1]
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[S.length()][T.length()];
    }
}
