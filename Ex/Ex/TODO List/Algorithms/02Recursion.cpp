#include <stdio.h>
#include <string.h>
#include "02Recursion.h"
#include "tools.h"

/* Que 1. Tower Of Hanoi
 * 
 * Algo Type : Recursion
 * 
 * Parameters : Number of disks,
 * 		Source Tower
 * 		Destination Tower
 * 		Auxillary Tower
 * 		bool to start counting number of steps
 * 
 * Return     : None
 * 
 * Time  Complexity : O(n^2)
 * Space Complexity :
 */
void TowerOfHanoi(int n,char from,char to,char aux,bool _set)
{
  static int nSteps = 0;
  if(_set) nSteps = 0;
  
  if(n == 1)
  {
      nSteps++;
      printf("%d\tMove Disk %d from Tower %c To Tower %c\n",nSteps,n,from,to);
      return;
  }
  
  TowerOfHanoi(n-1,from,aux,to,false);
  
  nSteps++;
  printf("%d\tMove Disk %d from Tower %c To Tower %c\n",nSteps,n,from,to);
  
  TowerOfHanoi(n-1,aux,to,from,false);
  
}
/* Que 2. Generate all the strings of n bits. for Binary number.
 * 
 * Algo Type : BackTracking
 * 
 * Parameters : number of bits
 * Return     : None
 * 
 * Time Complexity : 
 * 
 *        c             if n < 0
 * T(n) = 
 * 	  2T(n-1) + d   otherwise
 * Substraction and Conquer Master Theorem
 * O(2^n)
 * 
 */
void BinaryNumber(int n, int size, char A[],bool _set)
{
  static int nCount = 0;
  if(_set) nCount = 0;
  
  if(n < 1)
  {
    printf("%d\t",++nCount);
    PrintArray(A,size,false);
    return;
  }
  else
  {
      A[n-1] = 0 + '0';
      BinaryNumber(n-1,size,A);
      A[n-1] = 1 + '0';
      BinaryNumber(n-1,size,A);
  }
}
/* Que 3. Generate all the strings of n bits. for n-array
 * 
 * Algo Type : BackTracking
 * 
 * Parameters : number of bits
 * Return     : None
 * 
 * Time Complexity : 
 * 
 *        c             if n < 0
 * T(n) = 
 * 	  kT(n-1) + d   otherwise
 * Substraction and Conquer Master Theorem
 * O(k^n)
 *
 */
void BaseKNumber(int n, int base,int size, char A[],bool _set)
{
  static int nCount = 0;
  if(_set) nCount = 0;
  
  if(n < 1)
  {
    printf("%d\t",++nCount);
    PrintArray(A,size,false);
    return;
  }
  else
  {
     for(int i=0;i<base;i++)
     {
	A[n-1] = i + '0';
	BaseKNumber(n-1,base,size,A);
     }
  }
}



























