// Source : https://leetcode.com/problems/same-tree/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-27

/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
Output: true

Example 2:
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]
Output: false

Example 3:
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
Output: false
*/

#include<iostream>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

/*
Algorithm for the recursion:
1)
If one of the node is NULL then return the equality result of p an q.
This boils down to if both are NULL then return true,
but if one of them is NULL but not the other one then return false
2)
At this point both root nodes represent valid pointers.
Return true if the root nodes have same value and
the left tree of the roots are same (recursion)
and the right tree of the roots are same (recursion).
Otherwise return false.
*/

bool isSameTree(TreeNode *p, TreeNode *q) {
    if (p == NULL || q == NULL) return (p == q);
    return (p->val == q->val && isSameTree(p->left, q->left) && isSameTree(p->right, q->right));
}

int main()
{
  return 0;
}