#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

long long int random_partition(int A[], long long int start, long long int end)
{
    long long int pivotIdx = start + rand() % (end-start+1);
    long long int pivot = A[pivotIdx];
    swap(A[pivotIdx], A[end]); // move pivot element to the end
    pivotIdx = end;
    long long int i = start - 1;
 
    for(long long int j = start; j <= end-1; j++)
    {
        if(A[j] <= pivot)
        {
            i++;
            swap(A[i], A[j]);
        }
    }
 
    swap(A[i+1], A[pivotIdx]);
    return i+1;
}
 
int random_select(int A[], long long int start, long long int end, long long int k)
{
    if(start == end)
        return A[start];
    if(k == 0) 
        return -1;
    if(start < end)
    {
        long long int mid = random_partition(A, start, end);
        long long int i = mid - start + 1;
        if(i == k)
            return A[mid];
        else 
        if(k < i)
            return random_select(A, start, mid-1, k);
        else 
            return random_select(A, mid+1, end, k-i);
    }
    return 0;
}

// Median of a sequence of increasing numbers is A[(n+1)/2] if elements are odd, if not it is (A[n/2]+A[(n+2)/2])/2
int main() {
    srand(time(NULL));
    long long int size;
    cin >> size;
    int A[size];
    for(long long int i = 0; i < size; i++) {
        int a;
        cin >> a;
        A[i] = a;
    }
    cout << random_select(A, 0, size-1, (size+1)/2);
    return 0;
}
