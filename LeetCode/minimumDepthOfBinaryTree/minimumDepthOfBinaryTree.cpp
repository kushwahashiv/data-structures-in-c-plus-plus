// Source : https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-22

/********************************************************************************** 
* 
* Given a binary tree, find its minimum depth.
* 
* The minimum depth is the number of nodes along the shortest path from the root node 
* down to the nearest leaf node.
*               
**********************************************************************************/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 * };
 */


#include <iostream>
#include <vector>
#include <ctime>
using namespace std;



struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};



class Solution {
public:
    int minDepth(TreeNode *root) {
        if (root==nullptr){
            return 0;
        }
        if (root->left==nullptr && root->right==nullptr){
            return 1;
        }
        int left=INT_MAX;
        if (root->left){
            left = minDepth(root->left) + 1 ;
        }
        int right=INT_MAX;
        if (root->right){
            right = minDepth(root->right) + 1;
        }
        
        return left<right ? left : right;
        
    }
};


int main()
{

  return 0;

}