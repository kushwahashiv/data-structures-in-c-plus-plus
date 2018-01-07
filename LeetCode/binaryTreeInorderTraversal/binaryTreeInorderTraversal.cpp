/*
Source : https://leetcode.com/problems/binary-tree-inorder-traversal/description/
Date   : 2014-06-27

Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/


#include <iostream>
#include <vector>
using namespace std;

struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

vector<int> inorderTraversal(TreeNode *root) {
  vector<int> vector;
  if (!root)
    return vector;
  stack<TreeNode *> stack;
  stack.push(root);
  while (!stack.empty())
  {
    TreeNode *pNode = stack.top();
    if (pNode->left)
    {
      stack.push(pNode->left);
      pNode->left = NULL;
    }
    else
    {
      vector.push_back(pNode->val);
      stack.pop();
      if (pNode->right)
        stack.push(pNode->right);
    }
  }
  return vector;
}

// 2

vector<int> inorderTraversal(TreeNode *root)
{
  vector<TreeNode*> stack;
  vector<int> v;

  while (stack.size() > 0 || root != nullptr)
  {
    if (root != nullptr)
    {
      stack.push_back(root);
      root = root->left;
    }
    else
    {
      if (stack.size() > 0)
      {
        root = stack.back();
        stack.pop_back();
        v.push_back(root->val);
        root = root->right;
      }
    }
  }
  return v;
}


int main()
{
  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(2);
  root->right = new TreeNode(3);
  root->left->left = new TreeNode(4);
  root->left->right = new TreeNode(5);
  root->left->left->left = new TreeNode(8);

  auto result = inorderTraversal(root);
  for (auto item : result)
  {
    std::cout << item << ", ";
  }


  system("pause");

  return 0;
}