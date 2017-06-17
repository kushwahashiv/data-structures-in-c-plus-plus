#include <cmath>
#include <cstdio>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

#define MAXVAL 1000000001 // 10^9 is max for this problem

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> candies;
    for(int i = 0; i < n; i++) {
        int num;
        cin >> num;
        candies.push_back(num);
    }
    // Sort the vector. Logic is this: You pick one min and one max from this vector, which is the 0th and k-1'th element.
    // Then, you subtract them. Then you repeat this and find the minimum of this operation. That's the answer.
    sort(candies.begin(), candies.begin()+n);
    int result = MAXVAL; // so that the first minimum operation always turns into result
    for(int i = 0; i < n-k; i++)
        result = min(result, candies[k+i-1] - candies[i]); // k+i-1 because, i stops at n-k-1, this will stop at n-2
    cout << result;
    return 0;
}
