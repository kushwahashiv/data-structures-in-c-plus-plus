/*
Poblem:
Given a BinarySearchTree and value K, find all value pairs whose sum is K in O(n).
or
Given a binary search tree of n nodes, find two nodes whose sum is equal to a given number k in O(n) time and constant space O(logn) 
*/

#include <iostream>

typedef struct Node
{
  int data;
  struct Node* parent;
  struct Node* left;
  struct Node* right;
} TreeNode;

void insert_into_BST(TreeNode** root, int data)
{
  if (*root == nullptr) 
  {
    *root = new TreeNode();//calloc(1, sizeof(TreeNode));
    (*root)->data = data;
  }
  else {
    TreeNode* trav = *root;
    TreeNode* newNode = new TreeNode(); // (1, sizeof(TreeNode));
    newNode->data = data;
    while (trav != nullptr) {
      if (data < trav->data) {
        if (trav->left == nullptr) {
          newNode->parent = trav;
          trav->left = newNode;
          break;
        }
        trav = trav->left;
      }
      else {
        if (trav->right == nullptr) {
          newNode->parent = trav;
          trav->right = newNode;
          break;
        }
        trav = trav->right;
      }
    }
  }
}

void insert_array_into_BST(TreeNode** root, int* array, int count) {
  int ii = 0;
  for (; ii < count; ii++) {
    insert_into_BST(root, array[ii]);
  }
}

void delete_tree(TreeNode* root) {
  if (root == nullptr)
    return;
  delete_tree(root->left);
  delete_tree(root->right);
  delete root;
}

TreeNode* find_smallest(TreeNode* root) {
  while (root->left) {
    root = root->left;
  }
  return root;
}

TreeNode* find_largest(TreeNode* root) {
  while (root->right) {
    root = root->right;
  }
  return root;
}

TreeNode* find_predecessor(TreeNode* root) {
  if (root->left) {
    root = root->left;
    while (root->right) {
      root = root->right;
    }
    return root;
  }
  else if (root == root->parent->right) {
    return root->parent;
  }
  else {
    while (root == root->parent->left)
      root = root->parent;
    return root->parent;
  }

  return nullptr;
}

TreeNode* find_successor(TreeNode* root) {
  if (root->right) {
    root = root->right;
    while (root->left) {
      root = root->left;
    }
    return root;
  }
  else if (root == root->parent->left) {
    return root->parent;
  }
  else {
    while (root == root->parent->right)
      root = root->parent;
    return root->parent;
  }

  return nullptr;
}

void print_pairs_with_sum(TreeNode* root, int sum) 
{
  TreeNode* smallest = find_smallest(root);
  TreeNode* largest = find_largest(root);

  if (smallest->data + find_successor(smallest)->data > sum || largest->data + find_predecessor(largest)->data < sum) 
  {
    std::cout << "No elements found..." << std::endl;
  }

  while (smallest->data < largest->data) 
  {
    if (sum == (smallest->data + largest->data)) 
    {
      std::cout<< "Sum of node("<< sum<< ") = "<< smallest->data << " and " << largest->data<< std::endl;
    }
    smallest = find_successor(smallest);

    while (smallest->data + largest->data > sum) 
    {
      largest = find_predecessor(largest);
    }
  }

}

int main()
{
  TreeNode* root(nullptr);
  int array[11] = { 10, 7, 3, 8, 1, 4, 12, 11, 16, 14, 19 };
  insert_array_into_BST(&root, array, 11);
  print_pairs_with_sum(root, 16);
  delete_tree(root);

  system("pause");
  return 0;
}
