package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-7
 * Time: 下午10:02
 */
public class C11_11_LongestCommonSubsequenceTest extends TestCase {

    public void testcase1(){
        String lcs = C11_11_LongestCommonSubsequence.LCS("bdcaba", "abcbdab");
        assertEquals("bcba", lcs);
    }

    public void testcase2(){
        String lcs = C11_11_LongestCommonSubsequence.LCS("bacd", "dcab");
        assertEquals("d", lcs);
    }

    public void testcase3(){
        String lcs = C11_11_LongestCommonSubsequence.LCS("absc", "ghui");
        assertEquals("", lcs);
    }
}
