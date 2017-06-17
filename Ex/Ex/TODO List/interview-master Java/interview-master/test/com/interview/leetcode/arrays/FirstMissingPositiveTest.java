package com.interview.leetcode.arrays;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午10:21
 */
public class FirstMissingPositiveTest extends TestCase {
    public void testFind() throws Exception {
        assertEquals(1, FirstMissingPositive.find(new int[0]));
        assertEquals(1, FirstMissingPositive.find(new int[]{7, 5, 6}));
        assertEquals(2, FirstMissingPositive.find(new int[]{3, 4, -1, 1}));
        assertEquals(2, FirstMissingPositive.find(new int[]{1, 1}));
    }
}
