package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-6
 * Time: 下午9:41
 */
public class C4_28_ResetMatrixTest extends TestCase {
    public void testcase1(){
        int[][] matrix = new int[][]{{1,2,4},{0,2,1}};
        int[][] cleanedMatrix = C4_28_ResetMatrix.reset(matrix);
        assertEquals(0, cleanedMatrix[0][0]);
        assertEquals(2, cleanedMatrix[0][1]);
        assertEquals(4, cleanedMatrix[0][2]);
        assertEquals(0, cleanedMatrix[1][0]);
        assertEquals(0, cleanedMatrix[1][1]);
        assertEquals(0, cleanedMatrix[1][2]);
    }
    public void testcase2(){
        int[][] matrix = new int[][]{{0,2,1},{4,2,1},{2,6,0}};
        int[][] cleanedMatrix = C4_28_ResetMatrix.reset(matrix);
        assertEquals(0, cleanedMatrix[0][0]);
        assertEquals(0, cleanedMatrix[0][1]);
        assertEquals(0, cleanedMatrix[0][2]);
        assertEquals(0, cleanedMatrix[1][0]);
        assertEquals(2, cleanedMatrix[1][1]);
        assertEquals(0, cleanedMatrix[1][2]);
        assertEquals(0, cleanedMatrix[2][0]);
        assertEquals(0, cleanedMatrix[2][1]);
        assertEquals(0, cleanedMatrix[2][2]);
    }
}
