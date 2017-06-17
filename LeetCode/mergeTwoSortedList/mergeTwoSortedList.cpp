// Source : https://oj.leetcode.com/problems/merge-two-sorted-lists/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-06

/**********************************************************************************
*
* Merge two sorted linked lists and return it as a new list. The new list should be
* made by splicing together the nodes of the first two lists.
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


#include <iostream>
#include <vector>
#include <ctime>
using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};


class Solution {
public:
  Solution(){
    srand(time(nullptr));
  }
  ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
    switch (rand() % 2){
    case 0:
      return mergeTwoLists01(l1, l2);
    case 1:
      return mergeTwoLists02(l1, l2);
    default:
      return mergeTwoLists03(l1, l2);
    }
  }

  /* merge the 2nd list into 1st list*/
  ListNode *mergeTwoLists01(ListNode* head1, ListNode* head2){
    ListNode *p1 = head1, *p2 = head2;
    static ListNode dummy(0);

    dummy.next = p1;
    ListNode *prev = &dummy;

    while (p1 && p2){
      if (p1->val < p2->val){
        prev = p1;
        p1 = p1->next;
      }
      else{
        prev->next = p2;
        p2 = p2->next;
        prev = prev->next;
        prev->next = p1;
      }
    }
    if (p2){
      prev->next = p2;
    }

    return dummy.next;
  }


  /* merge two lists to the new list */
  ListNode *mergeTwoLists02(ListNode *l1, ListNode *l2) {
    ListNode *l = nullptr, *p = nullptr;

    while (l1 != nullptr && l2 != nullptr){
      ListNode *n = nullptr;
      if (l1->val < l2->val){
        n = l1;
        l1 = l1->next;
      }
      else{
        n = l2;
        l2 = l2->next;
      }
      if (l == nullptr){
        l = p = n;
      }
      else{
        p->next = n;
        p = p->next;
      }
    }

    ListNode* rest = l1 ? l1 : l2;

    l = mergeTheRest(rest, l, p);


    return l;
  }

  ListNode* mergeTheRest(ListNode* l, ListNode*head, ListNode* tail){
    if (l){
      if (head && tail){
        tail->next = l;
      }
      else{
        head = l;
      }
    }
    return head;
  }

  /*
   * You can see the 2nd slution's code is quite complicated,
   * because it need to check the (head==nullptr) situation.
   * We can use the "pointer to pointer" to make the code more clean
   * however, this would be bad for performance.
   */
  ListNode *mergeTwoLists03(ListNode *l1, ListNode *l2) {
    ListNode *head = nullptr;
    ListNode **pTail = &head;
    while (l1 != nullptr && l2 != nullptr) {
      if (l1->val < l2->val) {
        *pTail = l1;
        l1 = l1->next;
      }
      else {
        *pTail = l2;
        l2 = l2->next;
      }
      pTail = &(*pTail)->next;
    }
    *pTail = (l1 != nullptr ? l1 : l2);
    return head;
  }

};


int main()
{

  return 0;
}