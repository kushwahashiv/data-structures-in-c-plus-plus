package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_19_MergeSortedArraysTest extends TestCase {

    public void testMergeArray() throws Exception {
        int[] arr1 = {1, 2, 5, 10};
        int[] arr2 = {3, 4, 6, 7};
        int[] expected = new int[]{1,2,3,4,5,6,7,10};
        int[] merged = C4_19_MergeSortedArrays.merge(arr1, arr2);
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], merged[i]);
        }
    }
}