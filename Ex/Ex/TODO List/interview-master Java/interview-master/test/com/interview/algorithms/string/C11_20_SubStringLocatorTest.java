package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-20
 * Time: 下午2:45
 */
public class C11_20_SubStringLocatorTest extends TestCase {
    public void testcase1(){
        String a = "abcbdef";
        String b = "de";
        assertEquals(4, C11_20_SubStringLocator.match(a, b));
        assertEquals(4, C11_20_SubStringLocator.kmpMatch(a, b));
        assertEquals(4, C11_20_SubStringLocator.sunnyMatch(a, b));
    }

    public void testcase2(){
        String a = "aaaaaaab";
        String b = "aaab";
        assertEquals(4, C11_20_SubStringLocator.match(a, b));
        assertEquals(4, C11_20_SubStringLocator.kmpMatch(a, b));
        assertEquals(4, C11_20_SubStringLocator.sunnyMatch(a, b));
    }

    public void testcase3(){
        String a = "aaaeaaabde";
        String b = "abc";
        assertEquals(-1, C11_20_SubStringLocator.match(a, b));
        assertEquals(-1, C11_20_SubStringLocator.kmpMatch(a, b));
        assertEquals(-1, C11_20_SubStringLocator.sunnyMatch(a, b));
    }

    public void testcase4(){
        String a = "cbcbdefacbce";
        String b = "cbce";
        assertEquals(8, C11_20_SubStringLocator.match(a, b));
        assertEquals(8, C11_20_SubStringLocator.kmpMatch(a, b));
        assertEquals(8, C11_20_SubStringLocator.sunnyMatch(a, b));
    }

    public void testcase5(){
        String a = "abccbccbb";
        String b = "abccbb";
        assertEquals(-1, C11_20_SubStringLocator.match(a, b));
        assertEquals(-1, C11_20_SubStringLocator.kmpMatch(a, b));
        assertEquals(-1, C11_20_SubStringLocator.sunnyMatch(a, b));
    }
}
