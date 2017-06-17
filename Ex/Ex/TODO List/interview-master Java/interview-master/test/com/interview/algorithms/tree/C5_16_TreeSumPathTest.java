package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_16_TreeSumPathTest extends TestCase {

    public void testFindSum() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        C5_16_TreeSumPath.findSum(tree, 13);
    }

    public void testFindSum2(){
        Integer[] data = new Integer[]{10,5,12,4,7};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        C5_16_TreeSumPath.findSum(tree, 22);
    }
}