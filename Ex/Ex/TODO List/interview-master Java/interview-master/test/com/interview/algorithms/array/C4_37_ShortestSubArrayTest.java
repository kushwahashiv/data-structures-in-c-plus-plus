package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-27
 * Time: 下午1:51
 */
public class C4_37_ShortestSubArrayTest extends TestCase {

    public void testFind() throws Exception {
        int[] array = new int[]{1,2,3,2,4,1,4,2,6,2,1,3,5,4};
        SubArray result = C4_37_ShortestSubArray.find(array, 6);
        assertEquals(8, result.start);
        assertEquals(13, result.end);
    }

    public void testFindWithCycle() throws Exception {
        int[] array = new int[]{6,1,2,3,2,4,1,4,2,6,2,2,1,1,3,5,4};
        SubArray result = C4_37_ShortestSubArray.find(array, 6);
        assertEquals(14, result.start);
        assertEquals(2, result.end);
    }
}
