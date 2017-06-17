package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_56_AllFactorNumberTest extends TestCase {
    public void testcase1(){
        assertTrue(C1_56_AllFactorNumber.isOddFactor(36));
    }

    public void testcase2(){
        assertFalse(C1_56_AllFactorNumber.isOddFactor(24));
    }
}