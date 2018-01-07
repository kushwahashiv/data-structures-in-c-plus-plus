// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

#include <iosteram>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *deleteDuplicates(ListNode *head) {

    for(ListNode *p=head; p && p->next; ){
        if (p->val == p->next->val){
            p->next = p->next->next;
            continue;
        }
        p=p->next;
    }
    return head;
}

void printList(ListNode* h)
{
    while(h!=nullptr){
        printf("%d ", h->val);
        h = h->next;
    }
    printf("\n");
}

ListNode* createList(int a[], int n)
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


int main()
{
    int a[]={1,1,2,3,3};
    int b[]={1,1,1};

    printList(deleteDuplicates(createList(a, sizeof(a)/sizeof(int))));
    printList(deleteDuplicates(createList(b, sizeof(b)/sizeof(int))));
    return 0;
}

