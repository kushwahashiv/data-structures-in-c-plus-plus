// Source : https://oj.leetcode.com/problems/linked-list-cycle/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-03

/********************************************************************************** 
* 
* Given a linked list, determine if it has a cycle in it.
* 
* Follow up:
* Can you solve it without using extra space?
* 
*               
**********************************************************************************/

/*
 * if there is a cycle in the list, then we can use two pointers travers the list.
 *
 * one pointer traverse one step each time, another one traverse two steps each time.
 *
 * so, those two pointers meet together, that means there must be a cycle inside the list.
 */

#include <iostream>
#include <vector>
using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};


bool hasCycle(ListNode *head) 
{
    ListNode* p1;
    ListNode* p2;

    if (head==nullptr) return false;
    p1=head;
    p2=head;

    while (p1!=nullptr && p2!=nullptr){

        p1=p1->next;

        if (p2->next == nullptr) return false;

        p2=p2->next->next;

        if (p1==p2) return true;
    }

    return false;

}  


int main()
{
  return 0;
}
