//
//  main.cpp
//  Problem 13
//
//  Created by Yanqiao Zhan on 11/2/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <vector>
using namespace std;
string Add(string a,string b)
{
    string c="";
    int increment=0;
    if(a.length()<b.length())
    {
        swap(a, b);
    }
    for(int i=0;i<a.length()&&i<b.length();i++)
    {
        int tem=a[a.length()-i-1]+b[b.length()-i-1]-2*'0'+increment;
        if(tem>=10)
        {
            increment=1;
        }
        else
        {
            increment=0;
        }
        string temstring=to_string(tem%10);
        c=temstring+c;
    }
    if(a.length()>b.length())
    {
        for(size_t i=b.length();i<a.length();i++)
        {
            int tem=a[a.length()-i-1]-'0'+increment;
            if(tem>=10)
            {
                increment=1;
            }
            else
            {
                increment=0;
            }
            string temstring=to_string(tem%10);
            c=temstring+c;
        }
    }
    if(increment==1)
    {
        c='1'+c;
    }
    
    return c;
}


int main(int argc, const char * argv[]) {
    vector<string> str;
    string tem;
    ifstream in("/Users/yanqiaozhan/Code/C++/problem 13/Problem 13/data.txt");//I store the input data in the data.txt
    
    while((in>>tem)&&tem!="!")
    {
        str.push_back(tem);
    }
    
    for(long i=str.size()-1;i>0;i--)
    {
        str[i-1]=Add(str[i-1],str[i]);
    }
    cout<<str[0].substr(0,10)<<endl;
    return 0;
}
