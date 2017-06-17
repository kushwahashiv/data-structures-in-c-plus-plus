package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-30
 * Time: 下午9:47
 */
public class C4_27_MinFinderInRotateSortedListTest extends TestCase {

    public void testcase1() throws Exception {
        int[] array = new int[] {3,4,5,6,1,2};
        int min = C4_27_MinFinderInRotateSortedList.findMin(array);
        assertEquals(1, min);
    }

    public void testcase2() throws Exception {
        int[] array = new int[] {3,4,5,6,7,1,2};
        int min = C4_27_MinFinderInRotateSortedList.findMin(array);
        assertEquals(1, min);
    }

    public void testcase3() throws Exception {
        int[] array = new int[] {5,6,1,2,3,4};
        int min = C4_27_MinFinderInRotateSortedList.findMin(array);
        assertEquals(1, min);
    }

    public void testcase4() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int min = C4_27_MinFinderInRotateSortedList.findMin(array);
        assertEquals(1, min);
    }

    public void testcase5() throws Exception {
        int[] array = new int[] {5,6,6,1,2,3,3};
        int min = C4_27_MinFinderInRotateSortedList.findMin(array);
        assertEquals(1, min);
    }
}
