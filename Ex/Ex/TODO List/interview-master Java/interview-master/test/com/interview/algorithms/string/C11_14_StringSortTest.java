package com.interview.algorithms.string;

import junit.framework.TestCase;

public class C11_14_StringSortTest extends TestCase {

    public void testcase1(){
        String str = "dfhaufhaiudfhiaudhfafadf";
        String sorted = "aaaaaddddffffffhhhhiiuuu";
        assertEquals(sorted, C11_14_StringSort.sort(str));
    }

    public void testcase2(){
        String str = "87983rewrqwerhkjhdafa%^$&sdfjadkfajdkfjahfga87-0-0";
        String sorted = "$%&--003778889^aaaaaaddddeefffffghhhjjjjkkkqrrrsww";
        assertEquals(sorted, C11_14_StringSort.sort(str));
    }

    public void testcase3(){
        String str = "";
        assertEquals("", C11_14_StringSort.sort(str));
    }

}