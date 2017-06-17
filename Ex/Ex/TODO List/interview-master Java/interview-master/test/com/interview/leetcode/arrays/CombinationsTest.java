package com.interview.leetcode.arrays;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午5:40
 */
public class CombinationsTest extends TestCase {
    public void testCombinationNoDup() throws Exception {
        int[] num = new int[]{1,2,3};
        List<List<Integer>> subsets = Combinations.combinationNoDup(num);
        assertEquals(8, subsets.size());
    }

    public void testCombinationWithDup() throws Exception {
        int[] num = new int[]{1,1,2,3};
        List<List<Integer>> subsets = Combinations.combinationWithDup(num);
        //ConsoleWriter.print(subsets);
        assertEquals(12, subsets.size());
    }

    public void testCombinationSizeK() throws Exception {
        int[] num = new int[]{1,1,2,3};
        List<List<Integer>> subsets = Combinations.combinationSizeK(num, 2);
        ConsoleWriter.print(subsets);
        assertEquals(4, subsets.size());
    }

    public void testCombinationSumKOnce()throws Exception {
        int[] num = new int[]{1, 1, 1, 2, 3};
        List<List<Integer>> subsets = Combinations.combinationSumKOnce(num, 4);
        ConsoleWriter.print(subsets);
        assertEquals(2, subsets.size());
    }

    public void testCombinationSumKMulti()throws Exception {
        int[] num = new int[]{1};
        List<List<Integer>> subsets = Combinations.combinationSumKMulti(num, 2);
        ConsoleWriter.print(subsets);
        assertEquals(4, subsets.size());
    }
}
