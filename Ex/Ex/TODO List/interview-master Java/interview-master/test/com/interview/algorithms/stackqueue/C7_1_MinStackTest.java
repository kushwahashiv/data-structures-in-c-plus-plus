package com.interview.algorithms.stackqueue;

import com.interview.algorithms.stackqueue.C7_1_MinStack;
import com.interview.algorithms.stackqueue.C7_1_MinStack_2Stack;
import junit.framework.TestCase;

public class C7_1_MinStackTest extends TestCase {

    public void testMin() throws Exception {
        C7_1_MinStack<Integer> minStack = new C7_1_MinStack<>();
        //C7_1_MinStack_2Stack<Integer> minStack = new C7_1_MinStack_2Stack<>();

        minStack.push(8);
        assertEquals(8, minStack.min().intValue());

        minStack.push(2);
        assertEquals(2, minStack.min().intValue());

        minStack.push(2);
        assertEquals(2, minStack.min().intValue());

        minStack.push(9);
        assertEquals(2, minStack.min().intValue());

        minStack.pop();
        assertEquals(2, minStack.min().intValue());

        minStack.pop();
        assertEquals(2, minStack.min().intValue());

        minStack.pop();
        assertEquals(8, minStack.min().intValue());
    }
}