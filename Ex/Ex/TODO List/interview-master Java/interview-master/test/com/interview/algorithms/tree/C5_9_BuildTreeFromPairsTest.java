package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTreeNode;
import junit.framework.TestCase;

public class C5_9_BuildTreeFromPairsTest extends TestCase {

    public void testConvert() throws Exception {
         /*
		System.out.println("            6");
		System.out.println("           / \ ");
		System.out.println("          4   8");
		System.out.println("         / \ / \ ");
		System.out.println("        3  5 7  9");
         */
        int[] children = new int[] {3, 5, 7, 9, 4, 8};
        int[] parents = new int[] {4, 4, 8, 8, 6, 6};
        C5_9_BuildTreeFromPairs builder = new C5_9_BuildTreeFromPairs();
        BinaryTreeNode root = builder.convert(children, parents);

        System.out.println("Printing the trees ....");
        C5_1_TreeTraverse traverser = new C5_1_TreeTraverse();
        traverser.traverseByPreOrder(root, new PrintProcessor());
    }
}