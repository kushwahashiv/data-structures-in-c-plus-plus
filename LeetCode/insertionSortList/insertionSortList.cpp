// Source : https://leetcode.com/problems/insertion-sort-list/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-19

//Sort a linked list using insertion sort.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *insertionSortList(ListNode *head) {
    // zero or one element in list
    if (head == nullptr || head->next ==nullptr){
        return head;
    }

    ListNode *pSorted = nullptr;
    while ( head != nullptr  ){
        /* remember the head */
        ListNode *pHead = head;
        /* trailing pointer for efficient splice */
        ListNode **ppTrail = &pSorted;
        
        /* pop head off list */
        head = head->next;
        
        /* splice head into sorted list at proper place */
        while( *ppTrail!=nullptr && pHead->val > (*ppTrail)->val )  {
            ppTrail = &(*ppTrail)->next;
        }
        pHead->next = *ppTrail;
        *ppTrail = pHead;
    }

    return pSorted;
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


int main(int argc, char** argv)
{
    int n = 10;
    if (argc>1){
        n = atoi(argv[1]);
    }
    srand(time(nullptr));

    int *a = new int[n];
    for(int i=0; i<n; i++){
        a[i] = rand()%n + 1;
    }

    ListNode *p = createList(a, n);
    printList(p);
    printList(insertionSortList(p));

    delete[] a;
}
