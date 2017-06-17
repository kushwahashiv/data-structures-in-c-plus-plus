package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-18
 * Time: 下午11:18
 */
public class C4_29_MaxSubArraySumTest extends TestCase {

    public void testcase1() throws Exception {
        int[] array = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int sum = C4_29_MaxSubArraySum.max(array);
        assertEquals(18, sum);
        sum = C4_29_MaxSubArraySum.maxForword(array);
        assertEquals(18, sum);
        C4_29_MaxSubArraySum.Range range = C4_29_MaxSubArraySum.maxRange(array);
        assertEquals(18, range.sum);
        assertEquals(2, range.begin);
        assertEquals(6, range.end);

    }

    public void testcase2() throws Exception {
        int[] array = new int[] {-32, 10, 33, -23, 32, -12, 41, -12, 12};
        int sum = C4_29_MaxSubArraySum.max(array);
        int max = 10 + 33 - 23 + 32 - 12 + 41;
        assertEquals(max, sum);
        sum = C4_29_MaxSubArraySum.maxForword(array);
        assertEquals(max, sum);
        C4_29_MaxSubArraySum.Range range = C4_29_MaxSubArraySum.maxRange(array);
        assertEquals(max, range.sum);
        assertEquals(1, range.begin);
        assertEquals(6, range.end);
    }

    public void testcase3() throws Exception {
        int[] array = new int[] {14, 10, 33, 23, 32, 12, 41, 12, 12};
        int sum = C4_29_MaxSubArraySum.max(array);
        int max = 0;
        for(int i = 0; i < array.length; i++) max += array[i];
        assertEquals(max, sum);
        sum = C4_29_MaxSubArraySum.maxForword(array);
        assertEquals(max, sum);
        C4_29_MaxSubArraySum.Range range = C4_29_MaxSubArraySum.maxRange(array);
        assertEquals(max, range.sum);
        assertEquals(0, range.begin);
        assertEquals(8, range.end);
    }

    public void testcase4() throws Exception {
        int[] array = new int[] {-14, -10, -33, -23, -2, -12, -41, -12, -12};
        int sum = C4_29_MaxSubArraySum.max(array);
        assertEquals(-2, sum);
        sum = C4_29_MaxSubArraySum.maxForword(array);
        assertEquals(-2, sum);
        C4_29_MaxSubArraySum.Range range = C4_29_MaxSubArraySum.maxRange(array);
        assertEquals(-2, range.sum);
        assertEquals(4, range.begin);
        assertEquals(4, range.end);
    }
}
