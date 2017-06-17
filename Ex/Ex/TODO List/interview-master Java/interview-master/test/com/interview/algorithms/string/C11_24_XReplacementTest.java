package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-7
 * Time: 下午3:39
 */
public class C11_24_XReplacementTest extends TestCase {
    public void testReplace() throws Exception {
        String str = "abcdeffdfegabcabc";
        String pattern = "abc";
        String replacement = C11_24_XReplacement.replace(str, pattern);
        assertEquals("XdeffdfegX", replacement);
    }

    public void testReplace2() throws Exception {
        String str = "abcabdeffdfegabcabc";
        String pattern = "abc";
        String replacement = C11_24_XReplacement.replace(str, pattern);
        assertEquals("XabdeffdfegX", replacement);
    }
}
