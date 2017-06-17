package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 上午11:09
 */
public class C3_21_ReverseLinkListBetweenMNTest extends TestCase {
    public void testReverseBetween() throws Exception {
        Integer[] array = new Integer[]{1,2,3};
        LinkedList<Integer> list = new LinkedList<>(array);

        Node head = C3_21_ReverseLinkListBetweenMN.reverseBetween(list.getHead(), 1, 3);
        Integer[] expected = new Integer[]{3,2,1};
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], head.item);
            head = head.next;
        }
    }
}
