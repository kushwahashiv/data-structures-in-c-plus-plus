package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午8:53
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 *  Given:
 *      s1 = "aabcc",
 *      s2 = "dbbca",
 *  When s3 = "aadbbcbcac", return true.
 *  When s3 = "aadbbbaccc", return false.
 *
 *  Tricks:
 *    1. for dp problem, at first should define a state
 *          state is if select i-th seq and j-th seq in s1 and s2 could match i+j+2 th seq in s3  optimal[n+1][m+1]
 *       then define a iterator solution on state: how to get optimal[i+1][*] from optimal[0][*] ~ optimal[i][*]
 *    2. after code is complete, check if space complexity can be reduces.
 *          when optimal[i+1][*] only depends on optimal[i][*], could use optimal[m+1] instead.
 *       if reuse optimal, please update the value whatever it should be.
 */
public class InterleavingString {
    /**
     * using dp to tracking select i-th seq and j-th seq in s1 and s2 could match i+j+2 th seq in s3
     *  1. init optimal[0] by check no select from s1
     *  2. init optimal[*][0] by check no select from s2
     *  3. do search for every i-th and j-th,
     *     could match when
     *      if i-th char in s2 equals to the (i+j+1)th char in s3, and previous j-th in s2 is matched without i-th char
     *      or
     *      if j-th char in s1 equals to the (i+j+1)th char in s3, and previous j-1th in s2 is matched with i-th char
     *
     *  a straight-forward solution should be Time: O(n*m), and Space: O(n*m)
     *  and space could optimize since
     *      optimal[i+1][*] only depends on optimal[i][*], so could use Space O(m)
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;

        boolean[][] optimal = new boolean[s1.length() + 1][s2.length() + 1];    //init dp optimal
        optimal[0][0] = true;
        for(int j = 0; j < s2.length(); j++){ //check no s1 char is selected, if s2 could equals to s3
            if(optimal[0][j] && s2.charAt(j) == s3.charAt(j)) optimal[0][j + 1] = true;
        }

        for(int i = 0; i < s1.length(); i++){ //check select i-th char in s1
            if(optimal[i][0] && s1.charAt(i) == s3.charAt(i)) optimal[i + 1][0] = true;    //no char in s2 is selected
            for(int j = 0; j < s2.length(); j++){  //select j-th char
                if((s1.charAt(i) == s3.charAt(i + j + 1) && optimal[i][j + 1]) ||
                    s2.charAt(j) == s3.charAt(i + j + 1) && optimal[i + 1][j]){
                        optimal[i + 1][j + 1] = true;
                }
            }
        }
        return optimal[s1.length()][s2.length()];
    }

    /**
     * optimal space usage to O(m)
     */
    public static boolean isInterleaveOptz(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;

        boolean[] optimal = new boolean[s2.length() + 1];    //dp optimal
        optimal[0] = true;
        for (int j = 0; j < s2.length(); j++) { //check no s1 char is selected, if s2 could equals to s3
            if (optimal[j] && s2.charAt(j) == s3.charAt(j)) optimal[j + 1] = true;
        }

        for (int i = 0; i < s1.length(); i++) { //check select i-th char in s1
            if (optimal[0] && s1.charAt(i) == s3.charAt(i)) optimal[0] = true;    //no char in s2 is selected
            else optimal[0] = false;
            for (int j = 0; j < s2.length(); j++) {  //select j-th char
                if ((s1.charAt(i) == s3.charAt(i + j + 1) && optimal[j + 1]) ||
                        s2.charAt(j) == s3.charAt(i + j + 1) && optimal[j]) {
                    optimal[j + 1] = true;
                } else optimal[j + 1] = false;
            }
        }
        return optimal[s2.length()];
    }
}
