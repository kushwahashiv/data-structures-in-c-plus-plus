package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_6_BinaryTreeMatcherTest extends TestCase {

    public void testEquals() throws Exception {
        Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);
        BinaryTree nonBSTTree = new BinaryTree(testArray);
        BinaryTreePrinter.print(nonBSTTree.getRoot());
        BinarySearchTree BSTTree1 = new BinarySearchTree(testArray);
        BinaryTreePrinter.print(BSTTree1.getRoot());

        BinarySearchTree BSTTree2 = new BinarySearchTree(testArray);
        BinaryTreePrinter.print(BSTTree1.getRoot());

        assertTrue(C5_6_BinaryTreeMatcher.equals(BSTTree1, BSTTree2));
        assertFalse(C5_6_BinaryTreeMatcher.equals(BSTTree1, nonBSTTree));
    }
}