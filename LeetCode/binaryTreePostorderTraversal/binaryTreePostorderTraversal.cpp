/*
Source : https://leetcode.com/problems/binary-tree-postorder-traversal/description/
Author : Shiv S. Kushwaha
Date   : 2014-07-21

Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

vector<int> postorderTraversal(TreeNode *root) {
  stack<TreeNode*> nodeStack;
  vector<int> result;
  //base case
  if (root == NULL)
    return result;
  nodeStack.push(root);
  while (!nodeStack.empty())
  {
    TreeNode* node = nodeStack.top();
    result.push_back(node->val);
    nodeStack.pop();
    if (node->left)
      nodeStack.push(node->left);
    if (node->right)
      nodeStack.push(node->right);
  }
  reverse(result.begin(), result.end());
  return result;

}

//
vector<int> postorderTraversal1(TreeNode *root)
{
  vector<int> v;
  vector<TreeNode*> stack;
  if (root) {
    stack.push_back(root);
  }
  while (stack.size() > 0)
  {
    TreeNode *n = stack.back();
    stack.pop_back();
    v.push_back(n->val);
    if (n->left)
    {
      stack.push_back(n->left);
    }
    if (n->right)
    {
      stack.push_back(n->right);
    }
  }
  std::reverse(v.begin(), v.end());  // the trick
  return v;
}

// traditional and standard way.
// using the stack to simulate the recursive function stack.
vector<int> postorderTraversal2(TreeNode *root) {
  vector<int> v;
  vector<TreeNode*> stack;
  TreeNode *node = root;
  TreeNode *lastVisitNode = nullptr;
  while (stack.size() > 0 || node != nullptr) {

    if (node != nullptr) {
      // keep going the left
      stack.push_back(node);
      node = node->left;
    }
    else {
      TreeNode *n = stack.back();
      // left way is finsised, keep going to the right way
      if (n->right != nullptr && lastVisitNode != n->right) {
        node = n->right;
      }
      else {
        // both left and right has been accessed.
        stack.pop_back();
        v.push_back(n->val);
        lastVisitNode = n;
      }
    }
  }
  return v;
}

// supporting functions
TreeNode* createTree(int a[], int n)
{
  if (n <= 0) return nullptr;

  TreeNode **tree = new TreeNode*[n];

  for (int i = 0; i < n; i++) {
    if (a[i] == 0) {
      tree[i] = nullptr;
      continue;
    }
    tree[i] = new TreeNode(a[i]);
  }
  int pos = 1;
  for (int i = 0; i < n && pos < n; i++) {
    if (tree[i]) {
      tree[i]->left = tree[pos++];
      if (pos < n) {
        tree[i]->right = tree[pos++];
      }
    }
  }
  return tree[0];
}

void printTree_post_order(TreeNode *root)
{
  if (root == nullptr) {
    cout << "# ";
    return;
  }
  printTree_post_order(root->left);
  printTree_post_order(root->right);
  cout << root->val << " ";
}


void printArray(vector<int> v)
{
  for (int i = 0; i < v.size(); i++) {
    cout << v[i] << " ";
  }
  cout << endl;
}

int main()
{
  srand(time(0));
  int a[] = { 1, 2, 3, 4, 5, 0, 6, 0, 0, 7, 8, 9, 0 };
  TreeNode* p = createTree(a, sizeof(a) / sizeof(int));
  printTree_post_order(p);
  cout << endl;
  vector<int> v = postorderTraversal(p);
  printArray(v);
  cout << endl;

  system("pause");
  return 0;
}
