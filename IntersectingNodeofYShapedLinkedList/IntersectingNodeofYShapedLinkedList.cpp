/*
Problem:
Intersecting node of a Y shaped linked list

*/
#include<iostream>


struct node
{
  int data;
  struct node* next;
};

int getCount(struct node* head)
{
  struct node* current = head;
  int count = 0;

  while (current != nullptr)
  {
    count++;
    current = current->next;
  }

  return count;
}

int IntesectionNode(int distance, struct node* head1, struct node* head2)
{
  int i;
  struct node* current1 = head1;
  struct node* current2 = head2;

  for (i = 0; i < distance; i++)
  {
    if (current1 == nullptr)
    {
      return -1;
    }
    current1 = current1->next;
  }

  while (current1 != nullptr && current2 != nullptr)
  {
    if (current1 == current2)
      return current1->data;
    current1 = current1->next;
    current2 = current2->next;
  }

  return -1;
}

int getIntesectionNode(struct node* head1, struct node* head2)
{
  int c1 = getCount(head1);
  int c2 = getCount(head2);
  int d;

  if (c1 > c2)
  {
    d = c1 - c2;
    return IntesectionNode(d, head1, head2);
  }
  else
  {
    d = c2 - c1;
    return IntesectionNode(d, head2, head1);
  }
}


int main()
{
  /*
  Create two linked lists

  1st 3->6->9->15->30
  2nd 10->15->30

  15 is the intersection point
  */
  struct node* newNode;
  struct node* head1 = (struct node*) malloc(sizeof(struct node));
  head1->data = 10;

  struct node* head2 = (struct node*) malloc(sizeof(struct node));
  head2->data = 3;

  newNode = (struct node*) malloc(sizeof(struct node));
  newNode->data = 6;
  head2->next = newNode;

  newNode = (struct node*) malloc(sizeof(struct node));
  newNode->data = 9;
  head2->next->next = newNode;

  newNode = (struct node*) malloc(sizeof(struct node));
  newNode->data = 15;
  head1->next = newNode;
  head2->next->next->next = newNode;

  newNode = (struct node*) malloc(sizeof(struct node));
  newNode->data = 30;
  head1->next->next = newNode;

  head1->next->next->next = nullptr;

  std::cout << "The node of intersection is" << getIntesectionNode(head1, head2) << std::endl;


  system("pause");

  return 0;
}