package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-19
 * Time: 下午5:53
 */
public class C3_15_ListReverseTest extends TestCase {
    Integer[] array = {1,2,3,4,5,6,7,8,9};

    public void testReverseByLoop() throws Exception {

        LinkedList<Integer> list = new LinkedList<>();
        for(Integer item : array) list.add(item);

        C3_15_ListReverse.reverseByLoop(list);

        Node<Integer> node = list.getHead();
        while(node.next != null){
            assertTrue(node.item > node.next.item);
            node = node.next;
        }

    }

    public void testReverseRecursive() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        for(Integer item : array) list.add(item);

        C3_15_ListReverse.reverseRecursive(list);

        Node<Integer> node = list.getHead();
        while(node.next != null){
            assertTrue(node.item > node.next.item);
            node = node.next;
        }
    }
}
