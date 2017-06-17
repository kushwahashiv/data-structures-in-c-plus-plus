package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午10:27
 */
public class C4_78_LongestConsecutiveSequenceTest extends TestCase {
    public void testLongestConsecutive() throws Exception {
        int[] seqs = new int[]{100,2,3,200,1,4};
        assertEquals(4, C4_78_LongestConsecutiveSequence.longestConsecutive(seqs));

        seqs = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        assertEquals(7, C4_78_LongestConsecutiveSequence.longestConsecutive(seqs));
    }

    public void testLongestConsecutiveUF() throws Exception {
        int[] seqs = new int[]{100,2,3,200,1,4};
        assertEquals(4, C4_78_LongestConsecutiveSequence.longestConsecutiveUF(seqs));

        seqs = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        assertEquals(7, C4_78_LongestConsecutiveSequence.longestConsecutiveUF(seqs));
    }
}
