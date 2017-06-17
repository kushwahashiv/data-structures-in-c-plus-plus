package com.interview.algorithms.stackqueue;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-26
 * Time: 上午9:41
 */
public class C7_9_MaxQueueTest extends TestCase {
    public void testcase(){
//        C7_9_MaxQueueWithHeap<Integer> maxQueue = new C7_9_MaxQueueWithHeap<>();
        C7_9_MaxQueueWithStack<Integer> maxQueue = new C7_9_MaxQueueWithStack<>();
        assertNull(maxQueue.max());
        maxQueue.push(4);
        assertEquals(4, maxQueue.max().intValue());
        maxQueue.push(1);
        assertEquals(4, maxQueue.max().intValue());
        maxQueue.push(2);
        assertEquals(4, maxQueue.max().intValue());
        assertEquals(4, maxQueue.pop().intValue());
        assertEquals(2, maxQueue.max().intValue());
    }
}
