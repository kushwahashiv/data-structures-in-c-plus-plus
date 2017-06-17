package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 4/6/14
 * Time: 7:24 AM
 */
public class C12_10_ChessMetricTest {

    @Test
    public void testHowMany() {

        C12_10_ChessMetric test = new C12_10_ChessMetric();

        int size = 3;
        int[] start = new int[] {0, 0};
        int[] finish = new int[] {0, 1};
        int numMoves = 1;
        long numWays = test.howMany(size, start, finish, numMoves);
        Assert.assertEquals(numWays, 1);

        size = 3;
        start = new int[] {0, 0};
        finish = new int[] {1, 2};
        numMoves = 1;
        numWays = test.howMany(size, start, finish, numMoves);
        Assert.assertEquals(numWays, 1);

        size = 3;
        start = new int[] {0, 0};
        finish = new int[] {2, 2};
        numMoves = 1;
        numWays = test.howMany(size, start, finish, numMoves);
        Assert.assertEquals(numWays, 0);

        size = 3;
        start = new int[] {0, 0};
        finish = new int[] {0, 0};
        numMoves = 2;
        numWays = test.howMany(size, start, finish, numMoves);
        Assert.assertEquals(numWays, 5);

//        size = 100;
//        start = new int[] {0, 0};
//        finish = new int[] {0, 99};
//        numMoves = 50;
//        numWays = test.howMany(size, start, finish, numMoves);
//        Assert.assertEquals(numWays, 243097320072600L);
    }
}
