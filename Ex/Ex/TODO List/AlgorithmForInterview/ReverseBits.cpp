//
//  ReverseBits.cpp
//  AlgorithmForInterview
//
//  Created by xzhu on 10/19/14.
//  Copyright (c) 2014 xzhu. All rights reserved.
//

#include "ReverseBits.h"
#include  <iostream>
using namespace std;

int reverseBits( int a)
{
    unsigned int flag_h = 1,flag_l=1;
    while ((flag_h<<1) != 0) {
        flag_h <<=1;
    }
    
    int b=0;
    while (flag_h > flag_l) {
        int v_h= a & flag_h;
        int v_l= a & flag_l;
        
        if(v_h)
        {
            
        }
    }
}

void testReverseBits()
{
    int a=10;
    int b=-10;
    cout << "10" << reverseBits(a) << endl;
    cout << "-10" << reverseBits(b) << endl;
}
