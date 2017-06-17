//
//  NThUglyNumber.cpp
//  AlgorithmForInterview
//
//  Created by xzhu on 10/19/14.
//  Copyright (c) 2014 xzhu. All rights reserved.
//

#include "NThUglyNumber.h"
#include <iostream>
using namespace std;

int min(int a,int b,int c)
{
    int curMin = a <= b? a:b;
    return curMin<=c?curMin:c;
}

int getTheNUglyNumber(int n)
{
    if (n<=0) {
        return 0;
    }
    
    int* uglyNumbers=new int[n];
    uglyNumbers[0]=1;
    int currentIndex=1;
    
    int *pMultiply2=uglyNumbers;
    int *pMultiply3=uglyNumbers;
    int *pMultiply5=uglyNumbers;
    
    while (currentIndex<n) {
        int curUgly=min(*pMultiply2 * 2, *pMultiply3 *3, *pMultiply5*5);
        uglyNumbers[currentIndex]=curUgly;
        while (*pMultiply2 * 2 <= curUgly) {
            pMultiply2++;
        }
        while (*pMultiply3 * 3 <= curUgly) {
            pMultiply3++;
        }
        while (*pMultiply5 * 5 <= curUgly) {
            pMultiply5++;
        }
        
        currentIndex ++;
    }
    
    int NUglyNumber = uglyNumbers[n-1];
    delete []uglyNumbers;
    return  NUglyNumber;
}

void testGetTheNUglyNumber()
{
    cout << getTheNUglyNumber(1500) << endl;
}


