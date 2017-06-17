package com.interview.basics.model.collection.heap;

import junit.framework.TestCase;

public class YangMatrixTest extends TestCase {
    public void testcase(){
        int[] array = new int[]{9,6,3,2,4,8,5,14,12};
        YangMatrix matrix = new YangMatrix(array, 4, 4);
        matrix.print();

        assertEquals(2, matrix.min());
        matrix.popMin();
        matrix.print();
        assertEquals(3, matrix.min());

        assertTrue(matrix.contains(8));
        assertFalse(matrix.contains(11));
    }

}