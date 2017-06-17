package com.interview.basics.search.array.sorted;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-2
 * Time: 下午3:19
 */
public class BinaryArraySearcherTest extends TestCase {
    public void testFind() throws Exception {
        Integer[] array = new Integer[]{68, 58, 34, 53, 37, 53, 61, 1, 79, 42, 30, 76, 49, 80, 67, 19, 23, 17, 18, 41};
        //TestUtil.generateIntArray(20, 100, 0);
        //ConsoleWriter.printIntArray(array);
        BinaryArraySearcher<Integer> searcher = new BinaryArraySearcher<>(array);
        assertEquals(61, searcher.find(61).intValue());
        assertEquals(17, searcher.find(17).intValue());
        assertNull(searcher.find(81));
    }
}
