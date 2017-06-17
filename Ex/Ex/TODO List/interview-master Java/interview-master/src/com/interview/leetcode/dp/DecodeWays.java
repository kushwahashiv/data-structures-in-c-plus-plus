package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午8:45
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *      'A' -> 1
 *      'B' -> 2
 *      ...
 *      'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 *      Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *      The number of ways decoding "12" is 2.
 *
 * State: Using a dp[i] to store the decode ways of substr(0-i)
 * Init:  dp[0] = dp[1] = 1;
 * Produce: cal dp[i]: get i-th as as cur and i-1th char as prev
 *        prev cur = 00, 30 ~ 90 invalid return 0
 *        prev cur = 10, 20, dp[i] = dp[i-2];   //must together with prev
 *        prev cur > 26 and < 10, dp[i] = dp[i-1]   //must not be together with prev
 *        prev cur <= 26 and > 10, dp[i] = dp[i-1] + dp[i-2]  //could have 2 ways, together or not together with prev
 * Retrun dp[s.length]
 *
 * Optimize: since dp[i] only use dp[i-1] and dp[i-2] so could use a cyclic int[3] to store dp.
 *
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;  //invalid
        int[] sols = new int[s.length() + 1];
        sols[0] = 1;  //empty
        sols[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int cur = s.charAt(i - 1) - '0';
            int pre = s.charAt(i - 2) - '0';
            if (cur == 0) {
                if (pre == 0 || pre > 2) return 0;   //30, invalid
                else sols[i] = sols[i - 2];
            } else {
                cur = pre * 10 + cur;
                if (cur > 26 || cur < 10) sols[i] = sols[i - 1];  // <10 -> pre == 0
                else sols[i] = sols[i - 1] + sols[i - 2];
            }
        }
        return sols[s.length()];
    }

    public static int numDecodingsOptz(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;  //invalid
        int[] sols = new int[3];
        sols[0] = 1;  //empty
        sols[1] = 1;  //one char
        for (int i = 2; i <= s.length(); i++) { //loop on 2nd char to end
            int cur = s.charAt(i - 1) - '0';
            int pre = s.charAt(i - 2) - '0';
            if (cur == 0) {
                if (pre == 0 || pre > 2) return 0;   //30, invalid
                else sols[i % 3] = sols[(i - 2) % 3];   //10 or 20, sols[i] == sols[i-2];
            } else {
                cur = pre * 10 + cur;    //calculate the num
                if (cur > 26 || cur < 10)
                    sols[i % 3] = sols[(i - 1) % 3];  // cur<10 -> pre == 0 or num > 26, can be together with prev, sols[i] == sols[i-1]
                else sols[i % 3] = sols[(i - 1) % 3] + sols[(i - 2) % 3];  //sols[i] == sols[i-1] + sols[i-2]
            }
        }
        return sols[s.length() % 3];
    }
}
