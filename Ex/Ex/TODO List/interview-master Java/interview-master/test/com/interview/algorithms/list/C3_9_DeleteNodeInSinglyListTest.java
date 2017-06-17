package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import junit.framework.TestCase;

public class C3_9_DeleteNodeInSinglyListTest extends TestCase {

    public void testDeleteNode() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Node<String> node = list.getHead().next;

        C3_9_DeleteNodeInSinglyList<String> example = new C3_9_DeleteNodeInSinglyList<String>();
        example.deleteNode(node);

        assertEquals("c", list.get(1));

    }
}