//
//  NDiceDotSum.cpp
//  AlgorithmForInterview
//
//  Created by xzhu on 10/18/14.
//  Copyright (c) 2014 xzhu. All rights reserved.
//

#include "NDiceDotSum.h"
#include <iostream>
#include <math.h>
using namespace std;

int g_maxValue=6;
void getNDiceCount(int n)
{
    if (n<0) {
        throw "Invalid Arguments";
    }
    const int maxSum=n*g_maxValue;
    int *count = new int[maxSum+1];
    int *count_temp = new int[maxSum+1];
    
    for (int i=0; i<=maxSum; i++) {
        count[i]=0;
        count_temp[i]=0;
    }
    
    for (int i=1; i<=g_maxValue; i++) {
        count[i]=1;
    }
    
    for (int j=2; j<=n; j++) {
        
        for (int k=0; k<j; k++) {
            count_temp[k]=0;
        }
        
        for (int k=j; k<=maxSum; k++) {
            count_temp[k]=0;
            for (int h=1; h<=k&&h<=g_maxValue; h++) {
                count_temp[k]+=count[k-h];
            }
        }
        int* temp;
        temp=count;
        count=count_temp;
        count_temp=temp;
    }
    
    
    //calculate the properbility
    double total=pow((double)6, n);
    for (int i=1; i<=maxSum;i++) {
        cout << i << ":" <<count[i] << ":" << count[i]/total << endl;
    }
    
}

void testGetNDiceCount(){
    cout << "n is 3:" << endl;
    int n1=3;
    getNDiceCount(n1);
}
