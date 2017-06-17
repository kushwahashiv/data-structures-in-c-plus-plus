package com.interview.algorithms.dp;

import junit.framework.TestCase;

public class C12_14_QuickSumsTest extends TestCase {
    C12_14_QuickSums solver = new C12_14_QuickSums(C12_14_QuickSums.RECURSIVE);

    public void testMinSums1() throws Exception {
        String text = "99999";
        int count = solver.minSums(text, 45);
        assertEquals(4, count);
        System.out.println(solver.count);
    }
    public void testMinSums2() throws Exception {
        String text = "1110";
        int count = solver.minSums(text, 3);
        assertEquals(3, count);
        System.out.println(solver.count);
    }
    public void testMinSums3() throws Exception {
        String text = "0123456789";
        int count = solver.minSums(text, 45);
        assertEquals(8, count);
        System.out.println(solver.count);
    }
    public void testMinSums4() throws Exception {
        String text = "99999";
        int count = solver.minSums(text, 100);
        assertEquals(-1, count);
        System.out.println(solver.count);
    }
    public void testMinSums5() throws Exception {
        String text = "382834";
        int count = solver.minSums(text, 100);
        assertEquals(2, count);
        System.out.println(solver.count);
    }
    public void testMinSums6() throws Exception {
        String text = "9230560001";
        int count = solver.minSums(text, 71);
        assertEquals(4, count);
        System.out.println(solver.count);
    }
}