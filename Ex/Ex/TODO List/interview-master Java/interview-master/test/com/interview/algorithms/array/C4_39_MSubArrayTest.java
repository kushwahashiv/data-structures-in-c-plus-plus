package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-28
 * Time: 下午8:45
 */
public class C4_39_MSubArrayTest extends TestCase {
    public void testFind() throws Exception {
        int[] array = new int[] {2,3,4,6,3};
        int M = C4_39_MSubArray.find(array);
        assertEquals(3, M);
    }

    public void testFindNon() throws Exception {
        int[] array = new int[] {6,3,4,6,3};
        int M = C4_39_MSubArray.find(array);
        assertEquals(1, M);
    }
}
