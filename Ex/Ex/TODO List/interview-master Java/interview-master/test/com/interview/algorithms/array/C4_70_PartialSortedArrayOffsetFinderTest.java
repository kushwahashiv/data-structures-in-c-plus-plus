package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-21
 * Time: 上午8:59
 */
public class C4_70_PartialSortedArrayOffsetFinderTest extends TestCase {
    public void testFindAsc() throws Exception {
        int[] array = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};
        C4_70_PartialSortedArrayOffsetFinder.Indices indices = C4_70_PartialSortedArrayOffsetFinder.find(array);

        assertEquals(3, indices.begin);
        assertEquals(9, indices.end);
    }

    public void testFindDec() throws Exception {
        int[] array = new int[]{19,18,16,7,6,12,7,11,10,7,4,2,1};
        C4_70_PartialSortedArrayOffsetFinder.Indices indices = C4_70_PartialSortedArrayOffsetFinder.find(array);

        assertEquals(3, indices.begin);
        assertEquals(9, indices.end);
    }
    public void testFindAsc2() throws Exception {
        int[] array = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};
        C4_70_PartialSortedArrayOffsetFinder2.Indices indices = C4_70_PartialSortedArrayOffsetFinder2.find(array);

        assertEquals(3, indices.begin);
        assertEquals(9, indices.end);
    }

    public void testFindDec2() throws Exception {
        int[] array = new int[]{19,18,16,7,6,12,7,11,10,7,4,2,1};
        C4_70_PartialSortedArrayOffsetFinder2.Indices indices = C4_70_PartialSortedArrayOffsetFinder2.find(array);

        assertEquals(3, indices.begin);
        assertEquals(9, indices.end);
    }
}
