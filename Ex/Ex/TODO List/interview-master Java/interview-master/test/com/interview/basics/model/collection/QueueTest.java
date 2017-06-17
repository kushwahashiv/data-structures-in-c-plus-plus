package com.interview.basics.model.collection;

import com.interview.algorithms.stackqueue.C7_2_QueueByStack;
import com.interview.basics.model.collection.queue.ArrayQueue;
import com.interview.basics.model.collection.queue.FixCapabilityArrayQueue;
import com.interview.basics.model.collection.queue.LinkedQueue;
import com.interview.basics.model.collection.queue.Queue;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-13
 * Time: 下午9:55
 */
public class QueueTest extends TestCase {
    Queue<Integer> queue;

    public void setUp() throws Exception {
        //queue = new ArrayQueue<Integer>(2);
        //queue = new FixCapabilityArrayQueue<Integer>(2);
        //queue = new LinkedQueue<Integer>();
        queue = new C7_2_QueueByStack<>();
    }

    public void testPush() throws Exception {
        queue.push(1);
        assertEquals(1, queue.size());
        queue.push(2);
        assertEquals(2, queue.size());
    }

    public void testPop() throws Exception {
        queue.push(1);
        queue.push(2);
        assertEquals(2, queue.size());
        assertEquals(1, queue.pop().intValue());
        assertEquals(1, queue.size());
        assertEquals(2, queue.pop().intValue());
        assertEquals(0, queue.size());
        queue.push(3);
        assertEquals(3, queue.pop().intValue());
    }

    public void testPeek() throws Exception {
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek().intValue());
        assertEquals(2, queue.size());
    }

    public void testIsEmpty() throws Exception {
        assertEquals(true, queue.isEmpty());
        queue.push(1);
        assertEquals(false, queue.isEmpty());
        queue.pop();
        assertEquals(true, queue.isEmpty());
    }

    public void testSize() throws Exception {
        assertEquals(0, queue.size());
        queue.push(1);
        assertEquals(1, queue.size());
        queue.pop();
        assertEquals(0, queue.size());
    }

    public void testExpand() throws Exception {
        if(queue instanceof ArrayQueue){
            queue.push(1);
            assertEquals(1, queue.size());
            queue.push(2);
            assertEquals(2, queue.size());
            queue.push(3);
            assertEquals(3, queue.size());
            assertEquals(1, queue.pop().intValue());
        }
    }
}
