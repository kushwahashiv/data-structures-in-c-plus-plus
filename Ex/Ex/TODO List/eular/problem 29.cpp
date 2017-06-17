//
//  main.cpp
//  Problem 29
//
//  Created by Yanqiao Zhan on 11/2/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    set<double>a;
    
    for(int i=2;i<=100;i++)
    {
        for(int j=2;j<=100;j++)
        {
            double result=pow(i, j);
            a.insert(result);
        }
    }
    cout<<a.size()<<endl;
    return 0;
}
