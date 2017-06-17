package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import junit.framework.TestCase;
import org.testng.Assert;

public class C5_1_TreeTraverseTest extends TestCase {
    private BinarySearchTree<Integer> tree;

    @Override
    public void setUp() throws Exception {
        System.out.println("The Tree Traverse Implementation");
        System.out.println("========================================================================");

        System.out.println("Tree Structure : \n--------");
        System.out.println("            6");
        System.out.println("           / \\ ");
        System.out.println("          4   8");
        System.out.println("         / \\ / \\ ");
        System.out.println("        3  5 7  9");

        Integer[] array = new Integer[]{6,4,8,3,5,7,9};
        tree = new BinarySearchTree<Integer>(array);

    }

    public void testTraversInDepthFirstOrder() throws Exception {
        AddListProcessor<Integer> p = new AddListProcessor<>();
        C5_1_TreeTraverse.traverseByPreOrder(tree.getRoot(), p);
        Object[] ordered = p.list.toArray();

        int[] expected = new int[]{6,4,3,5,8,7,9};
        for(int i = 0; i < ordered.length; i ++)
            Assert.assertTrue(ordered[i].equals(expected[i]), "The " + i + "th row is wrong");
    }

    public void testTraverseInBreadthFirstOrder() throws Exception {
        AddListProcessor<Integer> p = new AddListProcessor<>();
        C5_1_TreeTraverse.traverseInBreadthFirstOrder(tree.getRoot(), p);
        Object[] ordered = p.list.toArray();

        int[] expected = new int[]{6,4,8,3,5,7,9};
        for(int i = 0; i < ordered.length; i ++)
            Assert.assertTrue(ordered[i].equals(expected[i]), "The " + i + "th row is wrong");
    }

    public void testTraverseByPreOrder() throws Exception {
        AddListProcessor<Integer> p = new AddListProcessor<>();
        C5_1_TreeTraverse.traverseByPreOrder(tree.getRoot(), p);
        Object[] ordered = p.list.toArray();

        int[] expected = new int[]{6,4,3,5,8,7,9};
        for(int i = 0; i < ordered.length; i ++)
            Assert.assertTrue(ordered[i].equals(expected[i]), "The " + i + "th row is wrong");
    }

    public void testTraverseByInOrder() throws Exception {
        AddListProcessor<Integer> p = new AddListProcessor<>();
        C5_1_TreeTraverse.traverseByInOrder(tree.getRoot(), p);
        Object[] ordered = p.list.toArray();

        int[] expected = new int[]{3,4,5,6,7,8,9};
        for(int i = 0; i < ordered.length; i ++)
            Assert.assertTrue(ordered[i].equals(expected[i]), "The " + i + "th row is wrong");
    }

    public void testTraverseByPostOrder() throws Exception {
        AddListProcessor<Integer> p = new AddListProcessor<>();
        C5_1_TreeTraverse.traverseByPostOrder(tree.getRoot(), p);
        Object[] ordered = p.list.toArray();

        int[] expected = new int[]{3,5,4,7,9,8,6};
        for(int i = 0; i < ordered.length; i ++)
            Assert.assertTrue(ordered[i].equals(expected[i]), "The " + i + "th row is wrong");
    }
}