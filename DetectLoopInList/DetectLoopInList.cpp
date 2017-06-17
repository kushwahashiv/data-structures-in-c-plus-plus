/*
Problem:
Detect loop in a linked list

Following are different ways of doing this
Use Hashing:
Traverse the list one by one and keep putting the node addresses in a Hash Table. 
At any point, if nullptr is reached then return false and if next of current node points 
to any of the previously stored nodes in Hash then return true.

Mark Visited Nodes:
This solution requires modifications to basic linked list data structure.  
Have a visited flag with each node.  Traverse the linked list and keep marking visited nodes.  
If you see a visited node again then there is a loop. This solution works in O(n) but requires 
additional information with each node.

A variation of this solution that doesn�t require modification to basic data structure can be
implemented using hash.  Just store the addresses of visited nodes in a hash and if you see an 
address that already exists in hash then there is a loop.

*/


//Implementation of Floyd�s Cycle - Finding Algorithm :
//Time Complexity : O(n)
//Auxiliary Space : O(1)

#include<stdio.h>
#include<stdlib.h>

/* Link list node */
struct node
{
  int data;
  struct node* next;
};

void push(struct node** head_ref, int new_data)
{
  // allocate node 
  struct node* new_node =(struct node*) malloc(sizeof(struct node));

  //put in the data
  new_node->data = new_data;

  //link the old list off the new node
  new_node->next = (*head_ref);

  //move the head to point to the new node
  (*head_ref) = new_node;
}

int detectloop(struct node *list)
{
  struct node  *slow_p = list, *fast_p = list;

  while (slow_p && fast_p && fast_p->next)
  {
    slow_p = slow_p->next;
    fast_p = fast_p->next->next;
    if (slow_p == fast_p)
    {
      printf("Found Loop");
      return 1;
    }
  }
  return 0;
}

//Drier program to test above function
int main()
{
  //Start with the empty list
  struct node* head = nullptr;

  push(&head, 20);
  push(&head, 4);
  push(&head, 15);
  push(&head, 10);

  //Create a loop for testing
  head->next->next->next->next = head;
  detectloop(head);

  getchar();
}
