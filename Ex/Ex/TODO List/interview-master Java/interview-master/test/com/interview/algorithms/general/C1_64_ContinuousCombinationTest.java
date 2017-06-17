package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_64_ContinuousCombinationTest extends TestCase {
    //9 -> 4 + 5, 11 -> 5 + 6,  6 -> 1 + 2 + 3,  20 ->  2 + 3 + 4 + 5 + 6
    public void testcase1(){
        assertTrue(C1_64_ContinuousCombination.have(9));
    }

    public void testcase2(){
        assertTrue(C1_64_ContinuousCombination.have(6));
    }

    public void testcase3(){
        assertTrue(C1_64_ContinuousCombination.have(20));
    }

    public void testcase4(){
        assertFalse(C1_64_ContinuousCombination.have(8));
    }

    public void testcase5(){
        assertFalse(C1_64_ContinuousCombination.have(16));
    }

    public void testcase6(){
        assertTrue(C1_64_ContinuousCombination.have(28));
    }

    public void testcase7(){
        assertFalse(C1_64_ContinuousCombination.have(32));
    }
}