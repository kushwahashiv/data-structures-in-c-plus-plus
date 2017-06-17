package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-9
 * Time: 下午10:02
 */
public class C11_15_StringCompressorTest extends TestCase {
    public void testcase1(){
        String compression = C11_15_StringCompressor.compress("aabcccccaaa");
        assertEquals("a2b1c5a3", compression);
    }

    public void testcase2(){
        String compression = C11_15_StringCompressor.compress("abcde");
        assertEquals("abcde", compression);
    }

    public void testcase3(){
        String compression = C11_15_StringCompressor.compress("");
        assertEquals("", compression);
    }

    public void testcase4(){
        String compression = C11_15_StringCompressor.compress(null);
        assertEquals(null, compression);
    }
}
