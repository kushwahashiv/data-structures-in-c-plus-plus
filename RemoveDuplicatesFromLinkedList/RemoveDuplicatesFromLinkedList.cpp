#include <iostream>

using namespace std;

typedef struct Node
{
  int data;
  Node *next;
} Linked_list;

int add(Linked_list **head, int d)
{
  Linked_list *l = new Linked_list;
  if (l == nullptr)
    return 0;

  Linked_list *t = *head;
  l->data = d;
  l->next = nullptr;

  if (*head == nullptr)
  {
    *head = l;
    return 1;
  }

  while (t->next != nullptr)
  {
    t = t->next;
  }

  t->next = l;

  return 1;
}

int remove_dup(Linked_list *head)
{
  Linked_list *current;
  Linked_list *previous;
  Node *runner;
  Node *tmp;

  if (head == nullptr)
    return 0;

  if (head->next == nullptr)
    return 1;

  current = head->next;
  previous = head;

  while (current != nullptr)
  {
    runner = head;
    while (runner != current)
    {
      // remove node if equal
      if (runner->data == current->data)
      {
        tmp = current;
        current = current->next;
        previous->next = current;
        delete tmp;
        break;
      }

      runner = runner->next;
    }

    if (runner == current)
    {
      current = current->next;
      previous = previous->next;
    }
  }
}


int main(int argc, char* argv[])
{
  Linked_list *head = nullptr;
  Linked_list *l;

  add(&head, 1);
  add(&head, 1);
  add(&head, 2);
  add(&head, 3);
  add(&head, 9);
  add(&head, 4);
  add(&head, 1);
  add(&head, 5);

  cout << "before" << endl;
  l = head;

  while (l != nullptr)
  {
    cout << l->data << endl;
    l = l->next;
  }

  remove_dup(head);

  cout << "after remove dup " << endl;

  l = head;
  while (l != nullptr)
  {
    cout << l->data << endl;
    l = l->next;
  }

  system("pause");

  return 0;
}