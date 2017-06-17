/*
Source : https://oj.leetcode.com/problems/add-two-numbers/
Author : Shiv S. Kushwaha
Date   : 2014-06-18

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