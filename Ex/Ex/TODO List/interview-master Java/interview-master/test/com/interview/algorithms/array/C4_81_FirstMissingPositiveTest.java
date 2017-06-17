package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-12
 * Time: 下午5:42
 */
public class C4_81_FirstMissingPositiveTest extends TestCase {
    public void testFirstMissingPositive() throws Exception {
        assertEquals(1, C4_81_FirstMissingPositive.firstMissingPositive(new int[0]));
        assertEquals(1, C4_81_FirstMissingPositive.firstMissingPositive(new int[]{7, 5, 6}));
        assertEquals(2, C4_81_FirstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(2, C4_81_FirstMissingPositive.firstMissingPositive(new int[]{1, 1}));
    }
}
