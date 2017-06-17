package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created_By: stefanie
 * Date: 14-11-5
 * Time: 下午9:40
 */
public class C1_73B_NextPermutationTest extends TestCase {
    public void testcase1() throws Exception {
        int[] num = new int[]{4,2,0,2,3,2,0};
        C1_73B_NextPermutation.nextPermutation(num);
        int[] expected = new int[]{4, 2, 0, 3, 0, 2, 2};
        ConsoleWriter.printIntArray(num);
        Assert.assertArrayEquals(expected, num);
    }

    public void testcase2() throws Exception {
        int[] num = new int[]{2,5,4,3,1};
        C1_73B_NextPermutation.nextPermutation(num);
        int[] expected = new int[]{3,1,2,4,5};
        ConsoleWriter.printIntArray(num);
        Assert.assertArrayEquals(expected, num);
    }

    public void testcase3() throws Exception {
        int[] num = new int[]{4,3,2,1};
        C1_73B_NextPermutation.nextPermutation(num);
        int[] expected = new int[]{1,2,3,4};
        ConsoleWriter.printIntArray(num);
        Assert.assertArrayEquals(expected, num);
    }
}
