// Source : https://leetcode.com/problems/partition-list/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

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
