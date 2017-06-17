package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_36_FinalRoundNumberTest extends TestCase {

    public void testFind() throws Exception {
        assertEquals(0, C1_36_FinalRoundNumber.find(6, 3));
        assertEquals(3, C1_36_FinalRoundNumber.find(5, 3));
    }
}