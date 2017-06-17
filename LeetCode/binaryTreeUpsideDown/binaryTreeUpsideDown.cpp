/*
Source : https://oj.leetcode.com/problems/binary-tree-upside-down/
Author : Shiv S. Kushwaha

Given a binary tree where all the right nodes are either leaf nodes with
a sibling (a left node that shares the same parent node) or empty,

Flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
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


TreeNode* createTree(int a[], int n)
{
  if (n <= 0)
    return nullptr;

  TreeNode **tree = new TreeNode*[n];
  for (int i = 0; i < n; i++)
  {
    if (a[i] == 0)
    {
      tree[i] = nullptr;
      continue;
    }

    tree[i] = new TreeNode(a[i]);
  }

  int pos = 1;
  for (int i = 0; i < n && pos < n; i++)
  {
    if (tree[i])
    {
      tree[i]->left = tree[pos++];
      if (pos < n)
      {
        tree[i]->right = tree[pos++];
      }
    }
  }
  return tree[0];
}

void printArray(vector<int> v)
{
  for (int i = 0; i < v.size(); i++)
  {
    cout << v[i] << " ";
  }
  cout << endl;
}


TreeNode* upsideDownBinaryTree(TreeNode* root)
{
  //using a dummy node to help to store the new tree
  TreeNode dummy(0);
  TreeNode *head = &dummy, *left(nullptr), *right(nullptr);

  while (root != nullptr)
  {
    //find the right & left
    left = root->right;
    right = root;

    //move root the next
    root = root->left;

    //replace the right with current root
    right->left = head->left;
    right->right = head->right;

    //move the dummy to the root
    dummy.right = right;
    dummy.left = left;

    //reset the head to the root
    head = &dummy;
  }

  return head->right;
}

void printTree_pre_order(TreeNode *root)
{
  if (root == nullptr){
    cout << "# ";
    return;
  }
  cout << root->val << " ";
  printTree_pre_order(root->left);
  printTree_pre_order(root->right);
}


int main()
{
  int a[] = { 1, 2, 3, 4, 5, 0, 6, 0, 0, 7, 8, 9, 0 };
  TreeNode* p = createTree(a, sizeof(a) / sizeof(int));

  printTree_pre_order(upsideDownBinaryTree(p));
  cout << endl;

  return 0;
}

