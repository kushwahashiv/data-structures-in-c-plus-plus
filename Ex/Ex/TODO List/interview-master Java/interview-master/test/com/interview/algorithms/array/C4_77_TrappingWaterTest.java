package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午9:36
 */
public class C4_77_TrappingWaterTest extends TestCase {
    public void testTrap() throws Exception {
        int[] blocks = new int[]{2,0,2};
        assertEquals(2, C4_77_TrappingWater.trap(blocks));

        blocks = new int[]{4,2,0,3,2,4,3,4};
        assertEquals(10, C4_77_TrappingWater.trap(blocks));
    }
}
