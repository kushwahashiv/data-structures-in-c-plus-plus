package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import com.interview.util.TestUtil;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-19
 * Time: 上午12:58
 */
public class C3_13_ListIntersectionProverTest extends TestCase {
    public void testHaveIntersectionWithoutCycle() throws Exception {
        LinkedList list1 = TestUtil.generateLinkedList(10);
        Node head = new Node(6);
        head.next = new Node(56);
        head.next = list1.getHead().next.next.next;

        LinkedList list2 = new LinkedList(head);
        assertTrue(C3_13_ListIntersectionProver.haveIntersection(list1, list2));
    }

    public void testNotHaveIntersectionWithoutCycle(){
        LinkedList list1 = TestUtil.generateLinkedList(10);
        LinkedList list2 = TestUtil.generateLinkedList(7);
        assertFalse(C3_13_ListIntersectionProver.haveIntersection(list1, list2));
    }

    public void testHaveIntersectionWithCycle(){
        LinkedList list1 = TestUtil.generateCycleLinkedList(10);
        Node node = C3_14_ListCycleFinder.hasCycle(list1);
        node = node.next.next;
        LinkedList list2 = new LinkedList(node);
        assertTrue(C3_13_ListIntersectionProver.haveIntersection(list1, list2));
    }

    public void testNotHaveIntersectionWithCycle(){
        LinkedList list1 = TestUtil.generateCycleLinkedList(10);
        LinkedList list2 = TestUtil.generateCycleLinkedList(7);
        assertFalse(C3_13_ListIntersectionProver.haveIntersection(list1, list2));
    }
}
