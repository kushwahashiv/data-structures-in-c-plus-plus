package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-3
 * Time: 下午9:54
 */
public class C4_74_InPlaceRearrangeTest extends TestCase {
    public void testRearrange() throws Exception {
        String str = "1234abcd";
        String actual = C4_74_InPlaceRearrange.rearrange(str);
        String expected = "1a2b3c4d";
        assertEquals(expected, actual);
    }
}
