package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 下午5:25
 */
public class C4_8_KthElementTest extends TestCase {
    int[] data = new int[]{2, 3, 5, 1, 9, 10, -22};
    public void testMedianOfMedian() throws Exception {
        int element = C4_8_KthElement_MedianOfMedian.select(data, 4);
        assertEquals(3, element);
    }

    public void testQuickSelect() throws Exception {
        for(int i = 0; i < 10; i++){    //test more then one time due to random shuffle
            int element = C4_8_KthElement_QuickSelect.select(data, 4);
            assertEquals(3, element);
        }
    }

    public void testMaxHeap() throws Exception {
        int element = C4_8_KthElement_MaxHeap.select(data, 4);
        assertEquals(3, element);
    }
}
