package com.interview.basics.search.array;

import com.interview.basics.search.array.unsorted.IntervalBSTSearcher;
import com.interview.utils.models.Range;
import junit.framework.TestCase;

public class IntervalBSTSearcherTest extends TestCase {

    public void testSearch() throws Exception {
        Range[] ranges = new Range[]{new Range(2,4), new Range(1,6), new Range(5,13)};
        IntervalBSTSearcher searcher = new IntervalBSTSearcher(ranges);
        Range item = new Range(2,5);
        Range found = searcher.find(item);
        assertEquals(1, found.start);
        assertEquals(6, found.end);

        item = new Range(5,17);
        found = searcher.find(item);
        assertNull(found);

        item = new Range(4,7);
        found = searcher.find(item);
        assertNull(found);

        item = new Range(2,3);
        found = searcher.find(item);
        assertEquals(2, found.start);
        assertEquals(4, found.end);

        item = new Range(8,12);
        found = searcher.find(item);
        assertEquals(5, found.start);
        assertEquals(13, found.end);
    }
}