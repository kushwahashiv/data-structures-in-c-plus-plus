package com.interview.algorithms.dp;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-29
 * Time: 下午8:49
 */
public class C12_29_SpaceFillingTest extends TestCase {
    public void testBlockNumber() throws Exception {
        assertEquals(-1, C12_29_SpaceFilling.blockNumber(3,3));
        assertEquals(2, C12_29_SpaceFilling.blockNumber(2,2));
        assertEquals(2, C12_29_SpaceFilling.blockNumber(1,4));
        assertEquals(3, C12_29_SpaceFilling.blockNumber(3,2));
    }

    public void testFillingNumber() throws Exception {
        assertEquals(2, C12_29_SpaceFilling.fillingNumber(2,2));
        assertEquals(5, C12_29_SpaceFilling.fillingNumber(2,4));
        assertEquals(3, C12_29_SpaceFilling.fillingNumber(3,2));
    }
}
