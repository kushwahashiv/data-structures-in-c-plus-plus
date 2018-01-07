// Source : https://leetcode.com/problems/reverse-linked-list-ii/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-05

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
#include <iostream>
#include <time.h>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};


ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* new_head = new ListNode(0);
        new_head -> next = head;
        ListNode* pre = new_head;
        for (int i = 0; i < m - 1; i++)
            pre = pre -> next;
        ListNode* cur = pre -> next;
        for (int i = 0; i < n - m; i++) {
            ListNode* move = cur -> next;
            cur -> next = move -> next;
            move -> next = pre -> next;
            pre -> next = move;
        }
        return new_head -> next;
    }


void printList(ListNode* h)
{
    while(h!=nullptr){
        printf("%d ", h->val);
        h = h->next;
    }
    printf("\n");
}

ListNode* createList(int *a, int n)
{
    ListNode *head=nullptr, *p=nullptr;
    for(int i=0; i<n; i++){
        if (head == nullptr){
            head = p = new ListNode(a[i]);
        }else{
            p->next = new ListNode(a[i]);
            p = p->next;
        }
    }
    return head;
}

ListNode* createList(int len) {
    int *a = new int[len];
    for(int i=0; i<len; i++){
        a[i] = i+1;
    }
    ListNode* h =  createList(a, len);
    delete[] a;
    return h;
}

int main(int argc, char** argv)
{
    int l=5;
    int  m=2, n=4;
    
    if (argc>1){
        l = atoi(argv[1]);
    }
    if (argc>2) {
        m = atoi(argv[2]);
    }
    if (argc>3) {
        n = atoi(argv[3]);
    }
    
    ListNode* h = createList(l);
    printList( h );
    printList( reverseBetween(h , m, n) );

    
}
