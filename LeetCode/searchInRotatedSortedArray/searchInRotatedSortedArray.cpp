// Source : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-28

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/

#include <iostream>
#include <time.h>

int search(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }

void rotate_array(int a[], int n, int pos){
    int i, from=0;
    pos = pos % n;
    if (n<=0) return;

    int tmp = a[0];
    
    for(int i=0, step=0; step<n && i<pos; step++){
        int to;
        if (from-pos < 0) {
            to = n-pos+from; 
        }else{
            to = from-pos;
        }
        int t ;
        t = a[to];
        a[to] = tmp; 
        tmp = t;
        from = to;
        if ( to == i ){
            i++;
            from++;
            tmp = a[from];
        }
    }
    
}

void printArray(int A[], int n) {
    printf("{");
    for(int i=0; i<n; i++) {
        printf("%d, ", A[i]);
    }
    printf("}\n");
}

int main(int argc, char** argv)
{

    int cnt=20;

    if (argc>1) {
        cnt = atoi(argv[1]);
    }

    srand(time(nullptr)); 

   for(int n=0; n<=cnt; n++) {
        printf("--------------------------------------\n");
        int *a = new int[cnt];
        for(int i=0; i<cnt; i++){
            a[i]=i*2;
        }
        //printArray(a, cnt);
        int rotate = rand() % cnt;
        //rotate=2;
        //printf("rotate=%d\n", rotate);
        rotate_array(a, cnt, rotate);
        printArray(a, cnt);
        int target = rand() % (2*cnt);
        //target=6;
        printf("target=%d\n", target);
    
        int idx = search(a, cnt, target);
        if ( idx<0 ){
            printf("not found!\n");
        }else{
            printf("a[%d] = %d\n", idx, a[idx]); 
        }
        
        delete[] a;
   }

    return 0;
}
