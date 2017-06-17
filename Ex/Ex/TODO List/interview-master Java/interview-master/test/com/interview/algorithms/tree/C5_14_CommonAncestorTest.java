package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_14_CommonAncestorTest extends TestCase {

    public void testFind() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());
        tree.reheight();

        assertEquals(6, C5_14_CommonAncestor.find(tree, tree.search(6), tree.search(13)).value);
        assertEquals(6, C5_14_CommonAncestor.getLCA(tree, tree.search(6), tree.search(13)).value);

        assertEquals(6, C5_14_CommonAncestor.find(tree, tree.search(3), tree.search(13)).value);
        assertEquals(6, C5_14_CommonAncestor.getLCA(tree, tree.search(3), tree.search(13)).value);

        assertEquals(15, C5_14_CommonAncestor.find(tree, tree.search(18), tree.search(7)).value);
        assertEquals(15, C5_14_CommonAncestor.getLCA(tree, tree.search(18), tree.search(7)).value);
    }
}