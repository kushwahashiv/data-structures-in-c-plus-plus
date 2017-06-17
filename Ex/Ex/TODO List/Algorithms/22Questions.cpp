#include <stdio.h>
#include <string.h>
#include <string>
#include <iostream>


#include "22Questions.h"

using namespace std;

/**************************************************************************************
 * Que 1. Find all the perumation of a given string.
 * 
 * Comments : Using back tracking
 * 
 * Time Complexity : O(N * N!)
 * Space Complexity: O(N) Recursion
 * 
 * ***********************************************************************************/
void Permute(char A[])
{
    Permute(A,0,strlen(A) - 1);
}
void Permute(char A[], int i, int n)
{
    if(i == n)
      printf("%s\n",A);
    else
    {
      for(int k=i;k<=n;k++)
      {
	 SwapElement(A[i],A[k]);
	 Permute(A,i+1,n);
	 SwapElement(A[i],A[k]);
      }
    }
}
void SwapElement(char& a, char& b)
{
   char temp = a;
   a = b;
   b = temp;
}
void print_all_perm4(string s)
{
  int num_perm = 1, i, j, len = s.length();
 
  for (i = 1; i <= len; i++) num_perm *=i;
   
  for (i = 0; i < num_perm; i++){
    string p = s;
    string one_perm;
 
    int dv = num_perm;
    int num = i;
    for (j = len; j > 0;  j--){
      int index = num % j;
      one_perm.push_back( p[index] );
      p.erase(index, 1);
      num /= j;       
    }
    cout << one_perm << endl;
  }
}
