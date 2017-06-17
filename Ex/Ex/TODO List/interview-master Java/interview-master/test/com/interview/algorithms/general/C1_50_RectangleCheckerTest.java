package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-26
 * Time: 下午5:05
 */
public class C1_50_RectangleCheckerTest extends TestCase {
    public void testcase1(){
        int[][] points = new int[][]{{1,1},{2,1},{1,2},{2,2}};
        assertTrue(C1_50_RectangleChecker.isRectangle(points));
    }

    public void testcase2(){
        int[][] points = new int[][]{{1,1},{2,4},{1,2},{2,2}};
        assertFalse(C1_50_RectangleChecker.isRectangle(points));
    }

    public void testcase3(){
        int[][] points = new int[][]{{3,1},{2,1},{1,2},{2,2}};
        assertFalse(C1_50_RectangleChecker.isRectangle(points));
    }

    public void testcase4(){
        int[][] points = new int[][]{{-1,1},{2,1},{-1,2},{2,2}};
        assertTrue(C1_50_RectangleChecker.isRectangle(points));
    }

    public void testcase5(){
        int[][] points = new int[][]{{1,1},{1,1},{1,1},{1,1}};
        assertFalse(C1_50_RectangleChecker.isRectangle(points));
    }

    public void testcase6(){
        int[][] points = new int[][]{{0,0},{1,2},{2,-1},{3,1}};
        assertTrue(C1_50_RectangleChecker.isRectangle(points));
    }
}
