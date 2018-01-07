// Source : https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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


public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumR(root, 0);
    }
    public int sumR(TreeNode root, int x) {
        if (root.right == null && root.left == null)
            return 10 * x + root.val;
        int val = 0;
        if (root.left != null)
            val += sumR(root.left, 10 * x + root.val);
        if (root.right != null)
            val += sumR(root.right, 10 * x + root.val);
        return val;
    }

    // 2
int sumNumbers(TreeNode *root) {
        if (!root) return 0;
        int sum = 0;
        vector<TreeNode*> v;
        v.push_back(root);
        while(v.size()>0){
            TreeNode* node = v.back();
            v.pop_back();
            if (node->left){
                node->left->val += (10*node->val);
                v.push_back(node->left);
            }
            if (node->right){
                node->right->val += (10*node->val);
                v.push_back(node->right);
            }
            if(!node->right && !node->left){
                sum += node->val;
            }
        }

        return sum;
 }


int main()
{
  return 0;
}