#ifndef _H_Recursion_
#define _H_Recursion_

/* Que.1 Tower of hanoi problem */
void TowerOfHanoi(int n,char A,char B,char aux,bool _set);

/* Que.2 All combination of binary number */
void BinaryNumber(int n,int size,char A[],bool _set=false);
void PrintArray(char A,int size);

/* Que.3 All numbers of base k number for n bits */
void BaseKNumber(int n, int base,int size, char A[],bool _set=false);

#endif