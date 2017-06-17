//
//  main.cpp
//  problem 28
//
//  Created by Yanqiao Zhan on 10/31/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n;
    long sum=1;
    cin>>n;
    int level=(n-1)/2;
    int value=1;
    for(int i=1;i<=level;i++)
    {
        for(int j=0;j<4;j++)
        {
            value+=i*2;
            sum+=value;
        }
    }
    cout<<sum<<endl;
    return 0;
}
