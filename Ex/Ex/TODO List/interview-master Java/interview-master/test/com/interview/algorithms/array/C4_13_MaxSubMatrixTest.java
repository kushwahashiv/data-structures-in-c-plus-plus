package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_13_MaxSubMatrixTest extends TestCase {

    public void testFind() throws Exception {
        /**
         *  0 -2 -7  0
            9  2 -6  2
            -4  1 -4  1
            -1  8  0 -2

         max is:
            9 2
            -4 1
            -1 8
         */
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{0, -2, -7, 0};
        matrix[1] = new int[]{9,  2, -6, 2};
        matrix[2] = new int[]{-4, 1, -4, 1};
        matrix[3] = new int[]{-1, 8, 0, -2};

        int max = C4_13_MaxSubMatrix.find(matrix);
        assertEquals(15, max);
    }
}