package com.interview.algorithms.stackqueue;

import com.interview.basics.model.collection.stack.LinkedStack;
import com.interview.basics.model.collection.stack.Stack;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-31
 * Time: 下午11:18
 */
public class C7_8_ReverseStackTest extends TestCase {
    public void testReverse() throws Exception {
        Integer[] test = new Integer[]{1,2,3,4,5,6,7,8};
        Stack<Integer> stack = new LinkedStack<>();
        for(Integer i : test)
            stack.push(i);

        C7_8_ReverseStack.reverse(stack);

        for(int i = 0; i < test.length; i++){
            assertEquals(test[i], stack.pop());
        }
    }
}
