//
//  AppearTimeCounter.h
//  AlgorithmForInterview
//
//  Created by xzhu on 10/17/14.
//  Copyright (c) 2014 xzhu. All rights reserved.
//

#ifndef __AlgorithmForInterview__AppearTimeCounter__
#define __AlgorithmForInterview__AppearTimeCounter__

#include <stdio.h>
class AppearTimeCounter
{
private:
    int getCount(int n){
        int total=0;
        for(int i=1;i<=n;i++)
        {
            int temp=i;
            while(temp!=0)
            {
                if(temp%10==1){
                    total++;
                }
                temp/=10;
            }
        }
        return total;
    }
public:
    /**
     *  Count the appear times of 1 in the sequenc 1,2,3,4,...n. E.g. if n=21, then the appear time of 1 is 12.
     *
     *  @param n
     *
     *  @return The appear time
     */
    int count(int n);
    
    void test();
};

#endif /* defined(__AlgorithmForInterview__AppearTimeCounter__) */
