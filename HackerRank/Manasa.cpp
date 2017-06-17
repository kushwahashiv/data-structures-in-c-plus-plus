#include <iostream>

using namespace std;

void swap(int& a, int& b) {
  ((a ^= b), (b ^= a), (a ^= b));
}

int main() {
  int t; 
  cin >> t;
  for(int i = 1; i <= t; i++) {
    int n, a, b; 
    cin >> n >> a >> b;
    n--;

    if(a == b) cout << a * n << endl; // stepsize is only one option
    else {
      if(a > b) swap(a, b);

      cout << a * n;
      for(int i = 1; i <= n; i++) {
        cout << " " << (a * (n - i) + b * i); // all options: as i increases, a decreases but b increases
      }
      cout << endl;
    }
  }
  return 0;
}
