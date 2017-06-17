package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-3
 * Time: 下午7:32
 */
public class C11_7_ReverseStringTest extends TestCase {
    public void testReverse() throws Exception {
        String str = "";
        assertEquals("", C11_7_ReverseString.reverse(str));
    }

    public void testReverse2(){
        String str = "abhsuu877";
        assertEquals("778uushba", C11_7_ReverseString.reverse(str));
    }

    public void testReverse3(){
        String str = null;
        assertEquals(null, C11_7_ReverseString.reverse(str));
    }
}
