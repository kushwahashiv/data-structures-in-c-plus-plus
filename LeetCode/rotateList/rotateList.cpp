// Source : https://leetcode.com/problems/rotate-list/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-20

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