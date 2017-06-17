package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-7
 * Time: 下午10:26
 */
public class C11_12_LongestCommonSubstringTest extends TestCase {
    public void testcase1(){
        String lcs = C11_12_LongestCommonSubstring.LCS("abc", "bc");
        assertEquals("bc", lcs);
    }

    public void testcase2(){
        String lcs = C11_12_LongestCommonSubstring.LCS("gbchabc", "abc");
        assertEquals("abc", lcs);
    }

    public void testcase3(){
        String lcs = C11_12_LongestCommonSubstring.LCS("uhihh", "yowbc");
        assertEquals("", lcs);
    }

    public void testcase4(){
        String lcs = C11_12_LongestCommonSubstring.LCS("uhihh", "yowubc");
        assertEquals("u", lcs);
    }
}
