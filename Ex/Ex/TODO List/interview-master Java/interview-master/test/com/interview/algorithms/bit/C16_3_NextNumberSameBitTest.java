package com.interview.algorithms.bit;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-14
 * Time: 上午11:21
 */
public class C16_3_NextNumberSameBitTest extends TestCase {

    public void testNext() throws Exception {
        int N = Integer.parseInt("000110001",2);
        int expected = Integer.parseInt("000110010", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.next(N));

        N = Integer.parseInt("000110100",2);
        expected = Integer.parseInt("000111000", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.next(N));

        N = Integer.parseInt("000110110",2);
        expected = Integer.parseInt("000111001", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.next(N));

        N = Integer.parseInt("1000",2);
        expected = Integer.parseInt("10000", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.next(N));

        N = Integer.parseInt("11100",2);
        expected = Integer.parseInt("100011", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.next(N));

        N = Integer.parseInt("1011111",2);
        expected = Integer.parseInt("1101111", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.next(N));
    }

    public void testPrevious() throws Exception {
        int N = Integer.parseInt("000110001",2);
        int expected = Integer.parseInt("000101100", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.previous(N));

        N = Integer.parseInt("000110100",2);
        expected = Integer.parseInt("000110010", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.previous(N));

        N = Integer.parseInt("000110110",2);
        expected = Integer.parseInt("000110101", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.previous(N));

        N = Integer.parseInt("1000",2);
        expected = Integer.parseInt("0100", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.previous(N));

        N = Integer.parseInt("11100",2);
        expected = Integer.parseInt("11010", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.previous(N));

        N = Integer.parseInt("1011111",2);
        expected = Integer.parseInt("0111111", 2);
        assertEquals(expected, C16_3_NextNumberSameBit.previous(N));
    }
}
