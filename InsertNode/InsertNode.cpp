/**********************************************************************
* Implement the Insert function below such that it inserts the
* given node either immediately before the node at the given index
* or at the end of the list if the index is beyond the end of the list.
* For example, if the list contains 4,8,15,16,23, and 42,
* and Insert is called with a node with value 34 and offset 2, the
* modified list would contain 4,8,34,15,16,23, and 42.
**********************************************************************/

#include <tchar.h>
#include <assert.h>

struct Node
{
  int num;
  Node* next;
};

void Insert(Node** apList, Node* apNode, int aIndex);

int _tmain(int argc, _TCHAR* argv[])
{
  Node* apList = 0;
  for (int i = 0; i < 5; ++i)
  {
    Node* apNode = new Node;
    apNode->num = i;
    apNode->next = 0;

    Insert(&apList, apNode, i);
  }

  Node* apNode = new Node;
  apNode->num = 42;
  apNode->next = 0;

  Insert(&apList, apNode, 2);

  while (apList)
  {
    Node* temp = apList->next;
    delete apList;
    apList = temp;
  }

  return 0;
}


void Insert(Node** apList, Node* apNode, int aIndex)
{
  if (aIndex == 0)
  {
    apNode->next = *apList;
    *apList = apNode;
  }
  else
  {
    Node* current = *apList;

    for (int index = 0; index < aIndex - 1; index++)
    {
      assert(current != nullptr);
      current = current->next;
    }
    assert(current != nullptr);
    apNode->next = current->next;
    current->next = apNode;
  }
}