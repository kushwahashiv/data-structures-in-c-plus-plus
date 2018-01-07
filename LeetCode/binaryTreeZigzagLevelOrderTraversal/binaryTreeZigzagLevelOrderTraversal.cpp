// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-05

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal,
where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
*/

#include <iostream>
#include <vector>
#include <queue>
using namespace std;


struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
  queue<TreeNode*> q;
  if (root)  q.push(root);
  bool reverse = false;
  vector<vector<int>> zigzagResult;
  while (!q.empty()) {
    int size = q.size();
    zigzagResult.push_back(vector<int>(size));
    for (int i = 0; i < size; i++) {
      int index = reverse ? size - i - 1 : i;
      zigzagResult.back()[index] = q.front()->val;
      if (q.front()->left)  q.push(q.front()->left);
      if (q.front()->right)  q.push(q.front()->right);
      q.pop();
    }
    reverse = !reverse;
  }
  return zigzagResult;
}

// supporting functions
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

void printMatrix(vector< vector<int> > &vv)
{
  for (int i = 0; i < vv.size(); i++)
  {
    cout << "[";
    for (int j = 0; j < vv[i].size(); j++)
    {
      cout << " " << vv[i][j];
    }
    cout << " ]" << endl;;
  }
}


int main(int argc, char** argv)
{
  TreeNode *p;
  vector< vector<int> > vv;

  int a[] = { 3, 9, 20, 0, 0, 15, 7 };
  p = createTree(a, sizeof(a) / sizeof(int));
  printTree_level_order(p);
  vv = zigzagLevelOrder(p);
  printMatrix(vv);
  cout << endl;


  system("pause");
  return 0;
}

