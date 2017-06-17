package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 下午10:13
 */
public class C1_61_ProductOnlyContainsZeroOneTest extends TestCase {
    public void testcase1(){
        long M = C1_61_ProductOnlyContainsZeroOne.find(2);
        assertEquals(5, M);
    }

    public void testcase2(){
        long M = C1_61_ProductOnlyContainsZeroOne.find(3);
        assertEquals(37, M);
    }

    public void testcase3(){
        long M = C1_61_ProductOnlyContainsZeroOne.find(9);
        long expected = C1_61_ProductOnlyContainsZeroOne.correct(9);
        assertEquals(expected, M);
    }

    public void testcase4(){
        long M = C1_61_ProductOnlyContainsZeroOne.find(19);
        long expected = C1_61_ProductOnlyContainsZeroOne.correct(19);
        assertEquals(expected, M);
    }

    public void testcase5(){
        long M = C1_61_ProductOnlyContainsZeroOne.find(99);
        assertEquals(1122334455667789L, M);
    }
}
