package com.interview.basics.model.collection;

import com.interview.basics.model.collection.stack.ArrayStack;
import com.interview.basics.model.collection.stack.FixCapabilityArrayStack;
import com.interview.basics.model.collection.stack.LinkedStack;
import com.interview.basics.model.collection.stack.Stack;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-12
 * Time: 下午11:00
 */
public class StackTest extends TestCase {
    Stack<Integer> stack;

    @Override
    public void setUp() throws Exception {
        //stack = new FixCapabilityArrayStack<>(10);
        //stack = new ArrayStack<>();
        stack = new LinkedStack<>();
    }

    public void testPush() throws Exception {
        stack.push(1);
        assertEquals(1, stack.size());
    }

    public void testPop() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }

    public void testPeek() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek().intValue());
        assertEquals(2, stack.size());
    }

    public void testIsEmpty() throws Exception {
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        assertEquals(false, stack.isEmpty());
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    public void testSize() throws Exception {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }
}
