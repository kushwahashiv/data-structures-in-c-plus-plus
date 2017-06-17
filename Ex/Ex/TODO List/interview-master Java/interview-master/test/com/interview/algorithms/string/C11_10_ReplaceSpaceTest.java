package com.interview.algorithms.string;

import junit.framework.TestCase;

public class C11_10_ReplaceSpaceTest extends TestCase {
    C11_10_ReplaceSpace replacer = new C11_10_ReplaceSpace();

    public void testcase1(){
        String str = "abschhh";
        assertEquals(str, replacer.replace(str));
    }

    public void testcase2(){
        String str = "abs chhh";
        assertEquals("abs%20chhh", replacer.replace(str));
    }

    public void testcase3(){
        String str = "abs chhh ";
        assertEquals("abs%20chhh%20", replacer.replace(str));
    }

    public void testcase4(){
        String str = "abs c  hhh ";
        assertEquals("abs%20c%20%20hhh%20", replacer.replace(str));
    }

    public void testcase5(){
        String str = " ";
        assertEquals("%20", replacer.replace(str));
    }
}