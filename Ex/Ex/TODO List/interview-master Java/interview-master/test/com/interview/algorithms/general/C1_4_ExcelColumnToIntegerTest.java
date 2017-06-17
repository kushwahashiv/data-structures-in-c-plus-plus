package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_4_ExcelColumnToIntegerTest extends TestCase {
    public void testTransform(){
        int column = C1_4_ExcelColumnToInteger.transform("A");
        assertEquals(1, column);

        column = C1_4_ExcelColumnToInteger.transform("AA");
        assertEquals(26, column);

        column = C1_4_ExcelColumnToInteger.transform("AB");
        assertEquals(27, column);
    }
}