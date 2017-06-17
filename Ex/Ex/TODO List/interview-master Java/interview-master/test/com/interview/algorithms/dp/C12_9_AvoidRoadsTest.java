package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 4/4/14
 * Time: 5:14 PM
 */
public class C12_9_AvoidRoadsTest {

    @Test
    public void testNumWays() {
        C12_9_AvoidRoads test = new C12_9_AvoidRoads();

        int width = 1;
        int height = 1;
        String[] bad = new String[] {};
        long count = test.numWays(width, height, bad);
        Assert.assertEquals(count, 2);
        count = test.numWaysDP(width, height, bad);
        Assert.assertEquals(count, 2);

        width = 1;
        height = 1;
        bad = new String[] {"0 0 0 1"};
        count = test.numWays(width, height, bad);
        Assert.assertEquals(count, 1);
        count = test.numWaysDP(width, height, bad);
        Assert.assertEquals(count, 1);

        width = 6;
        height = 6;
        bad = new String[] {"0 0 0 1","6 6 5 6"};
        count = test.numWays(width, height, bad);
        Assert.assertEquals(count, 252);
        count = test.numWaysDP(width, height, bad);
        Assert.assertEquals(count, 252);

        width = 2;
        height = 2;
        bad = new String[] {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
        count = test.numWays(width, height, bad);
        Assert.assertEquals(count, 0);
        count = test.numWaysDP(width, height, bad);
        Assert.assertEquals(count, 0);

// takes too long to run
//        width = 35;
//        height = 31;
//        bad = new String[] {};
//        count = test.numWays(width, height, bad);
//        Assert.assertEquals(count, 6406484391866534976L);
    }
}
