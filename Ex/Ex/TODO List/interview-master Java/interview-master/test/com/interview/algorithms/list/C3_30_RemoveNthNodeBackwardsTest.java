package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 上午9:16
 */
public class C3_30_RemoveNthNodeBackwardsTest extends TestCase {
    public void testRemoveNthFromEnd() throws Exception {
        Integer[] array = new Integer[]{1,2,3,4,5};
        LinkedList<Integer> list = new LinkedList<>();
        for(Integer num : array) list.add(num);

        //ConsoleWriter.printLinkedList(list);
        assertEquals(4, list.get(3).intValue());
        C3_30_RemoveNthNodeBackwards.removeNthFromEnd(list.getHead(), 2);
        assertEquals(5, list.get(3).intValue());
        //ConsoleWriter.printLinkedList(list);
        list.setHead(C3_30_RemoveNthNodeBackwards.removeNthFromEnd(list.getHead(), 4));
        assertEquals(2, list.get(0).intValue());

        list.setHead(C3_30_RemoveNthNodeBackwards.removeNthFromEnd(list.getHead(), 4));
        assertEquals(2, list.get(0).intValue());

    }
}
