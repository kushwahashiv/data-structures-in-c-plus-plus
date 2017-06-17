package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 上午11:50
 */
public class C11_29_KImportantStringTest extends TestCase {


    public void testcase1() throws Exception {
        String[] strs = new String[] {"abc", "cde", "bcf"};
        String kstr = C11_29_KImportantString.find(strs, 3, 1);
        assertEquals("abc", kstr);
        kstr = C11_29_KImportantString.find(strs, 3, 2);
        assertEquals("abcf", kstr);
        kstr = C11_29_KImportantString.find(strs, 3, 3);
        assertEquals("abcfabc", kstr);
    }

    public void testcase2() throws Exception {
        String[] strs = new String[] {"abc", "cde", "bcf", "def"};
        String kstr = C11_29_KImportantString.find(strs, 3, 3);
        assertEquals("abcdef", kstr);
    }

}
