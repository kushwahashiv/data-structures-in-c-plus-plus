package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午8:59
 */
public class C11_36_DecodeWaysTest extends TestCase {
    public void testNumDecodings() throws Exception {
        assertEquals(0, C11_36_DecodeWays.numDecodings("00"));
        assertEquals(0, C11_36_DecodeWays.numDecodings("01"));
        assertEquals(0, C11_36_DecodeWays.numDecodings("40"));
        assertEquals(0, C11_36_DecodeWays.numDecodings(""));
        assertEquals(1, C11_36_DecodeWays.numDecodings("10"));
        assertEquals(1, C11_36_DecodeWays.numDecodings("110"));
        assertEquals(3, C11_36_DecodeWays.numDecodings("124"));

    }

    public void testNumDecodingsDP() throws Exception {
        assertEquals(0, C11_36_DecodeWays.numDecodingsDPConstantSpace("00"));
        assertEquals(0, C11_36_DecodeWays.numDecodingsDPConstantSpace("01"));
        assertEquals(0, C11_36_DecodeWays.numDecodingsDPConstantSpace("40"));
        assertEquals(0, C11_36_DecodeWays.numDecodingsDPConstantSpace(""));
        assertEquals(1, C11_36_DecodeWays.numDecodingsDPConstantSpace("10"));
        assertEquals(1, C11_36_DecodeWays.numDecodingsDPConstantSpace("110"));
        assertEquals(3, C11_36_DecodeWays.numDecodingsDPConstantSpace("124"));
        assertEquals(1, C11_36_DecodeWays.numDecodingsDPConstantSpace("27"));
    }
}
