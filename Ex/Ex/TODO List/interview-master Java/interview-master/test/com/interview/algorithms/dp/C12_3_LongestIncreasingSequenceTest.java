package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/14/14
 * Time: 5:52 PM
 */
public class C12_3_LongestIncreasingSequenceTest {

    @Test
    public void testGetLengthOfLongestIncreasingSequence() {
        C12_3_LongestIncreasingSequence test = new C12_3_LongestIncreasingSequence();
        int[] values = new int[] {5, 3, 4, 8, 6, 7};
        int[] seq = test.getLengthOfLongestIncreasingSequence(values);
        Assert.assertEquals(seq.length, 4);

        Assert.assertEquals(seq[0], 3);
        Assert.assertEquals(seq[1], 4);
        Assert.assertEquals(seq[2], 6);
        Assert.assertEquals(seq[3], 7);
    }

    @Test
    public void testcase2(){
        C12_3_LongestIncreasingSequence test = new C12_3_LongestIncreasingSequence();
        int[] values = new int[] {5, 3, 4, 8, 6, 2};
        int[] seq = test.getLengthOfLongestIncreasingSequence(values);

        Assert.assertEquals(seq.length, 3);

        Assert.assertEquals(seq[0], 3);
        Assert.assertEquals(seq[1], 4);
        Assert.assertEquals(seq[2], 8);
    }
}
