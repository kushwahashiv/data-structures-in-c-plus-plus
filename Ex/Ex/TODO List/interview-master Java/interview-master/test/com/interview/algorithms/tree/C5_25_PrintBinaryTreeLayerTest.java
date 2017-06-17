package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-9-26
 * Time: 下午3:42
 */
public class C5_25_PrintBinaryTreeLayerTest extends TestCase {

    public void testPrint() throws Exception {
        Integer[] input = TestUtil.generateIntArray(10, 100, 1);
        BinaryTree<Integer> tree = new BinaryTree<>(input);
        BinaryTreePrinter.print(tree.getRoot());

        C5_25_PrintBinaryTreeLayer.print(tree.getRoot());
    }

    public void testPrintLayer() throws Exception {
        Integer[] input = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        BinaryTree<Integer> tree = new BinaryTree<>(input);
        BinaryTreePrinter.print(tree.getRoot());

        List<Object> layer = C5_25_PrintBinaryTreeLayer.print(tree.getRoot(), 0);
        assertTrue(layer.contains(1));

        layer = C5_25_PrintBinaryTreeLayer.print(tree.getRoot(), 1);
        assertTrue(layer.contains(2));
        assertTrue(layer.contains(3));

        layer = C5_25_PrintBinaryTreeLayer.print(tree.getRoot(), 2);
        assertTrue(layer.contains(4));
        assertTrue(layer.contains(5));
        assertTrue(layer.contains(6));
        assertTrue(layer.contains(7));

        layer = C5_25_PrintBinaryTreeLayer.print(tree.getRoot(), 3);
        assertTrue(layer.contains(8));
        assertTrue(layer.contains(9));
        assertTrue(layer.contains(10));
    }

    public void testPrintLayerRecursive() throws Exception {
        Integer[] input = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        BinaryTree<Integer> tree = new BinaryTree<>(input);
        BinaryTreePrinter.print(tree.getRoot());

        List<Object> layer = C5_25_PrintBinaryTreeLayer.printRecursive(tree.getRoot(), 0);
        assertTrue(layer.contains(1));

        layer = C5_25_PrintBinaryTreeLayer.printRecursive(tree.getRoot(), 1);
        assertTrue(layer.contains(2));
        assertTrue(layer.contains(3));

        layer = C5_25_PrintBinaryTreeLayer.printRecursive(tree.getRoot(), 2);
        assertTrue(layer.contains(4));
        assertTrue(layer.contains(5));
        assertTrue(layer.contains(6));
        assertTrue(layer.contains(7));

        layer = C5_25_PrintBinaryTreeLayer.printRecursive(tree.getRoot(), 3);
        assertTrue(layer.contains(8));
        assertTrue(layer.contains(9));
        assertTrue(layer.contains(10));
    }
}
