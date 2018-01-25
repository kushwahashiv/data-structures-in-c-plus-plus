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

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
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
 
  ListNode* newNode;

  ListNode* a = new ListNode(2);
  newNode = new ListNode(4);
  a->next = newNode;
  newNode = new ListNode(3);
  a->next->next = newNode;

  ListNode* b = new ListNode(5);
  newNode = new ListNode(6);
  b->next = newNode;
  newNode = new ListNode(4);
  b->next->next = newNode;

  ListNode* c = addTwoNumbers(a, b);
  while (c != nullptr)
  {
    std::cout << c->val;
    c = c->next;
  }

  return 0;
}