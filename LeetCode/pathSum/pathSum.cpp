// Source : https://leetcode.com/problems/path-sum/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-22

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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

bool hasPathSum(TreeNode *root, int sum) {
  if (root == NULL) return false;
  if (root->right == root->left)  return sum == root->val;
  return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
}


bool hasPathSum2(TreeNode *root, int sum) {

  if (root == nullptr) return false;

  if (root->left == nullptr && root->right == nullptr) {
    return (root->val == sum);
  }

  if (root->left) {
    root->left->val += root->val;
    if (hasPathSum2(root->left, sum)) {
      return true;
    }
  }

  if (root->right) {
    root->right->val += root->val;
    if (hasPathSum2(root->right, sum)) {
      return true;
    }
  }

  return false;
}


int main()
{
  return 0;
}