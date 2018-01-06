# 1. 1stRepeatingNumber
First repeating number in array

http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/

Traverse the array once. While traversing, keep track of count of all elements in the array using a temp array count[] of size n,
when you see an element whose count is already set, print it as duplicate.

This method uses the range given in the question to restrict the size of count[],
but doesn't use the data that there are only two repeating elements.


```cpp
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
  //printRepeating(arr, arr_size);

  system("pause");

  return 0;
}
```


# BitCount

> Complete the BitCount function below.  The result from the function should equal the number of bits that are set. For example if 0101 1111 is passed in, the return value = 6       

```cpp
//#include <tchar.h>
#include <iostream>

int BitCount(unsigned char uc);

int _tmain(int argc, wchar_t* argv[])
{
	unsigned char uc = 0x82;
	
	int iResult = 0;
	iResult = BitCount(uc);
	std::cout << "Bit Count = " << iResult << std::endl;
	
	return 0;
}

int BitCount(unsigned char uc)
{
	int n = 0;

	while (uc) 
	{
		++n;
		uc &= uc - 1;
	}
	
	return n;
}

```

# ClosestNumber

```cpp
#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;

std::vector<std::pair<int, int>> find_min_abs_diff(std::vector<int>& arr) {
  // Sort the vector O(nlogn)
  std::sort(arr.begin(), arr.end());

  // Find the difference between every adjacent elements. O(n)
  // Keep track of minimum
  int min_so_far = std::numeric_limits<int>::max();
  std::vector<std::pair<int, int>> pairs;

  for (size_t i = 1; i < arr.size(); i++) {
    int diff = std::abs(arr[i] - arr[i - 1]);
    if (diff <= min_so_far) {
      min_so_far = diff;
      pairs.emplace_back(arr[i], arr[i - 1]);
    }
  }

  // Remove elements that are greater than the minimum found.
  pairs.erase(std::remove_if(pairs.begin(), pairs.end(),
    [&](const std::pair<int, int>& p) {
    return p.first - p.second > min_so_far;
  }), pairs.end());

  return pairs;
}


int main() {
  std::vector<int> arr{ -20, -3916237, -357920, -3620601, 7374819, -7330761,
    30, 6246457, -6461594, 266854, -520, -470 };
  std::vector<std::pair<int, int>> min_pairs = find_min_abs_diff(arr);
  
  for (const auto& item : min_pairs)
  {
    cout << item.second << " " << item.first << " ";
  }

  system("pause");
}



/*
std::vector<std::pair<int, int>> ClosestNumber(vector<int> a){
  int closest(a[0]);
  int diff = 0;
  bool initial = false;
  std::vector<std::pair<int, int>> closestPairs;

  for (unsigned int i = 0; i < a.size(); ++i)
  {
    for (unsigned int j = i + 1; j < a.size(); ++j)
    {
      //int difference = abs(a[i] - a[j]);
      int difference = abs(closest - a[j]);


      if (closest == difference)
      {
        closestPairs.push_back(std::make_pair(a[i], a[j]));
      }
      else if (closest > difference)
      {
        closest = difference;
        closestPairs.clear();
        closestPairs.push_back(std::make_pair(a[i], a[j]));
      }
      else if (!initial)
      {
        closest = difference;
        initial = true;
      }
    }
  }

  return closestPairs;
}


int main() {

  vector<int> dataArray = { -20, - 3916237, - 357920, - 3620601, 7374819, - 7330761, 30, 6246457, - 6461594, 266854, - 520, - 470 };
  auto res = ClosestNumber(dataArray);
  for (auto& item : res)
  {
    cout << item.first << " " << item.second << " ";
  }

  system("pause");

  return 0;
}
*/

```


# Combinations

```cpp
#include<iostream>
#include<ctime>
#include<cmath>

int n; // input array length
int p; // variable to store choose 'k' for the sake of printing
int count; // variable to store number of permutations/combinations

//print
int visit(int A[], int p)
{
  for (int i = 1; i <= p; i++)
  {
    std::cout << A[i] << " ";
  }
  std::cout << std::endl;

  count++;
  return 0;
}

/*
Function to generate combinations for a set of input. (Uses recursion calls)
Pre condition: Some location of A has already been taken by i+1 to n elements
Post condition: Selects k objects from i to i and assigns to the combination
*/
int combination(int A[], int i, int k)
{
  if (k == 0)
  {
    visit(A, p);
  }
  else if (i < k)
  {
    return 0;
  }
  else 
  {
    A[k] = i;
    combination(A, i - 1, k - 1);
    A[k] = 0;
    combination(A, i - 1, k);
  }
    
    //erro has been fixed below
    return 0;
}

//Function to generate the permutations of A - Does so in lexicographic order
void permutation(int A[], int i, int k)
{
  int j = n - 1;
  int l = n;
  if (p > 0 && p != n - 1)
  {
    visit(A, p);
  }

  do 
  {
    if (j == 0) 
      break;
    if (j <= p)
    {
      visit(A, p);
    }

    l = n - 1;
    j = n - 2;
    while ((A[j] >= A[j + 1]) && j > 0)
    {
      j--;
    }
    while ((A[j] >= A[l]) && l > 0)
    {
      l--;
    }

    int temp;
    temp = A[j];
    A[j] = A[l];
    A[l] = temp;

    int k = j + 1;
    l = n - 1;

    while (k < l && l>0) 
    {
      temp = A[k];
      A[k] = A[l];
      A[l] = temp;

      k++;
      l--;
    }

  } while (1);


}

enum Type
{
  CMOBINATION = 0,
  PERMUTATION
} ;


int main()
{
  clock_t start, end;
  int dur = 0;

  start = clock();

  n = 0;
  count = 0;
  int k = 0;

  //n choose r i.e. nCr

  n = 9;  //Combination from 1-9 digits
  k = 3;  //Combinations of 3 digits

  p = k;

  Type v = Type::CMOBINATION; //default calculate combination

  switch (v)
  {
  case Type::CMOBINATION: // Combination
  {
    if (k != 0)
    {
      int* A = new int(n);
      for (int i = 0; i < n; i++)
      {
        A[i] = 0;
      }
      combination(A, n, k);
    }
  }
  break;
  case Type::PERMUTATION: // permutation
  {
    n++;
    int * A = new int(n); //extra memory for the sentinel to be placed first
    for (int i = 1; i < n; i++)
    {
      A[i] = i;
    }
    A[0] = 0;
    permutation(A, n, k);
  }
  break;

  default:
    break;

  }

  end = clock();

  dur = (int)round((double)(end - start) / CLOCKS_PER_SEC * 1000);
  std::cout << count << " " << dur << std::endl;

  std::system("pause");

  return 0;
}

```

# ConvergentOfe

> The numerator follows a predictable pattern (sequence) and we are exploiting that to solve this problem.
> There is a multiplier, m, that follows the sequence (2,1,1), (4,1,1), (6,1,1), (8,1,1), '
> starting with the third term and the numerator follows (1, 2, 3, 8, 11, 19, 87, '):
>
>n_i = m_i * n_{i-1} + n_{i-2}, where:n_0=1  and n_1=2

```cpp
#include<iostream>
#include<vector>

auto ExponentialConvergent(int s)-> int
{
  int d = 1, n = 2;

  for (int i = 2; i <= s; i++)
  {
    int temp = d;
    int c = (i % 3) ? 1 : 2 * (i / 3);
    d = n;
    n = c*d + temp;
  }

  //digit sum
  int sum(0);
  while (n != 0)
  {
    sum += n % 10;
    n = n / 10;
  }

  return sum;
}


auto main() ->int
{
  int n;
  std::cin >> n;
  int x = ExponentialConvergent(n);
  std::cout << x;

  return 0;
}
```

# DetectLoopInList

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

A variation of this solution that doesn't require modification to basic data structure can be
implemented using hash.  Just store the addresses of visited nodes in a hash and if you see an 
address that already exists in hash then there is a loop.


//Implementation of Floyd's Cycle - Finding Algorithm :
//Time Complexity : O(n)
//Auxiliary Space : O(1)

```
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

```

# DetectNRemoveLoopInList

Problem:
detect and remove loop in a list

http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

(Efficient Solution)
This method is also dependent on Floyd's Cycle detection algorithm.
1) Detect Loop using Floyd's Cycle detection algo and get the pointer to a loop node.
2) Count the number of nodes in loop.Let the count be k.
3) Fix one pointer to the head and another to kth node from head.
4) Move both pointers at the same pace, they will meet at loop starting node.
5) Get pointer to the last node of loop and make next of it as nullptr.

```
#include<stdio.h>
#include<stdlib.h>

//Link list node
struct node
{
  int data;
  struct node* next;
};

//Function to remove loop.
void removeLoop(struct node *, struct node *);

//This function detects and removes loop in the list
//If loop was there in the list then it returns 1,
//otherwise returns 0
int detectAndRemoveLoop(struct node *list)
{
  struct node  *slow_p = list, *fast_p = list;

  while (slow_p && fast_p && fast_p->next)
  {
    slow_p = slow_p->next;
    fast_p = fast_p->next->next;

    //If slow_p and fast_p meet at some point then there is a loop
    if (slow_p == fast_p)
    {
      removeLoop(slow_p, list);

      //Return 1 to indicate that loop is found
      return 1;
    }
  }

  //Return 0 to indeciate that ther is no loop*/
  return 0;
}

//Function to remove loop.
//loop_node --> Pointer to one of the loop nodes
//head -->  Pointer to the start node of the linked list
void removeLoop(struct node *loop_node, struct node *head)
{
  struct node *ptr1 = loop_node;
  struct node *ptr2 = loop_node;

  // Count the number of nodes in loop
  unsigned int k = 1, i;
  while (ptr1->next != ptr2)
  {
    ptr1 = ptr1->next;
    k++;
  }

  // Fix one pointer to head
  ptr1 = head;

  // And the other pointer to k nodes after head
  ptr2 = head;
  for (i = 0; i < k; i++)
    ptr2 = ptr2->next;

  // Move both pointers at the same pace, they will meet at loop starting node
  while (ptr2 != ptr1)
  {
    ptr1 = ptr1->next;
    ptr2 = ptr2->next;
  }

  // Get pointer to the last node
  ptr2 = ptr2->next;
  while (ptr2->next != ptr1)
    ptr2 = ptr2->next;

  //Set the next node of the loop ending node to fix the loop
  ptr2->next = nullptr;
}

//UTILITY FUNCTIONS
//Given a reference (pointer to pointer) to the head
//of a list and an int, pushes a new node on the front
//of the list.
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

//Function to print linked list
void printList(struct node *node)
{
  while (node != nullptr)
  {
    printf("%d  ", node->data);
    node = node->next;
  }
}

//Drier program to test above function
int main()
{
  //Start with the empty list
  struct node* head = nullptr;

  push(&head, 10);
  push(&head, 4);
  push(&head, 15);
  push(&head, 20);
  push(&head, 50);

  //Create a loop for testing
  head->next->next->next->next->next = head->next->next;

  detectAndRemoveLoop(head);

  printf("Linked List after removing loop \n");
  printList(head);

  getchar();
  return 0;
}

```


# DFS

```cpp
#include<iostream>
#include <list>

using namespace std;

// Graph class represents a directed graph using adjacency list representation
class Graph
{
  int V;    // No. of vertices
  list<int> *adj;    // Pointer to an array containing adjacency lists
  void DFSUtil(int v, bool visited[]);  // A function used by DFS
public:
  Graph(int V);   // Constructor
  void addEdge(int v, int w);   // function to add an edge to graph
  void DFS(int v);    // DFS traversal of the vertices reachable from v
};

Graph::Graph(int V)
{
  this->V = V;
  adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
  adj[v].push_back(w); // Add w to v's list.
}

void Graph::DFSUtil(int v, bool visited[])
{
  // Mark the current node as visited and print it
  visited[v] = true;
  cout << v << " ";

  // Recur for all the vertices adjacent to this vertex
  list<int>::iterator i;
  for (i = adj[v].begin(); i != adj[v].end(); ++i)
  {
    if (!visited[*i])
    {
      DFSUtil(*i, visited);
    }
  }
}

// DFS traversal of the vertices reachable from v. It uses recursive DFSUtil()
void Graph::DFS(int v)
{
  // Mark all the vertices as not visited
  bool *visited = new bool[V];
  for (int i = 0; i < V; i++)
  {
    visited[i] = false;
  }

  // Call the recursive helper function to print DFS traversal
  DFSUtil(v, visited);
}

int main()
{
  // Create a graph given in the above diagram
  Graph g(4);
  g.addEdge(0, 1);
  g.addEdge(0, 2);
  g.addEdge(1, 2);
  g.addEdge(2, 0);
  g.addEdge(2, 3);
  g.addEdge(3, 3);

  cout << "Following is Depth First Traversal (starting from vertex 2) \n";
  g.DFS(2);

  return 0;
}
```

# EvenTree

Problem Statement
You are given a tree (a simple connected graph with no cycles).
You have to remove as many edges from the tree as possible to obtain a forest with the condition that
: Each connected component of the forest should contain an even number of vertices.

Your task is to calculate the number of removed edges in such a forest.
Input Format The first line of input contains two integers N and M. N is the number of vertices
and M is the number of edges. The next M lines contain two integers ui and vi which specifies an edge of the tree.
(1-based index)
Output Format Print the answer, a single integer.

Constraints 2 <= N <= 100.

Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

Sample Input
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
Sample Output
2
Explanation On removing the edges (1, 3) and (1, 6), we can get the desired result.

```cpp
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
  vector<int> u, v, n;
  int N, M, i, num = 0, a, b;
  cin >> N >> M;
  for (i = 0; i<M; i++)
  {
    cin >> a >> b;
    u.push_back(a);
    v.push_back(b);
  }


  n = vector<int>(N + 1, 1);
  for (i = 0; i<M; i++)
  {
    n[v[i]]++;
  }

  for (i = N; i > 1; i--)
  {
    if (n[i] % 2 == 0)
    {
      num++;
      for (int j = 0; j < M; j++)
      {
        if (u[j] == i)
          n[v[j]]--;
      }
    }
  }
  cout << num;

  return 0;
}

```

# Find1stMissingNumber
Problem:
Find the Missing Number

http://www.geeksforgeeks.org/find-the-missing-number/

You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

Example:
I/P    [1, 2, 4, ,6, 3, 7, 8]
O/P    5


METHOD 1(Use sum formula)
Algorithm:

1. Get the sum of numbers
total = n*(n+1)/2
2  Subtract all the numbers from sum and
you will get the missing number.
*/

//Time Complexity : O(n)

```cpp
#include<iostream>

//getMissingNo takes array and size of array as arguments
int getMissingNo(int a[], int n)
{
  int i, total;

  total = (n + 1)*(n + 2) / 2;

  for (i = 0; i < n; i++)
  {
    total -= a[i];
  }
  return total;
}

//program to test above function
int main()
{
  int a[] = { 1, 2, 4, 5, 6 };
  int miss = getMissingNo(a, 5);
  std::cout<< miss;
  

  system("pause");
}

```


## METHOD 2(Use XOR)

1) XOR all the array elements, let the result of XOR be X1.
2) XOR all numbers from 1 to n, let XOR be X2.
3) XOR of X1 and X2 gives the missing number.

```cpp
#include<stdio.h>

//getMissingNo takes array and size of array as arguments
int getMissingNo(int a[], int n)
{
  int i;
  int x1 = a[0]; //For xor of all the elemets in arary
  int x2 = 1; //For xor of all the elemets from 1 to n+1

  for (i = 1; i< n; i++)
    x1 = x1^a[i];

  for (i = 2; i <= n + 1; i++)
    x2 = x2^i;

  return (x1^x2);
}

//program to test above function
int main()
{
  int a[] = { 1, 2, 4, 5, 6 };
  int miss = getMissingNo(a, 5);
  printf("%d", miss);
  getchar();
}


*/

```

# FindCommonLettersIn2Strings

Problm:
program to take 2 sentences/string and find common letters

```cpp
#include <iostream>
#include <string>
#include <set>
#include <algorithm>
#include <iterator>
#include <vector>

std::set<char> FindSharedLetters(const std::string &s1, const std::string &s2)
{

  std::set<char> st1(s1.begin(), s1.end());
  std::set<char> st2(s2.begin(), s2.end());

  /* 
  //Case sensitive implementation
  //Comment above two lines

  std::set<char> st1;
  std::set<char> st2;

  for (char c : s1)
  {
    if (std::isalpha(c)) st1.emplace(std::toupper(c));
  }

  for (char c : s2)
  {
    if (std::isalpha(c)) st2.emplace(std::toupper(c));
  }
  */

  std::set<char> st0;

  std::set_intersection(st1.begin(), 
                        st1.end(),
                        st2.begin(), 
                        st2.end(),
                        std::inserter(st0, st0.end()));

  return st0;
}

int main()
{
  std::string s1("DCABD");
  std::string s2("FRDCACD");

  for (char c : FindSharedLetters(s1, s2))
  { 
    std::cout << c << ' ';
  }

  std::cout << std::endl;

  system("pause");

  return 0;
}


//int main()
//{
//  std::vector<std::string> a;
//  int number;
//  std::cin >> number;
//  for (unsigned int i = 0; i < 2 * number; i++)
//  {
//    std::string word;
//    //std::getline(std::cin, word);
//    std::cin >> word;
//    a.push_back(word);
//  }
//
//  for (unsigned int i = 0; i < number; i++)
//  {
//    auto b = FindSharedLetters(a[i], a[i + 1]);
//    if (b.size() > 0)
//      std::cout << "YES" << std::endl;
//    else
//      std::cout << "NO" << std::endl;
//
//  }
//  return 0;
//}

```

# FindDigits

Problem Statement

You are given a number N. Find the digits in this number that exactly divide N and display their count. 
For N = 24, there are 2 digits - 2 & 4. Both these digits exactly divide 24. So our answer is 2.
Note
If the same number is repeated twice at different positions, it should be counted twice, e.g., For N=122, 
2 divides 122 exactly and occurs at ones' and tens' position. So it should be counted twice. So for this case, our answer is 3.
Division by 0 is undefined.

Input Format
The first line contains T (number of test cases) followed by T lines (each containing an integer N).
Constraints
1 <=T <= 15
0 < N < 1010

Output Format

For each test case, display the count of digits in N that exactly divide N in separate line.

```cpp
#include<iostream>
#include<vector>
using namespace std;

auto FindDivisors(int N) -> int
{

  int n = N;
  int count(0);

  while (n !=0)
  {
    int digit = n % 10;
    if( digit != 0 && N%digit == 0)
        count++;

    n /= 10;
  }
  return count;
}


int main()
{
  std::vector<int> numbers;

  int t;
  cin >> t;

  for (int i = 0; i < t; i++)
  {
    int n;
    cin >> n;
    numbers.push_back(n);
  }

  for (auto i : numbers)
  {
    cout << FindDivisors(i)<<std::endl;
  }

  system("pause");

  return 0;
}
```

# FindKthLargestElement
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

```cpp
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

```

# FindNthFibonacciNumberRecursively

Problem:
Find nth Fibonacci number using recursive templates

```cpp
#include <iostream>

template< unsigned N >
struct FIB
{
  enum { RESULT = FIB<N - 1>::RESULT + FIB<N - 2>::RESULT };
};

template<>
struct FIB<0> 
{
  enum { RESULT = 0 };
};

template<>
struct FIB<1>
{
  enum { RESULT = 1 };
};

int main()
{
  std::cout << "FIB(10): " << FIB<22>::RESULT << std::endl;

  system("pause");
  return EXIT_SUCCESS;
}
```

# FirstUniqueElementInArray

Problem:
Implement an algorithm that takes an input array and returns only the unique elements in it.

Hints:
If the array is sorted you do not need hashmaps to achieve O(n). 
If you have a random/unsorted array you can use hashmaps to achieve the purpose,
Note that sorting requires O(n log(n)).

Point of interest: the first pass works because the values inside the unordered map (= hash map) are initialised with the default value, 0. 
We are using this fact to increment the values directly without bothering to check whether the value existed in the map beforehand. 
This makes the code more concise and is actually also more efficient.

read more about std::unordered_map:
http://www.cplusplus.com/reference/unordered_map/unordered_map/

```cpp
#include <iostream>
#include <unordered_map>
#include <vector>

int main() {
  std::unordered_map<int, unsigned> occurrences;

  int a[8] = { 1, 1, 1, 2, 2, 3, 3, 5};
  unsigned const size = sizeof a / sizeof a[0];

  // First pass: count occurrences.
  for (unsigned i = 0; i < size; ++i)
  {
    ++occurrences[a[i]];
  }


  // Second pass: search singleton.
  for (unsigned i = 0; i < size; ++i)
  {
    if (occurrences[a[i]] == 1)
    {
      std::cout << a[i] << " only occurred once." << std::endl;
    }
  }

  system("pause");

  return 0;
}
```

# HashExamples

http://en.cppreference.com/w/cpp/utility/hash
C++11 and C++14 samples

Demonstrates creation of a hash function for a user defined type.
Using this as a template parameter for std::unordered_map, std::unordered_set, etc. also requires specialization of std::equal_to.

```cpp
#include <iostream>
#include <functional>
#include <string>


struct S
{
  std::string first_name;
  std::string last_name;
};

template <class T> class MyHash;

template<>
class MyHash < S >
{
public:
  std::size_t operator()(S const& s) const
  {
    std::size_t h1 = std::hash<std::string>()(s.first_name);
    std::size_t h2 = std::hash<std::string>()(s.last_name);
    return h1 ^ (h2 << 1);
  }
};

int main()
{
  std::string s1 = "Hubert";
  std::string s2 = "Farnsworth";
  std::hash<std::string> h1;

  S n1;
  n1.first_name = s1;
  n1.last_name = s2;

  std::cout << "hash(s1) = " << h1(s1) << "\n"
    << "hash(s2) = " << std::hash<std::string>()(s2) << "\n"
    << "hash(n1) = " << MyHash<S>()(n1) << "\n";

  system("pause");
}

```

# InsertNode
- Implement the Insert function below such that it inserts the
- given node either immediately before the node at the given index
- or at the end of the list if the index is beyond the end of the list.
- For example, if the list contains 4,8,15,16,23, and 42,
- and Insert is called with a node with value 34 and offset 2, the
- modified list would contain 4,8,34,15,16,23, and 42.

```cpp
//#include <tchar.h>
#include <assert.h>

struct Node
{
  int num;
  Node* next;
};

void Insert(Node** apList, Node* apNode, int aIndex);

int _tmain(int argc, wchar_t* argv[])
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

```

# IntersectingNodeofYShapedLinkedList

Problem:
Intersecting node of a Y shaped linked list


```cpp
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
```

# K-1FriendsBuyNFlowers

Problem Statement

You and your K-1 friends want to buy N flowers. Flower number i has cost ci. 
Unfortunately the seller does not want just one customer to buy a lot of flowers,
so he tries to change the price of flowers for customers who have already bought some flowers.
More precisely, if a customer has already bought x flowers, he should pay (x+1)*ci dollars to buy flower number i.

You and your K-1 friends want to buy all N flowers in such a way that you spend the least amount of money.
You can buy the flowers in any order.

Input:

The first line of input contains two integers N and K (K <= N). The next line contains N space separated positive integers c1,c2,...,cN.

Output:

Print the minimum amount of money you (and your friends) have to pay in order to buy all N flowers.

Constraint :

1 <= N, K <= 100
Any ci is not more than 1,000,000

Sample input #00

3 3
2 5 6
Sample output #00

13

```cpp
#include <iostream>  
#include <vector>  
#include <algorithm>  
#include <functional>

using namespace std;

int main()
{
  int N; // num of flowers  
  int K; // num of people  
  vector<int> c; // price of each flower  
  vector<int> num_bought; // num of flowers each person bought  
  int money = 0; // min money to pay (output)  
  int i;

  // initialize problem  
  cin >> N >> K;

  c = vector<int>(N, 0); // N flowers  
  for (i = 0; i < N; i++)
    cin >> c[i];

  // body  
  num_bought = vector<int>(K, 0); // K people  

  sort(c.begin(), c.end(), std::greater<int>()); // sort from high to low  

  for (i = 0; i < N; i++) {
    money += (num_bought[i%K] + 1) * c[i];
    num_bought[i%K]++;
  }

  // print output  
  cout << money << endl;

  return 0;
}



/*
using System;
using System.Collections.Generic;
using System.IO;
class Solution
{
  static void Main(String[] args)
  {
    int N, K;
    string NK = Console.ReadLine();
    string[] NandK = NK.Split(new Char[] { ' ', 't', 'n' });
    N = Convert.ToInt32(NandK[0]);
    K = Convert.ToInt32(NandK[1]);

    string[] numbers = Console.ReadLine().Split(' ');
    List<int> number = new List<int>();
    for (int i = 0; i < numbers.Length; i++)
      number.Add(int.Parse(numbers[i]));
    int[] temp = number.ToArray();
    Array.Sort(temp);
    
    number.Clear();
    for (int i = 0; i < temp.Length; i++)
      number.Add(temp[i]);
    int[] friends = new int[K];
    int x = 0;
    int result = 0;
    while (number.Count > 0)
    {
      result += (friends[x] + 1) * number[number.Count - 1];
      number.RemoveAt(number.Count - 1);
      friends[x]++;
      x++;
      if (x == K)
        x = 0;
    }
    Console.WriteLine(result);
  }
}

*/
```

# KValueNodePairSearch

Poblem:
Given a BinarySearchTree and value K, find all value pairs whose sum is K in O(n).
or
Given a binary search tree of n nodes, find two nodes whose sum is equal to a given number k in O(n) time and constant space O(logn) 

```cpp
#include <iostream>

typedef struct Node
{
  int data;
  struct Node* parent;
  struct Node* left;
  struct Node* right;
} TreeNode;

void insert_into_BST(TreeNode** root, int data)
{
  if (*root == nullptr) 
  {
    *root = new TreeNode();//calloc(1, sizeof(TreeNode));
    (*root)->data = data;
  }
  else {
    TreeNode* trav = *root;
    TreeNode* newNode = new TreeNode(); // (1, sizeof(TreeNode));
    newNode->data = data;
    while (trav != nullptr) {
      if (data < trav->data) {
        if (trav->left == nullptr) {
          newNode->parent = trav;
          trav->left = newNode;
          break;
        }
        trav = trav->left;
      }
      else {
        if (trav->right == nullptr) {
          newNode->parent = trav;
          trav->right = newNode;
          break;
        }
        trav = trav->right;
      }
    }
  }
}

void insert_array_into_BST(TreeNode** root, int* array, int count) {
  int ii = 0;
  for (; ii < count; ii++) {
    insert_into_BST(root, array[ii]);
  }
}

void delete_tree(TreeNode* root) {
  if (root == nullptr)
    return;
  delete_tree(root->left);
  delete_tree(root->right);
  delete root;
}

TreeNode* find_smallest(TreeNode* root) {
  while (root->left) {
    root = root->left;
  }
  return root;
}

TreeNode* find_largest(TreeNode* root) {
  while (root->right) {
    root = root->right;
  }
  return root;
}

TreeNode* find_predecessor(TreeNode* root) {
  if (root->left) {
    root = root->left;
    while (root->right) {
      root = root->right;
    }
    return root;
  }
  else if (root == root->parent->right) {
    return root->parent;
  }
  else {
    while (root == root->parent->left)
      root = root->parent;
    return root->parent;
  }

  return nullptr;
}

TreeNode* find_successor(TreeNode* root) {
  if (root->right) {
    root = root->right;
    while (root->left) {
      root = root->left;
    }
    return root;
  }
  else if (root == root->parent->left) {
    return root->parent;
  }
  else {
    while (root == root->parent->right)
      root = root->parent;
    return root->parent;
  }

  return nullptr;
}

void print_pairs_with_sum(TreeNode* root, int sum) 
{
  TreeNode* smallest = find_smallest(root);
  TreeNode* largest = find_largest(root);

  if (smallest->data + find_successor(smallest)->data > sum || largest->data + find_predecessor(largest)->data < sum) 
  {
    std::cout << "No elements found..." << std::endl;
  }

  while (smallest->data < largest->data) 
  {
    if (sum == (smallest->data + largest->data)) 
    {
      std::cout<< "Sum of node("<< sum<< ") = "<< smallest->data << " and " << largest->data<< std::endl;
    }
    smallest = find_successor(smallest);

    while (smallest->data + largest->data > sum) 
    {
      largest = find_predecessor(largest);
    }
  }

}

int main()
{
  TreeNode* root(nullptr);
  int array[11] = { 10, 7, 3, 8, 1, 4, 12, 11, 16, 14, 19 };
  insert_array_into_BST(&root, array, 11);
  print_pairs_with_sum(root, 16);
  delete_tree(root);

  system("pause");
  return 0;
}

```


# LongestCommonSequence

A subsequence is a sequence that can be derived from another sequence by deleting some elements
without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences 
is a subsequence, with maximal length, which is common to both the sequences.

Given two sequence of integers, A=[a1,a2,',an] and B=[b1,b2,',bm], find any one longest common subsequence.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.

```cpp
#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

const int LEFT = -1, UP = -2, ADD = -3;

class data
{
private:
  vector<int> S1;
  vector<int> S2;
  std::vector<std::vector<int>> LCS;
  std::vector<std::vector<int>> ptrs;

public:
  data(vector<int>a, vector<int>b);
  void calc_longest_common_subsequence();
  vector<int> get_longest_common_subsequence();
  int longest_common_subsequence();
};

data::data(vector<int>a, vector<int>b)
{
  S1 = a;
  S2 = b;

  std::vector<std::vector<int>> lcs(a.size() + 1, std::vector<int>(b.size() + 1));
  std::vector<std::vector<int>> ptr(a.size() + 1, std::vector<int>(b.size() + 1));

  for (unsigned int i = 0; i <= a.size(); i++)
  {
    lcs[i][0] = 0;
    ptr[i][0] = UP;
  }

  for (unsigned int i = 0; i <= b.size(); i++)
  {
    lcs[0][i] = 0;
    ptr[0][i] = LEFT;
  }

  LCS = lcs;
  ptrs = ptr;
}

void data::calc_longest_common_subsequence()
{
  longest_common_subsequence();

  vector <int> lcs = get_longest_common_subsequence();
  reverse(lcs.begin(), lcs.end());

  for (auto i : lcs)
    cout << i << " ";
}

vector <int> data::get_longest_common_subsequence()
{
  vector <int> lcs;
  int i = S1.size(), j = S2.size();

  while (i != 0 && j != 0)
  {
    if (ptrs[i][j] == ADD)
    {
      lcs.push_back(S1[i - 1]);
      i--;
      j--;
    }
    else if (ptrs[i][j] == UP)
      i--;
    else
      j--;
  }

  return lcs;
}

int data::longest_common_subsequence()
{
  int max_length = -1;

  for (unsigned int i = 1; i <= S1.size(); i++)
  {
    for (unsigned int j = 1; j <= S2.size(); j++)
    {
      if (S1[i - 1] == S2[j - 1])
      {
        LCS[i][j] = LCS[i - 1][j - 1] + 1;
        ptrs[i][j] = ADD;
      }
      else if (LCS[i - 1][j] > LCS[i][j - 1])
      {
        LCS[i][j] = LCS[i - 1][j];
        ptrs[i][j] = UP;
      }
      else
      {
        LCS[i][j] = LCS[i][j - 1];
        ptrs[i][j] = LEFT;
      }
      max_length = max(max_length, LCS[i][j]);
    }
  }

  return max_length;
}

int main()
{
  vector<int> x = { 1, 2, 3, 4, 1 };
  vector<int> y = { 3, 4, 1, 2, 1, 3 };

  data myData(x, y);
  myData.calc_longest_common_subsequence();

  system("pause");

  return 0;
}


/*
#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

//const int N = 5, M = 6;
const int LEFT = -1, UP = -2, ADD = -3;

class data
{
private:
vector<int> S1;
vector<int> S2;
std::vector<std::vector<int>> LCS;
std::vector<std::vector<int>> ptrs;

public:
data(vector<int>a, vector<int>b);
void calc_longest_common_subsequence();
vector<int> get_longest_common_subsequence();
int longest_common_subsequence();
void print_sequences();
};

data::data(vector<int>a, vector<int>b)
{
S1 = a;
S2 = b;

std::vector<std::vector<int>> lcs(a.size()+1, std::vector<int>(b.size()+1));
std::vector<std::vector<int>> ptr(a.size()+1, std::vector<int>(b.size()+1));

for(int i = 0; i <= a.size(); i++)
{
lcs[i][0] = 0;
ptr[i][0] = UP;

//LCS[i][0] = 0;
//ptrs[i][0] = UP;
}

for (int i = 0; i <= b.size(); i++)
{
lcs[0][i] = 0;
ptr[0][i] = LEFT;
}

LCS = lcs;
ptrs = ptr;
}

void data::calc_longest_common_subsequence()
{
cout << "The length of the longest common subsequence, S3, is " << longest_common_subsequence() << endl;

vector <int> lcs = get_longest_common_subsequence();
reverse(lcs.begin(), lcs.end());

cout << "One longest common subsequence is '";
for (auto i :lcs)
cout << i;
cout << "'" << endl;
}

vector <int> data::get_longest_common_subsequence()
{
vector <int> lcs;
int i = S1.size(), j = S2.size();

while (i != 0 && j != 0)
{
if (ptrs[i][j] == ADD)
{
lcs.push_back(S1[i - 1]);
i--;
j--;
}
else if (ptrs[i][j] == UP)
i--;
else
j--;
}

return lcs;
}

int data::longest_common_subsequence()
{
int max_length = -1;

for (int i = 1; i <= S1.size(); i++)
{
for (int j = 1; j <= S2.size(); j++)
{
if (S1[i - 1] == S2[j - 1])
{
LCS[i][j] = LCS[i - 1][j - 1] + 1;
ptrs[i][j] = ADD;
}
else if (LCS[i - 1][j] > LCS[i][j - 1])
{
LCS[i][j] = LCS[i - 1][j];
ptrs[i][j] = UP;
}
else
{
LCS[i][j] = LCS[i][j - 1];
ptrs[i][j] = LEFT;
}
max_length = max(max_length, LCS[i][j]);
}
}

return max_length;
}

void data::print_sequences()
{
cout << "The sequence, S1, is " << endl;
for (auto i : S1)
cout << i << ' ';
cout << endl;

cout << "The sequence, S2, is " << endl;
for (auto i : S2)
cout << i << ' ';
cout << endl;
}

int main()
{
int m = 5;
int n = 6;

vector<int> x = { 1, 2, 3, 4, 1 };
vector<int> y = { 3, 4, 1, 2, 1, 3 };

data myData(x, y);
myData.calc_longest_common_subsequence();

system("pause");

return 0;
}
*/

```

# MaximizingXOR

Problem Statement

Given two integers: L and R,
find the maximal values of A xor B given, L ≤ A ≤ B ≤ R

Input Format
The input contains two lines, L is present in the first line.
R in the second line.

Constraints
1 ≤ L ≤ R ≤ 103

Output Format
The maximal value as mentioned in the problem statement.

```cpp
#include<iostream>
using namespace std;

auto maxXor(int l, int r) -> int 
{

  int sum = 0;
  int pos = 1;

  while (l != r)
  {
    l /= 2;
    r /= 2;
    sum += pos;
    pos *= 2;
  }
  return sum;
}


int main()
{
  int res;
  int _l;
  cin >> _l;

  int _r;
  cin >> _r;

  res = maxXor(_l, _r);
  cout << res;

  system("pause");

  return 0;
}

```

# MergeSortedLinkedList

Problem:
Merge two sorted linked lists

http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/


Method 1 (Using Dummy Nodes)
The strategy here uses a temporary dummy node as the start of the result list. 
The pointer Tail always points to the last node in the result list, so appending new nodes is easy.
The dummy node gives tail something to point to initially when the result list is empty. This dummy 
node is efficient, since it is only temporary, and it is allocated in the stack. The loop proceeds,
removing one node from either 'a' or 'b', and adding it to tail. When
we are done, the result is in dummy.next

```cpp
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

```

# Palindromes

```cpp
#include <stdlib.h>
//#include <tchar.h>
#include <iostream>

#define Method 1

// Method 1 - Using Simple metod
//----------------------------------------------------------------------------
bool isPalindrome( char* pStr )
{
  if ( pStr == nullptr )
   return false;
 
  char* pEnd = pStr;
  while ( *pEnd != '\0' )
    pEnd++;
 
  pEnd--; /* set pEnd to point to last character*/
 
  while(pEnd > pStr)
  {
    if ( *pEnd != *pStr )
      return false;
 
    pEnd--; 
    pStr++;
  }
 
  return true;
}

// Method 2 - Using Alogorithm
//----------------------------------------------------------------------------
#include <string>
#include <algorithm>
 
bool is_palindrome(std::string const& s)
{
  return std::equal(s.begin(), s.end(), s.rbegin());
}


/*---------------------------------------------------------------------------*/
int _tmain(int argc, wchar_t* argv[])
{
  char szString[100] = "";
  std::cout << "Enter String: ";
  std::cin.getline(szString, sizeof(szString) - 1);

#if Method
  if(isPalindrome(szString))
#else
  if(is_palindrome(szString))
#endif
  {
    std::cout <<szString<<  "\nString is a palindrom."<< std::endl;
  }
  else
  {
    std::cout <<szString<<  "\nString is NOT a palindrom."<< std::endl;
  }

  system( "pause \"Press any key to continue...\"" );
  return 0;
}


```


# Parity

Complete the ParityCheck function below.  The result from the function 
should equal 1 if the parity is even, 0 if it is odd                       
For example if 0101 1111 is passed in, the return value = 1          

```cpp
#include <iostream>

unsigned char ParityCheck(unsigned char uc);

int _tmain(int argc, wchar_t* argv[])
{
	unsigned char uc = 0x5F;
	
	unsigned char aResult = 0;
	aResult = ParityCheck(uc);
	std::cout << "Even Parity = " << (aResult != 0) << std::endl;
	
	return 0;
}

unsigned char ParityCheck(unsigned char uc)
{
	int n = 0;

	while (uc) 
	{
		++n;
		uc &= uc - 1;
	}

	return n;
}


```

# Permutation

```cpp
#include <iostream>

void print(const int *v, const int size)
{
  if (v != 0) {
    for (int i = 0; i < size; i++) {
      printf("%4d", v[i]);
    }
    printf("\n");
  }
} // print


void permute(int *v, const int start, const int n)
{
  if (start == n - 1) 
  {
    print(v, n);
  }
  else 
  {
    for (int i = start; i < n; i++) 
    {
      int tmp = v[i];

      v[i] = v[start];
      v[start] = tmp;
      permute(v, start + 1, n);
      v[start] = v[i];
      v[i] = tmp;
    }
  }
}


int main()
{
  int v[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  permute(v, 0, sizeof(v) / sizeof(int));

  system("pause");
  return 0;
}

```

# PrintListReverse

Implement the PrintListReverse function below such that it prints the
numbers in the nodes of a singly-linked list from the back of the list
to the front.  For example, if the list contains 4,8,15,16,23, and 42,
the function will output:
42
23
16
15
8
4

```cpp
#include <iostream>

struct Node
{
  int num;
  Node* next;
};

void PrintListReverse(Node** list);

int _tmain(int argc, wchar_t* argv[])
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


```

# PrintStringReverse
Complete the PrintReverse function below using 
recursion. The function should print the characters
in the string in reverse order.         
For example, 'Hello' entered would output 'olleH'  

```cpp
#include <iostream>

void PrintReverse(const char* aString);

void reverse(char string[])
{
  char temp;
  char* begin = string;
  char* end = string + strlen(string) -1;
  while(begin < end)
  {
    temp = *begin;
    *begin = *end;
    *end = temp;

    ++begin;
    --end;
  }
  std::cout<<std::endl<< string<< std::endl;
}

int _tmain(int argc, wchar_t* argv[])
{
	char szString[100] = "";

	std::cout << "Enter String: ";

	std::cin.getline(szString, sizeof(szString) - 1);
		
	PrintReverse(szString);
  reverse(szString);

	return 0;
}

void PrintReverse(const char* aString)
{
	if(*aString != '\0' ) 
		PrintReverse(aString + 1);
	
	std::cout<<*aString;
}

```

# QueueByStack
Implement a Queue with Stacks.
or
Program to implement a queue using two stacks
Can implement it use template

```cpp
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

```

# QuickSortInPlace

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

```cpp
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

```


# RandonShuffleNumbers

Problem:
  Random shuffle the deck.
//1. Using STD random_reshuffle function

```cpp
#include <iostream>     // std::cout
#include <algorithm>    // std::random_shuffle
#include <vector>       // std::vector
#include <ctime>        // std::time
#include <cstdlib>      // std::rand, std::srand

// random generator function
int myrandom(int i) 
{ 
  return std::rand() % i; 
}

int main() 
{
  std::srand(unsigned(std::time(0)));
  std::vector<int> myvector;

  // set some values:
  for (int i = 1; i < 10; ++i)
  {
    myvector.push_back(i); // 1 2 3 4 5 6 7 8 9
  }

  // using built-in random generator:
  std::random_shuffle(myvector.begin(), myvector.end());

  // using myrandom:
  std::random_shuffle(myvector.begin(), myvector.end(), myrandom);

  // print out content:
  std::cout << "myvector contains:";
  for (std::vector<int>::iterator it = myvector.begin(); it != myvector.end(); ++it)
  {
    std::cout << ' ' << *it;
  }

  std::cout << '\n';

  system("Pause");

  return 0;
}


//Output using std::random_shuffle
//myvector contains: 5 8 9 6 4 7 1 2 3

//Output using myrandom
//myvector contains : 7 8 9 3 4 2 5 6 1


```


## 2. Using STD rand() function
```cpp
#include<iostream>

#define DECK_SIZE 24

void shuffle(int deck[])
{
  int deckSize = DECK_SIZE, temp;
  while (deckSize > 1)
  {
    long k = rand() % DECK_SIZE;
    deckSize--;
    temp = deck[deckSize];
    deck[deckSize] = deck[k];
    deck[k] = temp;
  }
}


int main(int argc, char **argv)
{
  int deck[DECK_SIZE], i;

  for (i = 0; i < DECK_SIZE; ++i)
  {
    deck[i] = i + 1;
  }

  shuffle(deck);
  for (i = 0; i < DECK_SIZE; ++i)
  {
    std::cout << deck[i] << " ";
  }

  std::cout << std::endl;

  system("pause");

  return 0;
}


//Output
//1 17 19 11 14 16 9 24 2 23 4 15 3 7 10 6 20 13 21 8 5 12 22 18

```

# RemoveDuplicatesFromLinkedList

```cpp
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
    
    //erorr fixed below
    return 1;
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

```

# ReverseString
Complete the ReverseString function below. The function should reverse a string in place. For example, 'Hello' entered would output 'olleH'  

```cpp
#include <iostream>

void ReverseString(char* const szString);

int _tmain(int argc, wchar_t* argv[])
{
	char szString[100] = "";

	std::cout << "Enter String: ";

	std::cin.getline(szString, sizeof(szString) - 1);
		
	ReverseString(szString);

	std::cout << "Reversed String: " << szString << std::endl;

	return 0;
}

void ReverseString(char* const szString)
{
	char* Begin = szString;
	char* End = szString + strlen(szString) - 1;
	char TempChar = '\0';

	while(Begin < End)
	{
		TempChar = *Begin;
		*Begin = *End;
		*End = TempChar;

		Begin++;
		End--;
	}
}
```

# BredthFirstSearch

Breadth First Traversal for a Graph
Breadth First Traversal(or Search) for a graph is similar to Breadth First Traversal of a tree(See mthod 2 of this post).
The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again.
To avoid processing a node more than once, we use a boolean visited array.
For simplicity, it is assumed that all vertices are reachable from the starting vertex.

For example, in the following graph, we start traversal from vertex 2. 
When we come to vertex 0, we look for all adjacent vertices of it. 
2 is also an adjacent vertex of 0. If we don't mark visited vertices, 
then 2 will be processed again and it will become a non - terminating process.
Breadth First Traversal of the following graph is 2, 0, 3, 1.

      0----1
      |   /
      |  /
      | /
start 2---3
         / \
         \_/

// Program to print BFS traversal from a given source vertex. BFS(int s) 
// traverses vertices reachable from s.

```cpp
#include<iostream>
#include <list>

using namespace std;

// This class represents a directed graph using adjacency list representation
class Graph
{
  int V;    // No. of vertices
  list<int> *adj;    // Pointer to an array containing adjacency lists
public:
  Graph(int V);  // Constructor
  void addEdge(int v, int w); // function to add an edge to graph
  void BFS(int s);  // prints BFS traversal from a given source s
};

Graph::Graph(int V)
{
  this->V = V;
  adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
  adj[v].push_back(w); // Add w to v's list.
}

void Graph::BFS(int s)
{
  // Mark all the vertices as not visited
  bool *visited = new bool[V];
  for (int i = 0; i < V; i++)
    visited[i] = false;

  // Create a queue for BFS
  list<int> queue;

  // Mark the current node as visited and enqueue it
  visited[s] = true;
  queue.push_back(s);

  // 'i' will be used to get all adjacent vertices of a vertex
  list<int>::iterator i;

  while (!queue.empty())
  {
    // Dequeue a vertex from queue and print it
    s = queue.front();
    cout << s << " ";
    queue.pop_front();

    // Get all adjacent vertices of the dequeued vertex s
    // If a adjacent has not been visited, then mark it visited
    // and enqueue it
    for (i = adj[s].begin(); i != adj[s].end(); ++i)
    {
      if (!visited[*i])
      {
        visited[*i] = true;
        queue.push_back(*i);
      }
    }
  }
}

// Driver program to test methods of graph class
int main()
{
  // Create a graph given in the above diagram
  Graph g(4);
  g.addEdge(0, 1);
  g.addEdge(0, 2);
  g.addEdge(1, 2);
  g.addEdge(2, 0);
  g.addEdge(2, 3);
  g.addEdge(3, 3);

  cout << "Following is Breadth First Traversal (starting from vertex 2) \n";
  g.BFS(2);

//Output:
//Following is Breadth First Traversal(starting from vertex 2)
//2 0 3 1

  system("pause");

  return 0;
}

```

# TheGridSearch

Problem Statement
Given a 2D array of digits, try to find the location of a given 2D pattern of digits within it. For example, consider the following 2D matrix.

1234567890
0987654321
1111111111
1111111111
2222222222
If we need to look for the following 2D pattern within it:

876543
111111
111111
If we scan through the original array, we observe, that 2D pattern begins from the second row and the third column of the larger grid (the 8 in the second row and third column of the larger grid, is the top-left corner of the pattern we are searching for).

So, a 2D pattern of digits P is said to be present in a larger grid G, if the latter contains a contiguous, rectangular 2D grid of digits matching with the pattern P; similar to the example shown above.

Input Format
The first line contains an integer T, which is the number of tests. T tests follow and the structure of each test is described below:
The first line contains 2 space separated integers R and C indicating the number of rows and columns in the grid G.
This is followed by R lines, each with a string of C digits each; which represent the grid G.
The second line contains 2 tab separated integers r and c indicating the number of rows and columns in the pattern grid P.
This is followed by r lines, each with a string of c digits each; which represent the pattern P.

Constraints
1<=T<=5
1<=R,r,C,c<=1000
1<=r<=R
1<=c<=C

```cpp
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void cal(int **big, int **small, int a, int b, int c, int d)
{
  int i = 0, j = 0, k = 0, l = 0, found = 0;
  long long flag;

  for (i = 0; i<a; i++)
    for (j = 0; j<b; j++)
    {
      if (big[i][j] == small[0][0])
      {
        flag = c*d;
        if (i + c<a && j + d<b)
          for (k = i; k<i + c; k++)
            for (l = j; l<j + d; l++)
              if (big[k][l] == small[k - i][l - j]) flag--;
        if (flag == 0)
          found = 1;
      }
    }

  if (found == 1)
    cout << "YES\n";
  else
    cout << "NO\n";
}

int main() {
  int t;
  cin >> t;
  while (t--)
  {
    long long int a, b, c, d;
    int i = 0, j = 0;
    char ch;
    cin >> a;
    cin >> b;
    int **big;

    big = (int **)malloc(a*sizeof(int*));
    for (i = 0; i<b; i++)
      big[i] = (int*)malloc(b*sizeof(int));
    ch = getchar();
    for (i = 0; i<a; i++)
    {
      for (j = 0; j<b; j++)
      {
        ch = getchar();
        big[i][j] = (int)ch - 48;
      }
      ch = getchar();
    }

    cin >> c >> d;
    int **small;

    small = (int **)malloc(c*sizeof(int*));
    for (i = 0; i<b; i++)
      small[i] = (int*)malloc(d*sizeof(int));
    ch = getchar();
    for (i = 0; i<c; i++)
    {
      for (j = 0; j<d; j++)
      {
        ch = getchar();
        small[i][j] = (int)ch - 48;
      }
      ch = getchar();
    }

    cal(big, small, a, b, c, d);

  }

  system("pause");
  return 0;
}

```

