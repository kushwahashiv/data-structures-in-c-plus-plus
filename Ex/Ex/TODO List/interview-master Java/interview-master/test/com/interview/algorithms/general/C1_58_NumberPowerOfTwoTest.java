package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_58_NumberPowerOfTwoTest extends TestCase {

    public void testcase1() {
        assertEquals(4, C1_58_NumberPowerOfTwo.find(7));
    }

    public void testcase2() {
        assertEquals(16384, C1_58_NumberPowerOfTwo.find(20102));
    }

    public void testcase3() {
        assertEquals(16, C1_58_NumberPowerOfTwo.find(16));
    }
}