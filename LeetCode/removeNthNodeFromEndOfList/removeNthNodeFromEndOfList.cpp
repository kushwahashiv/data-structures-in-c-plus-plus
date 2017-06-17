// Source : https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/**********************************************************************************
*
* Given a linked list, remove the nth node from the end of list and return its head.
*
* For example,
*
*    Given linked list: 1->2->3->4->5, and n = 2.
*
*    After removing the second node from the end, the linked list becomes 1->2->3->5.
*
* Note:
* Given n will always be valid.
* Try to do this in one pass.
*
*
**********************************************************************************/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(nullptr) {}
 * };
 */



#include<iostream>
using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
  ListNode *removeNthFromEnd(ListNode *head, int n) {
    if (head == nullptr || n <= 0){
      return nullptr;
    }
    ListNode fakeHead(0);
    fakeHead.next = head;
    head = &fakeHead;

    ListNode *p1, *p2;
    p1 = p2 = head;
    for (int i = 0; i < n; i++){
      if (p2 == nullptr) return nullptr;
      p2 = p2->next;
    }
    while (p2->next != nullptr){
      p2 = p2->next;
      p1 = p1->next;
    }

    p1->next = p1->next->next;
    return head->next;
  }
};


int main()
{
  return 0;
}