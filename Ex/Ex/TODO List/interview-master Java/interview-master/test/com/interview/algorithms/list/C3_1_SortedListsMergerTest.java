package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import junit.framework.TestCase;

import java.util.Iterator;

/**
 * Created_By: stefanie
 * Date: 14-6-29
 * Time: 下午9:05
 */
public class C3_1_SortedListsMergerTest extends TestCase {
    C3_1_SortedListsMerger merger = new C3_1_SortedListsMerger();

    public void testCase1() throws Exception {
        System.out.println("Test case 1");
        int[] list1 = {10, 11, 12, 13, 14};
        int[] list2 = {1, 2, 3, 4, 5, 6};
        LinkedList nodeList1 = constractList(list1);
        LinkedList nodeList2 = constractList(list2);
        LinkedList finalHead = merger.merge(nodeList1, nodeList2);
        int[] mergeList = {1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14};
        match(mergeList, finalHead);
        //printList(finalHead);

        finalHead = merger.mergeRemoveDuplicate(nodeList1, nodeList2);
        match(mergeList, finalHead);
    }

    public void testCase2() throws Exception {
        System.out.println("Test case 2");
        int[] list3 = {1, 2, 3, 4, 5, 6};
        int[] list4 = {10, 11, 12, 13, 14};
        LinkedList nodeList1 = constractList(list3);
        LinkedList nodeList2 = constractList(list4);
        LinkedList finalHead = merger.merge(nodeList1, nodeList2);
        int[] mergeList = {1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14};
        match(mergeList, finalHead);
        //printList(finalHead);

        finalHead = merger.mergeRemoveDuplicate(nodeList1, nodeList2);
        match(mergeList, finalHead);
    }

    public void testCase3() throws Exception {
        System.out.println("Test case 3");
        int[] list5 = {1, 3, 7, 9, 11};
        int[] list6 = {2, 4, 6, 8, 10};
        LinkedList nodeList1 = constractList(list5);
        LinkedList nodeList2 = constractList(list6);
        LinkedList finalHead = merger.merge(nodeList1, nodeList2);
        int[] mergeList = {1, 2, 3, 4, 6, 7, 8, 9, 10, 11};
        match(mergeList, finalHead);
        //printList(finalHead);

        finalHead = merger.mergeRemoveDuplicate(nodeList1, nodeList2);
        match(mergeList, finalHead);
    }

    public void testCase4() throws Exception {
        System.out.println("Test case 4");
        int[] list7 = {1, 3, 7, 9, 11};
        int[] list8 = {};
        LinkedList nodeList1 = constractList(list7);
        LinkedList nodeList2 = constractList(list8);
        LinkedList finalHead = merger.merge(nodeList1, nodeList2);
        int[] mergeList = {1, 3, 7, 9, 11};
        match(mergeList, finalHead);

        finalHead = merger.mergeRemoveDuplicate(nodeList1, nodeList2);
        match(mergeList, finalHead);
        //printList(finalHead);
    }

    public void testCase5() throws Exception {
        System.out.println("Test case 5");
        int[] list9 = {};
        int[] list10 = {1, 3, 7, 9, 11};
        LinkedList nodeList1 = constractList(list9);
        LinkedList nodeList2 = constractList(list10);
        LinkedList finalHead = merger.merge(nodeList1, nodeList2);
        int[] mergeList = {1, 3, 7, 9, 11};
        match(mergeList, finalHead);
        //printList(finalHead);

        finalHead = merger.mergeRemoveDuplicate(nodeList1, nodeList2);
        match(mergeList, finalHead);
    }

    public void testCase6() throws Exception {
        System.out.println("Test case 6");
        int[] list11 = {1, 3, 7, 9, 11, 11, 11, 11, 11, 20};
        int[] list12 = {2, 4, 6, 8, 8, 8, 8, 8, 8, 9, 10, 20, 70};
        LinkedList nodeList1 = constractList(list12);
        LinkedList nodeList2 = constractList(list11);
        LinkedList finalHead = merger.merge(nodeList1, nodeList2);
        int[] mergeList = {1, 2, 3, 4, 6, 7, 8, 8, 8, 8, 8, 8, 9, 9, 10, 11, 11, 11, 11, 11, 20, 20, 70};
        match(mergeList, finalHead);
        //printList(finalHead);

        finalHead = merger.mergeRemoveDuplicate(nodeList1, nodeList2);
        int[] mergeRemoveDuplicate = {1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 20, 70};
        match(mergeRemoveDuplicate, finalHead);
    }

    private static LinkedList<Integer> constractList(int[] nums){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++)
            list.add(nums[i]);
        return list;
    }

    private static void printList(LinkedList<Integer> list){
        Node current = list.getHead();
        while(current != null){
            System.out.print(current.item + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public static void match(int[] expected, LinkedList<Integer> list){
        Iterator<Integer> itr = list.iterator();
        int i = 0;
        while(itr.hasNext()){
            assertEquals(expected[i++], itr.next().intValue());
        }
    }
}