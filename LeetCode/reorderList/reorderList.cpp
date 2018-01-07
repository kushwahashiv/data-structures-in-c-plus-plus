// Source : https://leetcode.com/problems/reorder-list/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-17

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
