// Source : https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-20

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

#include <iostream>
#include <vector>
using namespace std;

int largestRectangleArea(vector<int> &height) {

            int ret = 0;
            height.push_back(0);
            vector<int> index;

            for(int i = 0; i < height.size(); i++)
            {
                while(index.size() > 0 && height[index.back()] >= height[i])
                {
                    int h = height[index.back()];
                    index.pop_back();

                    int sidx = index.size() > 0 ? index.back() : -1;
                    if(h * (i-sidx-1) > ret)
                        ret = h * (i-sidx-1);
                }
                index.push_back(i);
            }

            return ret;
}

void printArray(vector<int> &v)
{
    cout << "{";
    for(int i=0; i<v.size(); i++) {
        cout << " " << v[i];
    }
    cout << "}" << endl;
}
void test(int a[], int n)
{
    vector<int> v(a, a + n);
    printArray(v);
    cout << largestRectangleArea(v) << endl;
}

int main()
{
    #define TEST(a) test(a, sizeof(a)/sizeof(int))
    int a0[] = {2,1,3,1};
    TEST(a0);
    int a1[] = {2,1,5,6,2,3};
    TEST(a1);

    return 0;
}