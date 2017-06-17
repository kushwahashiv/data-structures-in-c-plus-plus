package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_70_AddWithoutArithmeticTest extends TestCase {

    public void testAdd() throws Exception {
        assertEquals(41, C1_70_AddWithoutArithmetic.add(19, 22));
        assertEquals(-12, C1_70_AddWithoutArithmetic.add(1, -13));
    }
}