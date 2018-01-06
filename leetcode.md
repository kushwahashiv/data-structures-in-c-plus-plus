# 3Sum
Problem:
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

For example, given array S = {-1 0 1 2 -1 -4},
A solution set is:
(-1, 0, 1)
(-1, -1, 2)

Simlar like "Two Number" problem, we can have the simlar solution.

Suppose the input array is S[0..n-1], 3SUM can be solved in O(n^2) time on average by
inserting each number S[i] into a hash table, and then for each index i and j,
checking whether the hash table contains the integer - (s[i]+s[j])

Alternatively, the algorithm below first sorts the input array and then tests all
possible pairs in a careful order that avoids the need to binary search for the pairs
in the sorted list, achieving worst-case O(n^n)

Solution:  Quadratic algorithm
http://en.wikipedia.org/wiki/3SUM

```cpp
#include <stdio.h>
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

vector<vector<int> > threeSum(vector<int> &num)
{
  vector< vector<int> > result;
  //sort the array, this is the key
  sort(num.begin(), num.end());

  int n = num.size();

  for (int i = 0; i < n - 2; i++)
  {
    //skip the duplication
    if (i>0 && num[i - 1] == num[i])
      continue;

    int a = num[i];
    int low = i + 1;
    int high = n - 1;
    while (low < high)
    {
      int b = num[low];
      int c = num[high];
      if (a + b + c == 0)
      {
        //got the soultion
        vector<int> v;
        v.push_back(a);
        v.push_back(b);
        v.push_back(c);
        result.push_back(v);

        // Continue search for all triplet combinations summing to zero.
        //skip the duplication
        while (low < n && num[low] == num[low + 1])
          low++;

        while (high > 0 && num[high] == num[high - 1])
          high--;

        low++;
        high--;
      }
      else if (a + b + c > 0)
      {
        //skip the duplication
        while (high > 0 && num[high] == num[high - 1])
          high--;

        high--;
      }
      else
      {
        //skip the duplication
        while (low < n && num[low] == num[low + 1])
          low++;

        low++;
      }
    }
  }
  return result;
}
```

# 3SumClosest

Problem:
Given an array S of n integers, find three integers in S such that the sum is
closest to a given number, target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

solution:  http://en.wikipedia.org/wiki/3SUM
The idea as blow:
1. sort the array.
2. take the element one by one, calculate the two numbers in reset array.

notes: be careful the duplication number.
for example:
[-4,-1,-1,1,2]    target=1

take -4, can cacluate the "two number problem" of the reset array [-1,-1,1,2] while target=5
[(-4),-1,-1,1,2]  target=5  distance=4
^      ^
because the -1+2 = 1 which < 5, then move the `low` pointer(skip the duplication)
[(-4),-1,-1,1,2]  target=5  distance=2
^ ^
take -1(skip the duplication), can cacluate the "two number problem" of the reset array [1,2] while target=2
[-4,-1,(-1),1,2]  target=2  distance=1
^ ^

```cpp
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

#define INT_MAX 2147483647


int threeSumClosest(vector<int> &num, int target)
{
  //sort the array
  sort(num.begin(), num.end());

  int n = num.size();
  int distance = INT_MAX;
  int result;

  for (int i = 0; i < n - 2; i++)
  {
    //skip the duplication
    if (i>0 && num[i - 1] == num[i])
      continue;

    int a = num[i];
    int low = i + 1;
    int high = n - 1;
    //convert the 3sum to 2sum problem
    while (low < high)
    {
      int b = num[low];
      int c = num[high];
      int sum = a + b + c;
      if (sum - target == 0)
      {
        //got the final soultion
        return target;
      }
      else
      {
        //tracking the minmal distance
        if (abs(sum - target) < distance)
        {
          distance = abs(sum - target);
          result = sum;
        }

        if (sum - target > 0)
        {
          //skip the duplication
          while (high > 0 && num[high] == num[high - 1])
            high--;
          //move the `high` pointer
          high--;
        }
        else
        {
          //skip the duplication
          while (low < n && num[low] == num[low + 1])
            low++;
          //move the `low` pointer
          low++;
        }
      }
    }
  }

  return result;
}


int main()
{
  int target = 1;
  vector<int> n = { -1, 2, 1, -4 }; 
  cout << threeSumClosest(n, target) << endl;

  system("pause");
  return 0;
}

```

# 4Sum
Problem:
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in ascending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)

Solution:
1. Sort the array,
2. traverse the array, and solve the problem by using "3Sum" soultion.

```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int> > threeSum(vector<int> num, int target);


vector<vector<int> > fourSum(vector<int> &num, int target)
{
  vector< vector<int> > result;
  if (num.size() < 4) return result;
  sort(num.begin(), num.end());

  for (int i = 0; i < num.size() - 3; i++)
  {
    //skip the duplication
    if (i>0 && num[i - 1] == num[i])
      continue;

    vector<int> n(num.begin() + i + 1, num.end());
    vector<vector<int> > ret = threeSum(n, target - num[i]);

    for (int j = 0; j < ret.size(); j++)
    {
      ret[j].insert(ret[j].begin(), num[i]);
      result.push_back(ret[j]);
    }
  }

  return result;
}

vector<vector<int> > threeSum(vector<int> num, int target)
{
  vector< vector<int> > result;
  //sort the array (if the qrray is sorted already, it won't waste any time)
  sort(num.begin(), num.end());

  int n = num.size();

  for (int i = 0; i < n - 2; i++)
  {
    //skip the duplication
    if (i>0 && num[i - 1] == num[i])
      continue;
    int a = num[i];
    int low = i + 1;
    int high = n - 1;

    while (low < high)
    {
      int b = num[low];
      int c = num[high];
      if (a + b + c == target)
      {
        //got the soultion
        vector<int> v;
        v.push_back(a);
        v.push_back(b);
        v.push_back(c);
        result.push_back(v);
        // Continue search for all triplet combinations summing to zero.
        //skip the duplication
        while (low < n && num[low] == num[low + 1])
          low++;
        while (high > 0 && num[high] == num[high - 1])
          high--;

        low++;
        high--;
      }
      else if (a + b + c > target)
      {
        //skip the duplication
        while (high > 0 && num[high] == num[high - 1])
          high--;

        high--;
      }
      else{
        //skip the duplication
        while (low < n && num[low] == num[low + 1])
          low++;

        low++;
      }
    }
  }
  return result;
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
  vector<int> n = { 1, 0, -1, 0, -2, 2 };
  int t = 0;
  vector< vector<int> > v = fourSum(n, t);
  printMatrix(v);

  n.clear();
  int b[] = { -1, -5, -5, -3, 2, 5, 0, 4 };
  n.insert(n.begin(), b, b + 8);
  t = -7;

  v = fourSum(n, t);
  printMatrix(v);

  system("pause");

  return 0;
}

```

# addBinary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

```cpp
#include <iostream>
#include <string>
using namespace std;

string addBinary(string a, string b)
{
  int alen = a.size();
  int blen = b.size();
  bool carry = false;
  string result;

  while (alen > 0 || blen > 0)
  {
    int abit = alen <= 0 ? 0 : a[alen - 1] - '0';
    int bbit = blen <= 0 ? 0 : b[blen - 1] - '0';
    int cbit = carry ? 1 : 0;

    result.insert(result.begin(), '0' + ((abit + bbit + cbit) & 1));
    carry = (abit + bbit + cbit > 1);
    alen--; blen--;
  }

  if (carry)
  {
    result.insert(result.begin(), '1');
  }

  return result;
}


int main(int argc, char** argv)
{
  string a = "11";
  string b = "1";

  if (argc > 2)
  {
    a = argv[1];
    b = argv[2];
  }

  cout << a << "+" << b << "=" << addBinary(a, b) << endl;

  system("pause");

  return 0;
}

```

# addTwoNumbers
Problem:
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


// Definition for singly-linked list.
struct ListNode {
int val;
ListNode *next;
ListNode(int x) : val(x), next(nullptr) {}
};

```cpp
#include <iostream>
#include <string>
using namespace std;


struct Node
{
  int val;
  Node *next;
};


class Solution
{
public:
  Node *addTwoNumbers(Node *l1, Node *l2)
  {
    int x = 0, y = 0, carry = 0, sum = 0;
    Node *h = nullptr, **t = &h;

    while (l1 != nullptr || l2 != nullptr)
    {
      x = getValueAndMoveNext(l1);
      y = getValueAndMoveNext(l2);

      sum = carry + x + y;

      Node *node = new Node();
      node->val = sum % 10;

      *t = node;
      t = (&node->next);

      carry = sum / 10;
    }

    if (carry > 0)
    {
      Node *node = new Node();
      node->val = carry % 10;

      *t = node;
    }
    return h;
  }

private:
  int getValueAndMoveNext(Node* &l)
  {
    int x(0);
    if (l != nullptr)
    {
      x = l->val;
      l = l->next;
    }
    return x;
  }
};


int main()
{
  //Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  //Output : 7 -> 0 -> 8
  Solution obj;

  Node* newNode;

  Node* a = new Node();
  a->val = 2;
  newNode = new Node();
  newNode->val = 4;
  a->next = newNode;
  newNode = new Node();
  newNode->val = 3;
  a->next->next = newNode;

  Node* b = new Node();
  b->val = 5;
  newNode = new Node();
  newNode->val = 6;
  b->next = newNode;
  newNode = new Node();
  newNode->val = 4;
  b->next->next = newNode;

  Node* c = obj.addTwoNumbers(a, b);
  while (c != nullptr)
  {
    std::cout << c->val;
    c = c->next;
  }

  return 0;
}
```

# anagrams
Problem:
Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.

```cpp
#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<string>

using namespace std;


vector<string> anagrams(vector<string> &strs)
{
  vector<string> result;
  map<string, int> m;

  for (int i = 0; i < strs.size(); i++)
  {
    string word = strs[i];
    //sort it can easy to check they are anagrams or not
    sort(word.begin(), word.end());

    if (m.find(word) == m.end())
    {
      m[word] = i;
    }
    else
    {
      if (m[word] >= 0)
      {
        result.push_back(strs[m[word]]);
        m[word] = -1;
      }
      result.push_back(strs[i]);
    }
  }
  return result;
}


int main()
{
  std::vector<string>  words = { "hello", "world", "hi", "world" };
  auto result = anagrams(words);

  for (std::string item : result)
  {
    std::cout << item <<std::endl;
  }

  system("pause");
  return 0;
}
```

# balancedBinaryTree
Problem:
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than 1.
```cpp
#include <iostream>
#include <string>
#include <math.h>

using namespace std;


struct Node
{
  int val;
  Node *left;
  Node *right;
  Node(int x) : val(x), left(nullptr), right(nullptr) {}
};


int treeDepth(Node *root)
{
  if (root == nullptr)
  {
    return 0;
  }

  int left = 1, right = 1;

  left += treeDepth(root->left);
  right += treeDepth(root->right);

  return left > right ? left : right;
}

bool isBalanced(Node *root)
{
  if (root == nullptr)
    return true;

  int left = treeDepth(root->left);
  int right = treeDepth(root->right);

  if (std::abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right))
    return true;

  return false;
}

int main()
{
  Node* root = new Node(1);
  root->left = new Node(2);
  root->right = new Node(3);
  root->left->left = new Node(4);
  root->left->right = new Node(5);
  //root->left->left->left = new Node(8);

  if (isBalanced(root))
    std::cout << "Tree is balanced" << std::endl;
  else
    std::cout << "Tree is not balanced" << std::endl;

  system("pause");
  return 0;
}
```

# bestTimeToBuyAndSellStock
Problem:
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Solution:
This solution is O(1) space dynamic programming

We can make sure the max profit at least be ZERO. So,
1) we have two pointers (begin & end )
2) if prices[end] - prices[begin] >  0, then move the "end" pointer to next
3) if prices[end] - prices[begin] <= 0, then move the "begin" pointer to current posstion.
4) tracking the max profit

Notes:
Some people think find the highest-price & lowest-price, this is wrong.
Because the highest-price must be after lowest-price

```cpp
#include <iostream>
#include <vector>
using namespace std;

struct Node
{
  int val;
  Node *left;
  Node *right;
  Node(int x) : val(x), left(nullptr), right(nullptr) {}
};


int maxProfit(vector<int> &prices)
{
  int max = 0, begin = 0, end = 0, delta = 0;
  for (int i = 0; i < prices.size(); i++)
  {
    end = i;
    delta = prices[end] - prices[begin];
    if (delta <= 0)
    {
      begin = i;
    }
    if (delta > max)
    {
      max = delta;
    }
  }
  return max;
}


extern int maxProfit2(vector<int> &prices);
extern int maxProfit3(vector<int> &prices);

int main()
{
  std::vector<int> prices = {22, 32, 45, 31, 55, 21, 10, 19};
  std::cout<< maxProfit(prices) <<std::endl;
  std::cout << maxProfit2(prices) << std::endl;
  std::cout << maxProfit3(prices) << std::endl;

  system("pause");

  return 0;
}
```

# binaryTreeInorderTraversal

Problem:
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

1
\
2
/
3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies
a path terminator where no node exists below.

Here's an example:

 1
/ \
2   3
/
4
\
5

The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

```cpp
#include <iostream>
#include <vector>
using namespace std;

struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};


vector<int> inorderTraversal(TreeNode *root)
{
  vector<TreeNode*> stack;
  vector<int> v;

  while (stack.size() > 0 || root != nullptr)
  {
    if (root != nullptr)
    {
      stack.push_back(root);
      root = root->left;
    }
    else
    {
      if (stack.size() > 0)
      {
        root = stack.back();
        stack.pop_back();
        v.push_back(root->val);
        root = root->right;
      }
    }
  }
  return v;
}


int main()
{
  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(2);
  root->right = new TreeNode(3);
  root->left->left = new TreeNode(4);
  root->left->right = new TreeNode(5);
  root->left->left->left = new TreeNode(8);

  auto result =  inorderTraversal(root);
  for (auto item : result)
  {
    std::cout << item << ", ";
  }


  system("pause");

  return 0;
}
```

# binaryTreeLevelOrderTraversal
Problem:
Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
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

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies
a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5

The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

```cpp
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

vector<vector<int> > levelOrder1(TreeNode *root);
vector<vector<int> > levelOrder2(TreeNode *root);


vector<vector<int> > levelOrder(TreeNode *root)
{
  if (rand() % 2)
  {
    return levelOrder1(root);
  }
  return levelOrder2(root);
}

vector<vector<int> > levelOrder1(TreeNode *root)
{
  queue<TreeNode*> q;
  vector< vector<int> > vv;
  vector<int> v;
  if (root)
  {
    v.push_back(root->val);
    vv.push_back(v);
  }

  q.push(root);
  int i = 0;
  vector<TreeNode*> vt;

  while (q.size() > 0)
  {
    TreeNode *p = q.front();
    q.pop();
    vt.push_back(p);
    if (p == nullptr)
    {
      continue;
    }
    q.push(p->left);
    q.push(p->right);
  }

  int step = 2;
  int j;
  for (int i = 1; i < vt.size(); i = j)
  {
    v.clear();

    int cnt = 0;
    for (j = i; j < i + step && j < vt.size(); j++)
    {
      if (vt[j])
      {
        v.push_back(vt[j]->val);
        cnt += 2;
      }
    }
    step = cnt;
    if (v.size() > 0)
    {
      vv.push_back(v);
    }
  }

  return vv;
}

vector<vector<int> > levelOrder2(TreeNode *root)
{
  vector< vector<int> > vv;
  vector<int> v;
  if (root)
  {
    v.push_back(root->val);
    vv.push_back(v);
  }

  vector< vector<int> > vv_left, vv_right;
  if (root && root->left)
  {
    vv_left = levelOrder2(root->left);
  }
  if (root && root->right)
  {
    vv_right = levelOrder2(root->right);
  }

  //merge
  for (int i = 0; i < vv_left.size() || i < vv_right.size(); i++)
  {
    if (i < vv_left.size() && i < vv_right.size())
    {
      vv_left[i].insert(vv_left[i].end(), vv_right[i].begin(), vv_right[i].end());
      vv.push_back(vv_left[i]);
    }
    else if (i < vv_left.size())
    {
      vv.push_back(vv_left[i]);
    }
    else
    {
      vv.push_back(vv_right[i]);
    }
  }

  return vv;
}

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

```

# binaryTreeMaximumPathSum

Problem:
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.

For example:
Given the below binary tree,

  1
 / \
2   3

Return 6.

```cpp
#include <iostream>
#include <algorithm>
using namespace std;


struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

int maxPathSum(TreeNode *root, int& maxSum)
{
  if (nullptr == root)
    return 0;

  //get the maxPathSum for both left and right branch
  int left = maxPathSum(root->left, maxSum);
  int right = maxPathSum(root->right, maxSum);

  // The max sum could be one of the following situations:
  //    1) root + left
  //    2) root + right
  //    3) root
  //    4) root + left + right   
  //
  // And the whole function need to return the the max of 1) 2) 3) 
  int val = root->val;
  int maxBranch = left > right ? max(left + val, val) : max(right + val, val);
  int m = max(left + right + val, maxBranch);

  maxSum = max(maxSum, m);

  return maxBranch;
}

int maxPathSum(TreeNode *root)
{
#define INT_MIN     (-2147483647 - 1)
  int maxSum = INT_MIN;
  maxPathSum(root, maxSum);
  return maxSum;
}

int main()
{
  TreeNode root(1);
  TreeNode left(2);
  TreeNode right(3);
  root.left = &left;
  root.right = &right;
  cout << maxPathSum(&root) << endl;
  return 0;
}
```

# binaryTreePostorderTraversal

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

     1
   /  \
  #     2
 / \   / \
#   # 3   #

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

```cpp
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
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

vector<int> postorderTraversal1(TreeNode *root);
vector<int> postorderTraversal2(TreeNode *root);


// We have two methods here.
//   1) the first one acutally is pre-order but reversed the access order.
//   2) the second one is the traditional one 

vector<int> postorderTraversal(TreeNode *root)
{
  if (rand() % 3){
    cout << "---method one---" << endl;
    return postorderTraversal1(root);
  }
  cout << "---method two---" << endl;
  return postorderTraversal2(root);
}


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
  while (stack.size() > 0 || node != nullptr){

    if (node != nullptr){
      // keep going the left
      stack.push_back(node);
      node = node->left;
    }
    else{
      TreeNode *n = stack.back();
      // left way is finsised, keep going to the right way
      if (n->right != nullptr && lastVisitNode != n->right){
        node = n->right;
      }
      else{
        // both left and right has been accessed.
        stack.pop_back();
        v.push_back(n->val);
        lastVisitNode = n;
      }
    }
  }
  return v;
}


TreeNode* createTree(int a[], int n)
{
  if (n <= 0) return nullptr;

  TreeNode **tree = new TreeNode*[n];

  for (int i = 0; i < n; i++) {
    if (a[i] == 0){
      tree[i] = nullptr;
      continue;
    }
    tree[i] = new TreeNode(a[i]);
  }
  int pos = 1;
  for (int i = 0; i < n && pos < n; i++) {
    if (tree[i]){
      tree[i]->left = tree[pos++];
      if (pos < n){
        tree[i]->right = tree[pos++];
      }
    }
  }
  return tree[0];
}

void printTree_post_order(TreeNode *root)
{
  if (root == nullptr){
    cout << "# ";
    return;
  }
  printTree_post_order(root->left);
  printTree_post_order(root->right);
  cout << root->val << " ";
}


void printArray(vector<int> v)
{
  for (int i = 0; i < v.size(); i++){
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

```

# binaryTreePreorderTraversal
 Given a binary tree, return the preorder traversal of its nodes' values.
 For example:
 Given binary tree {1,#,2,3},
    1
     \
      2
     /
    3
 return [1,2,3].
 Note: Recursive solution is trivial, could you do it iteratively?
```cpp
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

vector<int> preorderTraversal1(TreeNode *root);
vector<int> preorderTraversal2(TreeNode *root);

vector<int> preorderTraversal(TreeNode *root) 
{
    //if (rand()%2)
    {
        cout << "---method one---" << endl;
        return preorderTraversal1(root);
    }

    cout << "---method two---" << endl;
    return preorderTraversal2(root);
}

vector<int> preorderTraversal1(TreeNode *root) 
{
    vector<int> v;
    vector<TreeNode*> stack;
    if (root) 
    {
        stack.push_back(root);
    }

    while (stack.size()>0)
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

vector<int> preorderTraversal2(TreeNode *root)
{
    vector<int> v;
    vector<TreeNode*> stack;
    stack.push_back((TreeNode*)nullptr);
    TreeNode *top = root;
    while(top!=nullptr)
    {
        v.push_back(top->val);
        if (top->right !=nullptr)
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

TreeNode* createTree(int a[], int n)
{
    if (n<=0) 
      return nullptr;

    TreeNode **tree = new TreeNode*[n];

    for(int i=0; i<n; i++) 
    {
        if (a[i]==0 )
        {
            tree[i] = nullptr;
            continue;
        }
        tree[i] = new TreeNode(a[i]);
    }

    int pos=1;
    for(int i=0; i<n && pos<n; i++) 
    {
        if (tree[i])
        {
            tree[i]->left = tree[pos++];
            if (pos<n)
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
        return ;
    }
    cout << root->val << " ";
    printTree_pre_order(root->left);
    printTree_pre_order(root->right);
}


void printArray(vector<int> v)
{
    for(int i=0; i<v.size(); i++)
    {
        cout << v[i] << " ";
    }
    cout << endl;
}

int main()
{
    srand(time(0));
    int a[] = {1,2,3,4,5,0,6,0,0,7,8,9,0};
    TreeNode* p = createTree(a, sizeof(a)/sizeof(int));
    printTree_pre_order(p);
    cout << endl;
    vector<int> v = preorderTraversal(p);
    printArray(v);
    cout << endl;

    system("pause");
    return 0;
}
```

# binaryTreeUpsideDown

Given a binary tree where all the right nodes are either leaf nodes with
a sibling (a left node that shares the same parent node) or empty,

Flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

```cpp
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <vector>
using namespace std;

struct TreeNode
{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};


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

void printArray(vector<int> v)
{
  for (int i = 0; i < v.size(); i++)
  {
    cout << v[i] << " ";
  }
  cout << endl;
}


TreeNode* upsideDownBinaryTree(TreeNode* root)
{
  //using a dummy node to help to store the new tree
  TreeNode dummy(0);
  TreeNode *head = &dummy, *left(nullptr), *right(nullptr);

  while (root != nullptr)
  {
    //find the right & left
    left = root->right;
    right = root;

    //move root the next
    root = root->left;

    //replace the right with current root
    right->left = head->left;
    right->right = head->right;

    //move the dummy to the root
    dummy.right = right;
    dummy.left = left;

    //reset the head to the root
    head = &dummy;
  }

  return head->right;
}

void printTree_pre_order(TreeNode *root)
{
  if (root == nullptr){
    cout << "# ";
    return;
  }
  cout << root->val << " ";
  printTree_pre_order(root->left);
  printTree_pre_order(root->right);
}


int main()
{
  int a[] = { 1, 2, 3, 4, 5, 0, 6, 0, 0, 7, 8, 9, 0 };
  TreeNode* p = createTree(a, sizeof(a) / sizeof(int));

  printTree_pre_order(upsideDownBinaryTree(p));
  cout << endl;

  return 0;
}

```

# binaryTreeZigzagLevelOrderTraversal

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
```cpp
#include <stdio.h>
#include <stdlib.h>
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

vector<TreeNode*> TreeToArray_level_order(TreeNode* root);

vector<vector<int> > zigzagLevelOrder(TreeNode *root)
{
  vector<vector<int> > result;
  vector<TreeNode*> tree = TreeToArray_level_order(root);

  int curLevelCnt = 1;
  int nextLevelCnt = 1;
  int level = 0;

  for (int i = 0; i < tree.size(); i += curLevelCnt)
  {
    int cnt = 0;
    level++;
    vector<int> v;
    if (level % 2 == 0)
    {
      for (int j = i + nextLevelCnt - 1; j >= i; j--)
      {
        if (tree[j])
        {
          cnt += 2;
          v.push_back(tree[j]->val);
        }
      }
    }
    else
    {
      for (int j = i; j < i + nextLevelCnt; j++)
      {
        if (tree[j])
        {
          cnt += 2;
          v.push_back(tree[j]->val);
        }
      }
    }
    curLevelCnt = nextLevelCnt;
    nextLevelCnt = cnt;
    if (v.size()>0)
    {
      result.push_back(v);
    }
  }
  return result;
}

vector<TreeNode*> TreeToArray_level_order(TreeNode* root)
{
  vector <TreeNode*> result;
  queue<TreeNode*> q;
  q.push(root);
  while (q.size() > 0)
  {
    TreeNode* n = q.front();
    q.pop();
    result.push_back(n);
    if (n == nullptr)
    {
      //   cout << "# ";
      continue;
    }
    //cout << n->val << " ";
    q.push(n->left);
    q.push(n->right);
  }
  //cout << endl;
  return result;
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
```

# candy
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Solution:
The soluiton is O(2n) run-time complexity
For example:
    ratings[] = { 5, 6, 7, 4, 1, 2, 3, 2, 1, 7 }

1) Go through the ratings from left to right.
   Find the each increasing sub-array, giving the minimal candy
    ratings[] = { 5, 6, 7,   4,   1, 2, 3,   2,   1, 7 }
      candy[] = { 1, 2, 3,   1,   1, 2, 3,   1,   1, 2 }

2) Go through the ratings from right to left.
         ratings[] = { 5,   6,   7, 4, 1,   2,   3, 2, 1,   7 }
      prev_candy[] = { 1,   2,   3, 1, 1,   2,   3, 1, 1,   2 }
           candy[] = { 1,   2,   3, 2, 1,   2,   3, 2, 1,   2 }

3) total candy is 19

```cpp
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <vector>
using namespace std;


void print(vector<int> &v);


int candy(vector<int> &ratings)
{

  vector<int> candyCnt(ratings.size());
  //allocate candies, considering the minimal rating on the left

  candyCnt[0] = 1;
  for (int i = 1; i < ratings.size(); i++)
  {
    candyCnt[i] = ratings[i] > ratings[i - 1] ? candyCnt[i - 1] + 1 : 1;
  }

  print(candyCnt);
  //modify the allocation, considering the minimal rating on the right
  int totalCandy = candyCnt[ratings.size() - 1];

  for (int i = ratings.size() - 2; i >= 0; i--)
  {
    candyCnt[i] = (ratings[i] > ratings[i + 1] && candyCnt[i + 1] + 1 > candyCnt[i]) ? candyCnt[i + 1] + 1 : candyCnt[i];
    //count total candies by the way
    totalCandy += candyCnt[i];
  }
  print(candyCnt);
  return totalCandy;
}

void generateRatings(vector<int> &ratings, int n)
{
  srand(time(0));
  for (int i = 0; i < n; i++)
  {
    ratings.push_back(rand() % 10);
  }
}

void print(vector<int> &v)
{
  for (int i = 0; i < v.size(); i++)
  {
    cout << v[i] << " ";
  }
  cout << endl;
}

int main(int argc, char**argv)
{
  int n = 10;
  if (argc > 1)
  {
    n = atoi(argv[1]);
  }
  vector<int> ratings;
  generateRatings(ratings, n);
  print(ratings);

  cout << candy(ratings) << endl;

  cout << "--------------------" << endl;
    int myints[] = { 5, 6, 7, 4, 1, 2, 3, 2, 1, 7};
    std::vector<int> ra (myints, myints + sizeof(myints) / sizeof(int) );
  print(ra);
  cout << candy(ra) << endl;

  system("pause");
  return 0;
}
```

# climbStairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

```cpp
#include<iostream>


int climbStairs(int n)
{
  if (n <= 3) 
    return n;
  int a[2] = { 2, 3 };

  for (int i = 4; i <= n; i++)
  {
    int t = a[0] + a[1];
    a[0] = a[1];
    a[1] = t;
  }
  return a[1];
}

//Time too long
int climbStairs2(int n)
{
  if (n <= 3) 
    return n;
  return climbStairs(n - 1) + climbStairs(n - 2);
}

int main(int argc, char** argv)
{

std::cout<< climbStairs2(5) <<std::endl;

  system("pause");

  return 0;
}
```

# cloneGraph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

Example:
consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:
       1
      / \
     /   \
    0 --- 2
         / \
         \_/
```cpp
#include<iostream>
#include<vector>
#include<map>
#include<queue>

using namespace std;

//Definition for undirected graph.
struct UndirectedGraphNode
{
  int label;
  vector<UndirectedGraphNode *> neighbors;
  UndirectedGraphNode(int x) : label(x) {};
};

UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node)
{
  if (node == nullptr)
    return nullptr;

  //create a map, key is source node, value is clone node.
  map<UndirectedGraphNode*, UndirectedGraphNode*> cloneMap;

  //using queue for breadth first search
  queue<UndirectedGraphNode*> q;
  q.push(node);

  //clone the root
  UndirectedGraphNode* cloneNode = new UndirectedGraphNode(node->label);
  cloneMap[node] = cloneNode;

  //breadth first search
  while (!q.empty())
  {
    UndirectedGraphNode* n = q.front();
    q.pop();
    //for each neighbors
    for (int i = 0; i < n->neighbors.size(); i++)
    {
      UndirectedGraphNode* neighbor = n->neighbors[i];
      //not existed in cloneMap
      if (cloneMap.find(neighbor) == cloneMap.end())
      {
        //clone a node
        UndirectedGraphNode* newNode = new UndirectedGraphNode(neighbor->label);
        cloneMap[n]->neighbors.push_back(newNode);
        cloneMap[neighbor] = newNode;

        //put the neighbors into the queue
        q.push(neighbor);
      }
      else
      {
        cloneMap[n]->neighbors.push_back(cloneMap[neighbor]);
      }
    }
  }

  return cloneNode;
}


int main()
{
  //todo create a sample data
  UndirectedGraphNode *node(nullptr);
  UndirectedGraphNode *result = cloneGraph(node);

  system("pause");
  return 0;
}
```

# combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 For example,
 If n = 4 and k = 2, a solution is:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
```cpp
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void getCombination(int n, int k, vector<int>& solution, vector< vector<int> >& result);
vector<vector<int> > combine1(int n, int k);
vector<vector<int> > combine2(int n, int k);

vector<vector<int> > combine(int n, int k)
{
  if (rand() % 2)
  {
    cout << "recusive method!" << endl;
    return combine1(n, k);
  }
  cout << "non-recusive method!" << endl;
  return combine2(n, k);
}

vector<vector<int> > combine1(int n, int k)
{
  vector<vector<int> > result;
  vector<int> solution;

  getCombination(n, k, solution, result);
  return result;
}

void getCombination(int n, int k, vector<int>& solution, vector< vector<int> >& result)
{
  if (k == 0)
  {
    //sort to meet LeetCode requirement
    vector<int> v = solution;
    sort(v.begin(), v.end());
    result.push_back(v);
    return;
  }
  for (int i = n; i > 0; i--)
  {
    solution.push_back(i);
    getCombination(i - 1, k - 1, solution, result);
    solution.pop_back();
  }
}

vector<vector<int> > combine2(int n, int k)
{

  vector<vector<int> > result;
  vector<int> d;
  for (int i = 0; i < n; i++)
  {
    d.push_back((i < k) ? 1 : 0);
  }

  //1) from the left, find the [1,0] pattern, change it to [0,1]
  //2) move all of the 1 before the pattern to the most left side
  //3) check all of 1 move to the right
  while (1)
  {
    vector<int> v;
    for (int x = 0; x < n; x++)
    {
      if (d[x]) v.push_back(x + 1);
    }
    result.push_back(v);
    //step 1), find [1,0] pattern
    int i;
    bool found = false;
    int ones = 0;
    for (i = 0; i < n - 1; i++)
    {
      if (d[i] == 1 && d[i + 1] == 0)
      {
        d[i] = 0; d[i + 1] = 1;
        found = true;
        //step 2) move all of right 1 to the most left side
        for (int j = 0; j < i; j++)
        {
          d[j] = (ones > 0) ? 1 : 0;
          ones--;
        }
        break;
      }
      if (d[i] == 1) 
        ones++;
    }

    if (!found)
    {
      break;
    }

  }
  return result;

}

void printResult(vector<vector<int> >& result)
{
  for (int i = 0; i < result.size(); i++)
  {
    cout << "[";
    for (int j = 0; j < result[i].size(); j++)
    {
      cout << " " << result[i][j];
    }
    cout << " ]" << endl;
  }
}

int main()
{
  srand(time(nullptr));

  int n = 4, k = 2;
  vector<vector<int> > r = combine(n, k);
  printResult(r);

  system("pause");

  return 0;
}

```

# combinationSum
 Problem:
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations
 in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.
 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.

 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


void combinationSumHelper(vector<int> &candidates, int start, int target, vector<int> &solution, vector< vector<int> > &result)
{
  if (target < 0)
  {
    return;
  }
  if (target == 0)
  {
    result.push_back(solution);
  }
  for (int i = start; i<candidates.size(); i++)
  {
    //remote duplicates
    if (i>start && candidates[i] == candidates[i - 1])
    {
      continue;
    }
    solution.push_back(candidates[i]);
    combinationSumHelper(candidates, i, target - candidates[i], solution, result);
    solution.pop_back();
  }
}

vector<vector<int> > combinationSum(vector<int> &candidates, int target)
{
  vector< vector<int> > result;
  if (candidates.size() <= 0)
  {
    return result;
  }
  sort(candidates.begin(), candidates.end());

  vector<int> solution;
  combinationSumHelper(candidates, 0, target, solution, result);

  return result;
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

void printArray(vector<int> &v)
{
  cout << "{";
  for (int i = 0; i < v.size(); i++)
  {
    cout << " " << v[i];
  }
  cout << "}" << endl;
}


int main(int argc, char** argv)
{
  int a[] = { 4, 2, 3, 3, 5, 7 };
  vector<int> v(a, a + sizeof(a) / sizeof(int));
  int target = 7;
  cout << "array  = ";
  printArray(v);
  cout << "target = " << target << endl;

  vector< vector<int> > vv = combinationSum(v, target);
  printMatrix(vv);

  system("pause");
  return 0;
}
``` 

# constructBinaryTreeFromInorderAndPostorderTraversal
Given inorder and postorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.
```cpp
#include <stdio.h>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode *buildTree(vector<int> &inorder, int in_offset, vector<int> &postorder, int post_offset, int n );

TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
    return buildTree(inorder, 0, postorder, 0, postorder.size());
}

// n - how many number,  offset - start from where?
TreeNode *buildTree(vector<int> &inorder, int in_offset, vector<int> &postorder, int post_offset, int n ) {

    if ( n<=0 || postorder.size()<=0 || inorder.size()<=0 ) return nullptr;

    TreeNode *root = new TreeNode(postorder[post_offset+n-1]);
    if ( n==1 ){
        return root;
    }

    //searching in inorder -- can be optimized by using <map>
    int i;
    for(i=in_offset; i<in_offset+n; i++){
        if (inorder[i] == postorder[post_offset+n-1]){
            break;
        }
    }

    //error: not found
    if (i == inorder.size()) return nullptr;

    int left_n = i - in_offset;
    int right_n = in_offset + n - i - 1;
    root->left = buildTree(inorder, in_offset, postorder, post_offset, left_n );
    root->right = buildTree(inorder, i+1, postorder, post_offset+left_n, right_n);

    return root;
}

//cause the problem: memory limited error
TreeNode *buildTree2(vector<int> &inorder, vector<int> &postorder) {
    
    if (postorder.size()<=0 || inorder.size()<=0 ) return nullptr;

    int post_n = postorder.size();
    TreeNode *root = new TreeNode(postorder[post_n-1]);
    if ( inorder.size()==1 && postorder.size()==1 ){
        return root;
    }

    //searching in inorder -- can be optimized by using <map>
    int i;
    for(i=0; i<inorder.size(); i++){
        if (inorder[i] == postorder[post_n-1]){
            break;
        }
    }

    //error: not found
    if (i == inorder.size()) return nullptr;

    
    vector<int>   in(inorder.begin(), inorder.begin()+i);
    vector<int> post(postorder.begin(), postorder.begin()+i);
    if (in.size()>0) {
        root->left = buildTree(in, post);
    }

    in.clear();
    in.assign(inorder.begin()+i+1, inorder.end());
    post.clear();
    post.assign(postorder.begin()+i, postorder.end()-1);
    if (in.size()>0) {
        root->right = buildTree(in, post);
    }

    return root;
}

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
    int   in_order[]={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    int post_order[]={'A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F'};
    vector<int>   inorder(  in_order,  in_order + 9 );
    vector<int> postorder( post_order, post_order + 9 );

    TreeNode* tree = buildTree(inorder, postorder);

    printTree_level_order(tree);
    printTree_pre_order(tree);
    printf("\n");
    printTree_in_order(tree);
    printf("\n");
    
    return 0;
}

```

# constructBinaryTreeFromPreorderAndInorderTraversal
Given preorder and inorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.

```cpp
#include <stdio.h>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode *buildTree(vector<int>& preorder, int& preidx, vector<int>& inorder);

TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    int preidx=0;
    return buildTree(preorder, preidx, inorder);
}

TreeNode *buildTree(vector<int>& preorder, int& preidx, vector<int>& inorder) {

    if (preorder.size()<=0 || inorder.size()<=0 ) return nullptr;

    TreeNode *root = new TreeNode(preorder[preidx]);
    if (inorder.size()==1){
        return root;
    }

    int i;
    for(i=0; i<inorder.size(); i++){
        if (inorder[i] == preorder[preidx]){
            break;
        }
    }

    //error: not found
    if (i == inorder.size()) return nullptr;

    if (preidx+1 >= preorder.size()){
        return root;
    }

    
    vector<int> v(inorder.begin(), inorder.begin()+i);
    if (v.size()>0) {
        preidx++;
        root->left = buildTree(preorder, preidx, v);
    }

    v.clear();
    v.assign(inorder.begin()+i+1, inorder.end());
    if (v.size()>0) {
        preidx++;
        root->right = buildTree(preorder, preidx, v);
    }

    return root;
}

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
```

# convertSortedArrayToBinarySearchTree
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.
```cpp
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <queue>
using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};


TreeNode* sortedListToBST(int low, int high, ListNode*& head);

TreeNode *sortedListToBST(ListNode *head) {
    int len = 0;
    
    for(ListNode* p=head; p!=nullptr; p=p->next){
        len++;
    }
    return sortedListToBST(0, len-1, head);
}

TreeNode* sortedListToBST(int low, int high, ListNode*& head) {
    if (low>high || head==nullptr) return nullptr;

    int mid = low + (high - low)/2;

    TreeNode* leftNode = sortedListToBST(low, mid-1, head);

    TreeNode* node = new TreeNode(head->val);
    node->left = leftNode;
    head = head->next;

    TreeNode* rightNode = sortedListToBST(mid+1, high, head);
    node->right = rightNode;

    return node;
}

void printTree_level_order(TreeNode *root)
{
    queue<TreeNode*> q;
    q.push(root);
    while (q.size()>0){
        TreeNode* n = q.front();
        q.pop();
        if (n==nullptr){
            cout << "# ";
            continue;
        }
        cout << n->val << " ";
        q.push(n->left);
        q.push(n->right);
    }
    cout << endl;
}

ListNode* createList(int a[], int n)
{
    ListNode *head=nullptr, *p=nullptr;
    for(int i=0; i<n; i++){
        if (head == nullptr){
            head = p = new ListNode(a[i]);
        }else{
            p->next = new ListNode(a[i]);
            p = p->next;
        }
    }
    return head;
}

void printList(ListNode* h)
{
    while(h!=nullptr){
        printf("%d -> ", h->val);
        h = h->next;
    }
    printf("nullptr\n");
}


int main(int argc, char** argv)
{
    int n = 8;
    if (argc>1){
        n = atoi(argv[1]);
    }
    int *a = new int[n];
    for(int i=0; i<n; i++){
        a[i]=i+1;
    }
    ListNode* head = createList(a, n);
    printList(head);
    TreeNode* root = sortedListToBST(head); 
    printTree_level_order(root);
    delete[] a; 

    return 0;
}
```

# copyListWithRandomPointer
A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.
Return a deep copy of the list.

```cpp
/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */


/*    
 *
 *  The idea as below:
 *
 *  Consider we have a linked list as below:
 *
 *    node1->random = node2;
 *    node2->random = node1;
 *    node3->random = node1;
 *    
 *       +-------------+                         
 *       |             v                         
 *    +-------+    +-------+    +-------+        
 *    | node1 |----> node2 |----> node3 |--->NULL
 *    +-------+    +-------+    +-------+        
 *      ^  ^           |           |             
 *      |  +-----------+           |             
 *      +--------------------------+             
 *    
 *
 *  To copy the list, 
 *   
 *    1) We insert a new node for each node's next position
 *
 * 
 *       +-------------------------+                                     
 *       |                         v                                     
 *    +--+----+     +-----+    +-------+     +-----+    +-------+     +-----+     
 *    | node1 |---> | NEW |----> node2 |---> | NEW |----> node3 |---> | NEW | ---> NULL
 *    +-------+     +-----+    +---+---+     +-----+    +--+----+     +-----+ 
 *      ^  ^                       |                       |             
 *      |  +-----------------------+                       |             
 *      +--------------------------------------------------+             
 *
 *    2) Then, we can construt the new node's random pointer:
 *
 *        (node1->next) -> random  = (node1->random) -> next;
 *
 *    3) After we take out all of the "NEW" node to finish the copy.
 *    
 */

#include<map>
#include<vector>

struct RandomListNode {
         int label;
         RandomListNode *next, *random;
         RandomListNode(int x) : label(x), next(nullptr), random(nullptr) {}
};

class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode *p = nullptr, *h=nullptr, *t=nullptr;
        if (head == nullptr){
            return nullptr;
        }
        
        //creat a new node for each node and insert its next
        p = head;
        while ( p != nullptr){
            RandomListNode *node = new RandomListNode(p->label);
            node->next = p->next;
            p->next = node;
            p = node->next;
        }
        
        //copy random pointer for each new node
        p = head;
        while (p != nullptr){
            if (p->random != nullptr){
                p->next->random = p->random->next;
            }
            p = p->next->next;
        }
        
        //break to two list
        p = head;
        h = t = head->next;
        while ( p != nullptr ){
            p->next = p->next->next;
            if (t->next!=nullptr){
                t->next = t->next->next;
            }
            
            p = p->next;
            t = t->next;
        }
        
        return h;
    }
};


/*
 *  Considering we have a link as below:
 *
 *
 *       +-------------+
 *       |             v
 *    +-------+    +-------+    +-------+
 *    | node1 |----> node2 |----> node3 |--->NULL
 *    +-------+    +-------+    +-------+
 *      ^  ^           |           |
 *      |  +-----------+           |
 *      +--------------------------+
 * 
 *  1) Using a map to store each node's random pointer's position
 *
 *      map[node1->random] = 1;
 *      map[node2->random] = 0;
 *      map[node3->random] = 0;
 *
 *  2) Clone the linked list (only consider the next pointer)
 *
 *      new1 --> new2 --> new3 --> NULL 
 *
 *  3) Using an array to strore the order of the cloned linked-list
 *
 *      v[0] = &new1
 *      v[1] = &new2
 *      v[2] = &new3
 * 
 *  4) Then we can clone the random pointers.
 *
 *      new->random = v [ map[node->random] ]
 *
 */ 
class MySolution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {

        RandomListNode *p = nullptr, *h=nullptr, *t=nullptr;
        //using a map to store the random pointer's postion.
        std::map<RandomListNode*, int> m;
        //construct the map
        int pos =0;
        for ( p = head; p != nullptr; p = p->next, pos++){
            m[p] = pos;
        }
        
        //clone the linked list  (only consider the next pointer)
        //and using a vector to store each node's postion.
        std::vector<RandomListNode*> v;
        for (p = head; p != nullptr; p = p->next){
            RandomListNode *node = new RandomListNode(p->label);
            v.push_back(node);
            if (h==nullptr){
                h = t = node;
            }else{
                t->next = node;
                t = node;
            }
        }

        //p => source link head 
        //t => new link head
        //move the p and t synchronously, and 
        //     t->random = vector[ map[p->random] ];
        for (t=h, p = head; t!=NULL && p!= NULL; p=p->next, t=t->next){
            if (p->random!=NULL) {
                pos = m[p->random];
                t->random = v[pos];
            }
        }
        
        return h;
        
    }
};
```

# countAndSay
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
 
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
 
Given an integer n, generate the nth sequence. 
Note: The sequence of integers will be represented as a string.
```cpp
#include <stdlib.h>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

string vecToStr(vector<int> v) {
    stringstream ss;
    for (int i=0; i<v.size(); i++) {
        ss << v[i]; 
    }
    return ss.str();
}

vector<int> getNext(vector<int>& v) {
    int cnt=0;
    int val=0;
    vector<int> ret;
    for(int i=0; i<v.size(); i++){
        if (i==0){
            val = v[i];
            cnt = 1;
            continue;
        }
        if (v[i] == val){
            cnt++;
        }else{
            ret.push_back(cnt); 
            ret.push_back(val); 
            val = v[i];
            cnt = 1;
        }
    }
    if (cnt>0 && val>0){
        ret.push_back(cnt); 
        ret.push_back(val); 
    }
    return ret;
}
    

string countAndSay(int n) {
    if (n<=0) return "";
    if (n==1) return "1";

    string s;
    vector<int> v;
    v.push_back(1);
    for(int i=2; i<=n; i++){
       v = getNext(v);
       //s = s + ", " +vecToStr(v);
    }
    s = vecToStr(v);
    return s;
}


int main(int argc, char** argv)
{
    int n = 4;
    if (argc>1){
        n = atoi(argv[1]);
    }
    cout << countAndSay(n) << endl;
    
    return 0;
}
```

# decodeWays
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
 
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12",
it could be decoded as "AB" (1 2) or "L" (12). 
The number of ways decoding "12" is 2.
```cpp
#include <iostream>
#include <string>
#include <string.h>
using namespace std;


//Count[i] = Count[i-1]              if S[i-1] is a valid char (not '0')
//         = Count[i-1]+ Count[i-2]  if S[i-1] and S[i-2] together is still a valid char (10 to 26).

int check(char ch){
    //check 0 or not
    return (!isdigit(ch) || ch=='0') ? 0 : 1;
}

int check(char ch1, char ch2){
    //check it's between 10 and 26
    return (ch1=='1' || (ch1=='2' && ch2<='6')) ? 1: 0;
}

int numDecodings(string s) {
    if (s.size()<=0) return 0;
    if (s.size()==1) return check(s[0]);
   
    int* dp = new int[s.size()];
    memset(dp, 0, s.size()*sizeof(int));

    dp[0] = check(s[0]);
    dp[1] = check(s[0]) *  check(s[1]) + check(s[0], s[1]) ;
    for (int i=2; i<s.size(); i++) {
        if (!isdigit(s[i])) break; 
        if (check(s[i])) {
            dp[i] = dp[i-1];
        }
        if (check(s[i-1], s[i])) {
            dp[i] += dp[i-2];
        }
    
    }
    int result = dp[s.size()-1];
    delete[] dp;
    return result;
}


int main(int argc, char**argv)
{
    string s = "123";
    if (argc>1){
        s = argv[1];
    }
    cout << "\"" << s << "\" : " << numDecodings(s) << endl; 
    return 0;
}
```

# distinctSubsequences
Given a string S and a string T, count the number of distinct subsequences of T in S. 
A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 
Here is an example:
S = "rabbbit", T = "rabbit"
 
Return 3.

```cpp
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <iostream>
#include <string>
#include <map>
#include <vector>
using namespace std;

//=====================
// Dynamic Programming
//=====================
//
//  The idea as below:
//
//     Considering m[i][j] means the distance from T[i] to S[j], and add the empty "" case, then,
//
//     A) Initialization for empty case:  m[0][j] = 1;
//
//     B) Calculation 
//
//        a) Target-len > Source-len cannot found any substring
//           i > j : m[i][j] = 0;   
//
//        b) if not equal, take the value of T[i] => S[j-1] (e.g. ["ra" => "rabb"] =["ra" => "rab"] )
//           S[j] != T[i] :  m[i][j] = m[i][j-1]
//
//        c) if equal. (e.g.  ["rab" => "rabb"] = ["rab" =>"rab"] + ["ra" => "rab"] ) 
//           S[j] == T[i] :  m[i][j] = m[i][j-1] + m[i-1][j-1]
//
//  1) Initialize a table as below   
//       ""  r  a  b  b  b  i  t
//    ""  1  1  1  1  1  1  1  1
//    r     
//    b   
//    t  
//
//  2) Calculation
//       ""  r  a  b  b  b  i  t
//    ""  1  1  1  1  1  1  1  1
//    r   0  1  1  1  1  1  1  1 
//    b   0  0  0  1  2  3  3  3
//    t   0  0  0  0  0  0  0  3
//
int numDistinct1(string S, string T) {
    vector< vector<int> > m(T.size()+1, vector<int>(S.size()+1));
    
    for (int i=0; i<m.size(); i++){
        for (int j=0; j<m[i].size(); j++){

            if (i==0){
                m[i][j] = 1;
                continue;
            }
            if ( i>j ) {
                m[i][j] = 0;
                continue;
            }
            if (S[j-1] == T[i-1]){
                m[i][j] = m[i][j-1] + m[i-1][j-1];
            } else {
                m[i][j] = m[i][j-1] ;
            }
        }
    }
    return m[T.size()][S.size()];
}


//=====================
// Dynamic Programming
//=====================
//
//  The idea here is an optimization of above idea 
//  (It might be difficult to understand if you don't understand the above idea)
//
//    For example:
//
//      S = "abbbc"  T="abb"
//      posMap = { [a]={0}, [b]={2,1} } <- the map of T's every char.
//      numOfSubSeq = {1, 0, 0, 0 }
//
//      S[0] is 'a', pos is 0,  numOfSubSeq = {1, 0+1, 0, 0};
//
//      S[1] is 'b', pos is 2,  numOfSubSeq = {1, 1, 0, 0+0};
//                   pos is 1,  numOfSubSeq = {1, 1, 0+1, 0};
//
//      S[2] is 'b', pos is 2,  numOfSubSeq = {1, 1, 1, 0+1};
//                   pos is 1,  numOfSubSeq = {1, 1, 1+1, 1};
//
//      S[3] is 'b', pos is 2,  numOfSubSeq = {1, 1, 2, 2+1};
//                   pos is 1,  numOfSubSeq = {1, 1, 1+2, 3};
//
//      S[4] is 'c', not found, numOfSubSeq = {1, 1, 3, 3};
// 
//
int numDistinct2(string S, string T) {

    map< char, vector<int> > pos_map;
    int len = T.size();
    vector<int> numOfSubSeq(len+1);
    numOfSubSeq[0] = 1;

    for (int i=len-1; i>=0; i--){
        pos_map[T[i]].push_back(i);
    }
    
    for (int i=0; i<S.size(); i++){
        char ch = S[i];
        if ( pos_map.find(ch) != pos_map.end() ) {
            for (int j=0; j<pos_map[ch].size(); j++) {
                int pos = pos_map[ch][j];
                numOfSubSeq[pos+1] += numOfSubSeq[pos];
            } 
        }
    }

    return numOfSubSeq[len];
}


//random invoker
int numDistinct(string S, string T) {
    srand(time(0));
    if (rand()%2){
        cout << "-----Dynamic Programming Method One-----" << endl;
        return numDistinct1(S,T);
    }
    cout << "-----Dynamic Programming Method Two-----" << endl;
    return numDistinct2(S,T);
}


int main(int argc, char** argv)
{
    string s = "rabbbit";
    string t = "rabbit";
    if (argc>2){
        s = argv[1];
        t = argv[2];
    }
    cout << "S=\"" << s << "\"  T=\"" << t << "\"" << endl;
    cout << "numDistinct = " << numDistinct(s, t) << endl;
    return 0;
}
```

# divideTwoInt
Divide two integers without using multiplication, division and mod operator.

```cpp
#include <stdio.h>
#include <string.h>
#include <iostream>
using namespace std;


int divide(int dividend, int divisor) {
  
    int sign = 1;
    long long dvd = dividend;
    long long dvs = divisor;
    if (dvd<0) {
        dvd = -dvd;
        sign = -sign;
    } 
    if (dvs<0) {
        dvs = -dvs;
        sign = -sign;
    }

    long long bit_num[32];
    memset( bit_num, 0, sizeof(bit_num)/sizeof(bit_num[0]) );

    int i=0;
    long long d = dvs;
    bit_num[i] = d;
    while( d <= dvd ){
        bit_num[++i] = d = d << 1;
    }
    i--;

    unsigned int result = 0;
    while(dvd >= dvs){
        if (dvd >= bit_num[i]){
            dvd -= bit_num[i];
            result += (1<<i);
        }else{
            i--;
        }
    }

    return result * sign;
}


int main()
{
    cout << "10/2=" << divide(10, 2) << endl;
    cout << "10/3=" << divide(10, 3) << endl;
    cout << "10/5=" << divide(10, 5) << endl;
    cout << "10/7=" << divide(10, 7) << endl;
    cout << "10/10=" << divide(10, 10) << endl;
    cout << "10/11=" << divide(10, 11) << endl;
    cout << "1/-1=" << divide(1, -1) << endl;
    cout << "-1/-1=" << divide(-1, -1) << endl;
    cout << "2147483647/1=" << divide(2147483647, 1) << endl;
    cout << "-2147483647/1=" << divide(-2147483647, 1) << endl;
    cout << "2147483647/-1=" << divide(2147483647, -1) << endl;
    cout << "-2147483647/-1=" << divide(-2147483647, -1) << endl;
    cout << "2147483647/2=" << divide(2147483647, 2) << endl;
    cout << "2147483647/10=" << divide(2147483647, 10) << endl;
    cout << "-2147483648/1=" << divide(-2147483648, 1) << endl;
}
```

# editDistance
Given two words word1 and word2, find the minimum number of steps required to 
convert word1 to word2. (each operation is counted as 1 step.) 
You have the following 3 operations permitted on a word:
 
a) Insert a character
b) Delete a character
c) Replace a character

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/*
 *  Dynamic Programming
 *
 *    Definitaion
 *
 *        m[i][j] is minimal distance from word1[0..i] to word2[0..j]
 *
 *    So, 
 *
 *        1) if word1[i] == word2[j], then m[i][j] == m[i-1][j-1].
 *
 *        2) if word1[i] != word2[j], then we need to find which one below is minimal:
 *
 *             min( m[i-1][j-1], m[i-1][j],  m[i][j-1] )
 *            
 *             and +1 - current char need be changed.
 *
 *        Let's take a look  m[1][2] :  "a" => "ab" 
 *
 *               +---+  +---+                                         
 *        ''=> a | 1 |  | 2 | '' => ab                                
 *               +---+  +---+                                         
 *                                                                    
 *               +---+  +---+                                         
 *        a => a | 0 |  | 1 | a => ab                                 
 *               +---+  +---+                                         
 *                                                            
 *        To know the minimal distance `a => ab`, we can get it from one of the following cases:
 *
 *            1) delete the last char in word1,  minDistance( '' => ab ) + 1                                                             
 *            2) delete the last char in word2,  minDistance(  a => a ) + 1                                                             
 *            3) change the last char,           minDistance( '' => a ) + 1                                                             
 *                                                            
 *  
 *    For Example:
 *
 *        word1="abb", word2="abccb"
 *
 *        1) Initialize the DP matrix as below:
 *
 *               "" a b c c b
 *            "" 0  1 2 3 4 5
 *            a  1
 *            b  2
 *            b  3
 *
 *        2) Dynamic Programming
 *
 *               "" a b c c b
 *            ""  0 1 2 3 4 5
 *            a   1 0 1 2 3 4 
 *            b   2 1 0 1 2 3
 *            b   3 2 1 1 1 2
 *
 */
int min(int x, int y, int z) {
    return std::min(x, std::min(y,z));
}

int minDistance(string word1, string word2) {
    int n1 = word1.size();     
    int n2 = word2.size();     
    if (n1==0) return n2;
    if (n2==0) return n1;
    vector< vector<int> > m(n1+1, vector<int>(n2+1));
    for(int i=0; i<m.size(); i++){
        m[i][0] = i;
    }
    for (int i=0; i<m[0].size(); i++) {
        m[0][i]=i;
    }

    //Dynamic Programming
    int row, col;
    for (row=1; row<m.size(); row++) {
        for(col=1; col<m[row].size(); col++){
            if (word1[row-1] == word2[col-1] ){
                m[row][col] = m[row-1][col-1];
            }else{
                int minValue = min(m[row-1][col-1], m[row-1][col],  m[row][col-1]);
                m[row][col] = minValue + 1;
            }
        }
    }

    return m[row-1][col-1];
}


int main(int argc, char**argv)
{
    string word1="abb", word2="abccb";
    if (argc>2){
        word1 = argv[1];
        word2 = argv[2];
    }

    int steps = minDistance(word1, word2);

    cout << word1 << ", " << word2 << " : " << steps << endl;
    return 0;
}
```

# evaluateReversePolishNotation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

```cpp
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
#define ERROR  err=false;continue
public:
    int evalRPN(vector<string> &tokens) {
        int i =0;
        bool err = false;
        vector<int> exp;
        for (int i=0; i<tokens.size() && !err; i++ ){
            if( isOp(tokens[i])==true ) {
                if (exp.size() >= 2) {
                    int lhs, rhs;
                    rhs = exp.back();
                    exp.pop_back();
                    lhs = exp.back();
                    exp.pop_back();

                    int evlValue;
                    if (tokens[i]=="+"){
                        evlValue = lhs + rhs;    
                    }else if (tokens[i]=="-"){
                        evlValue = lhs - rhs;
                    }else if (tokens[i]=="*"){
                        evlValue = lhs * rhs;
                    }else if (tokens[i]=="/"){
                        evlValue = lhs / rhs;
                    }
                    
                    exp.push_back(evlValue);
                        
                }else{
                    ERROR;
                }
            }else if (isNum(tokens[i])) {
                exp.push_back(value);
            }else {
                ERROR;
            }
        }
        if (err==true){
            return 0;
        }
        
        if (exp.size()==1){
            return exp.back();
        }
        return 0;        
                
    }
    
private:
    long value;
    
    bool isOp(string &op) {
        return (op=="+" || op=="-" || op=="*" || op=="/");
    }
    
    bool isNum(string &num) {
        char *end;
        value = strtol(num.c_str(), &end, 10); 
        if (end == num.c_str() || *end != '\0' || errno == ERANGE){
            return false;
        }
        return true;
    }
};

int main()
{
    Solution s;
    char exps[5][3] = {"42", "9", "6", "-", "+"};
    vector<string> expression;
    
    cout << "Expression: \n    ";
    for (int i=0; i<5; i++){
        expression.push_back(exps[i]);
        cout << exps[i] << " ";
    }
    cout << endl;
    cout << s.evalRPN(expression)<<endl;;

    char exps2[5][3] =  {"2", "1", "+", "3", "*"};
    expression.clear();

    cout << "Expression: \n    ";
    for (int i=0; i<5; i++){
        expression.push_back(exps2[i]);
        cout << exps2[i] << " ";
    }
    cout << endl;
    cout << s.evalRPN(expression)<<endl;



    return 0;
}
```

# findMinimumInRotatedSortedArray

