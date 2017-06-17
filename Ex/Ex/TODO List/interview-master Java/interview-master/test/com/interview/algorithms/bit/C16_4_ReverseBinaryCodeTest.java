package com.interview.algorithms.bit;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-20
 * Time: 下午10:29
 */
public class C16_4_ReverseBinaryCodeTest extends TestCase {
    public void testReverse() throws Exception {
        int number = Integer.parseInt("1010", 2);
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toBinaryString(C16_4_ReverseBinaryCode.reverse(number)));
        assertEquals("101", Integer.toBinaryString(C16_4_ReverseBinaryCode.reverse(number)));
    }

    public void testReverseFull() throws Exception {
        int number = Integer.parseInt("00000000000000000000001111110010", 2);
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toBinaryString(C16_4_ReverseBinaryCode.reverseFully(number)));
        assertEquals("11111111111111111111110000001101", Integer.toBinaryString(C16_4_ReverseBinaryCode.reverseFully(number)));
    }
}
