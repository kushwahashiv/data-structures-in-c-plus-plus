package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_60_PartialSortedArraySearchTest extends TestCase {
    int[] array = new int[] {7, 8, 16, 17, 20, 21, 40, 56, 81, 90, 3, 4, 6, 24, 49};

    public void testcase1() throws Exception {
        int index = C4_60_PartialSortedArraySearch.find(array, array[9]);
        assertEquals(9, index);
        index = C4_60_PartialSortedArraySearch.find(array, array[13]);
        assertEquals(13, index);
    }

    public void testcase2(){
        int index = C4_60_PartialSortedArraySearch.find(array, 47);
        assertEquals(-1, index);
    }

    public void testrandom(){
        int[] array = TestUtil.generatePartialSortedArray(20);
        ConsoleWriter.printIntArray(array);
        int expected = TestUtil.generateInt(19);
        int index = C4_60_PartialSortedArraySearch.find(array, array[expected]);
        assertEquals(expected, index);

    }
}