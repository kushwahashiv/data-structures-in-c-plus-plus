package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.sort.QuickSorter;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_11_SortedArray2BalancedBSTTest extends TestCase {

    public void testCreate() throws Exception {
        C5_11_SortedArray2BalancedBST<Integer> maker = new C5_11_SortedArray2BalancedBST<Integer>();

        Integer[] testArray = TestUtil.generateIntArray(15, 100, 0);
        new QuickSorter().sort(testArray);
        BinarySearchTree tree = maker.create(testArray);

        BinaryTreePrinter.print(tree.getRoot());

        assertEquals(true, new C5_5_BSTProver<Integer>().isBST(tree));
        assertEquals(true, C5_10_BalancedTreeProver.isBalanced(tree));

        tree.reheight();
        assertEquals(4, tree.height());
    }
}