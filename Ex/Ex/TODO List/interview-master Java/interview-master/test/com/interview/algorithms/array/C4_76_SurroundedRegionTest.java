package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午5:13
 */
public class C4_76_SurroundedRegionTest extends TestCase {
    public void testFlip() throws Exception {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] expected = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        C4_76_SurroundedRegion.flip(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }

    }
}
