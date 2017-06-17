package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 上午7:50
 */
public class C1_73A_AllPermutationsTest extends TestCase {
    public void testPermute() throws Exception {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permutations = C1_73A_AllPermutations.permute(nums);
        assertEquals(6, permutations.size());
    }
}
