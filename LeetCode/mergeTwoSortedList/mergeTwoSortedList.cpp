// Source : https://leetcode.com/problems/merge-two-sorted-lists/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-06

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