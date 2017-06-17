#include <iostream>
using namespace std;

int height(int n) {
    if(!n) return 1;
    if(!(n%2)) {
        return 1+height(n-1);
    }
    else
        return 2*height(n-1);
}
int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        cout << height(n) << endl;
    }
}
