package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_62_MaxItemHaveCombinationTest extends TestCase {

    public void testFind() throws Exception {
        Integer[] array = new Integer[] {2,3,7,10};
        assertEquals(10, C4_62_MaxItemHaveCombination.find(array));
    }

    public void testtest1() throws Exception {
        Integer[] array = new Integer[] {9, 13, 20, 5};
        assertEquals(-1, C4_62_MaxItemHaveCombination.find(array));
    }

    public void testcase2() throws Exception {
        Integer[] array = TestUtil.generateIntArray(10, 20, 0);
        ConsoleWriter.printIntArray(array);
        System.out.println(C4_62_MaxItemHaveCombination.find(array));
        //assertEquals(10, );
    }
}