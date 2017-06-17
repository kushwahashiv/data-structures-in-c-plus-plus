package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-18
 * Time: 下午8:47
 */
public class C5_17_BST2LinkedListTest extends TestCase {
    public void testTransfer() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        MaxMinNode node = C5_17_BST2LinkedList.transfer(tree);

        BinaryTreeNode<Integer> head = node.getMin();
        int count = 1;
        while(head.right != null){
            assertTrue(head.value.intValue() <= head.right.value.intValue());
            head = head.right;
            count++;
        }
        assertEquals(11, count);

        BinaryTreeNode<Integer> tail = node.getMax();
        count = 1;
        while(tail.left != null){
            assertTrue(head.value.intValue() >= tail.left.value.intValue());
            tail = tail.left;
            count++;
        }
        assertEquals(11, count);
    }

    public void testTransferNoExtraSpace() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        BinaryTreeNode<Integer> head = C5_17_BST2LinkedListNoExtraSpace.transfer(tree);
        int count = 1;
        while(head.right != null){
            assertTrue(head.value.intValue() <= head.right.value.intValue());
            head = head.right;
            count++;
        }
        assertEquals(11, count);

        count = 1;
        while(head.left != null){
            assertTrue(head.value.intValue() >= head.left.value.intValue());
            head = head.left;
            count++;
        }
        assertEquals(11, count);
    }
}
