package com.interview.leetcode.arrays.matrix;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午11:35
 */
public class MaxMatrixWithBlackBorderTest extends TestCase {
    public void testMaxMatrix() throws Exception {
        boolean[][] matrix = new boolean[][] {
                {true, true, true, false, true, true},
                {true, false, false, false, true, true},
                {true, true, true, true, true, true}};
        MaxMatrixWithBlackBorder.Matrix m = MaxMatrixWithBlackBorder.maxMatrix(matrix);
        assertEquals(0, m.x);
        assertEquals(4, m.y);
        assertEquals(1, m.width);
        assertEquals(2, m.height);
        System.out.printf("x:%d\ty:%d\twidth:%d\theight:%d\n", m.x, m.y, m.width, m.height);
    }
}
