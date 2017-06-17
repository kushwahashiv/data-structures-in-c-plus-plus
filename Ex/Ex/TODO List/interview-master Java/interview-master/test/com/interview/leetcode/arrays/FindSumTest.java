package com.interview.leetcode.arrays;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-12
 * Time: 下午10:17
 */
public class FindSumTest extends TestCase {
    int[] num = new int[]{3,5,1,6,7,3,2,1};
    public void testSum2() throws Exception {
        List<List<Integer>> sols = FindSum.sum2(num, 6);
        assertEquals(2, sols.size());
        //ConsoleWriter.printListOfList(sols);
    }

    public void testSum3() throws Exception {
        List<List<Integer>> sols = FindSum.sum3(num, 7);
        assertEquals(2, sols.size());
        //ConsoleWriter.printListOfList(sols);
    }

    public void testSum4() throws Exception {
        List<List<Integer>> sols = FindSum.sum4(num, 7);
        assertEquals(1, sols.size());
        //ConsoleWriter.printListOfList(sols);
    }

    public void testClosest3() throws Exception {
        int closest = FindSum.closest3(num, 15);
        assertEquals(15, closest);
        closest = FindSum.closest3(num, 0);
        assertEquals(4, closest);
        closest = FindSum.closest3(num, 17);
        assertEquals(16, closest);
    }


}
