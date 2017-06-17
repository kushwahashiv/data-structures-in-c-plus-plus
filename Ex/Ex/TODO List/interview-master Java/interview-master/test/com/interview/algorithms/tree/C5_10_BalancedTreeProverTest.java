package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_10_BalancedTreeProverTest extends TestCase {

    public void testIsBalanced() throws Exception {
        Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);
        BinaryTree nonBSTTree = new BinaryTree(testArray);
        BinaryTreePrinter.print(nonBSTTree.getRoot());
        BinarySearchTree BSTTree = new BinarySearchTree(testArray);
        BinaryTreePrinter.print(BSTTree.getRoot());

        assertTrue(C5_10_BalancedTreeProver.isBalanced(nonBSTTree));
        assertFalse(C5_10_BalancedTreeProver.isBalanced(BSTTree));
    }
}