package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-6
 * Time: 下午7:23
 */
public class C11_5_OccurrenceFinderTest extends TestCase {

    public void testFind() throws Exception {
        String base = "abcdefg";
        String[] list = new String[]{"abc", "bcd", "ef", "gh", "bac"};
        int[] occurrences = C11_5_OccurrenceFinder.find(base, list);
        assertEquals(0, occurrences[0]);
        assertEquals(1, occurrences[1]);
        assertEquals(4, occurrences[2]);
        assertEquals(-1, occurrences[3]);
        assertEquals(-1, occurrences[4]);
    }
}
