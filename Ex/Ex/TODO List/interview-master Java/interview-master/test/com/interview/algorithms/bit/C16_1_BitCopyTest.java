package com.interview.algorithms.bit;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-10
 * Time: 下午10:02
 */
public class C16_1_BitCopyTest extends TestCase {
    public void testCopy() throws Exception {
        int N = Integer.parseInt("1000000000",2);
        int M = Integer.parseInt("10011", 2);

        int actual = C16_1_BitCopy.copy(N, M, 2, 6);
        int expected = Integer.parseInt("1001001100", 2);
        assertEquals(expected, actual);
    }
}
