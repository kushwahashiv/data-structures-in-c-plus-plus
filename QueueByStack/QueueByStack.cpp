/*
Implement a Queue with Stacks.
or
Program to implement a queue using two stacks
Can implement it use template
*/

#include<iostream>

struct Node
{
  int data;
  Node *next;
};

void push(Node** top_ref, int new_data)
{
  Node* new_node = new Node();
  new_node->data = new_data;

  //link the old list off the new node
  new_node->next = (*top_ref);

  //move the head to point to the new node 
  (*top_ref) = new_node;
}

int pop(Node** top_ref)
{
  int res;
  Node *top(nullptr);

  //If stack is empty then error
  if (*top_ref == nullptr)
  {
    std::cout << "Stack overflow" << std::endl;
    exit(0);
  }
  else
  {
    top = *top_ref;
    res = top->data;
    *top_ref = top->next;
    free(top);
    return res;
  }
}


// structure of queue having two stacks 
struct queue
{
  Node *stack1;
  Node *stack2;
};

//enqueue an item to queue 
void enQueue(queue *q, int x)
{
  push(&q->stack1, x);
}

//dequeue an item from queue
int deQueue(queue *q)
{
  int x;
  if (q->stack1 == nullptr && q->stack2 == nullptr)
  {
    std::cout << "Q is empty" << std::endl;
    exit(0);
  }

  //Move elements from satck1 to stack 2 only if stack2 is empty
  if (q->stack2 == nullptr)
  {
    while (q->stack1 != nullptr)
    {
      x = pop(&q->stack1);
      push(&q->stack2, x);
    }
  }

  x = pop(&q->stack2);
  return x;
}

int main()
{
  //Create a queue with items 1 2 3
  queue *q = new queue();
  q->stack1 = nullptr;
  q->stack2 = nullptr;
  enQueue(q, 1);
  enQueue(q, 2);
  enQueue(q, 3);

  //Dequeue items
  std::cout << deQueue(q) <<std::endl;
  std::cout << deQueue(q) << std::endl;
  std::cout << deQueue(q) << std::endl;

  delete q;

  system("pause");

  return 0;
}
