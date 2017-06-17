package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 上午7:56
 */
public class C1_73C_PermutationSequenceTest extends TestCase {
    public void testPermutation() throws Exception {
        assertEquals("", C1_73C_PermutationSequence.permutation(3, 0));
        assertEquals("123", C1_73C_PermutationSequence.permutation(3, 1));
        assertEquals("312", C1_73C_PermutationSequence.permutation(3, 5));
        assertEquals("213", C1_73C_PermutationSequence.permutation(3, 3));

    }
}
