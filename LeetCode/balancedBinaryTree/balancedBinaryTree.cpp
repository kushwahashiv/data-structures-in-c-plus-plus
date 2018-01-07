/*
Source : https://leetcode.com/problems/balanced-binary-tree/description/

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 of every node never differ by more than 1.
*/

#include <iostream>
#include <string>
#include <math.h>

using namespace std;


struct Node
{
  int val;
  Node *left;
  Node *right;
  Node(int x) : val(x), left(nullptr), right(nullptr) {}
};


int depth(TreeNode *root) {
  if (root == NULL) return 0;
  return max(depth(root->left), depth(root->right)) + 1;
}

bool isBalanced(TreeNode *root) {
  if (root == NULL) return true;

  int left = depth(root->left);
  int right = depth(root->right);

  return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
}


int main()
{
  Node* root = new Node(1);
  root->left = new Node(2);
  root->right = new Node(3);
  root->left->left = new Node(4);
  root->left->right = new Node(5);
  //root->left->left->left = new Node(8);

  if (isBalanced(root))
    std::cout << "Tree is balanced" << std::endl;
  else
    std::cout << "Tree is not balanced" << std::endl;

  system("pause");
  return 0;
}