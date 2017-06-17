package com.interview.algorithms.general;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 4/8/14
 * Time: 10:29 AM
 */
public class C1_3_UnionFindTest {

    @Test
    public void testUnionFind(){

        String data =
                "4 3\n" +
                "3 8\n" +
                "6 5\n" +
                "9 4\n" +
                "2 1\n" +
                "8 9\n" +
                "5 0\n" +
                "7 2\n" +
                "6 1\n" +
                "1 0\n" +
                "6 7";
        C1_3_UnionFind test = new C1_3_UnionFind(10);
        for(String conn : data.split("\\n")) {
            String[] parts = conn.split("\\s+");
            int p = Integer.parseInt(parts[0]);
            int q = Integer.parseInt(parts[1]);
            test.union(p, q);
        }

        Assert.assertEquals(test.count(), 2);
        Assert.assertTrue(test.connected(0, 7));
        Assert.assertFalse(test.connected(0, 8));
        Assert.assertTrue(test.connected(3, 9));
    }
}
