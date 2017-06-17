package com.interview.basics.search.array.sorted;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-2
 * Time: 下午12:11
 */
public class RotatedArraySearcherTest extends TestCase {
    public void testcase1() throws Exception {
        Integer[] array = new Integer[]{38,40,55,89,6,13};
        RotatedArraySearcher<Integer> searcher = new RotatedArraySearcher<>(array);
        assertEquals(6, searcher.min().intValue());
        assertEquals(13, searcher.find(13).intValue());
        assertEquals(40, searcher.find(40).intValue());
        assertNull(searcher.find(47));
    }

    public void testcase2() throws Exception {
        Integer[] array = new Integer[]{38,40,55,89,6,13,14,15,16,19,30,33,37};
        RotatedArraySearcher<Integer> searcher = new RotatedArraySearcher<>(array);
        assertEquals(6, searcher.min().intValue());
        assertEquals(13, searcher.find(13).intValue());
        assertEquals(38, searcher.find(38).intValue());
        assertNull(searcher.find(47));
    }
}
