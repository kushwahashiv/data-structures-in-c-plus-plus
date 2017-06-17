package com.interview.algorithms.list;

import com.interview.datastructures.list.Node;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-7
 * Time: 下午11:54
 */
public class C3_4_LoopBeginningFinderTest extends TestCase {

    public void testFindBegin() throws Exception {
        Node head = new Node("0", null);
        Node current = head;

        int smallLoopBeginNodeValue = 69;
        Node smallLoopBeginNode = null;

        int bigLoopBeginNodeValue = 19;
        Node bigLoopBeginNode = null;

        for(int i = 1 ; i < 100; i ++) {

            Node next = new Node("" + i, null);
            current.setNext(next);

            if(i == bigLoopBeginNodeValue)
                bigLoopBeginNode = next;
            else if (i == smallLoopBeginNodeValue)
                smallLoopBeginNode = next;

            current = next;
        }
        current.setNext(smallLoopBeginNode);
        String val = C3_4_LoopBeginningFinder.findLoopBeginning(head).getValue();
        assertEquals("69", val);

        System.out.println("Algorithm detected small loop beginning node : " + val);

        current.setNext(bigLoopBeginNode);
        val = C3_4_LoopBeginningFinder.findLoopBeginning(head).getValue();
        assertEquals("19", val);
        System.out.println("Algorithm detected big loop beginning node : " + val);
    }

    public void testFindLoopBeginning() throws Exception {
        Node head = new Node("0", null);
        Node current = head;

        int smallLoopBeginNodeValue = 69;
        Node smallLoopBeginNode = null;

        int bigLoopBeginNodeValue = 19;
        Node bigLoopBeginNode = null;

        for(int i = 1 ; i < 100; i ++) {

            Node next = new Node("" + i, null);
            current.setNext(next);

            if(i == bigLoopBeginNodeValue)
                bigLoopBeginNode = next;
            else if (i == smallLoopBeginNodeValue)
                smallLoopBeginNode = next;

            current = next;
        }
        current.setNext(smallLoopBeginNode);
        String val = C3_4_LoopBeginningFinder.findBegin(head).getValue();
        assertEquals("69", val);

        System.out.println("Algorithm detected small loop beginning node : " + val);

        current.setNext(bigLoopBeginNode);
        val = C3_4_LoopBeginningFinder.findBegin(head).getValue();
        assertEquals("19", val);
        System.out.println("Algorithm detected big loop beginning node : " + val);
    }
}
