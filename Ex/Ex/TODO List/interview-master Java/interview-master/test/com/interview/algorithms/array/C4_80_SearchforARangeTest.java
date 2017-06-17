package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 上午3:47
 */
public class C4_80_SearchforARangeTest extends TestCase {
    public void testSearch() throws Exception {
        int[] numbers = new int[]{5, 7, 7, 8, 8, 10};
        int[] range = C4_80_SearchforARange.search(numbers, 8);
        assertEquals(3, range[0]);
        assertEquals(4, range[1]);
    }
}
