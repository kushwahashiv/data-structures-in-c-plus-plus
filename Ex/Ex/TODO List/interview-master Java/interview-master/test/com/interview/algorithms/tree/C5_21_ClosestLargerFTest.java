package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 上午10:46
 */
public class C5_21_ClosestLargerFTest extends TestCase {
    public void testcase1() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        int f = C5_21_ClosestLargerF.getF(tree);
        assertEquals(11, f);

        int k = C5_21_ClosestLargerF.find(tree);
        assertEquals(13, k);

    }

    public void testcase2() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 14, 20, 2, 4, 11, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        int f = C5_21_ClosestLargerF.getF(tree);
        assertEquals(11, f);

        int k = C5_21_ClosestLargerF.find(tree);
        assertEquals(14, k);

    }
}
