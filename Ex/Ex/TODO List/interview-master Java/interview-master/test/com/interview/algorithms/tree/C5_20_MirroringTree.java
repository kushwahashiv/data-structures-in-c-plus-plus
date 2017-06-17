package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/22/14
 * Time: 4:53 PM
 */
public class C5_20_MirroringTree {

    public static void mirror(BinaryTree tree){
        mirror(tree.getRoot());
    }

    public static void mirror(BinaryTreeNode node){
        BinaryTreeNode tmp = node.left;
        node.setLeft(node.right);
        node.setRight(tmp);

        if(node.left != null) mirror(node.left);
        if(node.right != null) mirror(node.right);
    }
}
