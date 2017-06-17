package com.interview.leetcode.arrays.matrix;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午11:40
 */
public class MaxSubMatrixTest extends TestCase {
    public void testGetMax() throws Exception {
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

        MaxSubMatrix.SubMatrix max = MaxSubMatrix.getMax(matrix);
        assertEquals(15, max.sum);
        assertEquals(1, max.r1);
        assertEquals(3, max.r2);
        assertEquals(0, max.c1);
        assertEquals(1, max.c2);
    }
}
