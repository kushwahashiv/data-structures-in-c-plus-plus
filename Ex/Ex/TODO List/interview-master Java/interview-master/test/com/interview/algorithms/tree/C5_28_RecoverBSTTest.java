package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTreeNode;
import junit.framework.TestCase;

public class C5_28_RecoverBSTTest extends TestCase {

    public void testRecoverTree() throws Exception {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        root.left = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(1);
        C5_28_RecoverBST recover = new C5_28_RecoverBST();
        recover.recoverTree(root);
        assertEquals(2, root.value.intValue());
        assertEquals(1, root.left.value.intValue());
        assertEquals(3, root.right.value.intValue());
    }
}