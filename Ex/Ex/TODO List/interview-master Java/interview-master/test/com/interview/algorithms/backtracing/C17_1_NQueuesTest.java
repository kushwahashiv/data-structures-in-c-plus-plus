package com.interview.algorithms.backtracing;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-7
 * Time: 下午5:47
 */
public class C17_1_NQueuesTest extends TestCase {
    public void testSolution1() throws Exception {
        int n = 8;
        C17_1_NQueues finder = new C17_1_NQueues();
        List<String[]> sols = finder.solveNQueens(n);
        assertEquals(92, sols.size());
//        System.out.println(sols.size());
//        for(String[] sol : sols){
//            for(int i = 0; i < n; i++) System.out.println(sol[i]);
//            System.out.println();
//        }
    }

    public void testSolution2() throws Exception {
        int n = 4;
        C17_1_NQueues finder = new C17_1_NQueues();
        List<String[]> sols = finder.solveNQueens(n);
        assertEquals(2, sols.size());
//        System.out.println(sols.size());
//        for(String[] sol : sols){
//            for(int i = 0; i < n; i++) System.out.println(sol[i]);
//            System.out.println();
//        }
    }
}
