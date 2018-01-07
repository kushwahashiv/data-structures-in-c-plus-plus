// Source : https://leetcode.com/problems/merge-k-sorted-lists/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-06

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

#include <time.h>
#include <iostream>
#include <vector>
using namespace std;


struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};


struct ListNode* SortedMerge(struct ListNode* a, struct ListNode* b)
{
  struct ListNode* result(nullptr);
  /* Base cases */
  if (a == nullptr)
    return(b);
  else if (b == nullptr)
    return(a);

  /* Pick either a or b, and recur */
  if (a->val <= b->val)
  {
    result = a;
    result->next = SortedMerge(a->next, b);
  }
  else
  {
    result = b;
    result->next = SortedMerge(a, b->next);
  }
  return(result);
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

int main(int argc, char**argv)
{
  int n;
  srand(time(0));
  if (argc > 1) {
    n = atoi(argv[1]) % 2;
  }

  int a[] = { 1,3,5,6,7,10 };
  int b[] = { 0,4,6,8,9,11,20,30,40 };
  ListNode* p1 = createList(a, sizeof(a) / sizeof(int));
  ListNode* p2 = createList(b, sizeof(b) / sizeof(int));

  auto result = SortedMerge(p1, p2);
  printList(result);


  cout << "method " << n + 1 << endl;
  return 0;
}
