// Source : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-09

/*
Given preorder and inorder traversal of a tree, construct the binary tree.
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


TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    return create(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
}

TreeNode* create(vector<int>& preorder, vector<int>& inorder, int ps, int pe, int is, int ie){
    if(ps > pe){
        return nullptr;
    }
    TreeNode* node = new TreeNode(preorder[ps]);
    int pos;
    for(int i = is; i <= ie; i++){
        if(inorder[i] == node->val){
            pos = i;
            break;
        }
    }
    node->left = create(preorder, inorder, ps + 1, ps + pos - is, is, pos - 1);
    node->right = create(preorder, inorder, pe - ie + pos + 1, pe, pos + 1, ie);
    return node;
}

// SF
void printTree_pre_order(TreeNode *root)
{
    if (root == nullptr){
        printf("# ");
        return;
    }
    printf("%c ", root->val );

    printTree_pre_order(root->left);
    printTree_pre_order(root->right);
}

void printTree_in_order(TreeNode *root)
{
    if (root == nullptr){
        printf("# ");
        return;
    }

    printTree_in_order(root->left);
    printf("%c ", root->val );
    printTree_in_order(root->right);
}


void printTree_level_order(TreeNode *root)
{
    queue<TreeNode*> q;
    q.push(root);
    while (q.size()>0){
        TreeNode* n = q.front();
        q.pop();
        if (n==nullptr){
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
    int pre_order[]={'F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H'};
    int  in_order[]={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    vector<int> preorder( pre_order, pre_order + 9 );
    vector<int>  inorder(  in_order,  in_order + 9 );

    TreeNode* tree = buildTree(preorder, inorder);

    printTree_level_order(tree);
    printTree_pre_order(tree);
    printf("\n");
    printTree_in_order(tree);
    printf("\n");
    
    return 0;
}
