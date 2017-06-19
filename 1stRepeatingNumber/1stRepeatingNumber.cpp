/*

Problem:
First repeating number in array

http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/

Traverse the array once. While traversing, keep track of count of all elements in the array using a temp array count[] of size n,
when you see an element whose count is already set, print it as duplicate.

This method uses the range given in the question to restrict the size of count[],
but doesn’t use the data that there are only two repeating elements.


*/

#include<iostream>
#include<array>

int FirstRepeatingElement(int arr[], int size)
{
  int *count = (int *)calloc(sizeof(int), (size - 2));
  //int *count = new int[size - 2];

  for (int i = 0; i < size; i++)
  {
    if (count[arr[i]] == 1)
      return arr[i];
    else
      count[arr[i]]++;
  }

  return 0;
}

int findRepeat(int* a, int arraySize)
{
  int i, j;
  for (i = 0; i < arraySize; i++)
  {
    for (j = i + 1; j < arraySize; j++)
    {
      if (a[i] == a[j])
        return a[i];
    }
  } return 0;
}

void printRepeating(int arr[], int size)
{
  int *count = (int *)calloc(sizeof(int), (size - 2));
  std::cout << " Repeating elements are ";

  for (int i = 0; i < size; i++)
  {
    if (count[arr[i]] == 1)
      std::cout << arr[i] << " ";
    else
      count[arr[i]]++;
  }
}

int main()
{
  int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
  int arr_size = sizeof(arr) / sizeof(arr[0]);

  //1.

  int firstRepeating = FirstRepeatingElement(arr, arr_size);
  if (firstRepeating)
  {
    std::cout << "First Repeating element: " << firstRepeating << std::endl;
  }
  else
  {
    std::cout << "No repeating elements" << std::endl;
  }


  //2.
  int element = findRepeat(arr, arr_size);
  if (element)
  {
    std::cout << "First Repeating element: " << element << std::endl;
  }
  else
  {
    std::cout << "No repeating elements" << std::endl;
  }
  
  printRepeating(arr, arr_size);

  system("pause");

  return 0;
}