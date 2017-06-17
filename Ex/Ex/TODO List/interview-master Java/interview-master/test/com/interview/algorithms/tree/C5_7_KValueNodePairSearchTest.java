package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class C5_7_KValueNodePairSearchTest extends TestCase {

    public void testSearch() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        C5_7_KValueNodePairSearch searcher = new C5_7_KValueNodePairSearch();


        HashMap<Integer, Integer> pairs = searcher.search(tree, 13);
        assertEquals(2, pairs.size());

        for(Map.Entry<Integer, Integer> pairEntry : pairs.entrySet()) {
            Integer key = pairEntry.getKey();
            Integer value = pairEntry.getValue();
            assertNotNull(tree.search(key));
            assertNotNull(tree.search(value));
            assertEquals(13, key + value);
        }

        pairs = searcher.search(tree, 40);
        assertEquals(0, pairs.size());
    }
}