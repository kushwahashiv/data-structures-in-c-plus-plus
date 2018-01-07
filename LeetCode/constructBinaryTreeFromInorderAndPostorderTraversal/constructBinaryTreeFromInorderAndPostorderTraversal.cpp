// Source : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-10

/*
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
*/

#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
  return create(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1);
}

TreeNode* create(vector<int> &inorder, vector<int> &postorder, int is, int ie, int ps, int pe) {
  if (ps > pe) {
    return nullptr;
  }
  TreeNode* node = new TreeNode(postorder[pe]);
  int pos;
  for (int i = is; i <= ie; i++) {
    if (inorder[i] == node->val) {
      pos = i;
      break;
    }
  }
  node->left = create(inorder, postorder, is, pos - 1, ps, ps + pos - is - 1);
  node->right = create(inorder, postorder, pos + 1, ie, pe - ie + pos, pe - 1);
  return node;
}

// SF
void printTree_pre_order(TreeNode *root)
{
  if (root == nullptr) {
    printf("# ");
    return;
  }
  printf("%c ", root->val);

  printTree_pre_order(root->left);
  printTree_pre_order(root->right);
}

void printTree_in_order(TreeNode *root)
{
  if (root == nullptr) {
    printf("# ");
    return;
  }

  printTree_in_order(root->left);
  printf("%c ", root->val);
  printTree_in_order(root->right);
}


void printTree_level_order(TreeNode *root)
{
  queue<TreeNode*> q;
  q.push(root);
  while (q.size() > 0) {
    TreeNode* n = q.front();
    q.pop();
    if (n == nullptr) {
      printf("# ");
      continue;
    }
    printf("%c ", n->val);
    q.push(n->left);
    q.push(n->right);
  }
  printf("\n");
}


int main()
{
  int   in_order[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
  int post_order[] = { 'A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F' };
  vector<int>   inorder(in_order, in_order + 9);
  vector<int> postorder(post_order, post_order + 9);

  TreeNode* tree = buildTree(inorder, postorder);

  printTree_level_order(tree);
  printTree_pre_order(tree);
  printf("\n");
  printTree_in_order(tree);
  printf("\n");

  return 0;
}
