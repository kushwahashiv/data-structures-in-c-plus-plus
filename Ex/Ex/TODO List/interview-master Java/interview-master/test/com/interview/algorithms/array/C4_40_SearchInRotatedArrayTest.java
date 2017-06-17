package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-29
 * Time: 下午8:10
 */
public class C4_40_SearchInRotatedArrayTest extends TestCase {
    int[] array = new int[] {5,6,1,2,3,4};
    int[] array2 = new int[] {3,4,5,6,1,2};
    public void testFound() throws Exception {
        int index = C4_40_SearchInRotatedArray.search(array, 3);
        assertEquals(4, index);
        index = C4_40_SearchInRotatedArray.search(array2, 3);
        assertEquals(0, index);
    }

    public void testFound2() throws Exception {
        int index = C4_40_SearchInRotatedArray.search(array, 5);
        assertEquals(0, index);
        index = C4_40_SearchInRotatedArray.search(array2, 5);
        assertEquals(2, index);
    }

    public void testNotFound() {
        int index = C4_40_SearchInRotatedArray.search(array, 7);
        assertEquals(-1, index);
    }

    public void testcase(){
        int[] array = new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = C4_40_SearchInRotatedArray.search(array, 11);
        assertEquals(1, index);
    }
}
