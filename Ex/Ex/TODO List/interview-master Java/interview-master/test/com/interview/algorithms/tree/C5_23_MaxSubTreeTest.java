package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C5_23_MaxSubTreeTest extends TestCase {
    C5_23_MaxSubTree finder = new C5_23_MaxSubTree();

    public void testcase1(){
        Integer[] array = new Integer[]{-28, 14, -33, -32, -67, 14, -67, -37, -58, -14, -80, 74, 12, 88, -23, -99, 78, 40, 58, -52};
        test(array, 88, 128);
    }

    public void testcase2(){
        Integer[] array = new Integer[]{93, 51, -35, -78, 4, -45, -52, 71, -72, 19, 32, 70, -80, -11, -49, 10, -85, 80, 68, 80 };
        test(array, -45, 186);
    }

    public void testRandom(){
        Integer[] array = TestUtil.generateIntegerArray(20, 100, 0, true);
        ConsoleWriter.printIntArray(array);
        BinaryTree<Integer> tree = new BinaryTree<Integer>(array);
        BinaryTreePrinter.print(tree.getRoot());

        BinaryTreeNode<Integer> subtree = finder.find(tree);
        BinaryTreePrinter.print(subtree);
        System.out.println(finder.max);
    }

    public void test(Integer[] array, int root, int sum){
        //ConsoleWriter.printIntArray(array);
        BinaryTree<Integer> tree = new BinaryTree<Integer>(array);
        //BinaryTreePrinter.print(tree.getRoot());

        BinaryTreeNode<Integer> subtree = finder.find(tree);
        assertEquals(root, subtree.value.intValue());
        assertEquals(sum, finder.max);
        //BinaryTreePrinter.print(subtree);
        //System.out.println(finder.max);
    }
}