package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.Iterator;

public class C5_18_BSTPostOrderTest extends TestCase {

    public void testCheck() throws Exception {
        //Integer[] array = TestUtil.generateIntArray(10, 100, 0);
        Integer[] array = new Integer[]{8,6,10,5,7,9,11};

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(array);
        BinaryTreePrinter.print(tree.getRoot());
        AddListProcessor<Integer> p = new AddListProcessor<Integer>();
        C5_1_TreeTraverse.traverseByPostOrder(tree.getRoot(), p);
        List<Integer> postOrder = p.list;
        Integer[] postOrderArray = new Integer[postOrder.size()];
        int i = 0;
        Iterator<Integer> itr = postOrder.iterator();
        while(itr.hasNext()){
            postOrderArray[i++] = itr.next();
        }
        //ConsoleWriter.printIntArray(postOrder);

        assertTrue(C5_18_BSTPostOrder.check(postOrderArray));
        assertFalse(C5_18_BSTPostOrder.check(array));

    }
}