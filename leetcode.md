# 2sum

```cpp
#include <iostream>
#include<map>
#include<vector>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
  map<int, int> m;
  for (int i = 0; i <nums.size(); i++) {
    int complement = target - nums[i];
    auto a = m.find(complement);
    if (a != m.end()) {
      vector<int> result = { a->second, i };
      return result;
    }
    m.insert(pair<int, int>(nums[i], i));
  }
  // throw new IllegalArgumentException("No two sum solution");
}


int main()
{
  vector<int> a = { 2, 7, 11, 15 };
  auto o = twoSum(a, 9);

  for (auto a : o) {
    std::cout <<a << endl;
  }

  system("pause");
    return 0;
}

```

# 3Sum

```cpp
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

// method: 1
vector<vector<int> > threeSum(vector<int> &num) {
  vector<vector<int> > res;
  std::sort(num.begin(), num.end());
  for (int i = 0; i < num.size(); i++) {
    int target = -num[i];
    int front = i + 1;
    int back = num.size() - 1;

    while (front < back) {

      int sum = num[front] + num[back];

      // Finding answer which start from number num[i]
      if (sum < target)
        front++;

      else if (sum > target)
        back--;

      else {
        vector<int> triplet(3, 0);
        triplet[0] = num[i];
        triplet[1] = num[front];
        triplet[2] = num[back];
        res.push_back(triplet);

        // Processing duplicates of Number 2
        // Rolling the front pointer to the next different number forwards
        while (front < back && num[front] == triplet[1]) front++;

        // Processing duplicates of Number 3
        // Rolling the back pointer to the next different number backwards
        while (front < back && num[back] == triplet[2]) rear--;
      }

    }

    // Processing duplicates of Number 1
    while (i + 1 < num.size() && num[i + 1] == num[i])
      i++;
  }
  return res;
}


//2.
vector<vector<int>> threeSum(vector<int>& nums) {
  vector<vector<int>> result;
  sort(nums.begin(), nums.end());

  for (auto i = 0; i < nums.size();) {
    auto target = -nums[i];
    int l = i + 1, u = nums.size() - 1;

    while (l < u) {
      auto sum = nums[l] + nums[u];

      if (sum < target)
        while (++l < nums.size() && nums[l] == nums[l - 1]);  // Processing duplicates of Number 2
      else if (sum > target)
        while (--u < nums.size() && nums[u] == nums[u + 1]);  // Processing duplicates of Number 3
      else {
        result.push_back(vector<int>{nums[i], nums[l], nums[u]});
        while (++l < nums.size() && nums[l] == nums[l - 1]);  // Processing duplicates of Number 2
        while (--u < nums.size() && nums[u] == nums[u + 1]);  // Processing duplicates of Number 3
      }
    }
    // Processing duplicates of Number 1
    while (++i < nums.size() && nums[i] == nums[i - 1]);
  }

  return result;
}

void printMatrix(vector<vector<int> > &matrix)
{
  for (int i = 0; i < matrix.size(); i++)
  {
    printf("{");
    for (int j = 0; j < matrix[i].size(); j++)
    {
      printf("%3d ", matrix[i][j]);
    }
    printf("}\n");
  }
  cout << endl;
}


int main()
{
  vector<int> n = { -1, 1, 1, 1, -1, -1, 0, 0, 0 };
  vector< vector<int> > result = threeSum(n);
  printMatrix(result);

  system("pause");
  return 0;
}
```

# 3SumClosest
```cpp
/*
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
*/

#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int threeSumClosest(vector<int>& nums, int target) {
  if (nums.size() < 3) return 0;
  int closest = nums[0] + nums[1] + nums[2];
  sort(nums.begin(), nums.end());

  for (int first = 0; first < nums.size() - 2; ++first) {
    if (first > 0 && nums[first] == nums[first - 1]) continue;

    int second = first + 1;
    int third = nums.size() - 1;
    while (second < third) {
      int curSum = nums[first] + nums[second] + nums[third];

      if (curSum == target) return curSum;

      if (abs(target - curSum) < abs(target - closest)) {
        closest = curSum;
      }

      if (curSum > target) {
        --third;
      }
      else {
        ++second;
      }
    }
  }
  return closest;
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

```cpp
/*
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

*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> fourSum(vector<int>& nums, int target) {
  vector<vector<int>> total;
  int n = nums.size();
  if (n < 4)  return total;
  sort(nums.begin(), nums.end());
  for (int i = 0; i < n - 3; i++)
  {
    if (i > 0 && nums[i] == nums[i - 1]) continue;
    if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
    if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
    for (int j = i + 1; j < n - 2; j++)
    {
      if (j > i + 1 && nums[j] == nums[j - 1]) continue;
      if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
      if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
      int left = j + 1, right = n - 1;
      while (left < right) {
        int sum = nums[left] + nums[right] + nums[i] + nums[j];
        if (sum < target) left++;
        else if (sum > target) right--;
        else {
          total.push_back(vector<int>{nums[i], nums[j], nums[left], nums[right]});
          do { left++; } while (nums[left] == nums[left - 1] && left < right);
          do { right--; } while (nums[right] == nums[right + 1] && left < right);
        }
      }
    }
  }
  return total;
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


// method 2
vector<vector<int>> fourSum2(vector<int>& nums, int target) {
  vector<vector<int>> total;
  int n = nums.size();
  if (n < 4)  return total;
  sort(nums.begin(), nums.end());

  for (int i = 0; i < n - 3; i++)
  {
    if (i > 0 && nums[i] == nums[i - 1]) continue;
    if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
    if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;

    for (int j = i + 1; j < n - 2; j++)
    {
      if (j > i + 1 && nums[j] == nums[j - 1]) continue;
      if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
      if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;

      int left = j + 1, right = n - 1;
      while (left < right) {
        int sum = nums[left] + nums[right] + nums[i] + nums[j];
        if (sum < target) left++;
        else if (sum > target) right--;
        else {
          total.push_back(vector<int>{nums[i], nums[j], nums[left], nums[right]});
          do { left++; } while (nums[left] == nums[left - 1] && left < right);
          do { right--; } while (nums[right] == nums[right + 1] && left < right);
        }
      }
    }
  }
  return total;
}


int main()
{
  vector<int> n = { 1, 0, -1, 0, -2, 2 };
  int t = 0;
  vector< vector<int> > v = fourSum2(n, t);
  printMatrix(v);

  n.clear();
  int b[] = { -1, -5, -5, -3, 2, 5, 0, 4 };
  n.insert(n.begin(), b, b + 8);
  t = -7;

  v = fourSum2(n, t);
  printMatrix(v);

  system("pause");

  return 0;
}
```

# addBinary

```cpp
/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

#include <iostream>
#include <string>
using namespace std;

string addBinary(string a, string b)
{
  string s = "";

  int c = 0, i = a.size() - 1, j = b.size() - 1;
  while (i >= 0 || j >= 0 || c == 1)
  {
    c += i >= 0 ? a[i--] - '0' : 0;
    c += j >= 0 ? b[j--] - '0' : 0;
    s = char(c % 2 + '0') + s;
    c /= 2;
  }

  return s;
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

```cpp
/*
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
*/


#include <iostream>
#include <string>
using namespace std;


struct Node
{
  int val;
  Node *next;
};


ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
  ListNode preHead(0), *p = &preHead;
  int extra = 0;
  while (l1 || l2 || extra) {
    int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + extra;
    extra = sum / 10;
    p->next = new ListNode(sum % 10);
    p = p->next;
    l1 = l1 ? l1->next : l1;
    l2 = l2 ? l2->next : l2;
  }
  return preHead.next;
}

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

```cpp
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/

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
    std::cout << item << std::endl;
  }

  system("pause");
  return 0;
}
```

# balancedBinaryTree
```cpp
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 of every node never differ by more than 1.
*/

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


int depth(TreeNode *root) {
  if (root == NULL) return 0;
  return max(depth(root->left), depth(root->right)) + 1;
}

bool isBalanced(TreeNode *root) {
  if (root == NULL) return true;

  int left = depth(root->left);
  int right = depth(root->right);

  return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
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

```cpp
/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

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


int maxProfit(vector<int> &prices) {
  int maxPro = 0;
  int minPrice = INT_MAX;
  for (int i = 0; i < prices.size(); i++) {
    minPrice = min(minPrice, prices[i]);
    maxPro = max(maxPro, prices[i] - minPrice);
  }
  return maxPro;
}

int main()
{
  std::vector<int> prices = { 22, 32, 45, 31, 55, 21, 10, 19 };
  std::cout << maxProfit(prices) << std::endl;
  std::cout << maxProfit2(prices) << std::endl;
  std::cout << maxProfit3(prices) << std::endl;

  system("pause");

  return 0;
}
```

# binaryTreeInorderTraversal
```cpp
/*
Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/


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

vector<int> inorderTraversal(TreeNode *root) {
  vector<int> vector;
  if (!root)
    return vector;
  stack<TreeNode *> stack;
  stack.push(root);
  while (!stack.empty())
  {
    TreeNode *pNode = stack.top();
    if (pNode->left)
    {
      stack.push(pNode->left);
      pNode->left = NULL;
    }
    else
    {
      vector.push_back(pNode->val);
      stack.pop();
      if (pNode->right)
        stack.push(pNode->right);
    }
  }
  return vector;
}

// 2

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

  auto result = inorderTraversal(root);
  for (auto item : result)
  {
    std::cout << item << ", ";
  }


  system("pause");

  return 0;
}
```
# binaryTreeLevelOrderTraversal

```cpp
/*
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
  if (root == NULL) return;
  if (ret.size() == depth)
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

```

# binaryTreeMaximumPathSum

```cpp
/*
Given a binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
For example:
Given the below binary tree,

       1
      / \
     2   3
*/

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

int maxToRoot(TreeNode *root, int &re) {
  if (!root) return 0;
  int l = maxToRoot(root->left, re);
  int r = maxToRoot(root->right, re);
  if (l < 0) l = 0;
  if (r < 0) r = 0;
  if (l + r + root->val > re) re = l + r + root->val;
  return root->val += max(l, r);
}

int maxPathSum(TreeNode *root) {
  int max = -2147483648;
  maxToRoot(root, max);
  return max;
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
```cpp
/*
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

```

# binaryTreePreorderTraversal

```cpp
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

```

# binaryTreeUpsideDown
```cpp
/*
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
*/

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
  if (root == nullptr) {
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

```cpp
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

```

# candy
```cpp
/*
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
*/

#include <time.h>
#include <iostream>
#include <vector>
using namespace std;


int candy(vector<int> &ratings)
{
  int size = ratings.size();
  if (size <= 1)
    return size;
  vector<int> num(size, 1);
  for (int i = 1; i < size; i++)
  {
    if (ratings[i] > ratings[i - 1])
      num[i] = num[i - 1] + 1;
  }
  for (int i = size - 1; i > 0; i--)
  {
    if (ratings[i - 1] > ratings[i])
      num[i - 1] = max(num[i] + 1, num[i - 1]);
  }
  int result = 0;
  for (int i = 0; i < size; i++)
  {
    result += num[i];
    // cout<<num[i]<<" ";
  }
  return result;
}


// SF

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
  vector<int> ra = { 5, 6, 7, 4, 1, 2, 3, 2, 1, 7 };
  print(ra);
  cout << candy(ra) << endl;

  system("pause");
  return 0;
}

```

# climbStairs

```cpp
/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
Example 1:
Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output:  3

Explanation:  There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

#include<iostream>


int climbStairs(int n) {
  int a = 1, b = 1;
  while (n--)
    a = (b += a) - a;
  return a;
}

// 2
//Time too long
int climbStairs2(int n)
{
  if (n <= 3)
    return n;
  return climbStairs(n - 1) + climbStairs(n - 2);
}

int main(int argc, char** argv)
{
  std::cout << climbStairs2(5) << std::endl;
  system("pause");

  return 0;
}

```

# cloneGraph

```cpp
/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
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
*/

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

// BFS
class Solution {
public:
  UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
    if (!node) return NULL;
    UndirectedGraphNode* copy = new UndirectedGraphNode(node->label);
    mp[node] = copy;
    queue<UndirectedGraphNode*> toVisit;
    toVisit.push(node);
    while (!toVisit.empty()) {
      UndirectedGraphNode* cur = toVisit.front();
      toVisit.pop();
      for (UndirectedGraphNode* neigh : cur->neighbors) {
        if (mp.find(neigh) == mp.end()) {
          UndirectedGraphNode* neigh_copy = new UndirectedGraphNode(neigh->label);
          mp[neigh] = neigh_copy;
          toVisit.push(neigh);
        }
        mp[cur]->neighbors.push_back(mp[neigh]);
      }
    }
    return copy;
  }
private:
  unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> mp;
};

// DFS
class Solution {
public:
  UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
    if (!node) return NULL;
    if (mp.find(node) == mp.end()) {
      mp[node] = new UndirectedGraphNode(node->label);
      for (UndirectedGraphNode* neigh : node->neighbors)
        mp[node]->neighbors.push_back(cloneGraph(neigh));
    }
    return mp[node];
  }
private:
  unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> mp;
};


int main()
{
  UndirectedGraphNode *node(nullptr);
  UndirectedGraphNode *result = cloneGraph(node);

  system("pause");
  return 0;
}
```

# combinations

```cpp
/*
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
*/

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> combine(int n, int k) {
  vector<vector<int>> result;
  int i = 0;
  vector<int> p(k, 0);
  while (i >= 0) {
    p[i]++;
    if (p[i] > n) --i;
    else if (i == k - 1) result.push_back(p);
    else {
      ++i;
      p[i] = p[i - 1];
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
```cpp
/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
  std::vector<std::vector<int> > combinationSum3(int k, int n) {
    std::vector<std::vector<int> > res;
    std::vector<int> combination;
    combinationSum3(n, res, combination, 1, k);
    return res;
  }
private:
  void combinationSum3(int target, std::vector<std::vector<int> > &res, std::vector<int> &combination, int begin, int need) {
    if (!target) {
      res.push_back(combination);
      return;
    }
    else if (!need)
      return;
    for (int i = begin; i != 10 && target >= i * need + need * (need - 1) / 2; ++i) {
      combination.push_back(i);
      combinationSum3(target - i, res, combination, i + 1, need - 1);
      combination.pop_back();
    }
  }
};

// SF

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

```cpp
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

```

# constructBinaryTreeFromPreorderAndInorderTraversal

```cpp
/*
*Given preorder and inorder traversal of a tree, construct the binary tree.
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

TreeNode* create(vector<int>& preorder, vector<int>& inorder, int ps, int pe, int is, int ie) {
  if (ps > pe) {
    return nullptr;
  }
  TreeNode* node = new TreeNode(preorder[ps]);
  int pos;
  for (int i = is; i <= ie; i++) {
    if (inorder[i] == node->val) {
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
  int pre_order[] = { 'F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H' };
  int  in_order[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
  vector<int> preorder(pre_order, pre_order + 9);
  vector<int>  inorder(in_order, in_order + 9);

  TreeNode* tree = buildTree(preorder, inorder);

  printTree_level_order(tree);
  printTree_pre_order(tree);
  printf("\n");
  printTree_in_order(tree);
  printf("\n");

  return 0;
}

```

# containerWithMostWater
```cpp
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/
#include<iostream>
#include<vector>

using namespace std;

/*
Start by evaluating the widest container, using the first and the last line.
All other possible containers are less wide, so to hold more water, they need to be higher.
Thus, after evaluating that widest container, skip lines at both ends that don’t support a higher height.
Then evaluate that new container we arrived at. Repeat until there are no more possible containers left.
*/

int maxArea(vector<int>& height) {
  int water = 0;
  int i = 0, j = height.size() - 1;
  while (i < j) {
    int h = min(height[i], height[j]);
    water = max(water, (j - i) * h);
    while (height[i] <= h && i < j) i++;
    while (height[j] <= h && i < j) j--;
  }
  return water;
}


int main()
{

  return 0;
}

```

# convertSortedArrayToBinarySearchTree

```cpp
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
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


TreeNode *sortedArrayToBST(vector<int> &num) {
  if (num.size() == 0) return NULL;
  if (num.size() == 1)
  {
    return new TreeNode(num[0]);
  }

  int middle = num.size() / 2;
  TreeNode* root = new TreeNode(num[middle]);

  vector<int> leftInts(num.begin(), num.begin() + middle);
  vector<int> rightInts(num.begin() + middle + 1, num.end());

  root->left = sortedArrayToBST(leftInts);
  root->right = sortedArrayToBST(rightInts);

  return root;
}


int main()
{

  return 0;
}
```

# convertSortedListToBinarySearchTree
```cpp
/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted linked list: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

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


TreeNode* sortedListToBST(ListNode* head) {
  if (head == nullptr)
    return nullptr;
  if (head->next == nullptr)
    return new TreeNode(head->val);
  ListNode *fast = head->next->next, *slow = head;
  while (fast != nullptr && fast->next != nullptr) {
    slow = slow->next;
    fast = fast->next->next;
  }
  TreeNode* root = new TreeNode(slow->next->val);
  root->right = sortedListToBST(slow->next->next);
  slow->next = nullptr;
  root->left = sortedListToBST(head);
  return root;
}

// SF
void printTree_level_order(TreeNode *root)
{
  queue<TreeNode*> q;
  q.push(root);
  while (q.size() > 0) {
    TreeNode* n = q.front();
    q.pop();
    if (n == nullptr) {
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
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}

void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d -> ", h->val);
    h = h->next;
  }
  printf("nullptr\n");
}


int main(int argc, char** argv)
{
  int n = 8;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  int *a = new int[n];
  for (int i = 0; i < n; i++) {
    a[i] = i + 1;
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

```cpp
/*
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.
Return a deep copy of the list.
*/

/*
Here's how the 1st algorithm goes.
Consider l1 as a node on the 1st list and l2 as the corresponding node on 2nd list.
Step 1:
Build the 2nd list by creating a new node for each node in 1st list.
While doing so, insert each new node after it's corresponding node in the 1st list.
Step 2:
The new head is the 2nd node as that was the first inserted node.
Step 3:
Fix the random pointers in the 2nd list: (Remember that l1->next is actually l2)
l2->random will be the node in 2nd list that corresponds l1->random,
which is next node of l1->random.
Step 4:
Separate the combined list into 2: Splice out nodes that are part of second list.
Return the new head that we saved in step 2.
*/

RandomListNode *copyRandomList(RandomListNode *head) {
    RandomListNode *newHead, *l1, *l2;
    if (head == NULL) return NULL;
    for (l1 = head; l1 != NULL; l1 = l1->next->next) {
        l2 = new RandomListNode(l1->label);
        l2->next = l1->next;
        l1->next = l2;
    }

    newHead = head->next;
    for (l1 = head; l1 != NULL; l1 = l1->next->next) {
        if (l1->random != NULL) l1->next->random = l1->random->next;
    }

    for (l1 = head; l1 != NULL; l1 = l1->next) {
        l2 = l1->next;
        l1->next = l2->next;
        if (l2->next != NULL) l2->next = l2->next->next;
    }

    return newHead;
}


/*
Here's how the 2nd algorithm goes.
Consider l1 as a node on the 1st list and l2 as the corresponding node on 2nd list.
Step 1:
Build the 2nd list by creating a new node for each node in 1st list.
While doing so, set the next pointer of the new node to the random pointer
of the corresponding node in the 1st list.  And set the random pointer of the
1st list's node to the newly created node.
Step 2:
The new head is the node pointed to by the random pointer of the 1st list.
Step 3:
Fix the random pointers in the 2nd list: (Remember that l1->random is l2)
l2->random will be the node in 2nd list that corresponds to the node in the
1st list that is pointed to by l2->next,
Step 4:
Restore the random pointers of the 1st list and fix the next pointers of the
2nd list. random pointer of the node in 1st list is the next pointer of the
corresponding node in the 2nd list.  This is what we had done in the
1st step and now we are reverting back. next pointer of the node in
2nd list is the random pointer of the node in 1st list that is pointed to
by the next pointer of the corresponding node in the 1st list.
Return the new head that we saved in step 2.
*/

RandomListNode *copyRandomList(RandomListNode *head) {
    RandomListNode *newHead, *l1, *l2;
    if (head == NULL) return NULL;

    for (l1 = head; l1 != NULL; l1 = l1->next) {
        l2 = new RandomListNode(l1->label);
        l2->next = l1->random;
        l1->random = l2;
    }

    newHead = head->random;
    for (l1 = head; l1 != NULL; l1 = l1->next) {
        l2 = l1->random;
        l2->random = l2->next ? l2->next->random : NULL;
    }

    for (l1 = head; l1 != NULL; l1 = l1->next) {
        l2 = l1->random;
        l1->random = l2->next;
        l2->next = l1->next ? l1->next->random : NULL;
    }

    return newHead;
}

int main(){

return 0;
}
```
# countAndSay

```cpp
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

string countAndSay(int n) {
  if (n == 1) { return "1"; }
  if (n == 2) { return "11"; }
  string result = countAndSay(n - 1);
  string newresult = "";
  int count = 1;
  for (int i = 1; i < result.size(); ++i) {
    if (result[i] != result[i - 1]) {
      newresult.push_back('0' + count);
      newresult.push_back(result[i - 1]);
      count = 1;
    }
    else {
      count++;
    }
    if (i == result.size() - 1) {
      newresult.push_back('0' + count);
      newresult.push_back(result[i]);
    }
  }
  return newresult;
}

int main(int argc, char** argv)
{
  int n = 4;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  cout << countAndSay(n) << endl;

  return 0;
}

```

# decodeWays
```cpp
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
*/

#include <iostream>
#include <string>
using namespace std;

int numDecodings(string s) {
  if (!s.size() || s.front() == '0') return 0;
  // r2: decode ways of s[i-2] , r1: decode ways of s[i-1]
  int r1 = 1, r2 = 1;

  for (int i = 1; i < s.size(); i++) {
    // zero voids ways of the last because zero cannot be used separately
    if (s[i] == '0') r1 = 0;

    // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
    if (s[i - 1] == '1' || s[i - 1] == '2' && s[i] <= '6') {
      r1 = r2 + r1;
      r2 = r1 - r2;
    }

    // one-digit letter, no new way added
    else {
      r2 = r1;
    }
  }

  return r1;
}

int main(int argc, char**argv)
{
  string s = "123";
  if (argc > 1) {
    s = argv[1];
  }
  cout << "\"" << s << "\" : " << numDecodings(s) << endl;
  return 0;
}

```

# distinctSubsequences
```cpp
/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/
#include <iostream>
#include <vector>

using namespace std;

int numDistinct(string s, string t) {
  int n = s.length(), m = t.length();
  vector<int> dp(m + 1, 0);
  dp[0] = 1;
  for (int j = 1; j <= n; j++) {
    for (int i = m; i >= 1; i--) {
      dp[i] += s[j - 1] == t[i - 1] ? dp[i - 1] : 0;
    }
  }
  return dp[m];
}

//random invoker
int numDistinct(string S, string T) {
  srand(time(0));
  if (rand() % 2) {
    cout << "-----Dynamic Programming Method One-----" << endl;
    return numDistinct1(S, T);
  }
  cout << "-----Dynamic Programming Method Two-----" << endl;
  return numDistinct2(S, T);
}


int main(int argc, char** argv)
{
  string s = "rabbbit";
  string t = "rabbit";
  if (argc > 2) {
    s = argv[1];
    t = argv[2];
  }
  cout << "S=\"" << s << "\"  T=\"" << t << "\"" << endl;
  cout << "numDistinct = " << numDistinct(s, t) << endl;
  return 0;
}

```

# divideTwoInt

```cpp
/*
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
*/

#include <iostream>
using namespace std;


int divide(int dividend, int divisor) {
  if (!divisor || (dividend == INT_MIN && divisor == -1))
    return INT_MAX;
  int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
  long long dvd = labs(dividend);
  long long dvs = labs(divisor);
  int res = 0;
  while (dvd >= dvs) {
    long long temp = dvs, multiple = 1;
    while (dvd >= (temp << 1)) {
      temp <<= 1;
      multiple <<= 1;
    }
    dvd -= temp;
    res += multiple;
  }
  return sign == 1 ? res : -res;
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
```cpp
/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
*/
#include <iostream>
#include <vector>
using namespace std;


int minDistance(string word1, string word2) {
  // DP talbe, i is the position in word1, and j is the position in word2
  vector<vector<int>> distance(word1.length() + 1, vector<int>(word2.length() + 1, 0));

  // when i or j=0 means empty string, the distance is the length of another string
  for (int i = 0; i < distance.size(); i++)
    for (int j = 0; j < distance[0].size(); j++) {
      if (i == 0)
        distance[i][j] = j;
      else if (j == 0)
        distance[i][j] = i;
    }

  // if word1[i]==word2[j], then the distance of i and j is the previous i and j
  // otherwise we either replace, insert or delete a char
  // when insert a char to word1 it means we are trying to match word1 at i-1 to word2 at j
  // when delete a char from word1 it equals to insert a char to word2, which
  // means we are trying to match word1 at i to word2 at j-1
  // when replace a char to word1, then we add one step to previous i and j
  for (int i = 1; i < distance.size(); i++)
    for (int j = 1; j < distance[0].size(); j++) {
      if (word1[i - 1] == word2[j - 1])
        distance[i][j] = distance[i - 1][j - 1];
      else
        distance[i][j] = 1 + min(distance[i - 1][j - 1], min(distance[i - 1][j], distance[i][j - 1]));
    }

  return distance[word1.length()][word2.length()];
}

int main(int argc, char**argv)
{
  string word1 = "abb", word2 = "abccb";
  if (argc > 2) {
    word1 = argv[1];
    word2 = argv[2];
  }

  int steps = minDistance(word1, word2);

  cout << word1 << ", " << word2 << " : " << steps << endl;
  return 0;
}

```

# evaluateReversePolishNotation

```cpp
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

#include <vector>
#include <iostream>
using namespace std;


int evalRPN(vector<string>& tokens) {
  string s = tokens.back(); tokens.pop_back();
  if (s != "+" && s != "-" && s != "*" && s != "/") return stoi(s);

  int r2 = evalRPN(tokens), r1 = evalRPN(tokens);

  if (s == "+") return r1 + r2;
  if (s == "-") return r1 - r2;
  if (s == "*") return r1 * r2;
  if (s == "/") return r1 / r2;
}

int main()
{
  Solution s;
  char exps[5][3] = { "42", "9", "6", "-", "+" };
  vector<string> expression;

  cout << "Expression: \n    ";
  for (int i = 0; i < 5; i++) {
    expression.push_back(exps[i]);
    cout << exps[i] << " ";
  }
  cout << endl;
  cout << s.evalRPN(expression) << endl;;

  char exps2[5][3] = { "2", "1", "+", "3", "*" };
  expression.clear();

  cout << "Expression: \n    ";
  for (int i = 0; i < 5; i++) {
    expression.push_back(exps2[i]);
    cout << exps2[i] << " ";
  }
  cout << endl;
  cout << s.evalRPN(expression) << endl;



  return 0;
}
```

# findMinimumInRotatedSortedArray

```cpp
/**********************************************************************************
* Suppose a sorted array is rotated at some pivot unknown to you beforehand.
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
* Find the minimum element.
* You may assume no duplicate exists in the array.
**********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <vector>
using namespace std;

/*
 *  Obveriously, to search any sorted array, the binary search is the common sense.
 *  To solve this problem, the idea is same as the search in rotated sorted array.
 */
int findMin(vector<int> &num) {
  int low = 0, high = num.size() - 1;
  while (high - low > 1) {
    int mid = low + (high - low) / 2;
    // Chek the array if it is non-rotated, then just return the first element.
    if (num[low] < num[mid] && num[mid] < num[high]) {
      return num[low];
    }

    // The array is rotated
    // Spli it into two part, the minimal value must be the rotated part

    // if the left part is rotated, warch the left part
    if (num[low] > num[mid]) {
      high = mid;
      continue;
    }
    // if the right part is rotated, search the right part.
    if (num[mid] > num[high]) {
      low = mid;
      continue;
    }
  }
  // the array only has 1 element
  if (high == low) return num[low];

  // the array has 2 elements
  return num[low] < num[high] ? num[low] : num[high];

}

void printArray(vector<int>& arr) {
  for (auto i : arr) {
    printf("%d, ", i);
  }
}

int main()
{
  int expectedMin, actualMin;
  vector<int> num{ 11, 12, 13, 14, 15, 3, 4, 5, 6, 7, 8, 9, 10 };
  expectedMin = num[5];
  printArray(num);

  actualMin = findMin(num);
  cout << "findMin = " << actualMin << "   " << (expectedMin == actualMin ? "passed" : "failed") << endl;

  return 0;
}

```

# findPeakElement
```cpp
/*
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
click to show spoilers.
Note:Your solution should be in logarithmic complexity.
Credits:Special thanks to @ts for adding this problem and creating all test cases.
*/
#include <iostream>
#include <vector>
using namespace std;

/*
 Binary search is common idea here.
 However, you need to think about two senarios:
 1) Becasue we need check `num[mid-1]`, `num[mid]`, `num[mid+1]`,
    So, we need make sure there hasn't out-of-boundary issue.
 2) There are multiple Peak elements.
    For example: [1,2,1,2,1], or [ 1,2,3,1,2,1]
    LeetCode doesn't tell you what the expected result is. I guess:
    2.1) for [1,2,1,2,1] you can return either 1 or 3, because both them are peak elements
    2.1) for [1,2,3,2,4,2,1] it should return 4, because num[4] is the real peak.  but Leetcode accept either 2 or 4
*/

int findPeakElement(const vector<int> &num)
{
  int low = 0;
  int high = num.size() - 1;

  while (low < high)
  {
    int mid1 = (low + high) / 2;
    int mid2 = mid1 + 1;
    if (num[mid1] < num[mid2])
      low = mid2;
    else
      high = mid1;
  }
  return low;
}

void printVector(vector<int> &n) {
  cout << "[ ";
  int i;
  for (i = 0; i < n.size(); i++) {
    cout << n[i] << (i == n.size() - 1 ? " ]" : ", ");
  }
  cout << endl;
}

void test(int a[], int n) {
  vector<int> v(a, a + n);
  cout << "Peak Index = " << findPeakElement(v) << "\t";
  printVector(v);
}


#define TEST(a) test(a, sizeof(a)/sizeof(a[0]))

int main(int argc, char**argv)
{
  int n0[] = { 1 };
  TEST(n0);

  int n1[] = { 1,2 };
  TEST(n1);

  int n2[] = { 2,1 };
  TEST(n2);

  int n3[] = { 1,2,3 };
  TEST(n3);

  int n4[] = { 3,2,1 };
  TEST(n4);

  int n5[] = { 1,2,3,2 };
  TEST(n5);

  int n6[] = { 0,1,2,9,7,5,4,2,1 };
  TEST(n6);

  int n7[] = { 1,2,1,2,1 };
  TEST(n7);

  int n8[] = { 1,2,1,2,3,1 };
  TEST(n8);

  int n9[] = { 1,2,3,2,4,2,1 };
  TEST(n9);

  int n10[] = { 1,3,1,2,1,3,1 };
  TEST(n10);

  return 0;
}
```

# firstMissingPositive
```cpp
/*
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
*/
#include <iostream>
#include <map>
using namespace std;

int firstMissingPositive(vector<int>& nums) {
  int n = nums.size();
  for (int i = 0; i < n; i++)
    while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
      swap(nums[i], nums[nums[i] - 1]);
  for (int i = 0; i < n; i++)
    if (nums[i] != i + 1)
      return i + 1;
  return n + 1;
}

void printArray(vector<int>& data) {
  for (auto d : data) {
    cout << d << ", ";
  }
}

void Test(vector<int>& data, int expected) {
  printArray(data);
  int ret = firstMissingPositive(data);
  cout << "\t   missed = " << ret << "  " << (ret == expected ? "passed!" : "failed!") << endl;
  printArray(data);
  cout << endl;
}

int main()
{
  vector<int>a0 = { 1 };
  TEST(a0);

  vector<int> a1 = { 1,2,0 };
  TEST(a1);

  vector<int> a2 = { 3,4,-1,1 };
  TEST(a2);

  vector<int> a3 = { 1000,-1 };
  TEST(a3);

  vector<int> a4 = { 1000, 200 };
  TEST(a4);

  vector<int> a5 = { 2,5,3,-1 };
  TEST(a5);

  vector<int> a6 = { 1, 100 };
  TEST(a6);

  vector<int> a7 = { 7,8,9,11 };
  TEST(a7);

  vector<int> a8 = { 4,3,2,1 };
  TEST(a8);

  return 0;
}

```

# flattenBinaryTreeToLinkedList
```cpp
/*
Given a binary tree, flatten it to a linked list in-place.
For example,
Given
    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
Hints:
If you notice carefully in the flattened tree, each node's right child points to
the next node of a pre-order traversal.
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

void flatten(TreeNode *root) {
  TreeNode*now = root;
  while (now)
  {
    if (now->left)
    {
      //Find current node's prenode that links to current node's right subtree
      TreeNode* pre = now->left;
      while (pre->right)
      {
        pre = pre->right;
      }
      pre->right = now->right;
      //Use current node's left subtree to replace its right subtree(original right
      //subtree is already linked by current node's prenode
      now->right = now->left;
      now->left = NULL;
    }
    now = now->right;
  }
}

int main()
{
  return 0;
}
```
# gasStation

```cpp
/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to
its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note: The solution is guaranteed to be unique.
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
  int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
    int current = 0;
    int start = gas.size(); //start from the end to beginning
    int total = 0;

    do {
      if (total + gas[current] - cost[current] >= 0) {
        total += (gas[current] - cost[current]);
        current++; // can go from current to current+1
      }
      else {
        start--; //not enough gas, try to start the one before origin start point.
        total += (gas[start] - cost[start]);
      }
    } while (current != start);

    return total >= 0 ? start % gas.size() : -1;
  }
};

int main()
{
  return 0;
}
```

# generateParentheses

```cpp
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

#include <string>
#include <iostream>
#include <vector>
using namespace std;

void generator(vector<string> &v, string str, int n, int m) {
  if (n == 0 && m == 0) {
    v.push_back(str);
    return;
  }
  if (m > 0) { generator(v, str + ")", n, m - 1); }
  if (n > 0) { generator(v, str + "(", n - 1, m + 1); }
}

vector<string> generateParenthesis(int n) {
  vector<string> res;
  generator(res, "", n, 0);
  return res;
}

void printResult(vector<string>& result)
{
  for (int i = 0; i < result.size(); i++) {
    std::cout << result[i] << endl;
  }
}

int main(int argc, char** argv)
{
  int n = 4;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  vector<string> r = generateParenthesis(n);
  printResult(r);
  return 0;
}

```

# grayCode
```cpp
/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code,
print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

#include <time.h>
#include <iostream>
#include <vector>

using namespace std;
/*
I designed the following stupid algorithm base on the blow observation
I noticed I can use a `mirror-like` binary tree to figure out the gray code.
For example:
          0
       __/ \__
      0       1
     / \     / \
    0   1   1   0
So, the gray code as below: (top-down, from left to right)
    0 0 0
    0 0 1
    0 1 1
    0 1 0

                 0
           _____/ \_____
          0             1
       __/ \__       __/ \__
      0       1     1       0
     / \     / \   / \     / \
    0   1   1   0 0   1   1   0

So, the gray code as below:
    0 0 0 0
    0 0 0 1
    0 0 1 1
    0 0 1 0
    0 1 1 0
    0 1 1 1
    0 1 0 1
    0 1 0 0
*/

vector<int> grayCode(int n)
{
  vector<int> result(1, 0);
  for (int i = 0; i < n; i++) {
    int curCount = result.size();
    // push back all element in result in reverse order
    while (curCount) {
      curCount--;
      int curNum = result[curCount];
      curNum += (1 << i);
      result.push_back(curNum);
    }
  }
  return result;
}

/*
Actually, there is a better way.
The mathematical way is: (num >> 1) ^ num;
Please refer to http://en.wikipedia.org/wiki/Gray_code
 */
vector<int> grayCode02(int n) {
  vector<int> ret;
  int size = 1 << n;
  for (int i = 0; i < size; ++i) {
    ret.push_back((i >> 1) ^ i);
  }
  return ret;
}

void printBits(int n, int len) {
  for (int i = len - 1; i >= 0; i--) {
    if (n & (1 << i)) {
      printf("1");
    }
    else {
      printf("0");
    }
  }
}

void printVector(vector<int>& v, int bit_len)
{
  for (auto it : v) {
    printBits(it, bit_len);
    cout << " ";
  }
  cout << endl;
}

int main()
{
  int n = 2;
  vector<int> v = grayCode(n);
  printVector(v, n);
  return 0;
}

```

# insertInterval
```cpp
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Interval {
  int start;
  int end;
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}
};

vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
  vector<Interval> ret;
  auto it = intervals.begin();
  for (; it != intervals.end(); ++it) {
    if (newInterval.end < (*it).start) //all intervals after will not overlap with the newInterval
      break;
    else if (newInterval.start > (*it).end) //*it will not overlap with the newInterval
      ret.push_back(*it);
    else { //update newInterval bacause *it overlap with the newInterval
      newInterval.start = min(newInterval.start, (*it).start);
      newInterval.end = max(newInterval.end, (*it).end);
    }
  }
  // don't forget the rest of the intervals and the newInterval
  ret.push_back(newInterval);
  for (; it != intervals.end(); ++it)
    ret.push_back(*it);
  return ret;
}

int main()
{
  Interval i1(1, 2);
  Interval i2(3, 5);
  Interval i3(6, 7);
  Interval i4(8, 10);
  Interval i5(12, 16);
  vector<Interval> intervals;
  intervals.push_back(i1);
  intervals.push_back(i2);
  intervals.push_back(i3);
  intervals.push_back(i4);
  intervals.push_back(i5);

  Interval n(4, 9);
  vector<Interval> r = insert(intervals, n);

  for (int i = 0; i < r.size(); i++) {
    cout << "[ " << r[i].start << ", " << r[i].end << " ] ";
  }
  cout << endl;

  return 0;
}

```

# insertionSortList
```cpp
//Sort a linked list using insertion sort.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *insertionSortList(ListNode *head) {
  // zero or one element in list
  if (head == nullptr || head->next == nullptr) {
    return head;
  }

  ListNode *pSorted = nullptr;
  while (head != nullptr) {
    /* remember the head */
    ListNode *pHead = head;
    /* trailing pointer for efficient splice */
    ListNode **ppTrail = &pSorted;

    /* pop head off list */
    head = head->next;

    /* splice head into sorted list at proper place */
    while (*ppTrail != nullptr && pHead->val > (*ppTrail)->val) {
      ppTrail = &(*ppTrail)->next;
    }
    pHead->next = *ppTrail;
    *ppTrail = pHead;
  }

  return pSorted;
}

void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int a[], int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}


int main(int argc, char** argv)
{
  int n = 10;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  srand(time(nullptr));

  int *a = new int[n];
  for (int i = 0; i < n; i++) {
    a[i] = rand() % n + 1;
  }

  ListNode *p = createList(a, n);
  printList(p);
  printList(insertionSortList(p));

  delete[] a;
}

```

# integerToRoman

```cpp
/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

#include <stdlib.h>
#include <string>
#include <iostream>
using namespace std;

//greeding algorithm
string intToRoman(int num) {
  string symbol[] = { "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I" };
  int value[] = { 1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1 };
  string result;

  for (int i = 0; num != 0; i++) {
    while (num >= value[i]) {
      num -= value[i];
      result += symbol[i];
    }
  }

  return result;
}


int main(int argc, char** argv)
{
  int num = 1234;
  if (argc > 0) {
    num = atoi(argv[1]);
  }
  cout << num << " : " << intToRoman(num) << endl;
  return 0;
}

```

# interleavingString

```cpp
/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position. 0th position means empty string.
So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving.
If only s1 is empty, then if previous s2 position is interleaving and current s2 position char is equal to s3 current position char, it is considered interleaving.
similar idea applies to when s2 is empty. when both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal, it s interleaving.
If we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position equal. it is interleaving.
*/
bool isInterleave(string s1, string s2, string s3) {

  if (s3.length() != s1.length() + s2.length())
    return false;

  bool table[s1.length() + 1][s2.length() + 1];

  for (int i = 0; i < s1.length() + 1; i++)
    for (int j = 0; j < s2.length() + 1; j++) {
      if (i == 0 && j == 0)
        table[i][j] = true;
      else if (i == 0)
        table[i][j] = (table[i][j - 1] && s2[j - 1] == s3[i + j - 1]);
      else if (j == 0)
        table[i][j] = (table[i - 1][j] && s1[i - 1] == s3[i + j - 1]);
      else
        table[i][j] = (table[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || (table[i][j - 1] && s2[j - 1] == s3[i + j - 1]);
    }

  return table[s1.length()][s2.length()];
}

#define TEST(s1, s2, s3) cout << s1 << ", " << s2 << " = " << s3 << " : " << isInterleave(s1,s2,s3) << endl;
int main()
{
  string s1 = "aabcc", s2 = "dbbca";
  TEST(s1, s2, "aadbbcbcac");
  TEST(s1, s2, "aadbbbaccc");

  s1 = "c"; s2 = "ca";
  TEST(s1, s2, "cca");
  TEST(s1, s2, "cac");

  s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
  s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
  string s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
  TEST(s1, s2, s3);

  return 0;
}

```

# intersectionOfTwoLinkedLists
```cpp
/*
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

#include <iostream>
#include <vector>
using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
{
  ListNode *p1 = headA;
  ListNode *p2 = headB;

  if (p1 == nullptr || p2 == nullptr) return nullptr;

  while (p1 != nullptr && p2 != nullptr && p1 != p2) {
    p1 = p1->next;
    p2 = p2->next;

    // Any time they collide or reach end together without colliding
    // then return any one of the pointers.
    //
    if (p1 == p2) return p1;

    // If one of them reaches the end earlier then reuse it
    // by moving it to the beginning of other list.
    // Once both of them go through reassigning,
    // they will be equidistant from the collision point.

    if (p1 == NULL) p1 = headB;
    if (p2 == NULL) p2 = headA;
  }

  return p1;
}


int main()
{
  return 0;
}
```
# jumpGame

```cpp
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
*/

bool canJump(int A[], int n) {
  int i = 0;
  for (int reach = 0; i < n && i <= reach; ++i)
    reach = max(i + A[i], reach);
  return i == n;
}

int main() {

  return 0;
}

```

# largestRectangleInHistogram

```cpp
/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

#include <iostream>
#include <vector>
using namespace std;

int largestRectangleArea(vector<int> &height) {

  int ret = 0;
  height.push_back(0);
  vector<int> index;

  for (int i = 0; i < height.size(); i++)
  {
    while (index.size() > 0 && height[index.back()] >= height[i])
    {
      int h = height[index.back()];
      index.pop_back();

      int sidx = index.size() > 0 ? index.back() : -1;
      if (h * (i - sidx - 1) > ret)
        ret = h * (i - sidx - 1);
    }
    index.push_back(i);
  }

  return ret;
}

void printArray(vector<int> &v)
{
  cout << "{";
  for (int i = 0; i < v.size(); i++) {
    cout << " " << v[i];
  }
  cout << "}" << endl;
}
void test(int a[], int n)
{
  vector<int> v(a, a + n);
  printArray(v);
  cout << largestRectangleArea(v) << endl;
}

int main()
{
#define TEST(a) test(a, sizeof(a)/sizeof(int))
  int a0[] = { 2,1,3,1 };
  TEST(a0);
  int a1[] = { 2,1,5,6,2,3 };
  TEST(a1);

  return 0;
}
```
# lengthOfLastWord

```cpp
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5
*/
#include <stdio.h>
#include <ctype.h>

int lengthOfLastWord(string s) {
  int len = 0, tail = s.length() - 1;
  while (tail >= 0 && s[tail] == ' ') tail--;
  while (tail >= 0 && s[tail] != ' ') {
    len++;
    tail--;
  }
  return len;
}

int main(int argc, char** argv)
{
  const char* p;
  p = "hello world";
  printf("%s, %d\n", p, lengthOfLastWord(p));
  p = "a";
  printf("%s, %d\n", p, lengthOfLastWord(p));

  if (argc > 1) {
    p = argv[1];
    printf("%s, %d\n", p, lengthOfLastWord(p));
  }
}

```

# letterCombinationsOfAPhoneNumber
```cpp
/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

vector<string> letterCombinations(string digits) {
  vector<string> res;
  string charmap[10] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  res.push_back("");
  for (int i = 0; i < digits.size(); i++)
  {
    vector<string> tempres;
    string chars = charmap[digits[i] - '0'];
    for (int c = 0; c < chars.size(); c++)
      for (int j = 0; j < res.size(); j++)
        tempres.push_back(res[j] + chars[c]);
    res = tempres;
  }
  return res;
}

void printVector(vector<string>& ss) {
  cout << "{ ";
  for (int i = 0; i < ss.size(); i++) {
    if (i > 0) cout << ", ";
    cout << ss[i];
  }
  cout << " }" << endl;
}

int main(int argc, char**argv)
{
  string s = "23";
  if (argc > 1) {
    s = argv[1];
  }
  vector<string> ss = letterCombinations(s);
  printVector(ss);
  return 0;
}

```

# linkedListCycle
```cpp
/*
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
*/

#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

bool hasCycle(ListNode *head) {
  ListNode* slow = head;
  ListNode* fast = head;

  while (fast && fast->next) {
    slow = slow->next;
    fast = fast->next->next;

    if (slow == fast) {
      return true;
    }
  }
  return false;
}


int main()
{
  return 0;
}

```

# longEncodedString
```cpp
/*
Long Encoded String
----------------------------
Consider a string consisting of lowercase English alphabetic letters(i.e., [a - z]) only.We use the following rules to encode all of its characters into string s :
- a is encoded as 1, b is encoded as 2, c is encoded as 3, ..., and i is encoded as 9.
- j is encoded as 10#, k is encoded as 11#, i is encoded as 12#, ..., and z is encoded as 26#.
- If there are two or more consecutive occurrences of any character, then the character count is written within parentheses(i.e., (c), where c is an integer denoting the count of consecutive occurrences being encoded) immediately following the character.For example, consider the following string encodings :

o String "abzx" is encoded as s = "1226#24#".
o String "aabccc" is encoded as s = "1(2)23(3)".
o String "bajj" is encoded as s = "2110#(2)".
o String "wwxyzwww" is encoded as s = "23#(2)24#25#26#23#(3).

Complete the frequency function in the editor below.It has one parameter : a string, s, that was encoded using the rules above and consists of digits(i.e., decimal integers from 0 to 9), # symbols, and parentheses.It must return an array of 26 integ
- The element at index 0 denotes the frequency of character a in the original string.
- The element at index 1 denotes the frequency of character b in the original string.
- The element at index 2 denotes the frequency of character c in the original string.
- The element at index 25 denotes the frequency of character z in the original string.Input Format
Locked stub code in the editor reads encoded string s from stdin and passes it to the function.

Constraints
- String s consists of decimal integers from 0 to 9, #s, and O's only.
- 1 length of s 105
- It is guaranteed that string s is a valid encoded string.
- 2 c 104, where c is a parenthetical count of consecutive occurrences of an encoded character.

Output Format
The function must return an array of 26 integers denoting the respective frequencies of each character(i.e., a through z) in the decoded string.This is printed to stdout by locked stub code in the editor.
Sample Input 0
1226#24#

Sample Output 0
1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1
*/

#include<iostream>
#include<string>
#include<array>

using namespace std;

auto frequency(string s) {
  array<int, 26> res = {};
  int len = s.length();
  int i = 0;
  while (i < len) {
    int val = 0;
    if (i + 2 >= len || s[i + 2] != '#') {//single num
      val = s[i] - '0';
      res[val - 1]++;
      i++;
    }
    else if (s[i + 2] == '#') {//double num
      val = (s[i] - '0') * 10 + (s[i + 1] - '0');
      res[val - 1]++;
      i = i + 3;
    }
    if (i < len) {//update frequency
      if (s[i] == '(') {
        int freq = s[i + 1] - '0';
        res[val - 1] += freq - 1;
        i = i + 3;
      }
    }
  }
  return res;
}


auto main() -> int {
  string s("1226#24#");
  auto result = frequency(s);
  for (auto r: result) {
    std::cout << r;
  }

  return 0;
}
```
# longestCommonPrefix
```cpp
//Write a function to find the longest common prefix string amongst an array of strings.

#include <iostream>
#include <string>
#include <vector>
using namespace std;

string longestCommonPrefix(vector<string>& strs) {
  string prefix = "";
  for (int idx = 0; strs.size() > 0; prefix += strs[0][idx], idx++)
    for (int i = 0; i < strs.size(); i++)
      if (idx >= strs[i].size() || (i > 0 && strs[i][idx] != strs[i - 1][idx]))
        return prefix;
  return prefix;
}

int main()
{
  const char* s[] = { "abab","aba","abc" };
  vector<string> v(s, s + 3);
  cout << longestCommonPrefix(v) << endl;
}

```

# longestConsecutiveSequence
```cpp
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
*/

#include<iostream>
#include<vector>
#include<map>

using namespace std;

int longestConsecutive(vector<int> &num) {
  map<int, int> m;
  for (int i = 0; i < num.size(); i++) {
    m[num[i]] = i;
  }

  int max_seq = 0;
  for (int i = 0; i < num.size(); i++) {
    int cnt = 1;

    for (int n = num[i] + 1; m.find(n) != m.end(); n++) {
      m.erase(m.find(n));
      cnt++;

    }
    for (int n = num[i] - 1; m.find(n) != m.end(); n--) {
      m.erase(m.find(n));
      cnt++;
    }
    if (max_seq < cnt) {
      max_seq = cnt;
    }
    if (m.size() == 0) {
      break;
    }
  }
  return max_seq;
}

int main()
{
  return 0;
}
```

# longestPalindromicSubstring

```cpp
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"
Output: "bb"
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

string longestPalindrome(string s) {
  if (s.empty()) return "";
  if (s.size() == 1) return s;
  int min_start = 0, max_len = 1;
  for (int i = 0; i < s.size();) {
    if (s.size() - i <= max_len / 2) break;
    int j = i, k = i;
    while (k < s.size() - 1 && s[k + 1] == s[k]) ++k; // Skip duplicate characters.
    i = k + 1;
    while (k < s.size() - 1 && j > 0 && s[k + 1] == s[j - 1]) { ++k; --j; } // Expand.
    int new_len = k - j + 1;
    if (new_len > max_len) { min_start = j; max_len = new_len; }
  }
  return s.substr(min_start, max_len);
}


int main(int argc, char**argv)
{
  string s = "abacdfgdcaba";
  if (argc > 1) {
    s = argv[1];
  }
  cout << s << " : " << longestPalindrome(s) << endl;

  s = "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";
  cout << s << " : " << longestPalindrome(s) << endl;
  return 0;
}

```
# longestSubstringWithAtMostTwoDistinctCharacters
```cpp
/*
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 *
 * For example, Given s = “eceba”,
 *
 * T is "ece" which its length is 3.
 */

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;


/*
 * Idea:
 *
 *    1) Using a map to count every char(s).
 *    2) Using a 'cnt' to count the current distinct chars.
 *    3) If `cnt > 2`, then go through the previous substring to decrease each char's count which stored in the map,
 *       if one of char's count decrease to zero, then the global distinct chars `cnt` decrease one.
 *       During the travel, maintain a pointer `start` to point the start position of sub-string.
 *
 * The following algorithm run-time complexity is O(n^2)
 *
 * This solution can be easy to extend to "find the length of longest substring with at most K distinct char(s)"
 */
int lengthOfLongestSubstringTwoDistinct(string s) {
  int maxLen = 0;
  int charMap[256] = { 0 };
  int wordCnt = 0;
  int start = 0;

  for (int i = 0; i < s.size(); i++) {
    if (charMap[s[i]]++ == 0) {
      wordCnt++;
    }
    while (wordCnt > 2) {
      charMap[s[start]]--;
      if (charMap[s[start]] == 0) {
        wordCnt--;
      }
      start++;
    }
    maxLen = max(maxLen, i - start + 1);
  }

  return maxLen;
}


int main(int argc, char** argv)
{
  string s = "eceba";
  if (argc > 1) {
    s = argv[1];
  }
  cout << s << " : " << lengthOfLongestSubstringTwoDistinct(s) << endl;

  return 0;
}

```
# longestSubstringWithoutRepeatingCharacters

```cpp
/*
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

#include <string.h>
#include <iostream>
#include <string>
#include <map>
using namespace std;
/*
Idea:
Using a map store each char's index.
So, we can be easy to know the when duplication and the previous duplicated char's index.
Then we can take out the previous duplicated char, and keep tracking the maxiumn length.
*/

int lengthOfLongestSubstring1(string s) {
  map<char, int> m;
  int maxLen = 0;
  int lastRepeatPos = -1;
  for (int i = 0; i < s.size(); i++) {
    if (m.find(s[i]) != m.end() && lastRepeatPos < m[s[i]]) {
      lastRepeatPos = m[s[i]];
    }
    if (i - lastRepeatPos > maxLen) {
      maxLen = i - lastRepeatPos;
    }
    m[s[i]] = i;
  }
  return maxLen;
}

int lengthOfLongestSubstring(string s) {
  vector<int> dict(256, -1);
  int maxLen = 0, start = -1;
  for (int i = 0; i != s.length(); i++) {
    if (dict[s[i]] > start)
      start = dict[s[i]];
    dict[s[i]] = i;
    maxLen = max(maxLen, i - start);
  }
  return maxLen;
}

int main(int argc, char** argv)
{
  string s = "abcabcbb";
  cout << s << " : " << lengthOfLongestSubstring(s) << endl;
  s = "bbbbb";
  cout << s << " : " << lengthOfLongestSubstring(s) << endl;
  s = "bbabcdb";
  cout << s << " : " << lengthOfLongestSubstring(s) << endl;
  if (argc > 1) {
    s = argv[1];
    cout << s << " : " << lengthOfLongestSubstring(s) << endl;
  }
  return 0;
}

```

# longestValidParentheses
```cpp
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

int longestValidParentheses(string s) {
  int maxLen = 0;
  int lastError = -1;
  vector<int> stack;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '(') {
      stack.push_back(i);
    }
    else if (s[i] == ')') {
      if (stack.size() > 0) {
        stack.pop_back();
        int len;
        if (stack.size() == 0) {
          len = i - lastError;
        }
        else {
          len = i - stack.back();
        }
        if (len > maxLen) {
          maxLen = len;
        }
      }
      else {
        lastError = i;
      }
    }
  }
  return maxLen;
}


int main(int argc, char** argv)
{
  string s = ")()())";
  if (argc > 1) {
    s = argv[1];
  }
  cout << s << " : " << longestValidParentheses(s) << endl;
  return 0;
}

```

# LRUCache

```cpp
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
Follow up:
Could you do both operations in O(1) time complexity?
Example:
LRUCache cache = new LRUCache( 2  ); // 2 = capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

#include <time.h>
#include <iostream>
#include <map>
using namespace std;

/*
There is a similar example in Java, but I wanted to share my solution using the new C++11 unordered\_map and a list.
The good thing about lists is that iterators are never invalidated by modifiers (unless erasing the element itself).
This way, we can store the iterator to the corresponding LRU queue in the values of the hash map.
Since using erase on a list with an iterator takes constant time, all operations of the LRU cache run in constant time.
*/
class LRUCache {
public:
  LRUCache(int capacity) : _capacity(capacity) {}

  int get(int key) {
    auto it = cache.find(key);
    if (it == cache.end()) return -1;
    touch(it);
    return it->second.first;
  }

  void set(int key, int value) {
    auto it = cache.find(key);
    if (it != cache.end()) touch(it);
    else {
      if (cache.size() == _capacity) {
        cache.erase(used.back());
        used.pop_back();
      }
      used.push_front(key);
    }
    cache[key] = { value, used.begin() };
  }

private:
  typedef list<int> LI;
  typedef pair<int, LI::iterator> PII;
  typedef unordered_map<int, PII> HIPII;

  void touch(HIPII::iterator it) {
    int key = it->first;
    used.erase(it->second.second);
    used.push_front(key);
    it->second.second = used.begin();
  }

  HIPII cache;
  LI used;
  int _capacity;
};

int main(int argc, char** argv)
{
  srand(time(0));

  int capacity = 5;
  int test_loop_times = 10;
  if (argc > 1) {
    capacity = atoi(argv[1]);
  }
  if (argc > 2) {
    test_loop_times = atoi(argv[1]);
  }

  LRUCache cache(capacity);

  int v;
  for (int i = 0; i < test_loop_times; i++) {
    v = i;//rand() % capacity;
    cout << "set " << v << ": ";
    cache.set(v, v);
    cache.print();

    v = rand() % capacity;
    cout << "get " << v << ": " << cache.get(v);
    cache.print();

    cout << endl;
  }
  return 0;
}

```

# maximalRectangle
```cpp
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

#include <time.h>
#include <iostream>
#include <vector>
using namespace std;

/*
If you think this algorithm is not easy to understand, you can try this example:
0 0 0 1 0 0 0
0 0 1 1 1 0 0
0 1 1 1 1 1 0
The vector “left” and “right” from row 0 to row 2 are as follows
row 0:

l: 0 0 0 3 0 0 0
r: 7 7 7 4 7 7 7

row 1:
l: 0 0 2 3 2 0 0
r: 7 7 5 4 5 7 7

row 2:
l: 0 1 2 3 2 1 0
r: 7 6 5 4 5 6 7
The vector “left” is computing the left boundary. Take (i,j)=(1,3) for example. On current row 1, the left boundary is at j=2.
However, because matrix[1][3] is 1, you need to consider the left boundary on previous row as well, which is 3.
So the real left boundary at (1,3) is 3.
*/

int maximalRectangle(vector<vector<char> > &matrix) {
  if (matrix.empty()) return 0;
  const int m = matrix.size();
  const int n = matrix[0].size();
  int left[n], right[n], height[n];
  fill_n(left, n, 0); fill_n(right, n, n); fill_n(height, n, 0);
  int maxA = 0;
  for (int i = 0; i < m; i++) {
    int cur_left = 0, cur_right = n;
    for (int j = 0; j < n; j++) { // compute height (can do this from either side)
      if (matrix[i][j] == '1') height[j]++;
      else height[j] = 0;
    }
    for (int j = 0; j < n; j++) { // compute left (from left to right)
      if (matrix[i][j] == '1') left[j] = max(left[j], cur_left);
      else { left[j] = 0; cur_left = j + 1; }
    }
    // compute right (from right to left)
    for (int j = n - 1; j >= 0; j--) {
      if (matrix[i][j] == '1') right[j] = min(right[j], cur_right);
      else { right[j] = n; cur_right = j; }
    }
    // compute the area of rectangle (can do this from either side)
    for (int j = 0; j < n; j++)
      maxA = max(maxA, (right[j] - left[j])*height[j]);
  }
  return maxA;
}


void printArray(vector<int> &v)
{
  cout << "{";
  for (int i = 0; i < v.size(); i++) {
    cout << " " << v[i];
  }
  cout << "}" << endl;
}

void test(int a[], int n)
{
  vector<int> v(a, a + n);
  printArray(v);
  cout << largestRectangleArea(v) << endl;
}

int main(int argc, char** argv)
{
#define TEST(a) test(a, sizeof(a)/sizeof(int))

  int a0[] = { 2,1,3,1 };
  TEST(a0);
  int a1[] = { 2,1,5,6,2,3 };
  TEST(a1);

  cout << "------------------" << endl;
  srand(time(0));

  int r = 3;
  int c = 3;
  if (argc > 2) {
    r = atoi(argv[1]);
    c = atoi(argv[2]);
  }

  vector< vector<char> > matrix;
  for (int i = 0; i < r; i++) {
    vector<char> v;
    cout << "[";
    for (int j = 0; j < c; j++) {
      char ch = rand() % 2 + '0';
      v.push_back(ch);
      cout << " " << ch;
    }
    matrix.push_back(v);
    cout << " ]" << endl;
  }
  cout << "------------------" << endl;
  cout << "maxArea = " << maximalRectangle(matrix) << endl;

  return 0;
}

```
# maximumDepthOfBinaryTree
```cpp
/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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

int maxDepth(TreeNode* root) {
  if (root == nullptr) {
    return 0;
  }
  int depth_left = maxDepth(root->left) + 1;
  int depth_right = maxDepth(root->right) + 1;
  return depth_left > depth_right ? depth_left : depth_right;
}


class Solution {
public:
  int maxDepth(TreeNode *root) {
    if (root == nullptr) {
      return 0;
    }
    if (!root->left && !root->right) {
      return 1;
    }
    int left = 1, right = 1;
    if (root->left) {
      left += maxDepth(root->left);
    }
    if (root->right) {
      right += maxDepth(root->right);
    }
    return left > right ? left : right;
  }

};



int main()
{
  return 0;
}

```
# maximumProductSubarray
```cpp
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

#include <iostream>
#include <algorithm>
using namespace std;

int maxProduct(int A[], int n) {
  if (n == 1) return A[0];
  int pMax = 0, nMax = 0, m = 0;
  for (int i = 0; i < n; i++) {
    if (A[i] < 0) swap(pMax, nMax);
    pMax = max(pMax*A[i], A[i]);
    nMax = min(nMax*A[i], A[i]);
    m = max(m, pMax);
  }
  return m;
}

// The only thing to note here is, maximum product can also be obtained by minimum (negative) product
// ending with the previous element multiplied by this element. For example, in array {12, 2, -3, -5, -6, -2},
// when we are at element -2, the maximum product is multiplication of, minimum product ending with -6 and -2.
int maxProduct1(int A[], int n) {
  // To remember the max/min product for previous position
  int maxPrev = A[0], minPrev = A[0];
  // To remember the max/min product for current position
  int maxHere = A[0], minHere = A[0];
  // Overall maximum product
  int maxProd = A[0];

  for (int i = 1; i < n; i++) {
    //max( maxPrev * A[i],  minPrev * A[i],  A[i] )
    maxHere = max(max(maxPrev * A[i], minPrev * A[i]), A[i]);
    //min( maxPrev * A[i],  minPrev * A[i],  A[i] )
    minHere = min(min(maxPrev * A[i], minPrev * A[i]), A[i]);
    //Keep tracking the overall maximum product
    maxProd = max(maxHere, maxProd);
    //Shift the current max/min product to previous variables
    maxPrev = maxHere;
    minPrev = minHere;
  }
  return maxProd;
}

#define TEST(a) cout << maxProduct( a, sizeof(a)/sizeof(int)) << endl
int main()
{
  int o[] = { 2,3,-2,4 };
  TEST(o);

  int a[] = { -4,-3 };
  TEST(a);

  int b[] = { -1, -1 };
  TEST(b);

  int c[] = { -1, 0, -2 };
  TEST(c);
}

```
# maximumSubArray

```cpp
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using
the divide and conquer approach, which is more subtle.
*/

#include <iostream>
#include <time.h>

int maxSubArray1(int A[], int n);
int maxSubArray2(int A[], int n);

int max(int x, int y) {
  return x > y ? x : y;
}

int maxSubArray(int A[], int n) {
  if (rand() % 2) {
    return maxSubArray1(A, n);
  }
  return maxSubArray2(A, n);
}

int maxSubArray1(int A[], int n) {
  int *sum = new int[n];
  sum[0] = A[0];
  int m = A[0];
  for (int i = 1; i < n; i++) {
    sum[i] = max(A[i], A[i] + sum[i - 1]);
    m = max(m, sum[i]);
  }
  delete[] sum;
  return m;
}

int main()
{
  srand(time(nullptr));
  int a[] = { -2,1,-3,4,-1,2,1,-5,4 };
  printf("%d\n", maxSubArray(a, sizeof(a) / sizeof(int)));
  printf("%d\n", maxSubArray(a, sizeof(a) / sizeof(int)));
  return 0;
}

```

# maxPointsOnALine
```cpp
//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

#include <time.h>
#include <iostream>
#include <vector>
#include <map>
using namespace std;

struct Point {
  int x;
  int y;
  Point() : x(0), y(0) {}
  Point(int a, int b) : x(a), y(b) {}
};

// The idea is straight forward. Calculate each slope between two points and handle two special cases: 1. vertical, 2. duplicate.

class Solution {
public:
  int maxPoints(vector<Point>& points)
  {
    if (points.size() <= 2) return points.size();
    int res = 0;
    for (int i = 0; i < points.size() - 1; i++) {
      int numVertical = 1, local = 1, duplicate = 0;
      unordered_map<double, int> map;
      for (int j = i + 1; j < points.size(); j++)
        if (points[i].x == points[j].x) // special cases
          if (points[i].y == points[j].y) // duplicate
            duplicate++;
          else // vertical
            numVertical++;
        else {
          double slope = (points[i].y - points[j].y)*1.0 / (points[i].x - points[j].x);
          map[slope] == 0 ? map[slope] = 2 : map[slope]++;
          local = max(local, map[slope]);
        }
        local = max(local + duplicate, numVertical + duplicate);
        res = max(res, local);
    }
    return res;
  }
};

void generatePoints(vector<Point> &points, int n) {
  srand(time(0));
  Point p;
  for (int i = 0; i < n; i++) {
    p.x = rand() % 1;
    p.y = rand() % 1;
    points.push_back(p);
  }
}

void printPoints(vector<Point> &points) {
  for (int i = 0; i < points.size(); i++) {
    cout << "(" << points[i].x << "," << points[i].y << ") ";
  }
  cout << endl;
}


int main(int argc, char** argv)
{
  int n = 20;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  vector<Point> points;
  generatePoints(points, n);
  printPoints(points);
  cout << maxPoints(points) << endl;
  return 0;
}

```

# medianOfTwoSortedArrays
```cpp
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

//Solution explanation: https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471
*/

#include <stdio.h>

double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
  int N1 = nums1.size();
  int N2 = nums2.size();
  if (N1 < N2) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.

  int lo = 0, hi = N2 * 2;
  while (lo <= hi) {
    int mid2 = (lo + hi) / 2;   // Try Cut 2
    int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly

    double L1 = (mid1 == 0) ? INT_MIN : nums1[(mid1 - 1) / 2];	// Get L1, R1, L2, R2 respectively
    double L2 = (mid2 == 0) ? INT_MIN : nums2[(mid2 - 1) / 2];
    double R1 = (mid1 == N1 * 2) ? INT_MAX : nums1[(mid1) / 2];
    double R2 = (mid2 == N2 * 2) ? INT_MAX : nums2[(mid2) / 2];

    if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
    else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
    else return (max(L1, L2) + min(R1, R2)) / 2;	// Otherwise, that's the right cut.
  }
  return -1;
}


int main()
{
  int r1[] = { 1 };
  int r2[] = { 2 };

  int n1 = sizeof(r1) / sizeof(r1[0]);
  int n2 = sizeof(r2) / sizeof(r2[0]);

  printf("Median is 1.5 = %f\n", findMedianSortedArrays(r1, n1, r2, n2));

  int ar1[] = { 1, 12, 15, 26, 38 };
  int ar2[] = { 2, 13, 17, 30, 45, 50 };

  n1 = sizeof(ar1) / sizeof(ar1[0]);
  n2 = sizeof(ar2) / sizeof(ar2[0]);

  printf("Median is 17 = %f\n", findMedianSortedArrays(ar1, n1, ar2, n2));

  int ar11[] = { 1, 12, 15, 26, 38 };
  int ar21[] = { 2, 13, 17, 30, 45 };

  n1 = sizeof(ar11) / sizeof(ar11[0]);
  n2 = sizeof(ar21) / sizeof(ar21[0]);

  printf("Median is 16 = %f\n", findMedianSortedArrays(ar11, n1, ar21, n2));

  int a1[] = { 1, 2, 5, 6, 8 };
  int a2[] = { 13, 17, 30, 45, 50 };

  n1 = sizeof(a1) / sizeof(a1[0]);
  n2 = sizeof(a2) / sizeof(a2[0]);

  printf("Median is 10.5 = %f\n", findMedianSortedArrays(a1, n1, a2, n2));

  int a10[] = { 1, 2, 5, 6, 8, 9, 10 };
  int a20[] = { 13, 17, 30, 45, 50 };

  n1 = sizeof(a10) / sizeof(a10[0]);
  n2 = sizeof(a20) / sizeof(a20[0]);

  printf("Median is 9.5 = %f\n", findMedianSortedArrays(a10, n1, a20, n2));

  int a11[] = { 1, 2, 5, 6, 8, 9 };
  int a21[] = { 13, 17, 30, 45, 50 };

  n1 = sizeof(a11) / sizeof(a11[0]);
  n2 = sizeof(a21) / sizeof(a21[0]);

  printf("Median is 9 = %f\n", findMedianSortedArrays(a11, n1, a21, n2));

  int a12[] = { 1, 2, 5, 6, 8 };
  int a22[] = { 11, 13, 17, 30, 45, 50 };

  n1 = sizeof(a12) / sizeof(a12[0]);
  n2 = sizeof(a22) / sizeof(a22[0]);

  printf("Median is 11 = %f\n", findMedianSortedArrays(a12, n1, a22, n2));

  int b1[] = { 1 };
  int b2[] = { 2,3,4 };

  n1 = sizeof(b1) / sizeof(b1[0]);
  n2 = sizeof(b2) / sizeof(b2[0]);

  printf("Median is 2.5 = %f\n", findMedianSortedArrays(b1, n1, b2, n2));
  return 0;
}

```

# mergeIntervals
```cpp
/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Interval {
  int start;
  int end;
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}
};

vector<Interval> merge(vector<Interval>& ins) {
  if (ins.empty()) return vector<Interval>{};
  vector<Interval> res;
  sort(ins.begin(), ins.end(), [](Interval a, Interval b) {return a.start < b.start; });
  res.push_back(ins[0]);
  for (int i = 1; i < ins.size(); i++) {
    if (res.back().end < ins[i].start) res.push_back(ins[i]);
    else
      res.back().end = max(res.back().end, ins[i].end);
  }
  return res;
}

int main(int argc, char**argv)
{
  Interval i1(1, 4);
  Interval i2(0, 2);
  Interval i3(3, 5);
  Interval i4(15, 18);
  vector<Interval> intervals;
  intervals.push_back(i1);
  intervals.push_back(i2);
  intervals.push_back(i3);
  intervals.push_back(i4);

  vector<Interval> r = merge(intervals);

  for (int i = 0; i < r.size(); i++) {
    cout << "[ " << r[i].start << ", " << r[i].end << " ] ";
  }
  cout << endl;

  return 0;
}

```
# mergeKSortedLists

```cpp
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

#include <time.h>
#include <iostream>
#include <vector>
using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};


struct ListNode* SortedMerge(struct ListNode* a, struct ListNode* b)
{
  struct ListNode* result(nullptr);
  /* Base cases */
  if (a == nullptr)
    return(b);
  else if (b == nullptr)
    return(a);

  /* Pick either a or b, and recur */
  if (a->val <= b->val)
  {
    result = a;
    result->next = SortedMerge(a->next, b);
  }
  else
  {
    result = b;
    result->next = SortedMerge(a, b->next);
  }
  return(result);
}


void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int a[], int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}

int main(int argc, char**argv)
{
  int n;
  srand(time(0));
  if (argc > 1) {
    n = atoi(argv[1]) % 2;
  }

  int a[] = { 1,3,5,6,7,10 };
  int b[] = { 0,4,6,8,9,11,20,30,40 };
  ListNode* p1 = createList(a, sizeof(a) / sizeof(int));
  ListNode* p2 = createList(b, sizeof(b) / sizeof(int));

  auto result = SortedMerge(p1, p2);
  printList(result);


  cout << "method " << n + 1 << endl;
  return 0;
}

```
# mergeTwoSortedArray
```cpp
// Source : https://leetcode.com/problems/merge-sorted-array/description/
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

#include <iostream>

void merge(int A[], int m, int B[], int n) {
  int i = m - 1;
  int j = n - 1;
  int k = m + n - 1;
  while (i >= 0 && j >= 0)
  {
    if (A[i] > B[j])
      A[k--] = A[i--];
    else
      A[k--] = B[j--];
  }
  while (j >= 0)
    A[k--] = B[j--];
}


void printArray(int A[], int n) {
  printf("{");
  for (int i = 0; i < n; i++) {
    printf("%d, ", A[i]);
  }
  printf("}\n");
}

int main()
{
  int a[] = { 2,4,6,8,10,0,0,0 };
  int b[] = { 1,3,5 };
  merge(a, 5, b, 3);
  printArray(a, sizeof(a) / sizeof(int));

  int a1[] = { 2,4,0,0,0 };
  int b1[] = { 3,5,7 };
  merge(a1, 2, b1, 3);
  printArray(a1, sizeof(a1) / sizeof(int));

  int a2[] = { 12,14,16,18,20,0,0,0 };
  int b2[] = { 1,3,5 };
  merge(a2, 5, b2, 3);
  printArray(a2, sizeof(a2) / sizeof(int));

  int a3[] = { 2,0 };
  int b3[] = { 3, };
  merge(a3, 1, b3, 1);
  printArray(a3, sizeof(a3) / sizeof(int));

  int a4[] = { 0,0,0 };
  int b4[] = { 1,3,5 };
  merge(a4, 0, b4, 3);
  printArray(a4, sizeof(a4) / sizeof(int));

  int a5[] = { 2,4,6,8,10,0,0,0 };
  int b5[] = { 11,13,15 };
  merge(a5, 5, b5, 3);
  printArray(a5, sizeof(a5) / sizeof(int));

  int a6[] = { 2,4,0,0,0,0,0,0 };
  int b6[] = { 1,3,5,7,9,11 };
  merge(a6, 2, b6, 6);
  printArray(a6, sizeof(a6) / sizeof(int));

  return 0;
}

```

# mergeTwoSortedList
```cpp
// Source : https://leetcode.com/problems/merge-two-sorted-lists/description/
/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

#include <iostream>
#include <vector>
using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode* mergeTwoLists(ListNode *l1, ListNode *l2) {
  if (l1 == nullptr) return l2;
  if (l2 == nullptr) return l1;

  if (l1->val < l2->val) {
    l1->next = mergeTwoLists(l1->next, l2);
    return l1;
  }
  else {
    l2->next = mergeTwoLists(l2->next, l1);
    return l2;
  }
}


int main()
{
  // create 1st list
  vector<int> data = { 1, 2, 3, 4, 5 };
  ListNode *head = nullptr, *p = nullptr;

  for (auto i : data) {
    if (head == nullptr) {
      head = p = new ListNode(i);
    }
    else {
      p->next = new ListNode(i);
      p = p->next;
    }
  }

  // create 2nd list
  vector<int> data2 = { 41, 22, 41, 64, 75 };
  ListNode *head2 = nullptr, *p2 = nullptr;

  for (auto i : data2) {
    if (head2 == nullptr) {
      head2 = p2 = new ListNode(i);
    }
    else {
      p2->next = new ListNode(i);
      p2 = p2->next;
    }
  }

  Solution s;
  auto v = mergeTwoLists(head, head2);
  while (v != nullptr) {
    cout << v->val << " " << endl;
    v = v->next;
  }


  return 0;
}
```

# minimumDepthOfBinaryTree
```cpp
// Source : https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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


int minDepth(TreeNode *root) {
  if (!root) return 0;
  if (!root->left) return 1 + minDepth(root->right);
  if (!root->right) return 1 + minDepth(root->left);
  return 1 + min(minDepth(root->left), minDepth(root->right));
}


int main()
{

  return 0;

}
```
# minimumPathSum
```cpp
// Source : https://leetcode.com/problems/minimum-path-sum/description/
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
*/

#include <limits.h>
#include <iostream>
#include <vector>
using namespace std;

int minPathSum(vector<vector<int>>& grid) {
  int m = grid.size();
  int n = grid[0].size();
  vector<int> cur(m, grid[0][0]);
  for (int i = 1; i < m; i++)
    cur[i] = cur[i - 1] + grid[i][0];
  for (int j = 1; j < n; j++) {
    cur[0] += grid[0][j];
    for (int i = 1; i < m; i++)
      cur[i] = min(cur[i - 1], cur[i]) + grid[i][j];
  }
  return cur[m - 1];
}

int main()
{
  int a[6][2] = { {7,2},{6,6},{8,6},{8,7},{5,0},{6,0} };
  vector< vector<int> > grid;
  for (int i = 0; i < 6; i++) {
    vector<int> v;
    for (int j = 0; j < 2; j++) {
      v.push_back(a[i][j]);
    }
    grid.push_back(v);
  }

  cout << "minPathSum=" << minPathSum(grid) << endl;

  return 0;
}


```
# minimumWindowSubstring
```cpp
// Source : https://leetcode.com/problems/minimum-window-substring/description/
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

#include <string>
#include <iostream>
#include <string>
using namespace std;

// https://leetcode.com/problems/minimum-window-substring/discuss/26808
string minWindow(string s, string t) {
  vector<int> map(128, 0);
  for (auto c : t) map[c]++;
  int counter = t.size(), begin = 0, end = 0, d = INT_MAX, head = 0;
  while (end < s.size()) {
    if (map[s[end++]]-- > 0) counter--; //in t
    while (counter == 0) { //valid
      if (end - begin < d)  d = end - (head = begin);
      if (map[s[begin++]]++ == 0) counter++;  //make it invalid
    }
  }
  return d == INT_MAX ? "" : s.substr(head, d);
}

int lengthOfLongestSubstring(string s) {
  vector<int> map(128, 0);
  int counter = 0, begin = 0, end = 0, d = 0;
  while (end < s.size()) {
    if (map[s[end++]]++ > 0) counter++;
    while (counter > 0) if (map[s[begin++]]-- > 1) counter--;
    d = max(d, end - begin); //while valid, update d
  }
  return d;
}

int main(int argc, char**argv)
{
  string S = "ADOBECODEBANC";
  string T = "ABC";
  if (argc > 2) {
    S = argv[1];
    T = argv[2];
  }
  cout << "S = \"" << S << "\"  T=\"" << T << "\"" << endl;
  cout << minWindow(S, T) << endl;
  return 0;
}


```
# minStack
```cpp
// Source : https://leetcode.com/problems/min-stack/description/
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

#include <iostream>
using namespace std;

class MinStack {
public:
    vector<int> a;
    vector<int> min;
    MinStack() {
        min.push_back(2147483647);
    }
    void push(int x) {
        a.push_back(x);
        if (x < min.back()) {
            min.push_back(x);
        } else {
            min.push_back(min.back());
        }
    }

    void pop() {
        a.pop_back();
        min.pop_back();
    }

    int top() {
        return a.back();
    }

    int getMin() {
        return min.back();
    }
};

class MinStack {
private:
    stack<int> s1;
    stack<int> s2;
public:
    void push(int x) {
	    s1.push(x);
	    if (s2.empty() || x <= getMin())  s2.push(x);
    }
    void pop() {
	    if (s1.top() == getMin())  s2.pop();
	    s1.pop();
    }
    int top() {
	    return s1.top();
    }
    int getMin() {
	    return s2.top();
    }
};

int main()
{
    cout << "--- expected output [0, 0, 0, 2]" << endl;
    MinStack ms;
    ms.push(2);
    ms.push(0);
    ms.push(3);
    ms.push(0);

    cout << ms.getMin() << endl;
    ms.pop();
    cout << ms.getMin() << endl;
    ms.pop();
    cout << ms.getMin() << endl;
    ms.pop();
    cout << ms.getMin() << endl;


    ms.clear();

    cout << "--- expected output [2147483647 2147483646 2147483646 2147483647 2147483647 -2147483648 -2147483648 2147483647 " << endl;

    ms.push(2147483646);
    ms.push(2147483646);
    ms.push(2147483647);

    cout << ms.top() << endl;
    ms.pop();
    cout << ms.getMin() << endl;
    ms.pop();
    cout << ms.getMin() << endl;
    ms.pop();

    ms.push(2147483647);
    cout << ms.top() << endl;
    cout << ms.getMin() << endl;
    ms.push(-2147483648);
    cout << ms.top() << endl;
    cout << ms.getMin() << endl;
    ms.pop();
    cout << ms.getMin() << endl;

    return 0;
}

```

# multiplyStrings
```cpp
// Source : https://leetcode.com/problems/multiply-strings/description/
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

#include <iostream>
#include <string>
using namespace std;

/*
This is the standard manual multiplication algorithm. We use two nested for loops, working backward from the end of each input number.
We pre-allocate our result and accumulate our partial result in there.
One special case to note is when our carry requires us to write to our sum string outside of our for loop.
At the end, we trim any leading zeros, or return 0 if we computed nothing but zeros.
*/
string multiply(string num1, string num2) {
    string sum(num1.size() + num2.size(), '0');

    for (int i = num1.size() - 1; 0 <= i; --i) {
        int carry = 0;
        for (int j = num2.size() - 1; 0 <= j; --j) {
            int tmp = (sum[i + j + 1] - '0') + (num1[i] - '0') * (num2[j] - '0') + carry;
            sum[i + j + 1] = tmp % 10 + '0';
            carry = tmp / 10;
        }
        sum[i] += carry;
    }

    size_t startpos = sum.find_first_not_of("0");
    if (string::npos != startpos) {
        return sum.substr(startpos);
    }
    return "0";
}

int main(int argc, char**argv)
{
    string s1="20";
    string s2="25";
    if (argc>2){
        s1 = argv[1];
        s2 = argv[2];
    }
    cout << s1 << " * " << s2 << " = " << multiply(s1, s2) << endl;
    return 0;
}

```
# nextPermutation

```cpp
// Source : https://leetcode.com/problems/next-permutation/description/
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void nextPermutation(vector<int>& nums) {
  int k = -1;
  for (int i = nums.size() - 2; i >= 0; i--) {
    if (nums[i] < nums[i + 1]) {
      k = i;
      break;
    }
  }
  if (k == -1) {
    reverse(nums.begin(), nums.end());
    return;
  }
  int l = -1;
  for (int i = nums.size() - 1; i > k; i--) {
    if (nums[i] > nums[k]) {
      l = i;
      break;
    }
  }
  swap(nums[k], nums[l]);
  reverse(nums.begin() + k + 1, nums.end());
}

void nextPermutation(vector<int> &num) {

  if (num.size() <= 1) return;

  for (int i = num.size() - 1; i > 0; i--) {
    if (num[i - 1] < num[i]) {
      int j = num.size() - 1;
      while (num[i - 1] >= num[j]) {
        //pass;
        j--;
      }
      int tmp = num[j];
      num[j] = num[i - 1];
      num[i - 1] = tmp;
      //sort works as well
      //sort(num.begin()+i, num.end()); 
      reverse(num.begin() + i, num.end());
      return;
    }
    //edge case: 4 3 2 1
    if (i == 1) {
      //sort works as well
      //sort(num.begin(), num.end());
      reverse(num.begin(), num.end());
      return;
    }
  }

}

void printVector(vector<int> &num) {
  for (int i = 0; i < num.size(); i++) {
    cout << num[i] << " ";
  }
  cout << endl;
}
bool isBeginVector(vector<int> &num) {
  for (int i = 0; i < num.size(); i++) {
    if (num[i] != i + 1) {
      return false;
    }
  }
  return true;
}

int main(int argc, char** argv)
{
  int n = 4;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  vector<int> num;
  for (int i = 1; i <= n; i++) {
    num.push_back(i);
  }

  while (true) {
    printVector(num);
    nextPermutation(num);
    if (isBeginVector(num)) {
      break;
    }
  }
  return 0;
}

```

# nQueens
```cpp
// Source : https://leetcode.com/problems/n-queens/description/
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
#include <iostream>
#include <vector>
#include <string>
using namespace std;

// https://leetcode.com/problems/n-queens/discuss/19808/
class Solution {
public:
  std::vector<std::vector<std::string> > solveNQueens(int n) {
    std::vector<std::vector<std::string> > res;
    std::vector<std::string> nQueens(n, std::string(n, '.'));
    solveNQueens(res, nQueens, 0, n);
    return res;
  }
private:
  void solveNQueens(std::vector<std::vector<std::string> > &res, std::vector<std::string> &nQueens, int row, int &n) {
    if (row == n) {
      res.push_back(nQueens);
      return;
    }
    for (int col = 0; col != n; ++col)
      if (isValid(nQueens, row, col, n)) {
        nQueens[row][col] = 'Q';
        solveNQueens(res, nQueens, row + 1, n);
        nQueens[row][col] = '.';
      }
  }
  bool isValid(std::vector<std::string> &nQueens, int row, int col, int &n) {
    //check if the column had a queen before.
    for (int i = 0; i != row; ++i)
      if (nQueens[i][col] == 'Q')
        return false;
    //check if the 45\xb0 diagonal had a queen before.
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
      if (nQueens[i][j] == 'Q')
        return false;
    //check if the 135\xb0 diagonal had a queen before.
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
      if (nQueens[i][j] == 'Q')
        return false;
    return true;
  }
};


void printMatrix(vector< vector<string> >& matrix) {
  for (int i = 0; i < matrix.size(); i++) {
    cout << "-----------" << endl;
    for (int j = 0; j < matrix[i].size(); j++) {
      cout << matrix[i][j] << endl;
    }
  }
}


int main(int argc, char** argv)
{
  int n = 8;
  if (argc > 1) {
    n = atoi(argv[1]);
  }

  vector< vector<string> > result = solveNQueens(n);
  printMatrix(result);

  return 0;
}


```

# oneEditDistance

```cpp
// Source : https://oj.leetcode.com/problems/one-edit-distance/
//Given two strings S and T, determine if they are both one edit distance apart.

#include <string.h>
#include <iostream>
#include <string>
using namespace std;


/*
 * Notes:
 *
 *   If you try to use the Dynamic Program Algorithm, just like the `Edit Distance`,
 *   Then, you will get `Memory Limit Error` or `Time Limit Error`.
 *
 *   The Dynamic Program Algorithm which `Edit Distance` prolem used call `Wagner–Fischer Algorithm`
 *   (refer to: http://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm)
 *   Ths DP algorithm's  time complexity is O(m*n), and the space complexity is O(m*n) as well,
 *   You can optimized the space complexity to O(2*min(m,n)), but it still have `Time Limit Error`
 *
 *   Fortunately, this problem just for the `One` edit distance, so, this is special case we can solve it by special way.
 */

bool isOneEditDistance(string s, string t) {
  int len_s = s.size();
  int len_t = t.size();
  if (len_s == 0) return len_t == 1;
  if (len_t == 0) return len_s == 1;


  switch (abs(len_s - len_t)) {
  case 0:
  {
    //if these two strings have same length.
    //it means - we cannot use `add` or `delete` edit methods, just use the `replace` method
    //So, just simply count the different char(s).
    int cnt = 0;
    for (int i = 0; i < len_s; i++) {
      if (s[i] != t[i]) {
        cnt++;
        if (cnt > 1) return false;
      }
    }
    return cnt == 1;
  }

  case 1:
  {
    //if these two strings' length just have ONE difference.
    //it means - we only can use `delete` edit method to delete one char in longer string.
    //So, just remove one char in longer string, and check it whether equal to shorter string.
    string& ss = (len_s > len_t) ? s : t;
    string& tt = (len_s < len_t) ? s : t;
    for (int i = 0; i < ss.size(); i++) {
      string tmp = ss;
      if (ss.erase(i, 1) == tt) {
        return true;
      }
    }
    return false;

  }

  default:
    return false;
  }

  return false;
}

int main(int argc, char** argv)
{
  string s = "ab", t = "acb";
  if (argc > 2) {
    s = argv[1];
    t = argv[2];
  }
  cout << "s = \"" << s << "\"  t = \"" << t << "\"  : " << (isOneEditDistance(s, t) ? "true" : "false") << endl;
  return 0;
}

```

# palindromeNumber
```cpp
// Source : https://oj.leetcode.com/problems/palindrome-number/
/*
Determine whether an integer is a palindrome. Do this without extra space.
Some hints:
Could negative integers be palindromes? (ie, -1)
If you are thinking of converting the integer to string, note the restriction of using extra space.
You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
There is a more generic way of solving this problem.
*/

#include <iostream>

bool isPalindrome(int x) {
  if (x < 0 || (x != 0 && x == 0)) return false;
  int sum = 0;
  while (x > sum)
  {
    sum = sum * 10 + x;
    x = x / 10;
  }
  return (x == sum) || (x == sum / 10);
}

int main()
{
  printf("%d is %d\n", 0, isPalindrome(0));
  printf("%d is %d\n", -101, isPalindrome(-101));
  printf("%d is %d\n", 1001, isPalindrome(1001));
  printf("%d is %d\n", 1234321, isPalindrome(1234321));
  printf("%d is %d\n", 2147447412, isPalindrome(2147447412));
  printf("%d is %d\n", 2142, isPalindrome(2142));
}

```

# palindromePartitioning

```cpp
// Source : https://leetcode.com/problems/palindrome-partitioning/description/
/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
[
  ["aa","b"],
  ["a","a","b"]
]
*/

#include <iostream>
#include <vector>
#include <string>
using namespace std;

/*
DFS - Deepth First Search
For example: "aaba"
                    +------+
             +------| aaba |-----+
             |      +------+     |
           +-v-+              +-v--+
           | a |aba           | aa |ba
       +---+---+--+           +--+-+
       |          |              |
     +-v-+     +--v--+         +-v-+
     | a |ba   | aba |\0       | b |a
     +-+-+     +-----+         +-+-+
       |        a, aba           |
     +-v-+                     +-v-+
     | b |a                    | a |\0
     +-+-+                     +---+
       |                      aa, b, a
     +-v-+
     | a |\0
     +---+
   a, a, b, a

  You can see this algorithm still can be optimized, becasue there are some dupliation.
  (  The optimization you can see the "Palindrome Partitioning II" )
*/
vector<vector<string>> partition(string s) {
  vector<vector<string> > ret;
  if (s.empty()) return ret;

  vector<string> path;
  dfs(0, s, path, ret);

  return ret;
}

void dfs(int index, string& s, vector<string>& path, vector<vector<string> >& ret) {
  if (index == s.size()) {
    ret.push_back(path);
    return;
  }
  for (int i = index; i < s.size(); ++i) {
    if (isPalindrome(s, index, i)) {
      path.push_back(s.substr(index, i - index + 1));
      dfs(i + 1, s, path, ret);
      path.pop_back();
    }
  }
}

bool isPalindrome(const string& s, int start, int end) {
  while (start <= end) {
    if (s[start++] != s[end--])
      return false;
  }
  return true;
}

void printMatrix(vector< vector<string> > &matrix)
{
  for (int i = 0; i < matrix.size(); i++) {
    cout << "{ ";
    for (int j = 0; j < matrix[i].size(); j++) {
      cout << matrix[i][j] << ", ";
    }
    cout << "}" << endl;
  }
  cout << endl;
}


int main(int argc, char** argv)
{
  string s("aab");
  if (argc > 1) {
    s = argv[1];
  }

  vector< vector<string> > result = partition(s);

  printMatrix(result);
}

```
# partitionList
```cpp
// Source : https://leetcode.com/problems/partition-list/description/
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

#include <stdio.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *partition(ListNode *head, int x) {
  ListNode node1(0), node2(0);
  ListNode *p1 = &node1, *p2 = &node2;
  while (head) {
    if (head->val < x)
      p1 = p1->next = head;
    else
      p2 = p2->next = head;
    head = head->next;
  }
  p2->next = NULL;
  p1->next = node2.next;
  return node1.next;
}

void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int a[], int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}

int main()
{
  //int a[] = {1}; int x =2;
  //int a[] = {2,3,1}; int x=2;
  int a[] = { 3,1,2 }; int x = 3;
  ListNode* p = createList(a, sizeof(a) / sizeof(int));
  printList(p);
  p = partition(p, x);
  printList(p);

  return 0;
}

```

# pascalTriangle

```cpp
// Source : https://leetcode.com/problems/pascals-triangle/description/
/*
Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

#include <vector>
#include <iostream>
using namespace std;

vector<vector<int> > generate(int numRows) {
  vector<vector<int>> r(numRows);

  for (int i = 0; i < numRows; i++) {
    r[i].resize(i + 1);
    r[i][0] = r[i][i] = 1;

    for (int j = 1; j < i; j++)
      r[i][j] = r[i - 1][j - 1] + r[i - 1][j];
  }

  return r;
}

void printTriangle(vector< vector<int> > pt)
{
  cout << "[" << endl;
  for (int i = 0; i < pt.size(); i++) {
    for (int space = (pt.size() - i - 1); space >= 0; space--) {
      cout << " ";
    }
    cout << "[";
    for (int j = 0; j < pt[i].size(); j++) {
      cout << pt[i][j];
      if (j < pt[i].size() - 1) {
        cout << ",";
      }
    }
    cout << "]";
    if (i < pt.size() - 1) {
      cout << ",";
    }
    cout << endl;
  }
  cout << "]" << endl;
}

int main(int argc, char** argv)
{
  int n = 3;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  printTriangle(generate(n));
}

```

# pathSum
```cpp
// Source : https://leetcode.com/problems/path-sum/description/
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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

bool hasPathSum(TreeNode *root, int sum) {
  if (root == NULL) return false;
  if (root->right == root->left)  return sum == root->val;
  return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
}


bool hasPathSum2(TreeNode *root, int sum) {

  if (root == nullptr) return false;

  if (root->left == nullptr && root->right == nullptr) {
    return (root->val == sum);
  }

  if (root->left) {
    root->left->val += root->val;
    if (hasPathSum2(root->left, sum)) {
      return true;
    }
  }

  if (root->right) {
    root->right->val += root->val;
    if (hasPathSum2(root->right, sum)) {
      return true;
    }
  }

  return false;
}


int main()
{
  return 0;
}
```
# permutations

```cpp
// Source : https://leetcode.com/problems/permutations/description/
/*
Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > permute(vector<int> &num) {
  vector<vector<int> > result;

  permuteRecursive(num, 0, result);
  return result;
}

// permute num[begin..end]
// invariant: num[0..begin-1] have been fixed/permuted
void permuteRecursive(vector<int> &num, int begin, vector<vector<int> > &result) {
  if (begin >= num.size()) {
    // one permutation instance
    result.push_back(num);
    return;
  }

  for (int i = begin; i < num.size(); i++) {
    swap(num[begin], num[i]);
    permuteRecursive(num, begin + 1, result);
    // reset
    swap(num[begin], num[i]);
  }
}

int main(int argc, char** argv)
{
  int n = 3;
  if (argc > 1) {
    n = atoi(argv[1]);
  }

  vector<int> v;
  for (int i = 0; i < n; i++) {
    v.push_back(i + 1);
  }
  vector<vector<int> > vv;
  vv = permute(v);

  for (int i = 0; i < vv.size(); i++) {
    cout << "{ ";
    for (int j = 0; j < vv[i].size(); j++) {
      cout << vv[i][j] << " ";
    }
    cout << "}" << endl;
  }

  return 0;
}

```
# permutationSequence
```cpp
// Source : https://leetcode.com/problems/permutation-sequence/description/
/*
The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

#include <iostream>
using namespace std;

string getPermutation(int n, int k) {
  int i, j, f = 1;
  // left part of s is partially formed permutation, right part is the leftover chars.
  string s(n, '0');
  for (i = 1; i <= n; i++) {
    f *= i;
    s[i - 1] += i; // make s become 1234...n
  }
  for (i = 0, k--; i < n; i++) {
    f /= n - i;
    j = i + k / f; // calculate index of char to put at s[i]
    char c = s[j];
    // remove c by shifting to cover up (adjust the right part).
    for (; j > i; j--)
      s[j] = s[j - 1];
    k %= f;
    s[i] = c;
  }
  return s;
}

int main(int argc, char**argv)
{
  int n = 3, k = 6;
  if (argc > 2) {
    n = atoi(argv[1]);
    k = atoi(argv[2]);
  }
  cout << "n = " << n << ", k = " << k << " : " << getPermutation(n, k) << endl;

  return 0;
}

```

# plusOne
// Source : https://leetcode.com/problems/plus-one/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
*/

#include <iostream>
#include <vector>
using namespace std;

void plusone(vector<int> &digits)
{
  int n = digits.size();
  for (int i = n - 1; i >= 0; --i)
  {
    if (digits[i] == 9)
    {
      digits[i] = 0;
    }
    else
    {
      digits[i]++;
      return;
    }
  }
  digits[0] = 1;
  digits.push_back(0);
}


vector<int> plusOne(vector<int> &digits) {
  int carry = 1;
  vector <int> v;
  while (digits.size() > 0) {
    int x = digits.back();
    digits.pop_back();
    x = x + carry;
    v.insert(v.begin(), x % 10);
    carry = x / 10;
  }
  if (carry > 0) {
    v.insert(v.begin(), carry);
  }
  return v;

}

void printVector(vector<int>& v)
{
  cout << "{ ";
  for (int i = 0; i < v.size(); i++) {
    cout << v[i] << " ";
  }
  cout << "} " << endl;
}


int main()
{
  int a[] = { 9,9,9 };
  vector<int> d(&a[0], &a[0] + sizeof(a) / sizeof(int));
  vector<int> v = plusOne(d);
  printVector(v);
  return 0;
}

```

# populatingNextRightPointersInEachNode
```cpp
// Source : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
/*
Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

#include <vector>
using namespace std;

struct TreeLinkNode {
  int val;
  TreeLinkNode *left, *right, *next;
  TreeLinkNode(int x) : val(x), left(nullptr), right(nullptr), next(nullptr) {}
  TreeLinkNode() : val(0), left(nullptr), right(nullptr), next(nullptr) {}
};

void connect(TreeLinkNode *root) {
  if (!root)
    return;
  while (root->left)
  {
    TreeLinkNode *p = root;
    while (p)
    {
      p->left->next = p->right;
      if (p->next)
        p->right->next = p->next->left;
      p = p->next;
    }
    root = root->left;
  }
}

void connect(TreeLinkNode *root) {

  if (root == nullptr) {
    return;
  }
  if (root->left && root->right) {
    root->left->next = root->right;
  }
  if (root->next && root->right) {
    root->right->next = root->next->left;
  }
  connect(root->left);
  connect(root->right);

}

void printTree(TreeLinkNode *root) {
  if (root == nullptr) {
    return;
  }
  printf("[%d], left[%d], right[%d], next[%d]\n",
    root->val,
    root->left ? root->left->val : -1,
    root->right ? root->right->val : -1,
    root->next ? root->next->val : -1);

  printTree(root->left);
  printTree(root->right);

}

int main()
{
  const int cnt = 7;
  TreeLinkNode a[cnt];
  for (int i = 0; i < cnt; i++) {
    a[i].val = i + 1;
  }
  for (int i = 0, pos = 0; pos < cnt - 1; i++) {
    a[i].left = &a[++pos];
    a[i].right = &a[++pos];
  }

  connect(&a[0]);
  printTree(&a[0]);
  return 0;
}

```

# pow

```cppp
// Source : https://leetcode.com/problems/powx-n/description/
/*
Implement pow(x, n).
Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100
*/
#include <iostream>

double pow(double x, int n) {
  if (n == 0)
    return 1;
  if (n < 0) {
    n = -n;
    x = 1 / x;
  }
  return (n % 2 == 0) ? pow(x*x, n / 2) : x*pow(x*x, n / 2);
}


double pow(double x, int n) {
  bool sign = false;
  unsigned int exp = n;
  if (n < 0) {
    exp = -n;
    sign = true;
  }
  double result = 1.0;
  while (exp) {
    if (exp & 1) {
      result *= x;
    }
    exp >>= 1;
    x *= x;
  }
  return sign ? 1 / result : result;
}

int main(int argc, char** argv) {
  double x = 2.0;
  int n = 3;
  if (argc == 3) {
    x = atof(argv[1]);
    n = atoi(argv[2]);
  }
  printf("%f\n", pow(x, n));
  return 0;
}

```

# readNCharactersGivenRead4
```cpp
// Source : https://oj.leetcode.com/problems/read-n-characters-given-read4/
/**********************************************************************************
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note:
 *   The read function will only be called once for each test case.
 *
 **********************************************************************************/
#include<iostream>
#include<ctime>

using namespace std;

// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
public:
  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return    The number of characters read
   */
  int read(char *buf, int n) {
    srand(time(0));
    if (rand() % 2) {
      return read1(buf, n);
    }
    return read2(buf, n);
  }

  //read the data in-place. potential out-of-boundary issue
  int read1(char *buf, int n) {
    int len = 0;
    int size = 0;

    // `buf` could be accessed out-of-boundary 
    while (len <= n && (size = read4(buf)) > 0) {
      size = len + size > n ? n - len : size;
      len += size;
      buf += size;
    }
    return  len;
  }

  //using a temp-buffer to avoid peotential out-of-boundary issue
  int read2(char *buf, int n) {
    char _buf[4];   // the buffer for read4()
    int _n = 0;     // the return for read4()
    int len = 0;    // total buffer read from read4()
    int size = 0;   // how many bytes need be copied from `_buf` to `buf`
    while ((_n = read4(_buf)) > 0) {
      //check the space of `buf` whether full or not
      size = len + _n > n ? n - len : _n;
      strncpy(buf + len, _buf, size);
      len += size;
      //buffer is full
      if (len >= n) {
        break;
      }
    }
    return len;
  }
};


int main()
{
  return 0;
}
```
# recoverBinarySearchTree
```cpp
// Source : https://leetcode.com/problems/recover-binary-search-tree/description/
/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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

We can convert the BST to a sorted array,  then we can find the two nodes which missed the order.
To cover the BST to sorted array, we needn't use an extra array, we just traverse the tree in order.
                  8
          _______/ \_______
         /                 \
        4                  12
     __/ \__             __/ \__
    /       \           /       \
   2         6        10        14
  / \       / \       / \       / \
 1   3     5   7     9  11    13  15
*/

#include<iostream>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
  void recoverTreeHelper(TreeNode *root) {
    if (root == nullptr) return;

    recoverTreeHelper(root->left);
    if (prev) {
      if (prev->val > root->val) {
        if (n1 == nullptr) {
          n1 = prev;
        }
        n2 = root;
      }
    }
    prev = root;
    recoverTreeHelper(root->right);
  }

  void recoverTree(TreeNode *root) {
    n1 = n2 = prev = nullptr;
    recoverTreeHelper(root);
    if (n1 && n2) {
      swap(n1->val, n2->val);
    }
  }
private:
  TreeNode *n1, *n2, *prev;
};


int main()
{
  return 0;
}
```

# regularExpressionMatching
```cpp
// Source : https://leetcode.com/problems/regular-expression-matching/description/
/*
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

#include <string>
#include <iostream>
using namespace std;

/*
1.’.’ is easy to handle. if p has a ‘.’, it can pass any single character in s except ‘\0’.
2.’’ is a totally different problem. if p has a '’ character, it can pass any length of first-match characters in s including ‘\0’.
*/

bool isMatch(const char *s, const char *p) {
  if (*p == '\0') {
    return *s == '\0';
  }
  //p's length 1 is special case 
  if (*(p + 1) == '\0' || *(p + 1) != '*') {
    if (*s == '\0' || (*p != '.' && *s != *p)) {
      return false;
    }
    return isMatch(s + 1, p + 1);
  }
  int len = strlen(s);
  int i = -1;
  while (i < len && (i < 0 || *p == '.' || *p == *(s + i))) {
    if (isMatch(s + i + 1, p + 2)) {
      return true;
    }
    i++;
  }
  return false;
}


int main(int argc, char** argv)
{
  const char* s = "aaa";
  const char* p = "a.*";

  if (argc > 2) {
    s = argv[1];
    p = argv[2];
  }

  cout << s << ", " << p << " : " << isMatch(s, p) << endl;
}

```
# removeDuplicatesFromSortedArray
```cpp
// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
/*
Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
*/

int removeDuplicates(int A[], int n) {
  if (n < 2) return n;
  int id = 1;
  for (int i = 1; i < n; ++i)
    if (A[i] != A[i - 1]) A[id++] = A[i];
  return id;
}
};

int removeDuplicates(int A[], int n) {

  if (n <= 1) return n;

  int pos = 0;
  for (int i = 0; i < n - 1; i++) {
    if (A[i] != A[i + 1]) {
      A[++pos] = A[i + 1];
    }
  }
  return pos + 1;
}

void printfArray(int A[], int n) {
  printf("{ ");
  for (int i = 0; i < n; i++) {
    printf("%d ", A[i]);
  }
  printf("}\n");
}


void testSuite(int a[], int n) {
  printfArray(a, n);
  n = removeDuplicates(a, n);
  printfArray(a, n);
  printf("------------------\n");
}

#define TEST(a) testSuite(a, sizeof(a)/sizeof(int))
int main()
{
  int a0[] = { 1, 2, 3, 4, 5 };
  TEST(a0);
  int a1[] = { 1, 1, 1 };
  TEST(a1);
  int a2[] = { 1, 2, 2 };
  TEST(a2);
  int a3[] = { 1, 1, 2 };
  TEST(a3);
  int a4[] = { 1, 1, 1, 1 };
  TEST(a4);
  int a5[] = { 1, 1, 1, 2 };
  TEST(a5);
  int a6[] = { 1, 2, 2, 2 };
  TEST(a6);
  int a7[] = { 1, 2, 2, 2, 3 };
  TEST(a7);
  int a8[] = { 1, 2, 2, 2, 3, 3 };
  TEST(a8);
  int a9[] = { 1,1,1,2,2,3 };
  TEST(a9);
  int a10[] = { 1,1,1,2,2,2 };
  TEST(a10);
  int a11[] = { 1,1,1,1,3,3 };
  TEST(a11);
  return 0;
}

```

# removeDuplicatesFromSortedList
```cpp
// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

#include <iosteram>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *deleteDuplicates(ListNode *head) {

  for (ListNode *p = head; p && p->next; ) {
    if (p->val == p->next->val) {
      p->next = p->next->next;
      continue;
    }
    p = p->next;
  }
  return head;
}

void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int a[], int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}


int main()
{
  int a[] = { 1,1,2,3,3 };
  int b[] = { 1,1,1 };

  printList(deleteDuplicates(createList(a, sizeof(a) / sizeof(int))));
  printList(deleteDuplicates(createList(b, sizeof(b) / sizeof(int))));
  return 0;
}


```

# removeElement
```cpp
// Source : https://leetcode.com/problems/remove-element/description/
/*
Given an array and a value, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given nums = [3,2,2,3], val = 3,
Your function should return length = 2, with the first two elements of nums being 2.
*/

int removeElement(int A[], int n, int elem) {
  int begin = 0;
  for (int i = 0; i < n; i++) if (A[i] != elem) A[begin++] = A[i];
  return begin;
}


int removeElement(int A[], int n, int elem) {
  int tail = n - 1;
  int i = 0;
  while (i <= tail) {
    if (A[i] == elem) {
      A[i] = A[tail--];
      continue;
    }
    i++;
  }

  return tail + 1;
}

int main()
{
  return 0;
}

```

# removeNthNodeFromEndOfList
```cpp
// Source : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/


#include<iostream>
#include<vector>
using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n)
{
  ListNode** t1 = &head, *t2 = head;
  for (int i = 1; i < n; ++i)
  {
    t2 = t2->next;
  }
  while (t2->next != NULL)
  {
    t1 = &((*t1)->next);
    t2 = t2->next;
  }
  *t1 = (*t1)->next;
  return head;
}

int main()
{
  vector<int> data = { 1, 2, 3, 4, 5 };
  ListNode *head = nullptr, *p = nullptr;

  for (auto i : data) {
    if (head == nullptr) {
      head = p = new ListNode(i);
    }
    else {
      p->next = new ListNode(i);
      p = p->next;
    }
  }

  auto v = removeNthFromEnd(head, 2);
  while (v != nullptr) {
    cout << v->val << " " << endl;
    v = v->next;
  }

  return 0;
}
```

# reorderList
```cpp
// Source : https://leetcode.com/problems/reorder-list/description/
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

#include <iostream>

// O(N) time, O(1) space in total
void reorderList(ListNode *head) {
  if (!head || !head->next) return;

  // find the middle node: O(n)
  ListNode *p1 = head, *p2 = head->next;
  while (p2 && p2->next) {
    p1 = p1->next;
    p2 = p2->next->next;
  }

  // cut from the middle and reverse the second half: O(n)
  ListNode *head2 = p1->next;
  p1->next = NULL;

  p2 = head2->next;
  head2->next = NULL;
  while (p2) {
    p1 = p2->next;
    p2->next = head2;
    head2 = p2;
    p2 = p1;
  }

  // merge two lists: O(n)
  for (p1 = head, p2 = head2; p1; ) {
    auto t = p1->next;
    p1 = p1->next = p2;
    p2 = t;
  }

  //for (p1 = head, p2 = head2; p2; ) {
  //    auto t = p1->next;
  //    p1->next = p2;
  //    p2 = p2->next;
  //    p1 = p1->next->next = t;
  //}
}

void printList(ListNode *h) {
  while (h != nullptr) {
    printf("%d->", h->val);
    h = h->next;
  }
  printf("nil\n");
}

int main(int argc, char** argv)
{
  int size = atoi(argv[1]);
  ListNode* n = new ListNode[size];

  for (int i = 0; i < size; i++) {
    n[i].val = i;
    if (i + 1 < size) {
      n[i].next = &n[i + 1];
    }
  }
  Solution s;
  s.reorderList(&n[0]);
  printList(&n[0]);
  return 0;
}

```
# restoreIPAddresses
```cpp
// Source : https://leetcode.com/problems/restore-ip-addresses/description/
/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> restoreIpAddresses(string s) {
  vector<string> ret;
  string ans;

  for (int a = 1; a <= 3; a++)
    for (int b = 1; b <= 3; b++)
      for (int c = 1; c <= 3; c++)
        for (int d = 1; d <= 3; d++)
          if (a + b + c + d == s.length()) {
            int A = stoi(s.substr(0, a));
            int B = stoi(s.substr(a, b));
            int C = stoi(s.substr(a + b, c));
            int D = stoi(s.substr(a + b + c, d));
            if (A <= 255 && B <= 255 && C <= 255 && D <= 255)
              if ((ans = to_string(A) + "." + to_string(B) + "." + to_string(C) + "." + to_string(D)).length() == s.length() + 3)
                ret.push_back(ans);
          }

  return ret;
}


// 2
vector<string> restoreIpAddresses(string s) {
  vector<string> result;
  string ip;
  restoreIpAddressesHelper(s, 0, 0, ip, result);
  return result;
}

void restoreIpAddressesHelper(string& s, int start, int partNum, string ip, vector<string>& result) {

  int len = s.size();
  if (len - start < 4 - partNum || len - start >(4 - partNum) * 3) {
    return;
  }

  if (partNum == 4 && start == len) {
    ip.erase(ip.end() - 1, ip.end());
    result.push_back(ip);
    return;
  }

  int num = 0;
  for (int i = start; i < start + 3; i++) {
    num = num * 10 + s[i] - '0';
    if (num < 256) {
      ip += s[i];
      restoreIpAddressesHelper(s, i + 1, partNum + 1, ip + '.', result);
    }
    //0.0.0.0 valid, but 0.1.010.01 is not
    if (num == 0) {
      break;
    }
  }

}


int main(int argc, char**argv)
{
  string s = "25525511135";
  if (argc > 1) {
    s = argv[1];
  }

  vector<string> result = restoreIpAddresses(s);

  cout << s << endl;
  for (int i = 0; i < result.size(); i++) {
    cout << '\t' << result[i] << endl;
  }
  return 0;
}

```

# reverseInteger
```cpp
// Source : https://leetcode.com/problems/reverse-integer/description/
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

#include <iostream>

int reverse(int x) {
  int ans = 0;
  while (x) {
    int temp = ans * 10 + x % 10;
    if (temp / 10 != ans)
      return 0;
    ans = temp;
    x /= 10;
  }
  return ans;
}


#define TEST(n, e)  printf("%12d  =>  %-12d    %s!\n",  n, reverse(n),  e == reverse(n)?"passed":"failed")

int main(int argc, char**argv)
{
  //basic cases
  TEST(123, 321);
  TEST(-123, -321);
  TEST(-100, -1);
  TEST(1002, 2001);
  //big integer
  TEST(1463847412, 2147483641);
  TEST(-2147447412, -2147447412);
  TEST(2147447412, 2147447412);
  //overflow
  TEST(1000000003, 0);
  TEST(2147483647, 0);
  TEST(-2147483648, 0);
  //customized cases
  if (argc < 2) {
    return 0;
  }
  printf("\n");
  for (int i = 1; i < argc; i++) {
    int n = atoi(argv[i]);
    printf("%12d  =>  %-12d    %s!\n", n, reverse(n), reverse(reverse(n)) == n ? "passed" : "failed");
  }
  return 0;
}

```
# reverseLinkedList

```cpp
// Source : https://leetcode.com/problems/reverse-linked-list-ii/description/
/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
#include <iostream>
#include <time.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};


ListNode* reverseBetween(ListNode* head, int m, int n) {
  ListNode* new_head = new ListNode(0);
  new_head->next = head;
  ListNode* pre = new_head;
  for (int i = 0; i < m - 1; i++)
    pre = pre->next;
  ListNode* cur = pre->next;
  for (int i = 0; i < n - m; i++) {
    ListNode* move = cur->next;
    cur->next = move->next;
    move->next = pre->next;
    pre->next = move;
  }
  return new_head->next;
}


void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int *a, int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}

ListNode* createList(int len) {
  int *a = new int[len];
  for (int i = 0; i < len; i++) {
    a[i] = i + 1;
  }
  ListNode* h = createList(a, len);
  delete[] a;
  return h;
}

int main(int argc, char** argv)
{
  int l = 5;
  int  m = 2, n = 4;

  if (argc > 1) {
    l = atoi(argv[1]);
  }
  if (argc > 2) {
    m = atoi(argv[2]);
  }
  if (argc > 3) {
    n = atoi(argv[3]);
  }

  ListNode* h = createList(l);
  printList(h);
  printList(reverseBetween(h, m, n));


}

```

# reverseNodesInKGroup
```cpp
// Source : https://leetcode.com/problems/reverse-nodes-in-k-group/description/
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

#include <iostream>
using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

/*
-1 -> 1 -> 2 -> 3 -> 4 -> 5
 |    |    |    |
pre  cur  nex  tmp

-1 -> 2 -> 1 -> 3 -> 4 -> 5
 |         |    |    |
pre       cur  nex  tmp

-1 -> 3 -> 2 -> 1 -> 4 -> 5
 |              |    |    |
pre            cur  nex  tmp
*/

ListNode *reverseKGroup(ListNode *head, int k) {
  if (head == NULL || k == 1) return head;
  int num = 0;
  ListNode *preheader = new ListNode(-1);
  preheader->next = head;
  ListNode *cur = preheader, *nex, *pre = preheader;
  while (cur = cur->next)
    num++;
  while (num >= k) {
    cur = pre->next;
    nex = cur->next;
    for (int i = 1; i < k; ++i) {
      cur->next = nex->next;
      nex->next = pre->next;
      pre->next = nex;
      nex = cur->next;
    }
    pre = cur;
    num -= k;
  }
  return preheader->next;
}

void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int a[], int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}



int main(int argc, char** argv)
{
  int a[] = { 1,2,3,4,5,6,7,8,9,10 };
  ListNode* pList = createList(a, sizeof(a) / sizeof(int));

  int k = 2;
  if (argc > 1) {
    k = atoi(argv[1]);
  }

  pList = reverseKGroup(pList, k);
  printList(pList);

  return 0;
}

```

# reverseWordsInAString
```cpp
// Source : https://leetcode.com/problems/reverse-words-in-a-string/description/
/*
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".
Update (2015-02-12):

For C programmers: Try to solve it in-place in O(1) space.
Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void reverseWords(string &s) {
  reverse(s.begin(), s.end());
  int storeIndex = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] != ' ') {
      if (storeIndex != 0) s[storeIndex++] = ' ';
      int j = i;
      while (j < s.size() && s[j] != ' ') { s[storeIndex++] = s[j++]; }
      reverse(s.begin() + storeIndex - (j - i), s.begin() + storeIndex);
      i = j;
    }
  }
  s.erase(s.begin() + storeIndex, s.end());
}

int main()
{
  string s;
  reverseWords(s);
  s = " ";
  reverseWords(s);
  s = "1 ";
  reverseWords(s);
  s = "love";
  reverseWords(s);
  s = "i love cpp";
  reverseWords(s);

  return 0;
}

```
# romanToInteger
```cpp
// Source : https://leetcode.com/problems/roman-to-integer/description/
/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

#include <iostream>
#include <string>
using namespace std;

//Problem is simpler to solve by working the string from back to front and using a map. Runtime speed is 88 ms.

int romanToInt(string s)
{
  unordered_map<char, int> T = { { 'I' , 1 },
                                 { 'V' , 5 },
                                 { 'X' , 10 },
                                 { 'L' , 50 },
                                 { 'C' , 100 },
                                 { 'D' , 500 },
                                 { 'M' , 1000 } };

  int sum = T[s.back()];
  for (int i = s.length() - 2; i >= 0; --i)
  {
    if (T[s[i]] < T[s[i + 1]])
    {
      sum -= T[s[i]];
    }
    else
    {
      sum += T[s[i]];
    }
  }

  return sum;
}

int main(int argc, char**argv)
{
  string s("XL");
  if (argc > 1) {
    s = argv[1];
  }
  cout << s << " : " << romanToInt(s) << endl;
  return 0;
}

```

# rotateImage
```cpp
// Source : https://leetcode.com/problems/rotate-image/description/
/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/

#include <iostream>
#include <vector>
using namespace std;

void rotate(vector<vector<int>>& matrix) {
  int n = matrix.size();
  int a = 0;
  int b = n - 1;
  while (a < b) {
    for (int i = 0; i < (b - a); ++i) {
      swap(matrix[a][a + i], matrix[a + i][b]);
      swap(matrix[a][a + i], matrix[b][b - i]);
      swap(matrix[a][a + i], matrix[b - i][a]);
    }
    ++a;
    --b;
  }
}

void rotate(vector<vector<int> > &matrix) {
  int n = matrix.size();
  for (int i = 0; i < n / 2; i++) {
    int low = i, high = n - i - 1;
    for (int j = low; j < high; j++) {
      int tmp;
      tmp = matrix[i][j];
      // left to top 
      matrix[i][j] = matrix[n - j - 1][i];
      // bottom to left
      matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
      // right to bottom
      matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
      // top to right
      matrix[j][n - i - 1] = tmp;
    }
  }
}

void printMatrix(vector<vector<int> > &matrix)
{
  for (int i = 0; i < matrix.size(); i++) {
    for (int j = 0; j < matrix[i].size(); j++) {
      printf("%3d ", matrix[i][j]);
    }
    cout << endl;
  }
  cout << endl;
}


int main(int argc, char** argv)
{
  int n = 2;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  vector< vector<int> > matrix;
  for (int i = 1; i <= n; i++) {
    vector<int> v;
    for (int j = 1; j <= n; j++) {
      v.push_back((i - 1)*n + j);
    }
    matrix.push_back(v);
  }

  printMatrix(matrix);
  rotate(matrix);
  printMatrix(matrix);

  return 0;
}

```

# rotateList
```cpp
// Source : https://leetcode.com/problems/rotate-list/description/
/*
Given a list, rotate the list to the right by k places, where k is non-negative.
Example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

#include<iostream>
using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode* rotateRight(ListNode* head, int k) {
  if (!head) return head;

  int len = 1; // number of nodes
  ListNode *newH, *tail;
  newH = tail = head;

  while (tail->next)  // get the number of nodes in the list
  {
    tail = tail->next;
    len++;
  }
  tail->next = head; // circle the link

  if (k %= len)
  {
    for (auto i = 0; i < len - k; i++) tail = tail->next; // the tail node is the (len-k)-th node (1st node is head)
  }
  newH = tail->next;
  tail->next = NULL;
  return newH;
}


ListNode *rotateRight(ListNode *head, int k) {
  if (!head || k <= 0) {
    return head;
  }

  //find the length of List
  int len = 1;
  ListNode *p = head;
  while (p->next != nullptr) {
    p = p->next;
    len++;
  }
  //connect the tail to head
  p->next = head;
  //find the left place (take care the case - k > len)
  k = len - k % len;

  //find the place
  for (int i = 0; i < k; i++) {
    p = p->next;
  }

  //break the list
  head = p->next;
  p->next = nullptr;

  return head;

}



int main()
{
  return 0;
}
```

# sameTree
```cpp
// Source : https://leetcode.com/problems/same-tree/description/
/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
Output: true

Example 2:
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]
Output: false

Example 3:
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
Output: false
*/

#include<iostream>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

/*
Algorithm for the recursion:
1)
If one of the node is NULL then return the equality result of p an q.
This boils down to if both are NULL then return true,
but if one of them is NULL but not the other one then return false
2)
At this point both root nodes represent valid pointers.
Return true if the root nodes have same value and
the left tree of the roots are same (recursion)
and the right tree of the roots are same (recursion).
Otherwise return false.
*/

bool isSameTree(TreeNode *p, TreeNode *q) {
  if (p == NULL || q == NULL) return (p == q);
  return (p->val == q->val && isSameTree(p->left, q->left) && isSameTree(p->right, q->right));
}

int main()
{
  return 0;
}
```
# scrambleString
```cpp
// Source : https://leetcode.com/problems/scramble-string/description/
/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 = "great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".
Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".
Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

#include <iostream>
#include <vector>
using namespace std;

bool isScramble(string s1, string s2) {
  if (s1 == s2)
    return true;

  int len = s1.length();
  int count[26] = { 0 };
  for (int i = 0; i < len; i++)
  {
    count[s1[i] - 'a']++;
    count[s2[i] - 'a']--;
  }

  for (int i = 0; i < 26; i++)
  {
    if (count[i] != 0)
      return false;
  }

  for (int i = 1; i <= len - 1; i++)
  {
    if (isScramble(s1.substr(0, i), s2.substr(0, i)) && isScramble(s1.substr(i), s2.substr(i)))
      return true;
    if (isScramble(s1.substr(0, i), s2.substr(len - i)) && isScramble(s1.substr(i), s2.substr(0, len - i)))
      return true;
  }
  return false;
}


int main(int argc, char** argv)
{
  string s1 = "great", s2 = "rgtae";
  if (argc > 2) {
    s1 = argv[1];
    s2 = argv[2];
  }
  cout << s1 << ", " << s2 << endl;
  cout << isScramble(s1, s2) << endl;
  return 0;
}

```
# search2DMatrix
```cpp
// Source : https://leetcode.com/problems/search-a-2d-matrix/description/
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

#include <iostream>
#include <vector>
using namespace std;

/*
Use binary search.
n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
*/
bool searchMatrix(vector<vector<int> > &matrix, int target) {
  int n = matrix.size();
  int m = matrix[0].size();
  int l = 0, r = m * n - 1;
  while (l != r) {
    int mid = (l + r - 1) >> 1;
    if (matrix[mid / m][mid % m] < target)
      l = mid + 1;
    else
      r = mid;
  }
  return matrix[r / m][r % m] == target;
}

int main()
{

  return 0;
}
```

# searchForRange
```cpp
// Source : https://leetcode.com/problems/search-for-a-range/description/
/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

#include <iostream>
#include <vector>
using namespace std;

// https://leetcode.com/problems/search-for-a-range/discuss/14699
vector<int> searchRange(int A[], int n, int target) {
  int i = 0, j = n - 1;
  vector<int> ret(2, -1);
  // Search for the left one
  while (i < j)
  {
    int mid = (i + j) / 2;
    if (A[mid] < target) i = mid + 1;
    else j = mid;
  }
  if (A[i] != target) return ret;
  else ret[0] = i;

  // Search for the right one
  j = n - 1;  // We don't have to set i to 0 the second time.
  while (i < j)
  {
    int mid = (i + j) / 2 + 1;	// Make mid biased to the right
    if (A[mid] > target) j = mid - 1;
    else i = mid;				// So that this won't make the search range stuck.
  }
  ret[1] = j;
  return ret;
}

void printVector(vector<int>&  pt)
{
  cout << "{ ";
  for (int j = 0; j < pt.size(); j++) {
    cout << pt[j] << " ";
  }
  cout << "} " << endl;
}


int main()
{
  const int cnt = 6;
  int a[cnt] = { 5, 7, 7, 8, 8, 10 };

  vector<int> v;
  v = searchRange(a, cnt, 8);
  printVector(v);


  int b[cnt] = { 5, 5, 5, 8, 8, 10 };
  v = searchRange(b, cnt, 5);
  printVector(v);

  int c[cnt] = { 5, 5, 5, 5, 5, 5 };
  v = searchRange(c, cnt, 5);
  printVector(v);
  return 0;
}

```

# searchInRotatedSortedArray
```cpp
// Source : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/

#include <iostream>
#include <time.h>

int search(int A[], int n, int target) {
  int lo = 0, hi = n - 1;
  // find the index of the smallest value using binary search.
  // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
  // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
  while (lo < hi) {
    int mid = (lo + hi) / 2;
    if (A[mid] > A[hi]) lo = mid + 1;
    else hi = mid;
  }
  // lo==hi is the index of the smallest value and also the number of places rotated.
  int rot = lo;
  lo = 0; hi = n - 1;
  // The usual binary search and accounting for rotation.
  while (lo <= hi) {
    int mid = (lo + hi) / 2;
    int realmid = (mid + rot) % n;
    if (A[realmid] == target)return realmid;
    if (A[realmid] < target)lo = mid + 1;
    else hi = mid - 1;
  }
  return -1;
}

void rotate_array(int a[], int n, int pos) {
  int i, from = 0;
  pos = pos % n;
  if (n <= 0) return;

  int tmp = a[0];

  for (int i = 0, step = 0; step < n && i < pos; step++) {
    int to;
    if (from - pos < 0) {
      to = n - pos + from;
    }
    else {
      to = from - pos;
    }
    int t;
    t = a[to];
    a[to] = tmp;
    tmp = t;
    from = to;
    if (to == i) {
      i++;
      from++;
      tmp = a[from];
    }
  }

}

void printArray(int A[], int n) {
  printf("{");
  for (int i = 0; i < n; i++) {
    printf("%d, ", A[i]);
  }
  printf("}\n");
}

int main(int argc, char** argv)
{

  int cnt = 20;

  if (argc > 1) {
    cnt = atoi(argv[1]);
  }

  srand(time(nullptr));

  for (int n = 0; n <= cnt; n++) {
    printf("--------------------------------------\n");
    int *a = new int[cnt];
    for (int i = 0; i < cnt; i++) {
      a[i] = i * 2;
    }
    //printArray(a, cnt);
    int rotate = rand() % cnt;
    //rotate=2;
    //printf("rotate=%d\n", rotate);
    rotate_array(a, cnt, rotate);
    printArray(a, cnt);
    int target = rand() % (2 * cnt);
    //target=6;
    printf("target=%d\n", target);

    int idx = search(a, cnt, target);
    if (idx < 0) {
      printf("not found!\n");
    }
    else {
      printf("a[%d] = %d\n", idx, a[idx]);
    }

    delete[] a;
  }

  return 0;
}

```
# searchInsertPosition
```cpp
// Source : https://leetcode.com/problems/search-insert-position/description/
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 1:

Input: [1,3,5,6], 0
Output: 0
*/

#include <iostream>

int searchInsert(vector<int>& nums, int target) {
  int low = 0, high = nums.size() - 1;

  // Invariant: the desired index is between [low, high+1]
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (nums[mid] < target)
      low = mid + 1;
    else
      high = mid - 1;
  }

  // (1) At this point, low > high. That is, low >= high+1
  // (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1. Follwing from (1), now we know low == high+1.
  // (3) Following from (2), the index is between [low, high+1] = [low, low], which means that low is the desired index
  //     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
  return low;
}

int main()
{
  int a[] = { 1,3,5,6 };
  printf("%d -> %d\n", 5, searchInsert(a, 4, 5));
  printf("%d -> %d\n", 2, searchInsert(a, 4, 2));
  printf("%d -> %d\n", 7, searchInsert(a, 4, 7));
  printf("%d -> %d\n", 0, searchInsert(a, 4, 0));
  return 0;
}

```

# setMatrixZeroes
```cpp
// Source : https://leetcode.com/problems/set-matrix-zeroes/description/
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

#include<iostream>
#include<vector>

using namespace std;

/*
store states of each row in the first of that row, and store states of each column in the first of that column.
Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0, and use another variable “col0” for column0.
In the first phase, use matrix elements to set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.
*/
void setZeroes(vector<vector<int> > &matrix) {
  int col0 = 1, rows = matrix.size(), cols = matrix[0].size();

  for (int i = 0; i < rows; i++) {
    if (matrix[i][0] == 0) col0 = 0;
    for (int j = 1; j < cols; j++)
      if (matrix[i][j] == 0)
        matrix[i][0] = matrix[0][j] = 0;
  }

  for (int i = rows - 1; i >= 0; i--) {
    for (int j = cols - 1; j >= 1; j--)
      if (matrix[i][0] == 0 || matrix[0][j] == 0)
        matrix[i][j] = 0;
    if (col0 == 0) matrix[i][0] = 0;
  }
}


int main()
{

  return 0;
}
```

# simplifyPath
```cpp
// Source : https://leetcode.com/problems/simplify-path/description/
/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;


string simplifyPath(string path) {
  string res, tmp;
  vector<string> stk;
  stringstream ss(path);
  while (getline(ss, tmp, '/')) {
    if (tmp == "" or tmp == ".") continue;
    if (tmp == ".." and !stk.empty()) stk.pop_back();
    else if (tmp != "..") stk.push_back(tmp);
  }
  for (auto str : stk) res += "/" + str;
  return res.empty() ? "/" : res;
}

int main(int argc, char** argv)
{
  string path("/a/./b/../../c/");
  if (argc > 1) {
    path = argv[1];
  }

  cout << path << " : " << simplifyPath(path) << endl;
}

```

# singleNumber

```cpp
// Source : https://leetcode.com/problems/single-number/description/
/*
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
#include <iostream>

// known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
int singleNumber(int A[], int n) {
  int result = 0;
  for (int i = 0; i < n; i++)
  {
    result ^= A[i];
  }
  return result;
}

int main()
{
  int a[] = { 1,1,2,2,3 };
  printf("%d\n", singleNumber(a, 5));
  return 0;
}

```
# sortColors
```cpp
// Source : https://leetcode.com/problems/sort-colors/description/
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/

#include <iostream>
#include <time.h>

/*
The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
It is hard to define what is a “one-pass” solution but this algorithm is bounded by O(2n),
meaning that at most each element will be seen and operated twice (in the case of all 0s).
You may be able to write an algorithm which goes through the list only once, but each step requires multiple operations,
leading the total operations larger than O(2n).
*/
void sortColors(int A[], int n) {
  int second = n - 1, zero = 0;
  for (int i = 0; i <= second; i++) {
    while (A[i] == 2 && i < second) swap(A[i], A[second--]);
    while (A[i] == 0 && i > zero) swap(A[i], A[zero++]);
  }
}

void printArray(int a[], int n) {
  for (int i = 0; i < n; i++) {
    printf("%d ", a[i]);
  }
  printf("\n");
}

int main(int argc, char** argv)
{
  int n = 7;
  if (argc > 1)
    n = atoi(argv[1]);

  srand(time(nullptr));

  int *a = new int[n];
  for (int i = 0; i < n; i++) {
    a[i] = rand() % 3;
  }
  printArray(a, n);
  sortColors(a, n);
  printArray(a, n);

  delete[] a;
}


```

# sortList

```cpp
// Source : https://leetcode.com/problems/sort-list/description/
// Sort a linked list in O(n log n) time using constant space complexity.
#include <iosteram>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *mergeTwoLists(ListNode* head1, ListNode* head2);

ListNode *sortList(ListNode *head) {
  if (head == nullptr || head->next == nullptr) {
    return head;
  }
  //find the middle place
  ListNode *p1 = head, *p2 = head->next;

  ListNode *prev;
  while (p2 && p2->next) {
    prev = p1;
    p1 = p1->next;
    p2 = p2->next->next;
  }
  p2 = p1->next;
  p1->next = nullptr;
  return mergeTwoLists(sortList(head), sortList(p2));
}


ListNode *mergeTwoLists(ListNode* head1, ListNode* head2) {
  ListNode *p1 = head1, *p2 = head2;
  static ListNode dummy(0);

  dummy.next = p1;
  ListNode *prev = &dummy;

  while (p1 && p2) {
    if (p1->val < p2->val) {
      prev = p1;
      p1 = p1->next;
    }
    else {
      prev->next = p2;
      p2 = p2->next;
      prev = prev->next;
      prev->next = p1;
    }
  }
  if (p2) {
    prev->next = p2;
  }

  return dummy.next;
}

void printList(ListNode* h)
{
  while (h != nullptr) {
    printf("%d ", h->val);
    h = h->next;
  }
  printf("\n");
}

ListNode* createList(int a[], int n)
{
  ListNode *head = nullptr, *p = nullptr;
  for (int i = 0; i < n; i++) {
    if (head == nullptr) {
      head = p = new ListNode(a[i]);
    }
    else {
      p->next = new ListNode(a[i]);
      p = p->next;
    }
  }
  return head;
}


int main(int argc, char** argv)
{
  int n = 10;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  srand(time(nullptr));

  int *a = new int[n];
  for (int i = 0; i < n; i++) {
    a[i] = rand() % n + 1;
  }

  ListNode *p = createList(a, n);
  printList(p);
  printList(sortList(p));

  delete[] a;
  return 0;
}

```

# spiralMatrix
```cpp
// Source : https://leetcode.com/problems/spiral-matrix/description/
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

include <iostream>
#include <vector>
using namespace std;

/*
When traversing the matrix in the spiral order, at any time we follow one out of the following four directions: RIGHT DOWN LEFT UP. Suppose we are working on a 5 x 3 matrix as such:
0 1 2 3 4 5
6 7 8 9 10
11 12 13 14 15

Imagine a cursor starts off at (0, -1), i.e. the position at ‘0’, then we can achieve the spiral order by doing the following:
Go right 5 times
Go down 2 times
Go left 4 times
Go up 1 times.
Go right 3 times
Go down 0 times -> quit
Notice that the directions we choose always follow the order ‘right->down->left->up’, and for horizontal movements,
the number of shifts follows:{5, 4, 3}, and vertical movements follows {2, 1, 0}.
Thus, we can make use of a direction matrix that records the offset for all directions,
then an array of two elements that stores the number of shifts for horizontal and vertical movements, respectively.
This way, we really just need one for loop instead of four.
Another good thing about this implementation is that:
If later we decided to do spiral traversal on a different direction (e.g. Counterclockwise),
then we only need to change the Direction matrix; the main loop does not need to be touched.
*/
vector<int> spiralOrder(vector<vector<int>>& matrix) {
  vector<vector<int> > dirs{ {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
  vector<int> res;
  int nr = matrix.size();     if (nr == 0) return res;
  int nc = matrix[0].size();  if (nc == 0) return res;

  vector<int> nSteps{ nc, nr - 1 };

  int iDir = 0;   // index of direction.
  int ir = 0, ic = -1;    // initial position
  while (nSteps[iDir % 2]) {
    for (int i = 0; i < nSteps[iDir % 2]; ++i) {
      ir += dirs[iDir][0]; ic += dirs[iDir][1];
      res.push_back(matrix[ir][ic]);
    }
    nSteps[iDir % 2]--;
    iDir = (iDir + 1) % 4;
  }
  return res;
}


void printArray(vector<int> v)
{
  cout << "[";
  for (int j = 0; j < v.size(); j++) {
    printf(" %02d", v[j]);
  }
  cout << "]" << endl;;
}

void printMatrix(vector< vector<int> > &vv)
{
  for (int i = 0; i < vv.size(); i++) {
    printArray(vv[i]);
  }
  cout << endl;
}

vector< vector<int> > createMatrix(int n, int m)
{
  vector< vector<int> > vv;
  int cnt = 1;
  for (int i = 0; i < n; i++) {
    vector<int> v;
    for (int j = 0; j < m; j++) {
      v.push_back(cnt++);
    }
    vv.push_back(v);
  }
  return vv;
}

int main(int argc, char** argv)
{
  int n = 3, m = 3;
  if (argc > 2) {
    n = atoi(argv[1]);
    m = atoi(argv[2]);
  }
  vector< vector<int> > matrix = createMatrix(n, m);
  printMatrix(matrix);
  vector<int> v = spiralOrder(matrix);
  printArray(v);
  return 0;
}

```
# sqrt

```cpp
// Source : https://leetcode.com/problems/sqrtx/description/
/*
Implement int sqrt(int x).
Compute and return the square root of x.
x is guaranteed to be a non-negative integer.
Example 1:
Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
*/
#include <iostream>
using namespace std;


int sqrt(int x) {
long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return r;
}

int main(int argc, char**argv)
{
    int n = 2;
    if( argc > 1 ){
        n = atoi(argv[1]);
    }
    cout << "sqrt(" << n << ") = " << sqrt(n) << endl;
    return 0;
}

```

# stringToIntegerAtoi
```cpp
// Source : https://oj.leetcode.com/problems/string-to-integer-atoi/
/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
spoilers alert... click to show requirements for atoi.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
#include <iosteram>

#define INT_MIN     (-2147483647 - 1)
#define INT_MAX      2147483647

int atoi(const char *str) {
  int sign = 1, base = 0, i = 0;
  while (str[i] == ' ') { i++; }
  if (str[i] == '-' || str[i] == '+') {
    sign = 1 - 2 * (str[i++] == '-');
  }
  while (str[i] >= '0' && str[i] <= '9') {
    if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str[i] - '0' > 7)) {
      if (sign == 1) return INT_MAX;
      else return INT_MIN;
    }
    base = 10 * base + (str[i++] - '0');
  }
  return base * sign;
}

int main()
{
  printf("\"%s\" = %d\n", "123", atoi("123"));
  printf("\"%s\" = %d\n", "   123", atoi("    123"));
  printf("\"%s\" = %d\n", "+123", atoi("+123"));
  printf("\"%s\" = %d\n", " -123", atoi(" -123"));
  printf("\"%s\" = %d\n", "123ABC", atoi("123ABC"));
  printf("\"%s\" = %d\n", " abc123ABC", atoi(" abc123ABC"));
  printf("\"%s\" = %d\n", "2147483647", atoi("2147483647"));
  printf("\"%s\" = %d\n", "-2147483648", atoi("-2147483648"));
  printf("\"%s\" = %d\n", "2147483648", atoi("2147483648"));
  printf("\"%s\" = %d\n", "-2147483649", atoi("-2147483649"));
  return 0;
}

```

# strStr
```cpp
// Source : https://leetcode.com/problems/implement-strstr/description/
/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/
#include <iosteram>
#include <time.h>

// https://leetcode.com/problems/implement-strstr/discuss/12956
int strStr(string haystack, string needle) {
  int m = haystack.length(), n = needle.length();
  if (!n) return 0;
  for (int i = 0; i < m - n + 1; i++) {
    int j = 0;
    for (; j < n; j++)
      if (haystack[i + j] != needle[j])
        break;
    if (j == n) return i;
  }
  return -1;
}

int main(int argc, char** argv)
{
  srand(time(0));
  const char* haystack = "mississippi";
  const char* needle = "issi";
  printf("%s, %s : %s\n", haystack, needle, strStr((char*)haystack, (char*)needle));

  haystack = "mississippi";
  needle = "issip";
  printf("%s, %s : %s\n", haystack, needle, strStr((char*)haystack, (char*)needle));


  haystack = "babbbbbabb";
  needle = "bbab";
  printf("%s, %s : %s\n", haystack, needle, strStr1((char*)haystack, (char*)needle));

  if (argc > 2) {
    haystack = argv[1];
    needle = argv[2];
    printf("%s, %s : %s\n", haystack, needle, strStr((char*)haystack, (char*)needle));
  }

  return 0;
}

```

# subsets
```cpp
// Source : https://leetcode.com/problems/subsets/description/
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int> > subsets(vector<int> &S) {
  sort(S.begin(), S.end());
  int elem_num = S.size();
  int subset_num = pow(2, elem_num);
  vector<vector<int> > subset_set(subset_num, vector<int>());
  for (int i = 0; i < elem_num; i++)
    for (int j = 0; j < subset_num; j++)
      if ((j >> i) & 1)
        subset_set[j].push_back(S[i]);
  return subset_set;
}


void printResult(vector<vector<int> >& result)
{
  for (int i = 0; i < result.size(); i++) {
    cout << "{";
    for (int j = 0; j < result[i].size(); j++) {
      cout << " " << result[i][j];
    }
    cout << " }" << endl;
  }
}

void printArray(vector<int>& v) {
  cout << "{";
  for (int i = 0; i < v.size(); i++) {
    cout << " " << v[i];
  }
  cout << " }" << endl;
}

int main(int argc, char** argv)
{
  srand(time(nullptr));

  int n = 3;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  vector<int> v;
  for (int i = n; i > 0; i--) {
    v.push_back(i);
  }
  printArray(v);
  vector<vector<int> > r = subsets(v);
  printResult(r);
}

```
# substringWithConcatenationOfAllWords
```cpp
// Source : https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

/*
travel all the words combinations to maintain a window
there are wl(word len) times travel
each time, n/wl words, mostly 2 times travel for each word
one left side of the window, the other right side of the window
so, time complexity O(wl * 2 * N/wl) = O(2N)
*/

vector<int> findSubstring(string S, vector<string> &L) {
  vector<int> ans;
  int n = S.size(), cnt = L.size();
  if (n <= 0 || cnt <= 0) return ans;

  // init word occurence
  unordered_map<string, int> dict;
  for (int i = 0; i < cnt; ++i) dict[L[i]]++;

  // travel all sub string combinations
  int wl = L[0].size();
  for (int i = 0; i < wl; ++i) {
    int left = i, count = 0;
    unordered_map<string, int> tdict;
    for (int j = i; j <= n - wl; j += wl) {
      string str = S.substr(j, wl);
      // a valid word, accumulate results
      if (dict.count(str)) {
        tdict[str]++;
        if (tdict[str] <= dict[str])
          count++;
        else {
          // a more word, advance the window left side possiablly
          while (tdict[str] > dict[str]) {
            string str1 = S.substr(left, wl);
            tdict[str1]--;
            if (tdict[str1] < dict[str1]) count--;
            left += wl;
          }
        }
        // come to a result
        if (count == cnt) {
          ans.push_back(left);
          // advance one word
          tdict[S.substr(left, wl)]--;
          count--;
          left += wl;
        }
      }
      // not a valid word, reset all vars
      else {
        tdict.clear();
        count = 0;
        left = j + wl;
      }
    }
  }

  return ans;
}


int main(int argc, char**argv)
{
  string s = "barfoobarfoothefoobarman";
  vector<string> l;
  l.push_back("foo");
  l.push_back("bar");
  l.push_back("foo");

  vector<int> indics = findSubstring(s, l);

  for (int i = 0; i < indics.size(); i++) {
    cout << indics[i] << " ";
  }
  cout << endl;

  return 0;
}

```
# sudokuSolver
```cpp
// Source : https://leetcode.com/problems/sudoku-solver/description/
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
A sudoku puzzle...
...and its solution numbers marked in red.

*/

#include <iostream>
#include <vector>
using namespace std;


bool check(vector<vector<char>>& board, int i, int j, char val) {

  for (int h = 0; h < 9; h++)
  {
    if (board[i][h] == val) return false; /* check row */
    if (board[h][j] == val) return false; /* check col */
    if (board[i - i % 3 + h / 3][j - j % 3 + h % 3] == val)return false; /* check cube */
  }

  return true;
}

/*bool check(vector<vector<char>> &board, int i, int j, char val)
{
    int row = i - i%3, column = j - j%3;
    for(int x=0; x<9; x++) if(board[x][j] == val) return false;
    for(int y=0; y<9; y++) if(board[i][y] == val) return false;
    for(int x=0; x<3; x++)
    for(int y=0; y<3; y++)
        if(board[row+x][column+y] == val) return false;
    return true;
}*/

bool solveSudoku(vector<vector<char>> &board, int i, int j)
{
  if (i == 9) return true;
  if (j == 9) return solveSudoku(board, i + 1, 0);
  if (board[i][j] != '.') return solveSudoku(board, i, j + 1);

  for (char c = '1'; c <= '9'; c++)
  {
    if (check(board, i, j, c))
    {
      board[i][j] = c;
      if (solveSudoku(board, i, j + 1)) return true;
      board[i][j] = '.';
    }
  }

  return false;
}

int main() {
  return 0;
}

```

# sumRootToLeafNumber
```cpp
// Source : https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
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
  while (v.size() > 0) {
    TreeNode* node = v.back();
    v.pop_back();
    if (node->left) {
      node->left->val += (10 * node->val);
      v.push_back(node->left);
    }
    if (node->right) {
      node->right->val += (10 * node->val);
      v.push_back(node->right);
    }
    if (!node->right && !node->left) {
      sum += node->val;
    }
  }

  return sum;
}


int main()
{
  return 0;
}
```
# surroundedRegions
```cpp
// Source : https://leetcode.com/problems/surrounded-regions/description/
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

/*
First, check the four border of the matrix. If there is a element is
’O’, alter it and all its neighbor ‘O’ elements to ‘1’.
Then ,alter all the ‘O’ to ‘X’
At last,alter all the ‘1’ to ‘O’
For example:
         X X X X           X X X X             X X X X
         X X O X  ->       X X O X    ->       X X X X
         X O X X           X 1 X X             X O X X
         X O X X           X 1 X X             X O X X
*/
void solve(vector<vector<char>>& board) {
  int i, j;
  int row = board.size();
  if (!row)
    return;
  int col = board[0].size();

  for (i = 0; i < row; i++) {
    check(board, i, 0, row, col);
    if (col > 1)
      check(board, i, col - 1, row, col);
  }
  for (j = 1; j + 1 < col; j++) {
    check(board, 0, j, row, col);
    if (row > 1)
      check(board, row - 1, j, row, col);
  }
  for (i = 0; i < row; i++)
    for (j = 0; j < col; j++)
      if (board[i][j] == 'O')
        board[i][j] = 'X';
  for (i = 0; i < row; i++)
    for (j = 0; j < col; j++)
      if (board[i][j] == '1')
        board[i][j] = 'O';
}
void check(vector<vector<char> >&vec, int i, int j, int row, int col) {
  if (vec[i][j] == 'O') {
    vec[i][j] = '1';
    if (i > 1)
      check(vec, i - 1, j, row, col);
    if (j > 1)
      check(vec, i, j - 1, row, col);
    if (i + 1 < row)
      check(vec, i + 1, j, row, col);
    if (j + 1 < col)
      check(vec, i, j + 1, row, col);
  }
}

//
void construct(vector< vector<char> > &board, int row, int col) {
  srand(time(0));
  for (int i = 0; i < row; i++) {
    vector<char> line;
    for (int j = 0; j < col; j++) {
      if (i == 0 || j == 0 || i == row - 1 || j == col - 1)
        line.push_back(rand() % 3 ? 'X' : 'O');
      else
        line.push_back(rand() % 2 ? 'X' : 'O');
    }
    board.push_back(line);
  }
}

void print(vector< vector<char> > &board) {
  for (int i = 0; i < board.size(); i++) {
    for (int j = 0; j < board[i].size(); j++) {
      cout << board[i][j] << " ";
    }
    cout << endl;
  }
  cout << endl;
}

int main(int argc, char** argv)
{
  int row, col;
  row = col = 6;
  if (argc > 1) {
    row = atoi(argv[1]);
  }
  if (argc > 2) {
    col = atoi(argv[2]);
  }

  vector< vector<char> > data;

  construct(data, row, col);
  print(data);

  solve(data);
  print(data);

  return 0;
}

```

# swapNodesInPairs
```cpp
// Source : https://leetcode.com/problems/swap-nodes-in-pairs/description/
/*
Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

#include<iostream>
#include<vector>
#include<ctime>

using namespace std;

/*
Pointer-pointer pp points to the pointer to the current node. So at first,
pp points to head, and later it points to the next field of ListNodes.
Additionally, for convenience and clarity, pointers a and b point to the current node and the next node.

We need to go from *pp == a -> b -> (b->next) to *pp == b -> a -> (b->next).
The first three lines inside the loop do that, setting those three pointers (from right to left). The fourth line moves pp to the next pair.
*/
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

ListNode* swapPairs(ListNode* head) {
  ListNode **pp = &head, *a, *b;
  while ((a = *pp) && (b = a->next)) {
    a->next = b->next;
    b->next = a;
    *pp = b;
    pp = &(a->next);
  }
  return head;
}

ListNode *swapPairs1(ListNode *head) {
  for (ListNode *p = head; p && p->next; p = p->next->next) {
    int n = p->val;
    p->val = p->next->val;
    p->next->val = n;
  }
  return head;
}

int main()
{
  return 0;
}
```
# symmetricTree

```cpp
// Source : https://leetcode.com/problems/symmetric-tree/description/
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

#include<iostream>
#include<vector>
#include<queue>
#include<ctime>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};


bool isSymmetric(TreeNode *root) {
  TreeNode *left, *right;
  if (!root)
    return true;

  queue<TreeNode*> q1, q2;
  q1.push(root->left);
  q2.push(root->right);
  while (!q1.empty() && !q2.empty()) {
    left = q1.front();
    q1.pop();
    right = q2.front();
    q2.pop();
    if (NULL == left && NULL == right)
      continue;
    if (NULL == left || NULL == right)
      return false;
    if (left->val != right->val)
      return false;
    q1.push(left->left);
    q1.push(left->right);
    q2.push(right->right);
    q2.push(right->left);
  }
  return true;
}


int main()
{
  return 0;
}
```
# textJustification
```cpp
// Source : https://leetcode.com/problems/text-justification/description/
/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

#include <math.h>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
For each line, I first figure out which words can fit in. According to the code, these words are words[i] through words[i+k-1].
 Then spaces are added between the words. The trick here is to use mod operation to manage the spaces that can’t be evenly
 distrubuted: the first (L-l) % (k-1) gaps acquire an additional space.
*/

vector<string> fullJustify(vector<string> &words, int L) {
  vector<string> res;
  for (int i = 0, k, l; i < words.size(); i += k) {
    for (k = l = 0; i + k < words.size() and l + words[i + k].size() <= L - k; k++) {
      l += words[i + k].size();
    }
    string tmp = words[i];
    for (int j = 0; j < k - 1; j++) {
      if (i + k >= words.size()) tmp += " ";
      else tmp += string((L - l) / (k - 1) + (j < (L - l) % (k - 1)), ' ');
      tmp += words[i + j + 1];
    }
    tmp += string(L - tmp.size(), ' ');
    res.push_back(tmp);
  }
  return res;
}

//
void printVector(vector<string> &words, bool newline = false) {
  for (int i = 0; i < words.size(); i++) {
    cout << "\"" << words[i] << "\", ";
    if (newline) cout << endl;
  }
  cout << endl;
}

void test(const char* A[], int len, int L) {
  vector<string> words(A, A + len);

  printVector(words);

  vector<string> result = fullJustify(words, L);
  cout << endl;
  printVector(result, true);

}

#define TEST(a, L) test(a, sizeof(a)/sizeof(const char*), L)

int main(int argc, char** argv)
{
  const char* w1[] = { "This", "is", "an", "example", "of", "text", "justification." };
  TEST(w1, 16);

  const char* w2[] = { "What","must","be","shall","be." };
  TEST(w2, 12);

  const char* w3[] = { "My","momma","always","said,","Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get." };
  TEST(w3, 20);

  return 0;
}

```
# trappingRainWater
```cpp
// Source : https://leetcode.com/problems/trapping-rain-water/description/
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     ^
     |
   3 |                       +--+
     |                       |  |
   2 |          +--+xxxxxxxxx|  +--+xx+--+
     |          |  |xxxxxxxxx|  |  |xx|  |
   1 |   +--+xxx|  +--+xxx+--+  |  +--+  +--+
     |   |  |xxx|  |  |xxx|  |  |  |  |  |  |
   0 +---+--+---+--+--+---+--+--+--+--+--+--+----->
       0  1   0  2  1   0  1  3  2  1  2  1
 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

#include <iosteram>

/*
instead of calculating area by height*width, we can think it in a cumulative way.
In other words, sum water amount of each bin(width=1).
Search from left to right and maintain a max height of left and right separately,
which is like a one-side wall of partial container. Fix the higher one and flow water from the lower part.
For example, if current height of left is lower, we fill water in the left bin. Until left meets right, we filled the whole container.
*/
int trap(int A[], int n) {
  int left = 0; int right = n - 1;
  int res = 0;
  int maxleft = 0, maxright = 0;
  while (left <= right) {
    if (A[left] <= A[right]) {
      if (A[left] >= maxleft) maxleft = A[left];
      else res += maxleft - A[left];
      left++;
    }
    else {
      if (A[right] >= maxright) maxright = A[right];
      else res += maxright - A[right];
      right--;
    }
  }
  return res;
}


#define TEST(a) printf("%d\n", trap(a, sizeof(a)/sizeof(int)))
int main()
{
  int a[] = { 2,0,2 };
  TEST(a);
  int b[] = { 0,1,0,2,1,0,1,3,2,1,2,1 };
  TEST(b);
  return 0;
}

```

# triangle
```cpp
// Source : https://oj.leetcode.com/problems/triangle/
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

#include <iostream>
#include <vector>
using namespace std;

// https://leetcode.com/problems/triangle/discuss/38730
int minimumTotal(vector<vector<int> > &triangle) {
  int n = triangle.size();
  vector<int> minlen(triangle.back());
  for (int layer = n - 2; layer >= 0; layer--) // For each layer
  {
    for (int i = 0; i <= layer; i++) // Check its every 'node'
    {
      // Find the lesser of its two children, and sum the current value in the triangle with it.
      minlen[i] = min(minlen[i], minlen[i + 1]) + triangle[layer][i];
    }
  }
  return minlen[0];
}


int main()
{
  vector< vector<int> > v;
  vector<int> i;
  i.push_back(-1);
  v.push_back(i);

  i.clear();
  i.push_back(2);
  i.push_back(3);
  v.push_back(i);

  i.clear();
  i.push_back(1);
  i.push_back(-1);
  i.push_back(-3);
  v.push_back(i);

  Solution s;
  cout << s.minimumTotal(v) << endl;;

  v.clear();
  i.clear();
  i.push_back(-1);
  v.push_back(i);

  i.clear();
  i.push_back(3);
  i.push_back(2);
  v.push_back(i);

  i.clear();
  i.push_back(-3);
  i.push_back(1);
  i.push_back(-1);
  v.push_back(i);
  cout << s.minimumTotal(v) << endl;;

  return 0;
}
```

# twoSum
```cpp
// Source : https://leetcode.com/problems/two-sum/description/
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

#include<iostream>
#include<vector>
#include<map>

using namespace std;


vector<int> twoSum(vector<int> &numbers, int target)
{
  //Key is the number and value is its index in the vector.
  unordered_map<int, int> hash;
  vector<int> result;
  for (int i = 0; i < numbers.size(); i++) {
    int numberToFind = target - numbers[i];

    //if numberToFind is found in map, return them
    if (hash.find(numberToFind) != hash.end()) {
      //+1 because indices are NOT zero based
      result.push_back(hash[numberToFind] + 1);
      result.push_back(i + 1);
      return result;
    }

    //number was not found. Put it in the map.
    hash[numbers[i]] = i;
  }
  return result;
}

// 2
vector<int> twoSum(vector<int> &numbers, int target) {
  map<int, int> m;
  vector<int> result;
  for (int i = 0; i < numbers.size(); i++) {
    // not found the second one
    if (m.find(numbers[i]) == m.end()) {
      // store the first one poisition into the second one's key
      m[target - numbers[i]] = i;
    }
    else {
      // found the second one
      result.push_back(m[numbers[i]] + 1);
      result.push_back(i + 1);
      break;
    }
  }
  return result;
}



int main()
{

  return 0;
}
```

# uniqueBinarySearchTrees

```cpp
// Source : https://leetcode.com/problems/unique-binary-search-trees/description/
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

#include <iosteram>

int numTrees(int n) {
  int dp[n + 1];
  dp[0] = dp[1] = 1;
  for (int i = 2; i <= n; i++) {
    dp[i] = 0;
    for (int j = 1; j <= i; j++) {
      dp[i] += dp[j - 1] * dp[i - j];
    }
  }
  return dp[n];
}

// 2
int numTrees2(int n) {
  if (n <= 0) return 0;
  if (n == 1) return 1;
  int sum = 0;
  for (int i = 1; i <= n; i++) {
    if (i == 1 || i == n) {
      sum += numTrees(n - 1);
    }
    else {
      sum += (numTrees(i - 1) * numTrees(n - i));
    }
  }
  return sum;
}


int main(int argc, char** argv)
{
  int n = 2;
  if (argc > 1) {
    n = atoi(argv[1]);
  }
  printf("%d=%d\n", n, numTrees(n));
  return 0;
}

```

# uniquePaths

```cpp
// Source : https://leetcode.com/problems/unique-paths/description/
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Above is a 3 x 7 grid. How many possible unique paths are there?
Note: m and n will be at most 100.
*/

#include <iosteram>

int uniquePaths(int m, int n) {
  if (m > n) return uniquePaths(n, m);
  vector<int> cur(m, 1);
  for (int j = 1; j < n; j++)
    for (int i = 1; i < m; i++)
      cur[i] += cur[i - 1];
  return cur[m - 1];
}

void printMatrix(int*a, int m, int n)
{
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      printf("%4d ", a[i*n + j]);
    }
    printf("\n");
  }
  printf("\n");
}

int main(int argc, char** argv)
{
  int m = 3, n = 7;
  if (argc > 2) {
    m = atoi(argv[1]);
    n = atoi(argv[2]);
  }

  printf("uniquePaths=%d\n", uniquePaths(m, n));
  return  0;
}

```
# validateBinarySearchTree
```cpp
// Source : https://leetcode.com/problems/validate-binary-search-tree/description/
/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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

bool isValidBST(TreeNode* root) {
  return isValidBST(root, NULL, NULL);
}

bool isValidBST(TreeNode* root, TreeNode* minNode, TreeNode* maxNode) {
  if (!root) return true;
  if (minNode && root->val <= minNode->val || maxNode && root->val >= maxNode->val)
    return false;
  return isValidBST(root->left, minNode, root) && isValidBST(root->right, root, maxNode);
}


//
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


int main()
{
  cout << isValidBST(nullptr) << endl;

  int a[] = { 1,1 };
  cout << isValidBST(createTree(a, sizeof(a) / sizeof(int))) << endl;

  int b[] = { 4,2,6,1,7,5,7 };
  cout << isValidBST(createTree(b, sizeof(b) / sizeof(int))) << endl;

  int c[] = { 4,2,6,1,3,5,7 };
  cout << isValidBST(createTree(c, sizeof(c) / sizeof(int))) << endl;
  return 0;
}

```

# validNumber
```cpp
// Source : https://leetcode.com/problems/valid-number/description/
/*
Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated.
If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
*/
#include <iostream>
using namespace std;


bool isNumber(const char *s)
{
  int i = 0;

  // skip the whilespaces
  for (; s[i] == ' '; i++) {}

  // check the significand
  if (s[i] == '+' || s[i] == '-') i++; // skip the sign if exist

  int n_nm, n_pt;
  for (n_nm = 0, n_pt = 0; (s[i] <= '9' && s[i] >= '0') || s[i] == '.'; i++)
    s[i] == '.' ? n_pt++ : n_nm++;
  if (n_pt > 1 || n_nm < 1) // no more than one point, at least one digit
    return false;

  // check the exponent if exist
  if (s[i] == 'e') {
    i++;
    if (s[i] == '+' || s[i] == '-') i++; // skip the sign

    int n_nm = 0;
    for (; s[i] >= '0' && s[i] <= '9'; i++, n_nm++) {}
    if (n_nm < 1)
      return false;
  }

  // skip the trailing whitespaces
  for (; s[i] == ' '; i++) {}

  return s[i] == 0;  // must reach the ending 0 of the string
}


#define TEST(s) cout << "\"" << s << "\"" << " : " << isNumber(s) << endl
int main(int argc, char** argv)
{
  const char* s = "123";
  if (argc > 1) {
    s = argv[1];
  }
  TEST(s);

  TEST("1.044");
  TEST(" 1.044 ");
  TEST("1.a");
  TEST("abc");
  TEST("e");
  TEST("1e");
  TEST("1e2");
  TEST("");
  TEST(" ");
  TEST("1.");
  TEST(".2");
  TEST(" . ");
  TEST(".");
  TEST("1.2.3");
  TEST("1e2e3");
  TEST("1..");
  TEST("+1.");
  TEST(" -1.");
  TEST("6e6.5");
  TEST("005047e+6");


  return 0;
}

```

# validPalindrome
```cpp
// Source : https://leetcode.com/problems/valid-palindrome/description/
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/

#include<iostream>
#include<string>

using namespace std;

bool isPalindrome(string s) {
  for (int i = 0, j = s.size() - 1; i < j; i++, j--) { // Move 2 pointers from each end until they collide
    while (isalnum(s[i]) == false && i < j) i++; // Increment left pointer if not alphanumeric
    while (isalnum(s[j]) == false && i < j) j--; // Decrement right pointer if no alphanumeric
    if (toupper(s[i]) != toupper(s[j])) return false; // Exit and return error if not match
  }

  return true;
}

// 2

bool isPalindrome(string s) {
  int start = 0, end = s.length() - 1;
  while (start < end) {
    if (!isalnum(s[start])) start++;
    else if (!isalnum(s[end])) end--;
    else {
      if (tolower(s[start++]) != tolower(s[end--])) return false;
    }
  }
  return true;
}


int main()
{
  return 0;
}
```

# validParentheses

```cpp
// Source : https://leetcode.com/problems/valid-parentheses/description/
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

#include <iostream>
#include <string>
#include<stack>

using namespace std;

bool isValid(string s) {
  stack<char> paren;
  for (char& c : s) {
    switch (c) {
    case '(':
    case '{':
    case '[': paren.push(c); break;
    case ')': if (paren.empty() || paren.top() != '(') return false; else paren.pop(); break;
    case '}': if (paren.empty() || paren.top() != '{') return false; else paren.pop(); break;
    case ']': if (paren.empty() || paren.top() != '[') return false; else paren.pop(); break;
    default:; // pass
    }
  }
  return paren.empty();
}


int main(int argc, char**argv)
{
  string s = "{{}{[]()}}";
  if (argc > 1) {
    s = argv[1];
  }
  cout << "str = \"" << (s) << "\"" << endl;
  cout << isValid(s) << endl;
}

```

# validSudoku
```cpp
// Source : https://leetcode.com/problems/valid-sudoku/description/
/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
A partially filled sudoku which is valid.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/
#include<iostream>
#include<vector>

using namespace std;

/*
Three flags are used to check whether a number appear.
used1: check each row
used2: check each column
used3: check each sub-boxes
*/

bool isValidSudoku(vector<vector<char> > &board)
{
  int used1[9][9] = { 0 }, used2[9][9] = { 0 }, used3[9][9] = { 0 };

  for (int i = 0; i < board.size(); ++i)
    for (int j = 0; j < board[i].size(); ++j)
      if (board[i][j] != '.')
      {
        int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
        if (used1[i][num] || used2[j][num] || used3[k][num])
          return false;
        used1[i][num] = used2[j][num] = used3[k][num] = 1;
      }

  return true;
}



int main()
{

  return 0;
}
```

# wildcardMatching
```cpp
// Source : https://leetcode.com/problems/wildcard-matching/description/
/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

#include <iostream>
#include <string>
using namespace std;

bool isMatch(const char *s, const char *p) {
  const char* star = NULL;
  const char* ss = s;
  while (*s) {
    //advancing both pointers when (both characters match) or ('?' found in pattern)
    //note that *p will not advance beyond its length
    if ((*p == '?') || (*p == *s)) { s++; p++; continue; }

    // * found in pattern, track index of *, only advancing pattern pointer
    if (*p == '*') { star = p++; ss = s; continue; }

    //current characters didn't match, last pattern pointer was *, current pattern pointer is not *
    //only advancing pattern pointer
    if (star) { p = star + 1; s = ++ss; continue; }

    //current pattern pointer is not star, last patter pointer was not *
    //characters do not match
    return false;
  }

  //check for remaining characters in pattern
  while (*p == '*') { p++; }

  return !*p;
}


int main(int argc, char** argv)
{
  const char *s = "aab";
  const char *p = "a*a*b";
  cout << s << ", " << p << " : " << isMatch(s, p) << endl;

  s = "abbb";
  p = "a*b";
  cout << s << ", " << p << " : " << isMatch(s, p) << endl;

  s = "abb";
  p = "a*bb";
  cout << s << ", " << p << " : " << isMatch(s, p) << endl;

  s = "abddbbb";
  p = "a*d*b";
  cout << s << ", " << p << " : " << isMatch(s, p) << endl;

  s = "abdb";
  p = "a**";
  cout << s << ", " << p << " : " << isMatch(s, p) << endl;

  s = "a";
  p = "a**";
  cout << s << ", " << p << " : " << isMatch(s, p) << endl;
  if (argc > 2) {
    s = argv[1];
    p = argv[2];
    cout << s << ", " << p << " : " << isMatch(s, p) << endl;
  }
  return 0;
}

```

# wordBreak

```cpp
// Source : https://leetcode.com/problems/word-break/description/
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 You may assume the dictionary does not contain duplicate words.
For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/

#include <iostream>
#include <vector>
#include <set>
using namespace std;

bool wordBreak(string s, unordered_set<string> &dict) {
  if (dict.size() == 0) return false;

  vector<bool> dp(s.size() + 1, false);
  dp[0] = true;

  for (int i = 1; i <= s.size(); i++)
  {
    for (int j = i - 1; j >= 0; j--)
    {
      if (dp[j])
      {
        string word = s.substr(j, i - j);
        if (dict.find(word) != dict.end())
        {
          dp[i] = true;
          break; //next i
        }
      }
    }
  }

  return dp[s.size()];
}

bool wordBreak(string s, set<string> &dict) {

  //using an array to mark subarray from 0 to i can be broken or not
  vector<bool> v(s.size(), false);

  for (int i = 0; i < s.size(); i++) {
    //check the substring from 0 to i is int dict or not
    string w = s.substr(0, i + 1);
    v[i] = (dict.find(w) != dict.end());

    //if it is, then use greedy algorithm
    if (v[i]) continue;

    //if it is not, then break it to check
    for (int j = 0; j < i; j++) {
      //if the substring from 0 to j can be borken, then check the substring from j to i
      if (v[j] == true) {
        w = s.substr(j + 1, i - j);
        v[i] = (dict.find(w) != dict.end());
        if (v[i]) break;
      }
    }
  }
  return v.size() ? v[v.size() - 1] : false;
}


int main()
{
  string s;
  set<string> dict;

  s = "a";
  dict.insert("a");
  cout << wordBreak(s, dict) << endl;

  dict.clear();
  s = "dogs";
  string d[] = { "dog","s","gs" };
  dict.insert(d, d + 3);
  cout << wordBreak(s, dict) << endl;

  return 0;
}

```

# wordLadder
```cpp
// Source : https://leetcode.com/problems/word-ladder/description/
/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/


// --------------------------- 
//  BFS non-recursive method
// ---------------------------
//
//    Using BFS instead of DFS is becasue the solution need the shortest transformation path.
//  
//    So, we can change every char in the word one by one, until find all possible transformation.
//
//    Keep this iteration, we will find the shorest path.
//
// For example:
//   
//     start = "hit"
//     end = "cog"
//     dict = ["hot","dot","dog","lot","log","dit","hig", "dig"]
//
//                      +-----+                  
//        +-------------+ hit +--------------+   
//        |             +--+--+              |   
//        |                |                 |   
//     +--v--+          +--v--+           +--v--+
//     | dit |    +-----+ hot +---+       | hig |
//     +--+--+    |     +-----+   |       +--+--+
//        |       |               |          |   
//        |    +--v--+         +--v--+    +--v--+
//        +----> dot |         | lot |    | dig |
//             +--+--+         +--+--+    +--+--+
//                |               |          |   
//             +--v--+         +--v--+       |   
//        +----> dog |         | log |       |   
//        |    +--+--+         +--+--+       |   
//        |       |               |          |   
//        |       |    +--v--+    |          |   
//        |       +--->| cog |<-- +          |   
//        |            +-----+               |   
//        |                                  |   
//        |                                  |   
//        +----------------------------------+   
//     
//     1) queue <==  "hit"
//     2) queue <==  "dit", "hot", "hig"
//     3) queue <==  "dot", "lot", "dig"
//     4) queue <==  "dog", "log" 
// 


#include<iostream>
#include<string>
#include<unordered_set>
#include<queue>
#include<map>

using namespace std;

int ladderLength(string start, string end, unordered_set<string> &dict) {

  // Using a map for two purposes:
  //   1) store the distince so far.
  //   2) remove the duplication
  map<string, int> dis;
  dis[start] = 1;

  queue<string> q;
  q.push(start);

  while (!q.empty()) {

    string word = q.front();
    q.pop();

    if (word == end) {
      break;
    }

    for (int i = 0; i < word.size(); i++) {
      string temp = word;
      for (char c = 'a'; c <= 'z'; c++) {
        temp[i] = c;
        if (dict.count(temp) > 0 && dis.count(temp) == 0) {
          dis[temp] = dis[word] + 1;
          q.push(temp);
        }
      }
    }
  }
  return (dis.count(end) == 0) ? 0 : dis[end];
}


// 2

int ladderLength(string beginWord, string endWord, unordered_set<string>& wordDict) {
  unordered_set<string> head, tail, *phead, *ptail;
  head.insert(beginWord);
  tail.insert(endWord);
  int dist = 2;
  while (!head.empty() && !tail.empty()) {
    if (head.size() < tail.size()) {
      phead = &head;
      ptail = &tail;
    }
    else {
      phead = &tail;
      ptail = &head;
    }
    unordered_set<string> temp;
    for (auto itr = phead->begin(); itr != phead->end(); itr++) {
      string word = *itr;
      wordDict.erase(word);
      for (int p = 0; p < (int)word.length(); p++) {
        char letter = word[p];
        for (int k = 0; k < 26; k++) {
          word[p] = 'a' + k;
          if (ptail->find(word) != ptail->end())
            return dist;
          if (wordDict.find(word) != wordDict.end()) {
            temp.insert(word);
            wordDict.erase(word);
          }
        }
        word[p] = letter;
      }
    }
    dist++;
    swap(*phead, temp);
  }
  return 0;
}


int main()
{
  return 0;
}
```

# wordSearch

```cpp
// Source : https://leetcode.com/problems/word-search/description/
/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
#include <iostream>
#include <vector>
#include <string>
using namespace std;

bool dfs(vector<vector<char>>& board, string &word, int col, int row, int beg)
{
  bool res(false);
  if (board[col][row] == word[beg])
  {
    if (beg >= word.size() - 1)
      return true;
    char temp(board[col][row]);
    board[col][row] = '*';
    if (col + 1 < board.size() && dfs(board, word, col + 1, row, beg + 1))
      res = true;
    else if (col > 0 && dfs(board, word, col - 1, row, beg + 1))
      res = true;
    else if (row + 1 < board[0].size() && dfs(board, word, col, row + 1, beg + 1))
      res = true;
    else if (row > 0 && dfs(board, word, col, row - 1, beg + 1))
      res = true;
    board[col][row] = temp;
  }
  return res;
}
bool exist(vector<vector<char>>& board, string word) {
  for (int i(0); i != board.size(); ++i)
    for (int j(0); j != board[i].size(); ++j)
      if (dfs(board, word, i, j, 0))
        return true;
  return false;
}


// 2

bool exist(vector<vector<char> > &board, string word) {
  if (board.size() <= 0 || word.size() <= 0) return false;
  int row = board.size();
  int col = board[0].size();
  //using a mask to mark which char has been selected.
  //do not use vector<bool>, it has big performance issue, could cause Time Limit Error
  vector< vector<int> > mask(row, vector<int>(col, 0));

  for (int i = 0; i < board.size(); i++) {
    for (int j = 0; j < board[i].size(); j++) {
      if (board[i][j] == word[0]) {
        vector< vector<int> > m = mask;
        if (exist(board, word, 0, i, j, m)) {
          return true;
        }
      }
    }
  }
  return false;
}


//
vector< vector<char> > buildBoard(char b[][5], int r, int c) {
  vector< vector<char> > board;
  for (int i = 0; i < r; i++) {
    vector<char> v(b[i], b[i] + c);
    cout << b[i] << endl;
    board.push_back(v);
  }
  cout << "----------" << endl;
  return board;
}

int main(int argc, char** argv)
{
  string s;
  char b[3][5] = { "ABCE", "SFCS", "ADEE" };
  vector< vector<char> > board = buildBoard(b, 3, 4);

  s = "SEE";
  cout << s << ":" << exist(board, s) << endl;

  s = "ABCCED";
  cout << s << ":" << exist(board, s) << endl;

  s = "ABCB";
  cout << s << ":" << exist(board, s) << endl;


  if (argc > 1) {
    s = argv[1];
    cout << s << ":" << exist(board, s) << endl;
  }

  cout << endl << "----------" << endl;
  char b1[3][5] = { "CAA", "AAA", "BCD" };
  board = buildBoard(b1, 3, 3);

  s = "AAB";
  cout << s << ":" << exist(board, s) << endl;


  cout << endl << "----------" << endl;
  char b2[3][5] = { "ABCE", "SFES", "ADEE" };
  board = buildBoard(b2, 3, 4);

  s = "ABCESEEEFS";
  cout << s << ":" << exist(board, s) << endl;

  cout << endl << "----------" << endl;
  char b3[3][5] = { "aaaa", "aaaa", "aaaa" };
  board = buildBoard(b3, 3, 4);

  s = "aaaaaaaaaaaaa";
  cout << s << ":" << exist(board, s) << endl;

  return 0;
}

```
# zigZagConversion
```cpp
// Source : https://leetcode.com/problems/zigzag-conversion/description/
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

#include <iostream>
#include <vector>
#include <string>
using namespace std;

string convert(string s, int nRows) {
  if (nRows <= 1)
    return s;

  const int len = (int)s.length();
  string *str = new string[nRows];

  int row = 0, step = 1;
  for (int i = 0; i < len; ++i)
  {
    str[row].push_back(s[i]);

    if (row == 0)
      step = 1;
    else if (row == nRows - 1)
      step = -1;

    row += step;
  }

  s.clear();
  for (int j = 0; j < nRows; ++j)
  {
    s.append(str[j]);
  }

  delete[] str;
  return s;
}

// 2

string convert(string s, int nRows) {
  //The cases no need to do anything
  if (nRows <= 1 || nRows >= s.size()) return s;

  vector<string> r(nRows);
  int row = 0;
  int step = 1;
  for (int i = 0; i < s.size(); i++) {
    if (row == nRows - 1) step = -1;
    if (row == 0) step = 1;
    //cout << row <<endl;
    r[row] += s[i];
    row += step;
  }

  string result;
  for (int i = 0; i < nRows; i++) {
    result += r[i];
  }
  return result;
}

int main(int argc, char**argv) {

  string s;
  int r;

  s = "PAYPALISHIRING";
  r = 3;
  cout << s << " : " << convert(s, 3) << endl;

}

```



