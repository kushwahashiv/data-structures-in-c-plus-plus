package com.interview.basics.model.tree;

import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-16
 * Time: 下午10:25
 */
public class BinaryTreeTest extends TestCase {


    public void test() throws Exception {
        Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);
        ConsoleWriter.printIntArray(testArray);
        BinaryTree<Integer> tree = new BinaryTree<>(testArray);
        BinaryTreePrinter.print(tree.getRoot());
    }
}
