package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-6
 * Time: 下午10:18
 */
public class C11_8_MaxCommonStringSearchTest extends TestCase {
    C11_8_MaxCommonStringSearch searcher = new C11_8_MaxCommonStringSearch();
    public void testcase1(){
        String[] list = new String[]{"abcde", "abccd", "abc", "abcef"};
        String common = searcher.findMaxCommonString(list);
        assertEquals("abc", common);
    }

    public void testcase2(){
        String[] list = new String[]{"fabcde", "rrtabccd", "abc", "ndabcef"};
        String common = searcher.findMaxCommonString(list);
        assertEquals("abc", common);
    }

    public void testcase3(){
        String[] list = new String[]{"fabcde", "rrtabccd", "abc", "f"};
        String common = searcher.findMaxCommonString(list);
        assertEquals("", common);
    }
}
