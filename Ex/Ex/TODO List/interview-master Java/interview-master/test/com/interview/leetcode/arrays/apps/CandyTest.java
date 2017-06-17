package com.interview.leetcode.arrays.apps;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午3:53
 */
public class CandyTest extends TestCase {
    public void testCandy() throws Exception {
        int[] children = new int[]{5,3,1};
        assertEquals(6, Candy.candy(children));
    }
}
