/*
Problem Statement
Quicksort In-Place

The previous version of Quicksort was easy to understand, but it was not optimal. 
It required copying the numbers into other arrays, which takes up space and time. 
To make things faster, one can create an "in-place" version of Quicksort, where the 
numbers are all sorted within the array itself.

Challenge
Create an in-place version of Quicksort. Also, always select the last element in the 
'sub-array' as a pivot. Partition the left side and then the right side of the array. 
Print out the whole array at the end of every partitioning method.

*/
#include <iostream>
using namespace std;

int n;

void print(int a[])
{
  for (int i = 0; i < n; i++)
    cout << a[i] << " ";
  cout << endl;
}

int partition(int* a, int low, int high)
{
  /*Start index for scanning the array*/
  int left = low;
  /*Select middle element of the array as pivot*/
  int pivotIdx = high;
  /*Swap pivot with right most element of the array*/
  int pivot = a[pivotIdx];
  a[pivotIdx] = a[high];
  a[high] = pivot;
  pivotIdx = high;
  /*Pivot will be placed at this index such that all elements
  to right of it are greater than pivot and all elements to
  the left of it are smaller than pivot*/
  int partitionIdx = low;
  while (left < high)
  {
    /*Initially our partition index is set to leftmost element
    index in the input array. We keep traversing towards right
    of the input array and if we find an element lesser than
    pivot, we swap it with element at partiotion index and
    increment partition index else just keep moving right*/
    if (a[left] < pivot)
    {
      int tmp = a[left];
      a[left] = a[partitionIdx];
      a[partitionIdx] = tmp;
      ++partitionIdx;
    }
    ++left;
  }
  /*Place the pivot value at the partition index*/
  a[pivotIdx] = a[partitionIdx];
  a[partitionIdx] = pivot;
  return partitionIdx;
}

/*quick sort - sorts data in ascending order
For an array of size N, initial call should be
made with low 0 and high as N-1*/
void q_sort(int* a, int low, int high)
{
  if (low < high)
  {
    int k = partition(a, low, high);
    print(a);
    /*Sort all elements to the left of 'k'*/
    q_sort(a, low, k - 1);
    /*Sort all elements to the right of 'k'*/
    q_sort(a, k + 1, high);
  }
  return;
}

//int main()
//{
//  cin >> n;
//
//  int* ar = new int[n];
//
//  for (int i = 0; i < n; i++)
//  {
//    cin >> ar[i];
//  }
//
//  q_sort(ar, 0, n - 1);
//
//  return 0;
//}




int main()
{

  int ar[] = { 1, 3, 9, 8, 2, 7, 5};
  n = sizeof(ar) / sizeof(int);
                      //
  q_sort(ar, 0, n - 1);


  system("pause");
  return 0;
}
