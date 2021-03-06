// Source :https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-21

/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/


#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

vector<int> preorderTraversal(TreeNode *root) {
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
    if (node->right)
      nodeStack.push(node->right);
    if (node->left)
      nodeStack.push(node->left);
  }
  return result;

}


// 2
vector<int> preorderTraversal1(TreeNode *root)
{
  vector<int> v;
  vector<TreeNode*> stack;
  if (root)
  {
    stack.push_back(root);
  }

  while (stack.size() > 0)
  {
    TreeNode* n = stack.back();
    v.push_back(n->val);
    stack.pop_back();
    if (n->right)
    {
      stack.push_back(n->right);
    }

    if (n->left)
    {
      stack.push_back(n->left);
    }
  }
  return v;
}

// 3
vector<int> preorderTraversal2(TreeNode *root)
{
  vector<int> v;
  vector<TreeNode*> stack;
  stack.push_back((TreeNode*)nullptr);
  TreeNode *top = root;
  while (top != nullptr)
  {
    v.push_back(top->val);
    if (top->right != nullptr)
    {
      stack.push_back(top->right);
    }

    if (top->left != nullptr)
    {
      stack.push_back(top->left);
    }

    top = stack.back();
    stack.pop_back();
  }
  return v;
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

void printTree_pre_order(TreeNode *root)
{
  if (root == nullptr)
  {
    cout << "# ";
    return;
  }
  cout << root->val << " ";
  printTree_pre_order(root->left);
  printTree_pre_order(root->right);
}


void printArray(vector<int> v)
{
  for (int i = 0; i < v.size(); i++)
  {
    cout << v[i] << " ";
  }
  cout << endl;
}

int main()
{
  srand(time(0));
  int a[] = { 1,2,3,4,5,0,6,0,0,7,8,9,0 };
  TreeNode* p = createTree(a, sizeof(a) / sizeof(int));
  printTree_pre_order(p);
  cout << endl;
  vector<int> v = preorderTraversal(p);
  printArray(v);
  cout << endl;

  system("pause");
  return 0;
}

