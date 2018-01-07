// Source : https://leetcode.com/problems/gray-code/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-06-20

/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code,
print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

#include <time.h>
#include <iostream>
#include <vector>

using namespace std;
/*
I designed the following stupid algorithm base on the blow observation
I noticed I can use a `mirror-like` binary tree to figure out the gray code.
For example:
          0      
       __/ \__   
      0       1  
     / \     / \ 
    0   1   1   0
So, the gray code as below: (top-down, from left to right)
    0 0 0
    0 0 1
    0 1 1
    0 1 0

                 0
           _____/ \_____
          0             1
       __/ \__       __/ \__
      0       1     1       0
     / \     / \   / \     / \
    0   1   1   0 0   1   1   0

So, the gray code as below:
    0 0 0 0
    0 0 0 1
    0 0 1 1
    0 0 1 0
    0 1 1 0
    0 1 1 1 
    0 1 0 1
    0 1 0 0
*/

vector<int> grayCode(int n)
{
    vector<int> result(1, 0);
    for (int i = 0; i < n; i++) {
        int curCount = result.size();
        // push back all element in result in reverse order
        while (curCount) {
            curCount--;
            int curNum = result[curCount];
            curNum += (1<<i);
            result.push_back(curNum);
        }
    }
    return result;
}

/*
Actually, there is a better way.
The mathematical way is: (num >> 1) ^ num; 
Please refer to http://en.wikipedia.org/wiki/Gray_code
 */
vector<int> grayCode02(int n) {
    vector<int> ret;   
    int size = 1 << n;   
    for(int i = 0; i < size; ++i) {
        ret.push_back((i >> 1)^i);   
    }
    return ret;   
}

void printBits(int n, int len){
    for(int i=len-1; i>=0; i--) {
        if (n & (1<<i)) {
            printf("1");
        }else{
            printf("0");
        }
    }
}

void printVector(vector<int>& v, int bit_len)
{
    for(auto it : v){
        printBits(it, bit_len);
        cout <<  " ";
    }
    cout << endl;
}

int main()
{
    int n = 2;
    vector<int> v = grayCode(n);
    printVector(v, n);
    return 0;
}
