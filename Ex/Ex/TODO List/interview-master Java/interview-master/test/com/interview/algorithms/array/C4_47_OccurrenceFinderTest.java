package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 上午9:35
 */
public class C4_47_OccurrenceFinderTest extends TestCase {
    public void testcase1(){
        Integer[] array = new Integer[]{1, 2, 2, 2, 3};
        assertEquals(1, C4_47_OccurrenceFinder.find(array, 1));
        assertEquals(3, C4_47_OccurrenceFinder.find(array, 2));
        assertEquals(1, C4_47_OccurrenceFinder.find(array, 3));
    }
}
