package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-11
 * Time: 下午9:26
 */
public class C11_26_LongestRepeatSubstringTest extends TestCase {

    public void testFind() throws Exception {
        String str = "abcdabcd";
        String substring = C11_26_LongestRepeatSubstring.find(str);
        assertEquals("abcd", substring);
    }

    public void testFind2() throws Exception {
        String str = "abczzacbca";
        String substring = C11_26_LongestRepeatSubstring.find(str);
        assertEquals("bc", substring);
    }
}
