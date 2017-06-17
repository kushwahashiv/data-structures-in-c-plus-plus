package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-1
 * Time: 下午6:35
 */
public class C4_13A_MaxSubMatrixTest extends TestCase {
    public void testGetMax() throws Exception {
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{0, -2, -7, 0};
        matrix[1] = new int[]{9,  2, -6, 2};
        matrix[2] = new int[]{-4, 1, -4, 1};
        matrix[3] = new int[]{-1, 8, 0, -2};

        C4_13A_MaxSubMatrix.SubMatrix max = C4_13A_MaxSubMatrix.getMax(matrix);
        assertEquals(15, max.sum);
        assertEquals(1, max.r1);
        assertEquals(3, max.r2);
        assertEquals(0, max.c1);
        assertEquals(1, max.c2);
        System.out.printf("sum: %d\tr1: %d\tr2: %d\tc1: %d\tc2: %d\n", max.sum, max.r1, max.r2, max.c1, max.c2);

    }

    public void test(){
        int[][] matrix = new int[][]{{1, 22, 3, 9}, {7, -20, 33, 17}, {95, 102, -84, 10}};
        C4_13A_MaxSubMatrix.SubMatrix max = C4_13A_MaxSubMatrix.getMax(matrix);
        assertEquals(207, max.sum);
        assertEquals(0, max.r1);
        assertEquals(2, max.r2);
        assertEquals(0, max.c1);
        assertEquals(1, max.c2);
        System.out.printf("sum: %d\tr1: %d\tr2: %d\tc1: %d\tc2: %d\n", max.sum, max.r1, max.r2, max.c1, max.c2);
    }
}
