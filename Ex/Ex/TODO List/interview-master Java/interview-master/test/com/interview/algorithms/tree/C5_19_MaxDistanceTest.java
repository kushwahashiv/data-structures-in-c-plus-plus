package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_19_MaxDistanceTest extends TestCase {

    public void testDistance() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9, 10};

        BinarySearchTree tree = new BinarySearchTree(data);
        BinaryTreePrinter.print(tree.getRoot());

        assertEquals(7, C5_19_MaxDistance.distance(tree));

        BinaryTree tree2 = new BinaryTree(data);
        BinaryTreePrinter.print(tree2.getRoot());

        assertEquals(6, C5_19_MaxDistance.distance(tree2));
    }
}