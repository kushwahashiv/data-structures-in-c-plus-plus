package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-30
 * Time: 下午9:37
 */
public class C5_22_NextNodeSameLayerTest extends TestCase {
    public void testFindNext() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};

        BinaryTree<Integer> tree = new BinaryTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        C5_22_NextNodeSameLayer.findNext(tree);

        assertNull(tree.getRoot().parent);
        BinaryTreeNode<Integer> node = tree.getRoot();
        assertEquals(18, node.left.parent.value.intValue());
        assertNull(node.right.parent);

        node = node.left;
        assertEquals(20, node.left.parent.value.intValue());
        assertEquals(3, node.right.parent.value.intValue());
        node = node.parent;
        assertEquals(17, node.left.parent.value.intValue());
        assertNull(node.right.parent);


    }

    public void findNextWithoutUsingParent() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};

        BinaryTree<Integer> tree = new BinaryTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        C5_22_NextNodeSameLayer.findNextComplete(tree);

        assertNull(tree.getRoot().parent);
        BinaryTreeNode<Integer> node = tree.getRoot();
        assertEquals(18, node.left.parent.value.intValue());
        assertNull(node.right.parent);

        node = node.left;
        assertEquals(20, node.left.parent.value.intValue());
        assertEquals(3, node.right.parent.value.intValue());
        node = node.parent;
        assertEquals(17, node.left.parent.value.intValue());
        assertNull(node.right.parent);


    }
}
