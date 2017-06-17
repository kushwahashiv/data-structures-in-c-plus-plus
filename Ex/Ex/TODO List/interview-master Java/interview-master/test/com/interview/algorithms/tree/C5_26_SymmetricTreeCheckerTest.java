package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTreeNode;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-5
 * Time: 下午4:09
 */
public class C5_26_SymmetricTreeCheckerTest extends TestCase {
    static BinaryTreeNode root;
    static {
        root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(2);
    }
    public void testIsSymmeticRecursive() throws Exception {
        assertTrue(C5_26_SymmetricTreeChecker.isSymmeticRecursive(root));
    }

    public void testIsSymmeticIterative() throws Exception {
        assertTrue(C5_26_SymmetricTreeChecker.isSymmeticIterative(root));
    }
}
