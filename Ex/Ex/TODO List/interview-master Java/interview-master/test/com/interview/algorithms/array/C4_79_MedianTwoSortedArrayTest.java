package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 上午2:36
 */
public class C4_79_MedianTwoSortedArrayTest extends TestCase {
    public void testMedian() throws Exception {
        int[] A = new int[0];
        int[] B = new int[]{1};
        assertEquals(1, C4_79_MedianTwoSortedArray.median(A, B));
    }
}
