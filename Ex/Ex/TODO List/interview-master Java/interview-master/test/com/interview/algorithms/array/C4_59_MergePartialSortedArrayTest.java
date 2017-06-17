package com.interview.algorithms.array;

import com.interview.basics.sort.MergeSorter;
import com.interview.basics.sort.QuickSorter;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class C4_59_MergePartialSortedArrayTest extends TestCase {

    public void testMerge() throws Exception {
        int[] array = new int[]{4,7,10, 1,5,8};
        int[] expected = new int[]{1,4,5,7,8,10};
        C4_59_MergePartialSortedArray.merge(array, 3);
        ConsoleWriter.printIntArray(array);
        Assert.assertArrayEquals(expected, array);
    }

    public void testMerge2() throws Exception {
        int[] array = new int[]{7, 8, 14, 39, 39, 51, 58, 67, 95, 95, 10, 10, 19, 52, 53, 58, 63, 72, 98, 99};
        int[] expected = new int[]{7, 8, 10, 10, 14, 19, 39, 39, 51, 52, 53, 58, 58, 63, 67, 72, 95, 95, 98, 99};
        C4_59_MergePartialSortedArray.merge(array, 10);
        ConsoleWriter.printIntArray(array);
        Assert.assertArrayEquals(expected, array);
    }

    public void testMerge3() throws Exception {
        int[] array = new int[]{2, 5, 10, 12, 42, 43, 54, 67, 73, 92, 13, 14, 15, 20, 38, 46, 64, 65, 70, 100};
        int[] expected = new int[]{2, 5, 10, 12, 13, 14, 15, 20, 38, 42, 43, 46, 54, 64, 65, 67, 70, 73, 92, 100};
        C4_59_MergePartialSortedArray.merge(array, 10);
        ConsoleWriter.printIntArray(array);
        Assert.assertArrayEquals(expected, array);
    }

    public void testRandom(){
        int[] arr1 = TestUtil.generateIntArray(10, false);
        int[] arr2 = TestUtil.generateIntArray(10, false);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] array = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++) array[i] = arr1[i];
        for(int i = 0; i < arr2.length; i++) array[i+arr1.length] = arr2[i];

        int[] expected = C4_19_MergeSortedArrays.merge(arr1, arr2);

        ConsoleWriter.printIntArray(array);
        ConsoleWriter.printIntArray(expected);

        C4_59_MergePartialSortedArray.merge(array, arr1.length);
        ConsoleWriter.printIntArray(array);
        Assert.assertArrayEquals(expected, array);
    }
}