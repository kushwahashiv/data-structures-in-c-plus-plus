//
//  Count1InBits.cpp
//  AlgorithmForInterview
//
//  Created by xzhu on 10/19/14.
//  Copyright (c) 2014 xzhu. All rights reserved.
//

#include "Count1InBits.h"
#include <iostream>
using namespace std;

int count1(int a)
{
    int flag=0x1;
    int n=0;
    while (flag!=0) {
        if ((a & flag) > 0) {
            n++;
        }
        flag=flag << 1;
    }
    return n;
}

int count2(int b)
{
    int n=0;
    while (b) {
        n++;
        b&=(b-1);
    }
    return  n;
}

void testCount1InBits(){
    int n=10;
    cout << "result 1:" << count1(n) << endl;
    cout << "result 2:" << count2(n) << endl;
}


