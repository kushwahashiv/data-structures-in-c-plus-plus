package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_65_YangMatrixSearchingTest extends TestCase {

    /**
     * 1    2   3   9
     * 2    4   9   12
     * 4    7   10  13
     * 6    8   11  15
     * @throws Exception
     */
    public void testcase() throws Exception {
        int[][] matrix = new int[][]{{1,2,8,9},{2,4,9,12},{3,7,10,13},{6,8,11,15}};
        assertTrue(C4_65_YangMatrixSearching.exist(matrix, 6));
        assertFalse(C4_65_YangMatrixSearching.exist(matrix, 5));
        assertTrue(C4_65_YangMatrixSearching.exist(matrix, 3));
        assertTrue(C4_65_YangMatrixSearching.exist(matrix, 12));
    }
}