// Source : https://oj.leetcode.com/problems/reorder-list/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-17

/********************************************************************************** 
* 
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* 
* You must do this in-place without altering the nodes' values.
* 
* For example,
* Given {1,2,3,4}, reorder it to {1,4,2,3}.
* 
*               
**********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
/**
 * Definition for singly-linked list.
 */
class ListNode {
public:
    int val;
    ListNode *next;
    ListNode():val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    void reorderList(ListNode *head) {
        ListNode *pMid = findMidPos(head);
        pMid = reverseList(pMid);
        head = Merge(head, pMid);
    }
    
private:
    ListNode* findMidPos(ListNode *head){

        ListNode *p1, *p2, *p=nullptr;
        p1 = p2 = head;
        
        while(p1!=nullptr && p2!=nullptr && p2->next!=nullptr){
            p = p1;
            p1 = p1->next;
            p2 = p2->next->next;
        }

        if(p!=nullptr){
            p->next = nullptr;
        }
        
        return p1;
    }
    
    ListNode* reverseList(ListNode *head){
        ListNode* h = nullptr;
        ListNode *p;
        while (head!=nullptr){
            p = head;
            head = head->next;
            p->next = h;
            h = p;
        }
        return h;
    }
    
    ListNode* Merge(ListNode *h1, ListNode* h2) 
    {
        ListNode *p1=h1, *p2=h2, *p1nxt, *p2nxt;
        while(p1!=nullptr && p2!=nullptr){
            p1nxt = p1->next;
            p2nxt = p2->next;
            
            p1->next = p2;
            p2->next = p1nxt;
            
            if (p1nxt==nullptr){
                p2->next = p2nxt;
                break;
            }
            p1=p1nxt;
            p2=p2nxt;
        }

        return h1;//Check if correct -Shiv
    }
};

void printList(ListNode *h){
    while(h!=nullptr){
        printf("%d->", h->val);
        h = h->next;
    }
    printf("nil\n");
}

int main(int argc, char** argv)
{
    int size = atoi(argv[1]);
    ListNode* n = new ListNode[size] ;

    for(int i=0; i<size; i++){
        n[i].val = i;
        if( i+1 < size) {
            n[i].next = &n[i+1];
        }
    }


    Solution s;
    s.reorderList(&n[0]);
    printList(&n[0]);
    
    
    
    return 0;
}
