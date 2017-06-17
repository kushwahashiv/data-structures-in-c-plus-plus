package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_13_TrackingMedianTest extends TestCase {

    public void testHeap() throws Exception {
        C1_13_TrackingMedian_Heap tracker = new C1_13_TrackingMedian_Heap();
        tracker.add(1);
        assertEquals(1, tracker.median());

        tracker.add(10);
        assertEquals(1, tracker.median());

        tracker.add(5);
        assertEquals(5, tracker.median());

        tracker.add(2);
        tracker.add(3); //1,2,3,5,10
        assertEquals(3, tracker.median());
    }

    public void testBinaryTree() throws Exception {
        C1_13_TrackingMedian_BinarySearchTree tracker = new C1_13_TrackingMedian_BinarySearchTree();
        tracker.add(1);
        assertEquals(1, tracker.median());

        tracker.add(10);
        assertEquals(1, tracker.median());

        tracker.add(5);
        assertEquals(5, tracker.median());

        tracker.add(2);
        tracker.add(3); //1,2,3,5,10
        assertEquals(3, tracker.median());
    }
}