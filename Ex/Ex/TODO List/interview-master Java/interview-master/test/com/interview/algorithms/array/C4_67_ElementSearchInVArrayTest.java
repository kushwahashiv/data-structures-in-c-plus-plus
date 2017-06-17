package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 下午3:33
 */
public class C4_67_ElementSearchInVArrayTest extends TestCase {
    public void testFind() throws Exception {
        int[] array = new int[]{6,4,2,1,3,7,8};
        assertEquals(1, C4_67_ElementSearchInVArray.find(array, 4));
        assertEquals(5, C4_67_ElementSearchInVArray.find(array, 7));
        assertEquals(-1, C4_67_ElementSearchInVArray.find(array, 5));
        assertEquals(0, C4_67_ElementSearchInVArray.find(array, 6));
    }
}
