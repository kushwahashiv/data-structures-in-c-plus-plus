package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午11:18
 *
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.
 * You have the following 3 operations permitted on a word:
 *  a) Insert a character
 *  b) Delete a character
 *  c) Replace a character
 *
 * State: optimal[i][j] is the min edit distance of a.substr(0-i) to b.substr(0,j) .
 * Init:  optimal[0][j] = j and optimal[i][0] = i
 * Produce:
 *   When scan to the i-th char in A and j-th char in B, it depends on the previous states.
 *    if i-th char in A == j-th char in B:  dis[i][j] = dis[i-1][j-1]
 *    delete i-th char in A:    dis[i][j] = dis[i-1][j] + 1;
 *    delete j-th char in B:    dis[i][j] = dis[i][j-1] + 1;
 *    add j-th char in B to A:  dis[i][j] = dis[i-1][j] + 1;
 *    add i-th char in A to B:  dis[i][j] = dis[i][j-1] + 1;
 *    modify i-th char in A to j-th char in B:  dis[i][j] = dis[i-1][j-1] + 1
 *   Find min of above options.
 *
 * so loop on i and j, and calculate to find the min action path.
 * Time: O(n*m) Space(n*m)
 *
 * Optimize space to O(n + m), using optA[n+1] and optB[m+1]
 */
public class EditDistance {
    public static int minDistance(String a, String b) {
        int[][] dis = new int[a.length() + 1][b.length() + 1];

        dis[0][0] = 0;
        for (int i = 1; i <= a.length(); i++)
            dis[i][0] = i;
        for (int i = 1; i <= b.length(); i++)
            dis[0][i] = i;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                dis[i][j] = a.charAt(i - 1) == b.charAt(j - 1) ? dis[i - 1][j - 1] : dis[i - 1][j - 1] + 1;
                int ten = Math.min(dis[i - 1][j], dis[i][j - 1]) + 1;
                if (dis[i][j] > ten) dis[i][j] = ten;
            }
        }
        return dis[a.length()][b.length()];
    }

    public static int minDistanceOptz(String a, String b) {
        int[] dis = new int[a.length() + 1];

        for (int j = 0; j <= a.length(); j++)
            dis[j] = j;

        for (int i = 1; i <= a.length(); i++) {
            int pre = dis[0];
            dis[0] = i;
            for (int j = 1; j <= b.length(); j++) {
                int cur = dis[j];
                dis[j] = a.charAt(i - 1) == b.charAt(j - 1) ? pre : pre + 1;
                int ten = Math.min(cur, dis[j - 1]) + 1;
                if (dis[j] > ten) dis[j] = ten;
                pre = cur;
            }
        }
        return dis[b.length()];
    }
}
