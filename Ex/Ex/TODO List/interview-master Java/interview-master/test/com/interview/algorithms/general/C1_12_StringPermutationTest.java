package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

public class C1_12_StringPermutationTest extends TestCase {

    public void testPermutation() throws Exception {
        String str = "abcd";
        List<String> permutations = C1_12_StringPermutation.permutation(str);

        assertEquals(24, permutations.size());

        assertTrue(permutations.contains("abcd"));
        assertTrue(permutations.contains("bacd"));
        assertTrue(permutations.contains("badc"));
        assertTrue(permutations.contains("dacb"));

    }

}