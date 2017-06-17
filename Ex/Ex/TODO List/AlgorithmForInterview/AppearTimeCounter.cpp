//
//  AppearTimeCounter.cpp
//  AlgorithmForInterview
//
//  Created by xzhu on 10/17/14.
//  Copyright (c) 2014 xzhu. All rights reserved.
//

#include "AppearTimeCounter.h"
#include <iostream>
using namespace std;

int AppearTimeCounter::count(int n)
{
    if(n<=0) return 0;
    
    int total=0;
    int curPos=1;
    
    while (n/curPos!=0) {
        
        int flag=curPos*10;
        int upper=n/flag;
        int reminder=n%flag;
        
        total+=upper*curPos;
        
        int leftTop=reminder/curPos;
        
        if (leftTop>1) {
            total+=(flag/10);
        }
        else if(leftTop==1)
        {
            total+=(reminder-curPos+1);
        }
        curPos*=10;
    }
    return total;
}

void AppearTimeCounter::test()
{
    cout << "right:" << getCount(1) << ":" << count(1) << endl;
    cout << "right:" << getCount(7) << ":" <<count(7) << endl;
    cout << "right:" << getCount(16) <<":" <<count(16) << endl;
    cout << "right:" << getCount(78) << ":" <<count(78)<< endl;
    cout << "right:" << getCount(198) << ":" <<count(198)<< endl;
    cout << "right:" << getCount(311) << ":" <<count(311)<< endl;
    cout << "right:" << getCount(11111) <<":" << count(11111)<< endl;
    cout << "right:" << getCount(21345) << ":" <<count(21345)<< endl;
}

