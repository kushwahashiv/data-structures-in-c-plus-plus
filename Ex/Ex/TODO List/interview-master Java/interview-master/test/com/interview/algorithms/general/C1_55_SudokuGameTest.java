package com.interview.algorithms.general;

import com.interview.algorithms.general.C1_55_SudokuGame;
import com.interview.algorithms.general.GameState;
import com.interview.util.TestUtil;
import com.interview.utils.ArrayUtil;
import junit.framework.TestCase;

public class C1_55_SudokuGameTest extends TestCase {
    class Position {
        public int x = 1;
        public int y = 1;
    }

    /**
     * 5 4 1           5 1              1 2 3
     * 3   2   --->    3 4 2            8   4
     * 7 8 6           7 8 6            7 6 5
     *
     * @throws Exception
     */

    public void testcase1() {
        Integer[][] start = new Integer[3][];
        start[0] = new Integer[]{5, 4, 1};
        start[1] = new Integer[]{3, 0, 2};
        start[2] = new Integer[]{7, 8, 6};

        Integer[][] end = new Integer[3][];
        end[0] = new Integer[]{5, 1, 2};
        end[1] = new Integer[]{7, 4, 6};
        end[2] = new Integer[]{8, 3, 0};
        testSolve(start, end);
    }

    public void test10Step(){
        testRandom(10);
    }

    public void test100Step(){
        testRandom(100);
    }

    public void test1000Step(){
        testRandom(1000);
    }

    public void test10000Step(){
        testRandom(10000);
    }

    public void testRandom(int step) {
        Integer[][] start = new Integer[3][];
        start[0] = new Integer[]{1, 2, 3};
        start[1] = new Integer[]{8, 0, 4};
        start[2] = new Integer[]{7, 6, 5};

        generateState(start, step);
        print(start);

        Integer[][] end = new Integer[3][];
        end[0] = new Integer[]{1, 2, 3};
        end[1] = new Integer[]{8, 0, 4};
        end[2] = new Integer[]{7, 6, 5};
        testSolve(start, end);
    }

    public void testSolve(Integer[][] start, Integer[][] end) {

        C1_55_SudokuGame game = new C1_55_SudokuGame(3);
        //game.debug(true);

        int[] ops = game.solve(start, end);
        System.out.printf("Find a solution with %d steps\n", ops.length);

        Position p = new Position();
        for(int i = 0; i < start.length; i++){
            for(int j = 0; j < start.length; j++)
                if(start[i][j] == 0){
                    p.x = i;
                    p.y = j;
                }
        }
        for (int op : ops) {
            move(start, op, p, true);
        }

        assertTrue(checkFinish(start, end));
    }

    public void generateState(Integer[][] matrix, int steps) {
        Position p = new Position();
        int i = 0;
        while (i < steps) {
            int op = TestUtil.generateInt(3);
            boolean canMove = move(matrix, op, p, false);
            if(canMove) i++;
        }
    }

    public boolean move(Integer[][] start, int op, Position p, boolean print) {
        switch (op) {
            case C1_55_SudokuGame.UP: //up
                if (p.x - 1 < 0) return false;
                if(print)   System.out.println("MOVE UP");
                ArrayUtil.swap(start, p.x, p.y, p.x - 1, p.y);
                p.x --;
                break;
            case C1_55_SudokuGame.DOWN: //down
                if (p.x + 1 > start.length - 1) return false;
                if(print)   System.out.println("MOVE DOWN");
                ArrayUtil.swap(start, p.x, p.y, p.x + 1, p.y);
                p.x ++;
                break;
            case C1_55_SudokuGame.LEFT: //left
                if (p.y - 1 < 0) return false;
                if(print)   System.out.println("MOVE LEFT");
                ArrayUtil.swap(start, p.x, p.y, p.x, p.y - 1);
                p.y --;
                break;
            case C1_55_SudokuGame.RIGHT:
                if (p.y + 1 > start.length - 1) return false;
                if(print)   System.out.println("MOVE RIGHT");
                ArrayUtil.swap(start, p.x, p.y, p.x, p.y + 1);
                p.y ++;
        }
        //if(print) print(start);
        return true;
    }

    public boolean checkFinish(Integer[][] matrix, Integer[][] end) {
        String s = GameState.getString(matrix);
        String e = GameState.getString(end);
        return s.equals(e);
    }

    public void print(Integer[][] matrix){
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}