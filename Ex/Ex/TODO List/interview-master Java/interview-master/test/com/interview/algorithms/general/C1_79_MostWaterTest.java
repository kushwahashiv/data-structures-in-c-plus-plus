package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-7
 * Time: 下午11:26
 */
public class C1_79_MostWaterTest extends TestCase {
    public void testMaxArea() throws Exception {
        int[] heights = new int[]{1,2};
        assertEquals(1, C1_79_MostWater.maxArea(heights));

        heights = new int[]{1,2,1};
        assertEquals(2, C1_79_MostWater.maxArea(heights));

        heights = new int[]{1,2,4,3};
        assertEquals(4, C1_79_MostWater.maxArea(heights));
    }
}
