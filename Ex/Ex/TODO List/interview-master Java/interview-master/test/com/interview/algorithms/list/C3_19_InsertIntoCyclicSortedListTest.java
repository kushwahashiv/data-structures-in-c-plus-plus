package com.interview.algorithms.list;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-20
 * Time: 下午9:58
 */
public class C3_19_InsertIntoCyclicSortedListTest extends TestCase {
    public void testInsert() throws Exception {
        C3_19_InsertIntoCyclicSortedList.Node head = new C3_19_InsertIntoCyclicSortedList.Node(3);
        head.next = head;
        print(head);

        head = C3_19_InsertIntoCyclicSortedList.insert(head, 5);
        print(head);

        head = C3_19_InsertIntoCyclicSortedList.insert(head, 7);
        print(head);

        head = C3_19_InsertIntoCyclicSortedList.insert(head, 2);
        print(head);

        head = C3_19_InsertIntoCyclicSortedList.insert(head, 4);
        print(head);
    }

    public void print(C3_19_InsertIntoCyclicSortedList.Node head){
        C3_19_InsertIntoCyclicSortedList.Node end = head;
        System.out.printf("%d\t", head.value);
        head = head.next;
        while(head != end){
            System.out.printf("%d\t", head.value);
            head = head.next;
        }
        System.out.println();
    }
}
