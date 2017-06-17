//
//  main.cpp
//  problem 12
//
//  Created by Yanqiao Zhan on 11/2/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;
int divisors(long n)
{
    int count=0;
    int divisor=1;
    while(divisor<=sqrt(n))
    {
        if(n%divisor==0)
        {
            count+=2;
        }
        divisor++;
    }
    if(divisor==sqrt(n))count--;
    return count;
}
int main(int argc, const char * argv[]) {
    int n=1;
    while(divisors(n*(n+1)/2)<500)
    {
        n++;
    }
    cout<<n*(n+1)/2<<endl;
    return 0;
}
