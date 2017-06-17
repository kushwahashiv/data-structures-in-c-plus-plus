package com.interview.algorithms.list;

/**
 * Created_By: stefanie
 * Date: 14-10-20
 * Time: 下午9:52
 */
public class C3_19_InsertIntoCyclicSortedList {
    static class Node{
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static Node insert(Node head, int k){
        Node newNode = new Node(k);
        if(head == head.next) {
            head.next = newNode;
            newNode.next = head;
            return head;
        } else {
            Node end = head;
            while(head.next != end && (head.value > k || head.next.value < k)) head = head.next;
            newNode.next = head.next;
            head.next = newNode;
            return end.value < newNode.value? end : newNode;
        }
    }
}
