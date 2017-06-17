package com.interview.algorithms.string;

import junit.framework.TestCase;

public class C11_27_RemoveWhiteSpaceAndReverseTest extends TestCase {

    public void testClean() throws Exception {
        String str = "abc    efg    hij";
        assertEquals("cba gfe jih", C11_27_RemoveWhiteSpaceAndReverse.clean(str));
    }

    public void testClean2() throws Exception {
        String str = "    abc    efg    hij   ";
        assertEquals("cba gfe jih", C11_27_RemoveWhiteSpaceAndReverse.clean(str));
    }
}