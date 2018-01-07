// Source : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-03

/*
Given a binary tree, flatten it to a linked list in-place.
For example,
Given
    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
Hints:
If you notice carefully in the flattened tree, each node's right child points to
the next node of a pre-order traversal.
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

void flatten(TreeNode *root) {
  TreeNode*now = root;
  while (now)
  {
    if (now->left)
    {
      //Find current node's prenode that links to current node's right subtree
      TreeNode* pre = now->left;
      while (pre->right)
      {
        pre = pre->right;
      }
      pre->right = now->right;
      //Use current node's left subtree to replace its right subtree(original right
      //subtree is already linked by current node's prenode
      now->right = now->left;
      now->left = NULL;
    }
    now = now->right;
  }
}

int main()
{
  return 0;
}