package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-16
 * Time: 下午10:44
 */
public class C5_5_BSTProverTest extends TestCase {
    public void testIsBST() throws Exception {
        Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);
        C5_5_BSTProver<Integer> prover = new C5_5_BSTProver<Integer>();

        BinaryTree nonBSTTree = new BinaryTree(testArray);
        assertFalse(prover.isBST(nonBSTTree));
        BinaryTreePrinter.print(nonBSTTree.getRoot());

        BinarySearchTree BSTTree = new BinarySearchTree(testArray);
        assertTrue(prover.isBST(BSTTree));
        BinaryTreePrinter.print(BSTTree.getRoot());

    }

    public void testIsBST2() throws Exception {
        Integer[] testArray = new Integer[]{1,3,2,6,8,7,5};
        C5_5_BSTProver<Integer> prover = new C5_5_BSTProver<Integer>();

        BinaryTree nonBSTTree = new BinaryTree(testArray);
        BinaryTreePrinter.print(nonBSTTree.getRoot());
        assertFalse(prover.isValidBST(nonBSTTree));
        assertFalse(prover.isValidBSTMinMax(nonBSTTree.getRoot()));

        BinarySearchTree BSTTree = new BinarySearchTree(testArray);
        BinaryTreePrinter.print(BSTTree.getRoot());
        assertTrue(prover.isValidBST(BSTTree));
        assertTrue(prover.isValidBSTMinMax(BSTTree.getRoot()));

    }
}
