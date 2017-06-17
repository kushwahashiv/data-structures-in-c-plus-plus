package com.interview.basics.search.array.sorted;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-2
 * Time: 下午12:33
 */
public class VArraySearcherTest extends TestCase {
    public void testcase1(){
        Integer[] array = new Integer[]{6,4,2,1,3,7,8,9,10};
        VArraySearcher<Integer> searcher = new VArraySearcher<>(array);
        assertEquals(1, searcher.min().intValue());
        assertEquals(4, searcher.find(4).intValue());
        assertEquals(7, searcher.find(7).intValue());
        assertNull(searcher.find(5));
        assertEquals(6, searcher.find(6).intValue());
    }

    public void testcase2(){
        Integer[] array = new Integer[]{9,8,7,6,4,2,1,3,7,8};
        VArraySearcher<Integer> searcher = new VArraySearcher<>(array);
        assertEquals(1, searcher.min().intValue());
        assertEquals(4, searcher.find(4).intValue());
        assertEquals(7, searcher.find(7).intValue());
        assertNull(searcher.find(5));
        assertEquals(6, searcher.find(6).intValue());
    }

    public void testcase3(){
        Integer[] array = new Integer[]{2,1,2,3,3,4,4,5,6,7,8};
        VArraySearcher<Integer> searcher = new VArraySearcher<>(array);
        assertEquals(1, searcher.min().intValue());
        assertEquals(4, searcher.find(4).intValue());
        assertEquals(7, searcher.find(7).intValue());
        assertNull(searcher.find(10));
        assertEquals(6, searcher.find(6).intValue());
    }
}
