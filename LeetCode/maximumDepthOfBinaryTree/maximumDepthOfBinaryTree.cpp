// Source : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

int maxDepth(TreeNode* root) {
  if (root == nullptr) {
    return 0;
  }
  int depth_left = maxDepth(root->left) + 1;
  int depth_right = maxDepth(root->right) + 1;
  return depth_left > depth_right ? depth_left : depth_right;
}


class Solution {
public:
  int maxDepth(TreeNode *root) {
    if (root == nullptr) {
      return 0;
    }
    if (!root->left && !root->right) {
      return 1;
    }
    int left = 1, right = 1;
    if (root->left) {
      left += maxDepth(root->left);
    }
    if (root->right) {
      right += maxDepth(root->right);
    }
    return left > right ? left : right;
  }

};



int main()
{
  return 0;
}