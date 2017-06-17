package com.interview.algorithms.dp;

import junit.framework.TestCase;

public class C12_12_JewelrySplitTest extends TestCase {

    public void testFind1() throws Exception {
        Integer[] jewelries = new Integer[] {1,2,5,3,4,5};
        long solution = C12_12_JewelrySplit.find(jewelries);
        assertEquals(9, solution);
    }

    public void testFind2() throws Exception {
        Integer[] jewelries = new Integer[] {1,2,3,4,5};
        long solution = C12_12_JewelrySplit.find(jewelries);
        assertEquals(4, solution);
    }

    public void testFind3() throws Exception {
        Integer[] jewelries = new Integer[] {7,7,8,9,10,11,1,2,2,3,4,5,6};
        long solution = C12_12_JewelrySplit.find(jewelries);
        assertEquals(607, solution);
    }

    public void testFind4() throws Exception {
        Integer[] jewelries = new Integer[] {123,217,661,678,796,964,54,111,417,526,917,923};
        long solution = C12_12_JewelrySplit.find(jewelries);
        assertEquals(0, solution);
    }

    public void testFind5() throws Exception {
        Integer[] jewelries = new Integer[] {1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000};
        long solution = C12_12_JewelrySplit.find(jewelries);
        assertEquals(18252025766940L, solution);
    }
}