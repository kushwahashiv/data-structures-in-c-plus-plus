/**********************************************************************
* Implement the PrintListReverse function below such that it prints the
* numbers in the nodes of a singly-linked list from the back of the list
* to the front.  For example, if the list contains 4,8,15,16,23, and 42,
* the function will output:
* 42
* 23
* 16
* 15
* 8
* 4
**********************************************************************/

#include <tchar.h>
#include <iostream>

struct Node
{
  int num;
  Node* next;
};

void PrintListReverse(Node** list);

int _tmain(int argc, _TCHAR* argv[])
{
  Node* head = nullptr;

  for (int i = 9; i >= 0; --i)
  {
    Node* other = new Node;
    other->num = i;
    other->next = head;
    head = other;
  }

  PrintListReverse(&head);

  while (head != nullptr)
  {
    std::cout << head->num;
    head = head->next;
  }

  while (head)
  {
    Node* next = head->next;
    delete head;
    head = next;
  }

  return 0;
}

void PrintListReverse(Node** list)
{
  Node* first = *list;
  Node* rest;

  if (*list == nullptr)
    return;
  first = *list;
  rest = first->next;
  if (rest == nullptr)
    return;

  PrintListReverse(&rest);

  first->next->next = first;
  first->next = nullptr;
  *list = rest;
}

