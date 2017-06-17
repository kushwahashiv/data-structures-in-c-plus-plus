package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_57_FirstNumberAppearOnceTest extends TestCase {

    public void testFind() throws Exception {
        int[] array = new int[]{2,3,4,56,2,1,3,4,56,1,6,1,3,5,7,3,6};
        assertEquals(5, C4_57_FirstNumberAppearOnce.find(array));
    }
}