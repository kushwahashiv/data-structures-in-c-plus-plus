package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created_By: stefanie
 * Date: 14-10-18
 * Time: 下午5:11
 */
public class C4_66_InPlaceMergeSortedArrayTest extends TestCase {
    public void testMerge() throws Exception {
        int[] ac = TestUtil.generateIntArray(20, false);
        int[] b = TestUtil.generateIntArray(10, false);

        Arrays.sort(ac);
        Arrays.sort(b);

        int[] a = new int[40];
        for(int i = 0; i < 20; i++) a[i] = ac[i];
        ConsoleWriter.printIntArray(a);
        ConsoleWriter.printIntArray(b);

        C4_66_InPlaceMergeSortedArray.merge(a, b, 20, 10);

        ConsoleWriter.printIntArray(a);
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
}
