package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午9:09
 */
public class C3_5_ReverseLinkedListWithStepKTest extends TestCase {
    public void testReverse() throws Exception {
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        Integer[] expected = new Integer[]{2,1,4,3,6,5};

        LinkedList list = new LinkedList(array);
        Node head = C3_5_ReverseLinkedListWithStepK.reverse(list.getHead(), 2);
        assertList(head, expected);

        list = new LinkedList(array);
        head = C3_5_ReverseLinkedListWithStepK.reverseUsingBetween(list.getHead(), 2);
        assertList(head, expected);
    }

    public void testReverse2() throws Exception {
        Integer[] array = new Integer[]{1,2,3,4,5};
        Integer[] expected = new Integer[]{3,2,1,4,5};

        LinkedList list = new LinkedList(array);
        Node head = C3_5_ReverseLinkedListWithStepK.reverse(list.getHead(), 3);
        assertList(head, expected);

        list = new LinkedList(array);
        head = C3_5_ReverseLinkedListWithStepK.reverseUsingBetween(list.getHead(), 3);    //2->1->4->3->5
        assertList(head, expected);
    }

    public void assertList(Node head, Integer[] expected){
        int i = 0;
        while(head != null){
            assertEquals(expected[i], head.item);
            head = head.next;
            i++;
        }
    }
}
