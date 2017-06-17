package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-9
 * Time: 下午9:18
 */
public class C1_15_StringToIntegerTest extends TestCase {
    public void testcase1(){
        int number = C1_15_StringToInteger.transfer("1234");
        assertEquals(1234, number);
    }

    public void testcase2(){
        int number = C1_15_StringToInteger.transfer("-1234");
        assertEquals(-1234, number);
    }

    public void testcase3(){
        int number = C1_15_StringToInteger.transfer("-*323");
        assertEquals(0, number);
    }

    public void testcase4(){
        int number = C1_15_StringToInteger.transfer("73366723486234923483294");
        assertEquals(0, number);
    }

    public void testcase5(){
        int number = C1_15_StringToInteger.transfer("2147483648");
        assertEquals(0, number);
    }

    public void testcase6(){
        int number = C1_15_StringToInteger.transfer("-2147483646");
        assertEquals(-2147483646, number);
    }
}
