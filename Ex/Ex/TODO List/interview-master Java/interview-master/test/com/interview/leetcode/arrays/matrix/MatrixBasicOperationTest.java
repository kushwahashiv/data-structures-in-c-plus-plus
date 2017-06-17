package com.interview.leetcode.arrays.matrix;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午10:40
 */
public class MatrixBasicOperationTest extends TestCase {
    public void testRotate() throws Exception {
        int[][] array = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        MatrixBasicOperation.rotate(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();

        array = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        MatrixBasicOperation.rotate(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();

        array = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        MatrixBasicOperation.rotate(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();
    }

    public void testSpiralMatrix() throws Exception {
        int[][] array = MatrixBasicOperation.spiralMatrix(3, 3);
        ConsoleWriter.printIntArray(array);
        System.out.println();

        array = MatrixBasicOperation.spiralMatrix(6, 5);
        ConsoleWriter.printIntArray(array);
        System.out.println();
    }

    public void testSpiralPrint() throws Exception {
        int[][] array = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        int[] print = MatrixBasicOperation.spiralPrint(array);
        ConsoleWriter.printIntArray(print);
        System.out.println();

        array = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        print = MatrixBasicOperation.spiralPrint(array);
        ConsoleWriter.printIntArray(print);
        System.out.println();

        array = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        print = MatrixBasicOperation.spiralPrint(array);
        ConsoleWriter.printIntArray(print);
        System.out.println();
    }
    
    public void testSetZeros(){
        int[][] matrix = new int[][]{{1,2,4},{0,2,1}};
        MatrixBasicOperation.setZeroes(matrix);
        assertEquals(0, matrix[0][0]);
        assertEquals(2, matrix[0][1]);
        assertEquals(4, matrix[0][2]);
        assertEquals(0, matrix[1][0]);
        assertEquals(0, matrix[1][1]);
        assertEquals(0, matrix[1][2]);
        
        matrix = new int[][]{{0,2,1},{4,2,1},{2,6,0}};
        MatrixBasicOperation.setZeroes(matrix);
        assertEquals(0, matrix[0][0]);
        assertEquals(0, matrix[0][1]);
        assertEquals(0, matrix[0][2]);
        assertEquals(0, matrix[1][0]);
        assertEquals(2, matrix[1][1]);
        assertEquals(0, matrix[1][2]);
        assertEquals(0, matrix[2][0]);
        assertEquals(0, matrix[2][1]);
        assertEquals(0, matrix[2][2]);
    }
}
