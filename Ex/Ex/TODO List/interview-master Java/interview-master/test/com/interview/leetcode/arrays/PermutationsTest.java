package com.interview.leetcode.arrays;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午7:33
 */
public class PermutationsTest extends TestCase {
    public void testPermutationsNoDup() throws Exception {
        int[] num = new int[]{1,2,3};
        List<List<Integer>> permutations = Permutations.permutationsNoDup(num);
        ConsoleWriter.print(permutations);
        assertEquals(6, permutations.size());
    }

    public void testPermutationsWithDup() throws Exception {
        int[] num = new int[]{1,1,2,3};
        List<List<Integer>> permutations = Permutations.permutationsWithDup(num);
        ConsoleWriter.print(permutations);
        assertEquals(6, permutations.size());
    }

    public void testNextPermuation() throws Exception {
        int[] num = new int[]{4,2,0,2,3,2,0};
        Permutations.nextPermutation(num);
        int[] expected = new int[]{4, 2, 0, 3, 0, 2, 2};
        ConsoleWriter.printIntArray(num);
        Assert.assertArrayEquals(expected, num);
    }

    public void testKthPermutation() throws Exception{
        assertEquals("", Permutations.KthPermutation(3, 0));
        assertEquals("123", Permutations.KthPermutation(3, 1));
        assertEquals("312", Permutations.KthPermutation(3, 5));
        assertEquals("213", Permutations.KthPermutation(3, 3));
    }
}
