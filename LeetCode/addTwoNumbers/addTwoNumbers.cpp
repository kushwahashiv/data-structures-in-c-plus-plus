/*
Source : https://leetcode.com/problems/add-two-numbers/description/
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