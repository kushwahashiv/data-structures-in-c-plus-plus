package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午9:05
 *
 */
public class C3_22_DeleteDuplicateInListTest extends TestCase {
    public void testDeleteDuplicates() throws Exception {
        LinkedList<Integer> list = new LinkedList<>(new Integer[]{1,2,3,3,4,4,5});
        Node<Integer> head = C3_22_DeleteDuplicateInList.deleteDuplicates(list.getHead());
        assertEquals(1, head.item.intValue());
        assertEquals(2, head.next.item.intValue());
        assertEquals(5, head.next.next.item.intValue());
    }

    public void testDeleteDuplicates2() throws Exception {
        LinkedList<Integer> list = new LinkedList<>(new Integer[]{1,1,1,2,3});
        Node<Integer> head = C3_22_DeleteDuplicateInList.deleteDuplicates(list.getHead());
        assertEquals(2, head.item.intValue());
        assertEquals(3, head.next.item.intValue());
    }
}
