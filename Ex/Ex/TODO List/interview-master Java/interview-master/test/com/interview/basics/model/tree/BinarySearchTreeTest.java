package com.interview.basics.model.tree;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

    public void testMaxMinSize(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();

        assertEquals(20, tree.max().value.intValue());
        assertEquals(2, tree.min().value.intValue());
        assertEquals(11, tree.size());
    }

    public void testSearch(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreeNode target = tree.search(7);
        assertNotNull(target);
        assertEquals(9, tree.successor(target).value.intValue());
        assertEquals(6, tree.predecessor(target).value.intValue());
        assertNull(tree.successor(tree.search(20)));
        assertNull(tree.predecessor(tree.search(2)));
    }

    public void testInsert(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        assertNull(tree.search(8));
        tree.insert(8);
        assertNotNull(tree.search(8));

        BinaryTreeNode target = tree.search(6);
        assertNotNull(target);
    }

    public void testSelectRank(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();
        //BinaryTreePrinter.print(tree.getRoot());
        assertEquals(13, tree.select(7).value.intValue());
        assertEquals(9, tree.rank(18));
    }

    public void testFloorCeil(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();
        //BinaryTreePrinter.print(tree.getRoot());
        assertEquals(7, tree.floor(7).value.intValue());
        assertEquals(7, tree.floor(8).value.intValue());
        assertEquals(9, tree.floor(12).value.intValue());
        assertEquals(13, tree.ceil(12).value.intValue());
        assertEquals(9, tree.ceil(9).value.intValue());
        assertEquals(6, tree.ceil(5).value.intValue());
    }

    public void testDelete(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();
        assertEquals(2, tree.min().value.intValue());
        tree.deleteMin();
        assertEquals(3, tree.min().value.intValue());
        assertEquals(20, tree.max().value.intValue());
        tree.deleteMax();
        assertEquals(18, tree.max().value.intValue());

        assertEquals(13, tree.ceil(12).value.intValue());
        tree.delete(13);
        assertEquals(15, tree.ceil(12).value.intValue());
    }
}