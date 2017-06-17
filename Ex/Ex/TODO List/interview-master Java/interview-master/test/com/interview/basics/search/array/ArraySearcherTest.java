package com.interview.basics.search.array;

import com.interview.basics.search.array.unsorted.BSTSearcher;
import com.interview.basics.search.array.unsorted.QuickSelect3MedianSearcher;
import com.interview.basics.search.array.unsorted.QuickSelectSearcher;
import com.interview.basics.search.array.unsorted.RBTSearcher;
import junit.framework.TestCase;

public class ArraySearcherTest extends TestCase {
    public static Integer[] testArray = new Integer[]{87, 1, 25, 23, 20, 86, 76, 92, 17, 31, 78, 56, 0, 31, 90, 88, 53, 24, 62, 26};

    public void testQuickSelect(){
        QuickSelectSearcher<Integer> searcher = new QuickSelectSearcher<>(testArray.clone());
        Integer expected = testArray[6];
        Integer actual = searcher.find(expected);
        assertEquals(expected, actual);
        assertNull(searcher.find(32));
    }

    public void testQuickSelect3Median(){
        QuickSelectSearcher<Integer> searcher = new QuickSelect3MedianSearcher<>(testArray.clone());
        Integer expected = testArray[6];
        Integer actual = searcher.find(expected);
        assertEquals(expected, actual);
        assertNull(searcher.find(32));
    }

    public void testBSTSearcher(){
        BSTSearcher<Integer> searcher = new BSTSearcher<>(testArray.clone());
        Integer expected = testArray[6];
        Integer actual = searcher.find(expected);
        assertEquals(expected, actual);
        assertNull(searcher.find(32));
    }

    public void testRBTSearcher(){
        BSTSearcher<Integer> searcher = new RBTSearcher<>(testArray.clone());
        Integer expected = testArray[6];
        Integer actual = searcher.find(expected);
        assertEquals(expected, actual);
        assertNull(searcher.find(32));
    }
}