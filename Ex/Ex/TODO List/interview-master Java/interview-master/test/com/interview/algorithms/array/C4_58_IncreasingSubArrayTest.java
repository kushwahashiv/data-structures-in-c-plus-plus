package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_58_IncreasingSubArrayTest extends TestCase {

    public void testFind() throws Exception {
        int[] array = new int[] {1,2,3};
        assertEquals(4, C4_58_IncreasingSubArray.find(array));
    }

    public void testcase1(){
        int[] array = new int[] {1,2,3,4};
        assertEquals(11, C4_58_IncreasingSubArray.find(array));
    }

    public void testcase2(){
        int[] array = new int[]{5,9,1,7,2,6,3,8,10,4};
        assertEquals(340, C4_58_IncreasingSubArray.find(array));
    }
}