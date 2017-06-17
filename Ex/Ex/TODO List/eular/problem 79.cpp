//
//  main.cpp
//  problem 79
//
//  Created by Yanqiao Zhan on 11/6/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <set>
#include <string>
#include <cstdio>
using namespace std;
int main(int argc, const char * argv[]) {
    ifstream fin("problem 79_keylog.txt");
    string number;
    set<int> pre[10];
    while(fin>>number)
    {
        pre[number[0]-'0'].insert(number[1]-'0');
        pre[number[0]-'0'].insert(number[2]-'0');
        pre[number[1]-'0'].insert(number[2]-'0');
    }
    fin.close();
    for(int i=0;i<10;i++)
    {
        cout<<i<<" is in ahead of: ";
        for(set<int>::iterator se=pre[i].begin();se!=pre[i].end();se++)
            cout<<*se<<" ";
        cout<<endl;
    }
    return 0;
}
