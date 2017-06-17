package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 下午4:41
 */
public class C1_58A_PowerOfTwoTest extends TestCase {
    public void testCheck() throws Exception {
        assertTrue(C1_58A_PowerOfTwo.check(4));
        assertTrue(C1_58A_PowerOfTwo.check(1024));
        assertFalse(C1_58A_PowerOfTwo.check(7));
        assertFalse(C1_58A_PowerOfTwo.check(5));
        assertFalse(C1_58A_PowerOfTwo.check(1023));
    }
}
