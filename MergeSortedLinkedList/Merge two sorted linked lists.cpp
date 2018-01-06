/*
Problem:
Merge two sorted linked lists

http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/


Method 1 (Using Dummy Nodes)
The strategy here uses a temporary dummy node as the start of the result list. 
The pointer Tail always points to the last node in the result list, so appending new nodes is easy.
The dummy node gives tail something to point to initially when the result list is empty. This dummy 
node is efficient, since it is only temporary, and it is allocated in the stack. The loop proceeds,
removing one node from either ‘a’ or ‘b’, and adding it to tail. When
we are done, the result is in dummy.next

*/



//Program to alternatively split a linked list into two halves
#include<iostream>
#include<assert.h>

//Link list node
struct node
{
  int data;
  struct node* next;
};

//pull off the front node of the source and put it in dest
void MoveNode(struct node** destRef, struct node** sourceRef);

//Takes two lists sorted in increasing order, and splices their nodes together to make one big sorted list which is returned.
struct node* SortedMerge(struct node* a, struct node* b)
{
  //a dummy first node to hang the result on
  struct node dummy;

  //tail points to the last result node
  struct node* tail = &dummy;

  //so tail->next is the place to add new nodes to the result.
  dummy.next = nullptr;
  while (1)
  {
    if (a == nullptr)
    {
      //if either list runs out, use the other list
      tail->next = b;
      break;
    }
    else if (b == nullptr)
    {
      tail->next = a;
      break;
    }
    if (a->data <= b->data)
    {
      MoveNode(&(tail->next), &a);
    }
    else
    {
      MoveNode(&(tail->next), &b);
    }
    tail = tail->next;
  }
  return(dummy.next);
}


//UTILITY FUNCTIONS
//MoveNode() function takes the node from the front of the source, and move it to the front of the dest.
//It is an error to call this with the source list empty.

//Before calling MoveNode():
//source == {1, 2, 3}
//dest == {1, 2, 3}

//Affter calling MoveNode():
//source == {2, 3}
//dest == {1, 1, 2, 3}

void MoveNode(struct node** destRef, struct node** sourceRef)
{
  //the front source node
  struct node* newNode = *sourceRef;
  assert(newNode != nullptr);

  //Advance the source pointer
  *sourceRef = newNode->next;

  //Link the old dest off the new node
  newNode->next = *destRef;

  //Move dest to point to the new node
  *destRef = newNode;
}


//Function to insert a node at the beginging of the linked list
void push(struct node** head_ref, int new_data)
{
  //allocate node
  struct node* new_node =
    (struct node*) malloc(sizeof(struct node));

  //put in the data
  new_node->data = new_data;

  //link the old list off the new node
  new_node->next = (*head_ref);

  //move the head to point to the new node
  (*head_ref) = new_node;
}


// method 2
#include<vector>
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(nullptr) {}
};

//Function to print nodes in a given linked list
void printList(struct node *node)
{
  while (node != nullptr)
  {
    std::cout<<node->data << " ";
    node = node->next;
  }
  std::cout <<std::endl;
}

ListNode *merge2Lists(ListNode* l1, ListNode* l2) {
	if (nullptr == l1) return l2;
	else if (nullptr == l2) return l1;
	if (l1->val <= l2->val) {
		l1->next = merge2Lists(l1->next, l2);
		return l1;
	} else {
		l2->next = merge2Lists(l1, l2->next);
		return l2;
	}
}

ListNode* mergeKLists(std::vector<ListNode*>& lists) {
	if (lists.empty())  return nullptr;
	if (lists.size() == 1) return lists[0];
	std::vector<ListNode*> newLists;
	if (lists.size() % 2)
		newLists.push_back(lists.back());
	for (int i = 0; i < lists.size() - 1; i += 2)
		newLists.push_back(merge2Lists(lists[i], lists[i + 1]));
	return mergeKLists(newLists);
}


/*
ListNode *mergeKLists(std::vector<ListNode *> &lists) {
if (lists.empty()) return nullptr;
int len = lists.size();
while (len > 1) {
for (int i = 0; i < len / 2; ++i) {
lists[i] = merge2Lists(lists[i], lists[len - 1 - i]);
}
len = (len + 1) / 2;
}
return lists.front();
}
*/


//Drier program to test above functions
int main()
{
  //Start with the empty list
  struct node* res = nullptr;
  struct node* a = nullptr;
  struct node* b = nullptr;

  //Let us create two sorted linked lists to test the functions
  //Created lists shall be a: 5->10->15,  b: 2->3->20 

  push(&a, 15);
  push(&a, 10);
  push(&a, 5);

  push(&b, 20);
  push(&b, 3);
  push(&b, 2);

  //Remove duplicates from linked list
  res = SortedMerge(a, b);

  std::cout <<"Merged Linked List is :"<<std::endl;
  printList(res);

  system("pause");
  return 0;
}