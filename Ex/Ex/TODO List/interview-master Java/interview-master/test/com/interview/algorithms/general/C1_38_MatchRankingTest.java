package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-25
 * Time: 下午11:32
 */
public class C1_38_MatchRankingTest extends TestCase {
    /**
     *      0       0       2       0
     *      0       1       1       3
     *      2       1       2       2
     *      0       3       2       3
     *
     */
    int[][] w = new int[][] {{0, 0, 2, 0}, {0, 1, 1, 3}, {2, 1, 2, 2}, {0, 3, 2, 3}};

    public void testcase1() throws Exception {
        int[] order = new int[] {0, 1, 2, 3};
        int[] rank = C1_38_MatchRanking.result(w, order);
        int[] expected = new int[]{2, 0, 3, 1};
        for(int i = 0; i < rank.length; i++){
            assertEquals(expected[i], rank[i]);
        }
        //ConsoleWriter.printIntArray(rank);
    }

    public void testcase2() throws Exception {
        int[] order = new int[] {3, 0, 2, 1};
        int[] rank = C1_38_MatchRanking.result(w, order);
        int[] expected = new int[]{0, 1, 2, 3};
        for(int i = 0; i < rank.length; i++){
            assertEquals(expected[i], rank[i]);
        }
        //ConsoleWriter.printIntArray(rank);
    }
}
