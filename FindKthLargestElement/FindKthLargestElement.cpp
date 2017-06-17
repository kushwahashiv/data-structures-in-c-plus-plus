/*
Prolem:
Find kth largest element in an array of n elements where k > 0 and k < n

http://www.crazyforcode.com/kth-largest-smallest-element-array/

http://gsamaras.wordpress.com/code/find-k-highest-elements-in-array-of-n-size-cc/


Method 4 (Using min heap)

This method is modification and optimization of method 2.
1) Build a Min Heap of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of min heap.
If the element is greater than the root then make it root and call heapify for min heap.
else ignore it. The step 2 is O((n-k)*logk)
3) Finally, min heap has k largest elements and root of the min heap is the kth largest element.

Time Complexity: O(k + (n-k)Logk) without sorted output. If sorted output is needed then O(k + (n-k)Logk + kLogk)

All of the above methods can be used to find the kth largest (or smallest) element.

Implementation of min heap method:


*/

#include<iostream>


void swap(int *a, int *b)
{
    * a = *a + *b;
    * b = *a - *b;
    * a = *a - *b;
}

void minHeapify(int a[], int size, int i)
{
    int l = 2 * i;
    int r = 2 * i + 1;
    int smallest = i;
    if (l < size && a[l] < a[smallest])
    {
      smallest = l;
    }

    if (r < size && a[r] < a[smallest])
    {
      smallest = r;
    }

    if (smallest != i)
    {
        swap(&a[i], &a[smallest]);
        minHeapify(a, size, smallest);
    }
}


void buildMinHeap(int a[], int size) 
{
  for (int i = size / 2; i >= 0; i--)
  {
    minHeapify(a, size, i);
  }
}

int kthLargest(int a[], int size, int k)
{
  int* minHeap = new int[k];
    //int minHeap[k];

    int i;
    for (i = 0; i < k; i++)
    {
      minHeap[i] = a[i];
    }

    buildMinHeap(minHeap, k);
    
    for (i = k; i<size; i++)
    {
        if (a[i]>minHeap[0])
        {
            minHeap[0] = a[i];
            minHeapify(minHeap, k, 0);
        }
    }
    return minHeap[0];
}

int main() 
{
    int a[] = { 16, 17, 18, 4, 12, 9, 5, 1 };
    int size = sizeof(a) / sizeof(a[0]);
    int k = 3;
    std::cout << k << " largest element is :" << kthLargest(a, size, k) <<std::endl;

    system("pause");
    return 0;
}




/*
#include <conio.h>
#include <time.h>
#include <iostream>

using namespace std;
void Input_Array(int a[], int n)
{
  srand(time_t(nullptr));
  for (int i = 0; i < n; i++)
  {
    a[i] = rand() % 90;
  }
}

void Print_Array(int a[], int n)
{
  for (int i = 0; i < n; i++)
  {
    cout << "   " << a[i];
  }
}

void Swap(int &x, int &y)
{
  int temp = x;
  x = y;
  y = temp;
}

int Search_Print_k(int a[], int n, int k)
{
  if (k <= n && k>0)
  {
    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if (a[i] > a[j])
        {
          swap(a[i], a[j]);
        }
      }
      cout << "   " << a[i];
    }

    if (a[k])
    {
      return a[k];
    }
  }
}

int main()
{
  int a[100], n, k;
  cout << "\nInput the number of array element : ";
  cin >> n;
  Input_Array(a, n);
  Print_Array(a, n);

  cout << "\nInput k :";
  cin >> k;
  cout << "\nElement largest " << k << " is : " << Search_Print_k(a, n, k) <<std::endl;

  system("pause");
  return 0;
}

*/