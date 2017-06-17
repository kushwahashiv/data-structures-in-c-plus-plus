package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_52_TaskAssignmentTest extends TestCase {

    public void testAssignSuccess() throws Exception {
        int[] request = new int[]{10, 8};
        int[] output = new int[]{5, 6};

        int[] seq = C1_52_TaskAssignment.assign(14, request, output);
        assertEquals(0, seq[0]);
        assertEquals(1, seq[1]);
    }

    public void testAssignFail(){
        int[] request = new int[]{10, 8, 5};
        int[] output = new int[]{5, 6, 2};

        int[] seq = C1_52_TaskAssignment.assign(14, request, output);
        assertEquals(0, seq.length);

    }
}