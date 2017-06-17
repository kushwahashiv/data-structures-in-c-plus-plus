package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午1:59
 */
public class C1_75_ZigZagTest extends TestCase {
    public void testConvert() throws Exception {
        String input = "PAYPALISHIRING";
        String expected = "PAHNAPLSIIGYIR";
        assertEquals(expected, C1_75_ZigZag.convert(input, 3));
    }

    public void testConvert2() throws Exception {
        String input = "heibqvithyevzevptnicckpknjhmhakogspypzrwxyuycpoxewzgiqtxzcjgetxkmmkbobanbumdl";
        String expected = "hmekmixkbtbqeovgbijatcnhzbyxuetmvqdzilegvzpwtenxiocpcckypukynxjwhrmzhpaykposg";
        assertEquals(expected, C1_75_ZigZag.convert(input, 33));
    }
}
