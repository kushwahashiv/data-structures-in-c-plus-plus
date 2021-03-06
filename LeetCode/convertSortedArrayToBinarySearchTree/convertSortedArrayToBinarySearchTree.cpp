// Source : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-23

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

#include<iostream>
#include<vector>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};


TreeNode *sortedArrayToBST(vector<int> &num) {
  if (num.size() == 0) return NULL;
  if (num.size() == 1)
  {
    return new TreeNode(num[0]);
  }

  int middle = num.size() / 2;
  TreeNode* root = new TreeNode(num[middle]);

  vector<int> leftInts(num.begin(), num.begin() + middle);
  vector<int> rightInts(num.begin() + middle + 1, num.end());

  root->left = sortedArrayToBST(leftInts);
  root->right = sortedArrayToBST(rightInts);

  return root;
}


int main()
{

  return 0;
}