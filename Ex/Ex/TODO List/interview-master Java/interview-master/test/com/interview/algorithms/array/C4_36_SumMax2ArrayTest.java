package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-25
 * Time: 下午11:12
 */
public class C4_36_SumMax2ArrayTest extends TestCase {
    public void testFind() throws Exception {
        int[][] a = new int[][] {{1,2,0,3,4},{2,3,4,5,1},{1,1,5,3,0}};
        assertEquals(17, C4_36_SumMax2Array.find(a));
    }
}
