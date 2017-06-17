//
//  main.cpp
//  Problem 15
//
//  Created by Yanqiao Zhan on 11/2/14.
//  Copyright (c) 2014 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
static long result[25][25];//the result matrix must use long type, since the value is more than Max_size of integer.
struct Point
{
    long x,y;
    Point(long a,long b)
    {
        x=a;
        y=b;
    }
    bool operator ==(const Point&t)
    {
        if(t.x==x&&t.y==y)
        {
            return true;
        }
        else return false;
    }
};
long go(Point point)
{
    if(result[point.x][point.y]!=0)
        return result[point.x][point.y];
    else{
        
        if(point.x>=1&&point.y>=1)
        {
            result[point.x][point.y]=go(Point(point.x-1, point.y))+go(Point(point.x, point.y-1));
            return result[point.x][point.y];
        }
        else if(point.x==0)
        {
            result[point.x][point.y]=1;
            return result[point.x][point.y];
        }
        else if(point.y==0)
        {
            result[point.x][point.y]=1;
            return result[point.x][point.y];
        }
        else return 0;
        
    }
}

int main(int argc, const char * argv[]) {
    
    result[1][1]=2;
    result[1][0]=1;
    result[0][1]=1;
    
    cout<<go(Point(20,20))<<endl;
    return 0;
}
