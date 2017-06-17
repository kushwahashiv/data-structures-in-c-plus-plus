package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_42_SmallestCombineNumberTest extends TestCase {

    public void testFind() throws Exception {
        int[] numbers = new int[] {125, 32};
        String combineNumber = C4_42_SmallestCombineNumber.find(numbers);
        assertEquals("12532", combineNumber);
    }

    public void testFind2() throws Exception {
        int[] numbers = new int[] {125, 32, 21};
        String combineNumber = C4_42_SmallestCombineNumber.find(numbers);
        assertEquals("1252132", combineNumber);
    }
}