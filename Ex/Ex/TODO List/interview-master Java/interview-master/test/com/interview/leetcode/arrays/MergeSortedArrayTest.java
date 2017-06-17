package com.interview.leetcode.arrays;

import com.interview.util.TestUtil;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午2:09
 */
public class MergeSortedArrayTest extends TestCase {
    public void testMerge2() throws Exception {
        int[] arr1 = {1, 2, 5, 10};
        int[] arr2 = {3, 4, 6, 7};
        int[] expected = new int[]{1,2,3,4,5,6,7,10};
        int[] merged = MergeSortedArray.merge2(arr1, arr2);
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], merged[i]);
        }
    }

    public void testMerge2A() throws Exception {
        int[] ac = TestUtil.generateIntArray(20, false);
        int[] b = TestUtil.generateIntArray(10, false);

        Arrays.sort(ac);
        Arrays.sort(b);

        int[] a = new int[40];
        for(int i = 0; i < 20; i++) a[i] = ac[i];

        MergeSortedArray.merge2A(a, 20, b, 10);
        assertOrder(a, true, 30);
    }

    private void assertOrder(int[] array, boolean asc, int size){
        for(int i = 0; i < size - 1; i++){
            if(asc){
                assertTrue(array[i] <= array[i + 1]);
            } else {
                assertTrue(array[i] >= array[i + 1]);
            }

        }
    }

    public void testMergeK() throws Exception {
        int[][] num = new int[10][10];
        for(int i = 0; i < num.length; i++){
            num[i] = TestUtil.generateIntArray(10, false);
            Arrays.sort(num[i]);
        }

        int[] merged = MergeSortedArray.mergeK(num);
        assertOrder(merged, true, 100);
    }
}
