package com.interview.leetcode.dp;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午9:06
 *      s1 = "aabcc",
 *      s2 = "dbbca",
 *  When s3 = "aadbbcbcac", return true.
 *  When s3 = "aadbbbaccc", return false.
 */
public class InterleavingStringTest extends TestCase {
    public void testIsInterleave() throws Exception {
        String s1 = "aabcc";
        String s2 = "dbbca";
        assertTrue(InterleavingString.isInterleave(s1, s2, "aadbbcbcac"));
        assertFalse(InterleavingString.isInterleave(s1, s2, "aadbbbaccc"));

        assertFalse(InterleavingString.isInterleave("a", "", "c"));
    }

    public void testIsInterleaveOptz() throws Exception {
        String s1 = "aabcc";
        String s2 = "dbbca";
        assertTrue(InterleavingString.isInterleaveOptz(s1, s2, "aadbbcbcac"));
        assertFalse(InterleavingString.isInterleaveOptz(s1, s2, "aadbbbaccc"));
        assertFalse(InterleavingString.isInterleaveOptz("a", "", "c"));
    }
}
