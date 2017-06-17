package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 下午5:26
 */
public class C4_68_TwoDimensionUnionFindTest extends TestCase {
    public void testUnionfind() throws Exception {
        int[][] matrix = new int[][]{
                {0, 1, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0, 1}
        };

        int[][] union = C4_68_TwoDimensionUnionFind.unionfind(matrix);
        for(int i = 0; i < union.length; i++){
            for(int j = 0; j < union[0].length; j++){
                System.out.printf("%d\t", union[i][j]);
            }
            System.out.println();
        }
    }
}
