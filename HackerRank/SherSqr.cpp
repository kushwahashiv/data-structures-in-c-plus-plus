#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

/*
Some cool observations while trying to figure out this STUPIDLY EASY relevance.
1-) In binary, each odd perfect square ends in 001.
2-) In binary, every perfect square has an even number of trailing zeros. (0 included)

And finally: Given a range A-B, you can get the amount of perfect squares using this: sqrt(B) - sqrt(A) ! But, A is not included, I tested many times, so you check for A in the end using a sqrt(A) == long sqrt(A) type cast
*/

int main() {
    long int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        
        int count = long (sqrt(r)) - long (sqrt(l));
        if(sqrt(l) == long(sqrt(l)))
            count++;
        cout << count << endl;
    }
    return 0;
}
