package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 上午9:29
 */
public class C4_7_RepeatingElementFinderTest extends TestCase {
    public void testFind() throws Exception {
        int[] array = new int[]{1, 2, 3, 5, 5, 5, 9, 12};
        int index = C4_7_RepeatingElementFinder.find(array);
        assertEquals(3, index);

    }
}
