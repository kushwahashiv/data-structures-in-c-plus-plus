package com.interview.algorithms.dp;

import junit.framework.TestCase;

public class C12_22_MatrixMultiplyTest extends TestCase {

    public void testcase1() throws Exception {
        int[] dim = new int[]{10, 10, 100, 5, 50};
        C12_22_MatrixMultiply.Result result = C12_22_MatrixMultiply.count(dim);
        //System.out.println(result.cost);
        //System.out.println(result.combination);
        assertEquals(8000, result.cost);
        assertEquals("((A)(BC))(D)", result.combination);
    }

    public void testcase2(){
        int[] dim = new int[]{10, 20, 30, 20, 10};
        C12_22_MatrixMultiply.Result result = C12_22_MatrixMultiply.count(dim);
        assertEquals(14000, result.cost);
        assertEquals("(A)((B)(CD))", result.combination);
//        System.out.println(result.cost);
//        System.out.println(result.combination);
    }

    public void testcase3(){
        int[] dim = new int[]{10, 30, 30, 20, 10};
        C12_22_MatrixMultiply.Result result = C12_22_MatrixMultiply.count(dim);
        assertEquals(17000, result.cost);
        assertEquals("((AB)(C))(D)", result.combination);
//        System.out.println(result.cost);
//        System.out.println(result.combination);
    }
}