// Source : https://leetcode.com/problems/max-points-on-a-line/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-10-12

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

#include <time.h>
#include <iostream>
#include <vector>
#include <map>
using namespace std;

struct Point {
    int x;
    int y;
    Point() : x(0), y(0) {}
    Point(int a, int b) : x(a), y(b) {}
};

// The idea is straight forward. Calculate each slope between two points and handle two special cases: 1. vertical, 2. duplicate.

class Solution {
public:
    int maxPoints(vector<Point>& points)
    {
        if(points.size()<=2) return points.size();
        int res=0;
        for(int i=0;i<points.size()-1;i++) {
            int numVertical=1,local=1,duplicate=0;
            unordered_map<double,int> map;
            for(int j=i+1;j<points.size();j++)
                if(points[i].x==points[j].x) // special cases
                    if(points[i].y==points[j].y) // duplicate
                        duplicate++;
                    else // vertical
                        numVertical++;
                else {
                    double slope=(points[i].y-points[j].y)*1.0/(points[i].x-points[j].x);
                    map[slope]==0?map[slope]=2:map[slope]++;
                    local=max(local,map[slope]);
                }
            local=max(local+duplicate,numVertical+duplicate);
            res=max(res,local);
        }
        return res;
    }
};

void generatePoints(vector<Point> &points, int n) {
    srand(time(0));
    Point p;
    for(int i=0; i<n; i++) {
        p.x = rand() % 1;
        p.y = rand() % 1;
        points.push_back(p);
    }
}

void printPoints(vector<Point> &points) {
    for(int i=0; i<points.size(); i++) {
        cout << "(" << points[i].x << "," << points[i].y << ") ";
    }
    cout << endl;
}


int main(int argc, char** argv) 
{
    int n = 20;
    if ( argc > 1) {
        n = atoi(argv[1]);
    }
    vector<Point> points;
    generatePoints(points, n);
    printPoints(points);
    cout << maxPoints(points) << endl;
    return 0;
}
