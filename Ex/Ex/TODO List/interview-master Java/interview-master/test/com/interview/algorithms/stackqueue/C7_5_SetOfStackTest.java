package com.interview.algorithms.stackqueue;

import junit.framework.TestCase;

public class C7_5_SetOfStackTest extends TestCase {

    C7_5_SetOfStack<String> stack;

    @Override
    public void setUp() throws Exception {
        stack = new C7_5_SetOfStack<>(2);
    }

    public void prepareData(){
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
    }

    public void testPush() throws Exception {
        prepareData();
        assertEquals(5, stack.size());
    }

    public void testPop() throws Exception {
        prepareData();
        assertEquals("e", stack.pop());
        assertEquals("d", stack.pop());
    }

    public void testPeek() throws Exception {
        prepareData();
        assertEquals("e", stack.peek());
    }

    public void testPopAt() throws Exception {
        prepareData();
        assertEquals("b", stack.popAt(0));
        assertEquals("d", stack.popAt(1));
        assertEquals("e", stack.popAt(2));
        assertEquals(null, stack.popAt(3));
    }

    public void testPopAtAndPop() throws Exception {
        prepareData();
        assertEquals("d", stack.popAt(1));
        assertEquals("c", stack.popAt(1));
        assertEquals("e", stack.pop());
        assertEquals("b", stack.pop());
    }
}