// Source : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-21

/**********************************************************************************
*
* Given a linked list, remove the nth node from the end of list and return its head.
*
* For example,
*
*    Given linked list: 1->2->3->4->5, and n = 2.
*
*    After removing the second node from the end, the linked list becomes 1->2->3->5.
*
* Note:
* Given n will always be valid.
* Try to do this in one pass.
*
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



#include<iostream>
#include<vector>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(nullptr) {}
};

/*
ListNode *removeNthFromEnd(ListNode *head, int n) {
	if (head == nullptr || n <= 0) {
		return nullptr;
	}
	ListNode fakeHead(0);
	fakeHead.next = head;
	head = &fakeHead;

	ListNode *p1, *p2;
	p1 = p2 = head;
	for (int i = 0; i < n; i++) {
		if (p2 == nullptr) return nullptr;
		p2 = p2->next;
	}
	while (p2->next != nullptr) {
		p2 = p2->next;
		p1 = p1->next;
	}

	p1->next = p1->next->next;
	return head->next;
}
*/

ListNode* removeNthFromEnd(ListNode* head, int n) {
	if (head == nullptr || n <= 0) {
		return nullptr;
	}

	ListNode dummy(0);
	dummy.next = head;
	ListNode* first = &dummy;
	ListNode* second = &dummy;
	// Advances first pointer so that the gap between first and second is n nodes apart
	for (int i = 1; i <= n + 1; i++) {
		first = first->next;
	}
	// Move first to the end, maintaining the gap
	while (first != nullptr) {
		first = first->next;
		second = second->next;
	}
	second->next = second->next->next;
	return dummy.next;
}


// method 2
ListNode* removeNthFromEnd2(ListNode* head, int n)
{
	ListNode** t1 = &head, *t2 = head;
	for (int i = 1; i < n; ++i)
	{
		t2 = t2->next;
	}
	while (t2->next != nullptr)
	{
		t1 = &((*t1)->next);
		t2 = t2->next;
	}
	*t1 = (*t1)->next;
	return head;
}



int main()
{
	vector<int> data = { 1, 2, 3, 4, 5 };
	ListNode *head= nullptr, *p= nullptr;

	for (auto i: data) {
		if (head == nullptr) {
			head = p = new ListNode(i);
		} else {
			p->next = new ListNode(i);
			p = p->next;
		}
	}

	auto v = removeNthFromEnd(head, 2);
	while(v != nullptr){
		cout << v->val << " " << endl;
		v = v->next;
	}
	
	return 0;
}