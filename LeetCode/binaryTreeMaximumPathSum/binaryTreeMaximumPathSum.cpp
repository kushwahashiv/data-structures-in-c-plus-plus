/*
Source : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
Author : Shiv S. Kushwaha
Date   : 2014-10-10

Given a binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
For example:
Given the below binary tree,

       1
      / \
     2   3
*/

#include <iostream>
#include <algorithm>
using namespace std;


struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

int maxToRoot(TreeNode *root, int &re) {
        if (!root) return 0;
        int l = maxToRoot(root->left, re);
        int r = maxToRoot(root->right, re);
        if (l < 0) l = 0;
        if (r < 0) r = 0;
        if (l + r + root->val > re) re = l + r + root->val;
        return root->val += max(l, r);
    }

    int maxPathSum(TreeNode *root) {
        int max = -2147483648;
        maxToRoot(root, max);
        return max;
    }


int main()
{
  TreeNode root(1);
  TreeNode left(2);
  TreeNode right(3);
  root.left = &left;
  root.right = &right;
  cout << maxPathSum(&root) << endl;
  return 0;
}
