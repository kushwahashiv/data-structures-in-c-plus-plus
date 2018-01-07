/*
Source : https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 Author : Shiv S. Kushwaha
 Date   : 2014-07-17

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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

vector<vector<int>> ret;

void buildVector(TreeNode *root, int depth)
{
    if(root == NULL) return;
    if(ret.size() == depth)
        ret.push_back(vector<int>());

    ret[depth].push_back(root->val);
    buildVector(root->left, depth + 1);
    buildVector(root->right, depth + 1);
}

vector<vector<int> > levelOrder(TreeNode *root) {
    buildVector(root, 0);
    return ret;
}

// supportiing function below

void printTree(TreeNode *root)
{
  if (root == nullptr)
  {
    printf("# ");
    return;
  }
  printf("%d ", root->val);

  printTree(root->left);
  printTree(root->right);
}

void printTree_level_order(TreeNode *root)
{
  queue<TreeNode*> q;
  q.push(root);
  while (q.size() > 0)
  {
    TreeNode* n = q.front();
    q.pop();
    if (n == nullptr)
    {
      cout << "# ";
      continue;
    }
    cout << n->val << " ";
    q.push(n->left);
    q.push(n->right);
  }
  cout << endl;
}

TreeNode* createTree(int a[], int n)
{
  if (n <= 0) return nullptr;

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
    cout << "]" << endl;;
  }
}

int main()
{
  TreeNode *p;
  vector< vector<int> > vv;

  int a[] = { 1, 2, 3, 4, 5, 0, 0 };
  p = createTree(a, sizeof(a) / sizeof(int));
  printTree_level_order(p);
  vv = levelOrder(p);
  printMatrix(vv);
  cout << endl;

  int b[] = { 1, 0, 2 };
  p = createTree(b, sizeof(b) / sizeof(int));
  printTree_level_order(p);
  vv = levelOrder(p);
  printMatrix(vv);
  cout << endl;

  int c[] = { 1, 2, 0, 3, 0, 4, 0, 5 };
  p = createTree(c, sizeof(c) / sizeof(int));
  printTree_level_order(p);
  vv = levelOrder(p);
  printMatrix(vv);
  cout << endl;

  int d[] = { 1, 2, 3, 4, 0, 0, 5 };
  p = createTree(d, sizeof(d) / sizeof(int));
  printTree_level_order(p);
  vv = levelOrder(p);
  printMatrix(vv);
  cout << endl;

  system("pause");

  return 0;
}

