package com.interview.basics.model.collection;

import com.interview.basics.model.collection.heap.BinaryArrayHeap;
import com.interview.basics.model.collection.heap.Heap;
import junit.framework.TestCase;

public class HeapTest extends TestCase {

    public void testMaxHeap(){
        Heap<Integer> heap = new BinaryArrayHeap<Integer>(BinaryArrayHeap.MAX_HEAD);
        heap.add(2);
        assertEquals(2, heap.getHead().intValue());

        heap.add(3);
        assertEquals(3, heap.getHead().intValue());

        heap.add(1);
        assertEquals(3, heap.getHead().intValue());

        heap.add(3);
        heap.pollHead();
        assertEquals(3, heap.getHead().intValue());
        heap.pollHead();
        assertEquals(2, heap.getHead().intValue());

        assertTrue(heap.contains(2));
        assertFalse(heap.contains(3));
    }

    public void testMinHeap(){
        Heap<Integer> heap = new BinaryArrayHeap<Integer>(BinaryArrayHeap.MIN_HEAD);
        heap.add(3);
        assertEquals(3, heap.getHead().intValue());

        heap.add(2);
        assertEquals(2, heap.getHead().intValue());

        heap.add(4);
        assertEquals(2, heap.getHead().intValue());

        heap.pollHead();
        assertEquals(3, heap.getHead().intValue());

        assertTrue(heap.contains(3));
        assertFalse(heap.contains(2));
    }

}