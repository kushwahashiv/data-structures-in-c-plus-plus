package com.interview.algorithms.stackqueue;

import com.interview.basics.model.collection.stack.LinkedStack;
import com.interview.basics.model.collection.stack.Stack;
import junit.framework.TestCase;

public class C7_7_StackSorterTest extends TestCase {

    public void testSort() throws Exception {
        Stack<String> stack = new LinkedStack<>();
        stack.push("a");
        stack.push("d");
        stack.push("b");
        stack.push("c");

        C7_7_StackSorter<String> sorter = new C7_7_StackSorter<String>();
        sorter.sort(stack);

        assertEquals("a", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("d", stack.pop());
    }
}