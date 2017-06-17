package com.interview.leetcode.arrays;

import com.interview.leetcode.arrays.searching.*;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午2:41
 */
public class SearchingTest extends TestCase {
    public void testFind() throws Exception {
        int[] num = new int[]{1,2,3,4,5,6,7,8};
        assertEquals(-1, SearchingSortedArray.findL(num, 0));
        assertEquals(-1, SearchingSortedArray.findL(num, 9));
        assertEquals(4, SearchingSortedArray.findL(num, 5));
        assertEquals(7, SearchingSortedArray.findL(num, 8));
        assertEquals(0, SearchingSortedArray.findL(num, 1));

        assertEquals(-1, SearchingSortedArray.findR(num, 0));
        assertEquals(-1, SearchingSortedArray.findR(num, 9));
        assertEquals(4, SearchingSortedArray.findR(num, 5));
        assertEquals(7, SearchingSortedArray.findR(num, 8));
        assertEquals(0, SearchingSortedArray.findR(num, 1));
    }

    public void testFindFirst() throws Exception {
        int[] num = new int[]{1,1,2,3,4,5,5,5,5,6,7,8};
        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstL(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstL(num, 9));
        assertEquals(5, SearchingSortedArrayWithDuplication.findFirstL(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findFirstL(num, 8));
        assertEquals(0, SearchingSortedArrayWithDuplication.findFirstL(num, 1));

        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstR(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstR(num, 9));
        assertEquals(5, SearchingSortedArrayWithDuplication.findFirstR(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findFirstR(num, 8));
        assertEquals(0, SearchingSortedArrayWithDuplication.findFirstR(num, 1));
    }

    public void testFindLast() throws Exception {
        int[] num = new int[]{1,1,2,3,4,5,5,5,5,6,7,8};
        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastL(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastL(num, 9));
        assertEquals(8, SearchingSortedArrayWithDuplication.findLastL(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findLastL(num, 8));
        assertEquals(1, SearchingSortedArrayWithDuplication.findLastL(num, 1));

        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastR(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastR(num, 9));
        assertEquals(8, SearchingSortedArrayWithDuplication.findLastR(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findLastR(num, 8));
        assertEquals(1, SearchingSortedArrayWithDuplication.findLastR(num, 1));
    }

    public void testFindRange() throws Exception {
        int[] num = new int[]{1,1,2,3,4,5,5,5,5,6,7,8};
        int[] range = SearchingSortedArrayWithDuplication.findRangeL(num, 0);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);

        range = SearchingSortedArrayWithDuplication.findRangeL(num, 9);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);

        range = SearchingSortedArrayWithDuplication.findRangeL(num, 5);
        assertEquals(5, range[0]);
        assertEquals(8, range[1]);

        range = SearchingSortedArrayWithDuplication.findRangeR(num, 0);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);

        range = SearchingSortedArrayWithDuplication.findRangeR(num, 9);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);

        range = SearchingSortedArrayWithDuplication.findRangeR(num, 5);
        assertEquals(5, range[0]);
        assertEquals(8, range[1]);
    }

    public void testMinInRotatedNoDup() throws Exception {
        assertEquals(1, SearchingRotatedArray.minL(new int[]{1, 2}));
        assertEquals(1, SearchingRotatedArray.minL(new int[]{2, 1}));
        assertEquals(1, SearchingRotatedArray.minR(new int[]{1, 2}));
        assertEquals(1, SearchingRotatedArray.minR(new int[]{2, 1}));
    }

    public void testMaxInRotatedNoDup() throws Exception {
        assertEquals(2, SearchingRotatedArray.maxL(new int[]{1, 2}));
        assertEquals(2, SearchingRotatedArray.maxL(new int[]{2, 1}));
        assertEquals(2, SearchingRotatedArray.maxR(new int[]{1, 2}));
        assertEquals(2, SearchingRotatedArray.maxR(new int[]{2, 1}));
        assertEquals(3, SearchingRotatedArray.maxR(new int[]{1, 2,3}));
        assertEquals(3, SearchingRotatedArray.maxR(new int[]{2, 3,1}));
    }

    public void testFindInRotatedNoDup() throws Exception {
        int[] num = new int[]{4,5,6,7,1,2,3};
        assertEquals(5, SearchingRotatedArray.findL(num, 2));
        assertEquals(1, SearchingRotatedArray.findL(num, 5));
        assertEquals(-1, SearchingRotatedArray.findL(num, 9));
        assertEquals(-1, SearchingRotatedArray.findL(num, 0));
        assertEquals(5, SearchingRotatedArray.findL(num, 2));
        assertEquals(1, SearchingRotatedArray.findL(num, 5));
        assertEquals(-1, SearchingRotatedArray.findL(num, 9));
        assertEquals(-1, SearchingRotatedArray.findL(num, 0));

        num = new int[]{4,5,1,2,3};
        assertEquals(3, SearchingRotatedArray.findR(num, 2));
        assertEquals(1, SearchingRotatedArray.findR(num, 5));
        assertEquals(-1, SearchingRotatedArray.findR(num, 9));
        assertEquals(-1, SearchingRotatedArray.findR(num, 0));
        assertEquals(3, SearchingRotatedArray.findR(num, 2));
        assertEquals(1, SearchingRotatedArray.findR(num, 5));
        assertEquals(-1, SearchingRotatedArray.findR(num, 9));
        assertEquals(-1, SearchingRotatedArray.findR(num, 0));
    }

    public void testMinInRotatedWithDup() throws Exception {
        //assertEquals(1, SearchingRotatedArrayWithDuplication.minL(new int[]{1, 2}));
        //assertEquals(1, SearchingRotatedArrayWithDuplication.minL(new int[]{2, 1}));
        assertEquals(1, SearchingRotatedArrayWithDuplication.minL(new int[]{1, 1, 2, 2, 2}));
        assertEquals(1, SearchingRotatedArrayWithDuplication.minL(new int[]{1, 2, 2, 2, 1}));
        assertEquals(1, SearchingRotatedArrayWithDuplication.minL(new int[]{2, 1, 2, 2, 2}));
        assertEquals(1, SearchingRotatedArrayWithDuplication.minL(new int[]{2, 2, 2, 1, 2}));
    }

    public void testMaxInRotatedWithDup() throws Exception {
//        assertEquals(2, SearchingRotatedArrayWithDuplication.maxL(new int[]{1, 2}));
//        assertEquals(2, SearchingRotatedArrayWithDuplication.maxL(new int[]{2, 1}));
        assertEquals(2, SearchingRotatedArrayWithDuplication.maxL(new int[]{1, 1, 1, 2, 1}));
        assertEquals(2, SearchingRotatedArrayWithDuplication.maxL(new int[]{2, 2, 1, 1, 1}));
        assertEquals(2, SearchingRotatedArrayWithDuplication.maxL(new int[]{1, 2, 1, 1, 1}));
        assertEquals(2, SearchingRotatedArrayWithDuplication.maxL(new int[]{1, 1, 1, 2, 1}));
    }

    public void testFindInRotatedWithDup() throws Exception {
        int[] num = new int[]{4,4,4,4,4,4,5,1,2,3,4};
        assertTrue(SearchingRotatedArrayWithDuplication.findR(num, 4) != -1);
        assertEquals(8, SearchingRotatedArrayWithDuplication.findR(num, 2));
        assertEquals(6, SearchingRotatedArrayWithDuplication.findR(num, 5));
        assertEquals(-1, SearchingRotatedArrayWithDuplication.findR(num, 9));
        assertEquals(-1, SearchingRotatedArrayWithDuplication.findR(num, 0));
        assertEquals(6, SearchingRotatedArrayWithDuplication.findR(num, 5));

        num = new int[]{4,5,1,2,3,4,4,4,4,4,4};
        assertTrue(SearchingRotatedArrayWithDuplication.findR(num, 4) != -1);
        assertEquals(3, SearchingRotatedArrayWithDuplication.findR(num, 2));
        assertEquals(1, SearchingRotatedArrayWithDuplication.findR(num, 5));
        assertEquals(-1, SearchingRotatedArrayWithDuplication.findR(num, 9));
        assertEquals(-1, SearchingRotatedArrayWithDuplication.findR(num, 0));
        assertEquals(1, SearchingRotatedArrayWithDuplication.findR(num, 5));
    }

    public void testFindInVArray() throws Exception{
        int[] array = new int[]{6,4,2,1,3,7,8,9,10};
        assertEquals(1, SearchingVArray.minR(array));
        assertEquals(4, SearchingVArray.findR(array, 4));
        assertEquals(7, SearchingVArray.findR(array, 7));
        assertEquals(-1, SearchingVArray.findR(array, 5));
        assertEquals(6, SearchingVArray.findR(array, 6));
        assertEquals(-1,SearchingVArray.findR(array, 11));

        array = new int[]{9,8,7,6,4,2,1,3,7,8};
        assertEquals(1, SearchingVArray.minR(array));
        assertEquals(4, SearchingVArray.findR(array, 4));
        assertEquals(7, SearchingVArray.findR(array, 7));
        assertEquals(-1, SearchingVArray.findR(array, 5));
        assertEquals(6, SearchingVArray.findR(array,6));
        assertEquals(-1,SearchingVArray.findR(array, 10));
    }

    public void testFindUnsortedArray() throws Exception{
        int[] array = new int[]{87, 1, 25, 23, 20, 86, 76, 92, 17, 31, 78, 56, 0, 31, 90, 88, 53, 24, 62, 26};
        assertTrue(SearchingUnsortedArray.find(array, 87));
        assertTrue(SearchingUnsortedArray.find(array, 0));
        assertTrue(SearchingUnsortedArray.find(array, 26));
        assertFalse(SearchingUnsortedArray.find(array, 32));
    }

    public void testTopKUnsortedArray() throws Exception{
        int[] array = new int[]{87, 1, 25, 23, 20, 86, 76, 92, 17, 31, 78, 56, 0, 31, 90, 88, 53, 24, 62, 26};
        int[] expected = new int[]{87, 1, 25, 23, 20, 86, 76, 92, 17, 31, 78, 56, 0, 31, 90, 88, 53, 24, 62, 26};
        Arrays.sort(expected);
        assertEquals(expected[0], SearchingUnsortedArray.topK(array, 0));
        assertEquals(expected[5], SearchingUnsortedArray.topK(array, 5));
        assertEquals(expected[12],SearchingUnsortedArray.topK(array, 12));
        assertEquals(expected[8], SearchingUnsortedArray.topK(array, 8));
    }
}
