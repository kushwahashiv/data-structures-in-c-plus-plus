package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_45_PowerNumberTest extends TestCase {

    public void testcase1(){
        assertEquals(1.0, C1_45_PowerNumber.power(1, 1));
        assertEquals(1.0, C1_45_PowerNumber.power2(1, 1));
    }

    public void testcase2(){
        assertEquals(4.0, C1_45_PowerNumber.power(4, 1));
        assertEquals(4.0, C1_45_PowerNumber.power2(4, 1));
    }

    public void testcase3(){
        assertEquals(Math.pow(3,2), C1_45_PowerNumber.power(3, 2));
        assertEquals(Math.pow(3,2), C1_45_PowerNumber.power2(3, 2));
    }

    public void testcase4(){
        assertEquals(Math.pow(3,3), C1_45_PowerNumber.power(3, 3));
        assertEquals(Math.pow(3,3), C1_45_PowerNumber.power2(3, 3));
    }

    public void testcase5(){
        assertEquals(Math.pow(3,4), C1_45_PowerNumber.power(3, 4));
        assertEquals(Math.pow(3,4), C1_45_PowerNumber.power2(3, 4));
    }

    public void testcase6(){
        assertEquals(Math.pow(3,5), C1_45_PowerNumber.power(3, 5));
        assertEquals(Math.pow(3,5), C1_45_PowerNumber.power2(3, 5));
    }

    public void testcase7(){
        assertEquals(Math.pow(3,0), C1_45_PowerNumber.power(3, 0));
        assertEquals(Math.pow(3,0), C1_45_PowerNumber.power2(3, 0));
    }

}