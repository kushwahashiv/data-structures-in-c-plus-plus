//
//  main.cpp
//  problem 27
//
//  Created by Yanqiao Zhan on 10/31/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <cmath>
#include <vector>
using namespace std;
vector<int>prime;
bool isprime(int n)
{
    int counter=2;
    while(counter<=sqrt(n))
    {
        if(n%counter==0)return false;
        else
        {
            counter++;
        }
    }
    return true;
}
int main(int argc, const char * argv[]) {
    
    int nMax=0,na=0,nb=0;
    for(int a=-999;a<=1000;a+=2)//since a+b must be a even, and b must be a prime, so b must be a odd and a also must be a odd
    {
        for(int b=-999;b<=1000;b+=2)
        {
            if(isprime(b))
            {
                int n=0;
                while(isprime(abs(n*n+a*n+b)))
                {
                    n++;
                }
                if(n>nMax)
                {
                    nMax=n;
                    na=a;
                    nb=b;
                }
            }
            
        }
    }
    cout<<na*nb<<endl;
    return 0;
}
