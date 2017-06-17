package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-6
 * Time: 下午8:12
 */
public class C3_18_LinkedListSorterTest extends TestCase {

    public void testSort() throws Exception {
        LinkedList<Integer> list = TestUtil.generateLinkedList(10);
        ConsoleWriter.printLinkedList(list);

        C3_18_LinkedListSorter<Integer> sorter = new C3_18_LinkedListSorter<>();
        sorter.sort(list, true);

        ConsoleWriter.printLinkedList(list);

        int count = 1;
        Node<Integer> head = list.getHead();
        while(head.next != null){
            assertTrue(head.next.item >= head.item);
            head = head.next;
            count++;
        }
        assertEquals(10, count);
    }
}
