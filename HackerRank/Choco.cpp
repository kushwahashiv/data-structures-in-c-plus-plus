#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main() {
    int v;
    cin >> v;
    for(int i = 0; i < v; i++) {
        int N, C, M;
        cin >> N >> C >> M;
        int count = N / C; // initial count
        int temp = count;
        while(temp >= M) {
            int prev = temp/M;
            count += prev;
            temp %= M;
            temp += prev;
        }
        cout << count << endl;
    }
    return 0;
}
