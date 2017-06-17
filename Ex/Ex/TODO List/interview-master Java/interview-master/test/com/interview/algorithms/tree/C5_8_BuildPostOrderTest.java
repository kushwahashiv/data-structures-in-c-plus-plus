package com.interview.algorithms.tree;

import junit.framework.TestCase;

public class C5_8_BuildPostOrderTest extends TestCase {

    public void testFind() throws Exception {
        String preOrder = "/+a*b-cd+ef";
        String inOrder = "a+b*c-d/e+f";
        String postOrder = "abcd-*+ef+/";
        /**
         *       /
         *      / \
         *     +   +
         *    / \ / \
         *   a  * e f
         *      /\
         *     b  -
         *       / \
         *      c   d
         */


        assertEquals(postOrder, C5_8_BuildPostOrder.find(preOrder, inOrder));
    }
}