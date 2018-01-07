// Source : https://leetcode.com/problems/symmetric-tree/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-28

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

#include<iostream>
#include<vector>
#include<queue>
#include<ctime>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};


bool isSymmetric(TreeNode *root) {
  TreeNode *left, *right;
  if (!root)
    return true;

  queue<TreeNode*> q1, q2;
  q1.push(root->left);
  q2.push(root->right);
  while (!q1.empty() && !q2.empty()) {
    left = q1.front();
    q1.pop();
    right = q2.front();
    q2.pop();
    if (NULL == left && NULL == right)
      continue;
    if (NULL == left || NULL == right)
      return false;
    if (left->val != right->val)
      return false;
    q1.push(left->left);
    q1.push(left->right);
    q2.push(right->right);
    q2.push(right->left);
  }
  return true;
}


int main()
{
  return 0;
}