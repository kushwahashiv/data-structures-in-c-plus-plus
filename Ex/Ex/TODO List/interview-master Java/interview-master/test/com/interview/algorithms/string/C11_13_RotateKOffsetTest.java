package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-7
 * Time: 下午10:50
 */
public class C11_13_RotateKOffsetTest extends TestCase {
    public void testcase1(){
        String str = "abcdef";
        String rotatedStr = C11_13_RotateKOffset.rotateByReserve(str, 3);
        assertEquals("defabc", rotatedStr);
        rotatedStr = C11_13_RotateKOffset.rotationByGCD(str, 3);
        assertEquals("defabc", rotatedStr);
    }

    public void testcase2(){
        String str = "abde";
        String rotatedStr = C11_13_RotateKOffset.rotateByReserve(str, 2);
        assertEquals("deab", rotatedStr);
        rotatedStr = C11_13_RotateKOffset.rotationByGCD(str, 2);
        assertEquals("deab", rotatedStr);
    }

    public void testcase3(){
        String str = "abcdef";
        String rotatedStr = C11_13_RotateKOffset.rotateByReserve(str, 0);
        assertEquals("abcdef", rotatedStr);
        rotatedStr = C11_13_RotateKOffset.rotationByGCD(str, 0);
        assertEquals("abcdef", rotatedStr);
    }

    public void testcase4(){
        String str = "abcdef";
        String rotatedStr = C11_13_RotateKOffset.rotateByReserve(str, 12);
        assertEquals("abcdef", rotatedStr);
        rotatedStr = C11_13_RotateKOffset.rotationByGCD(str, 12);
        assertEquals("abcdef", rotatedStr);
    }

    public void testcase5(){
        String str = "abcdef";
        String rotatedStr = C11_13_RotateKOffset.rotateByReserve(str, 11);
        assertEquals("fabcde", rotatedStr);
        rotatedStr = C11_13_RotateKOffset.rotationByGCD(str, 11);
        assertEquals("fabcde", rotatedStr);
    }
}
