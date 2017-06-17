package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午3:10
 *
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 * For example: Given the below binary tree,
 *      1
 *     / \
 *    2   3
 *  Return 6.
 *
 * Solutions:
 * 1. Max path can be reduced by a joined singlePath from left and right + node.val
 * 2. Keep tracking the max path and singlePath in each node
 *      singlePath(node) = max(0, max(singlePath(node.left), singlePath(node.right)) + node.val) //choose left or right
 *      maxPath(node) = max(
 *          max(maxPath(node.left), maxPath(node.right)),   //path doesn't go through node
 *          singlePath(node.left) + singlePath(node.right) + node.val;    //path go through node
 *      )
 * 3. It's a standard divide and conquer sample for Tree, in post-order traverse.
 *
 * Tricks:
 *  1. Define a simplest and clear calculation method for the variable you interested (max path), may have several different cases.
 *  2. For tree problem, find a suitable traverse: pre-order, in-order and post-order.
 *  3. Using divide and conquer every TreeNode, do the same procedure on its children.
 *  4. Consider the cases if result go negative, do we need change it to 0.    for the singlePath
 */
public class BinaryTreeMaximumPathSum {
    static class Result {
        int singlePath, maxPath;

        Result(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private static Result maxPath(TreeNode node) {
        if (node == null) return new Result(0, Integer.MIN_VALUE);

        //Divide
        Result left = maxPath(node.left);
        Result right = maxPath(node.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + node.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + node.val);

        return new Result(singlePath, maxPath);
    }

    public static int maxPathSum(TreeNode root) {
        Result result = maxPath(root);
        return result.maxPath;
    }
}
