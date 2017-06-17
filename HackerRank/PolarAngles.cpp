#include <cmath>
#include <cstdio>
#include <vector>
#include <utility>
#include <iostream>
#include <algorithm>
using namespace std;

/*
 The logic is this: To find polar angle, we have a very useful relation:
 x = r*cost y = r*sint => x/y = cot(t) => t = Arccot(x/y)
 But, we also know that => cross product can be used in this case to find the comparison of angles instead.
 This relation saves us from actually calculating Arccot everytime.
*/
bool compare_polar (int x1, int y1, int x2, int y2) { // if p2 > p1 return true
    // handle special cases
    // x > 0, y = 0 -> both have 0 angle, couldn't do it in a nicer way :(
    if(x1 > 0 && x2 > 0 && y1 == 0 && y2 == 0)
        return x1*x1 + y1*y1 <= x2*x2 + y2*y2;
    if(y1 == 0 && x1 > 0) // angle of p1 is 0, p2 > p1
        return true;
    if(y2 == 0 && x2 > 0) // angle of p2 is 0 , p1 > p2
        return false;
    if(y1 > 0 && y2 < 0) // p1 is between 0 and 180, 180 < p2 < 360
        return true;
    if(y1 < 0 && y2 > 0) // p2 for above case
        return false;
    int crossp = x1*y2 - y1*x2; // return true if p1 is clockwise from p2 ie. cross product result being + or not
    if(crossp != 0)
        return (crossp > 0);
    return x1*x1 + y1*y1 <= x2*x2 + y2*y2;
}

int main() {
    int n;
    cin >> n;
    vector<pair<int, int> > Coords;
    for(int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        Coords.push_back(make_pair(x, y));
    }
    
    for(int i = 0; i < n-1; i++) {
        for(int j = i+1; j < n; j++) {
            if(!compare_polar(Coords[i].first, Coords[i].second, Coords[j].first, Coords[j].second))
                swap(Coords[i], Coords[j]);
        }
    }
    
    for(int i = 0; i < n; i++)
        cout << Coords[i].first << " " << Coords[i].second << endl;
    
    return 0;
}
