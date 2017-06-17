#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        vector<vector<int> > P;
        P.resize(4); // x,y,z given
        int x;
        // Points P, Q, R, S
        for(int j = 0; j < 4; j++) { // 3x3
            for(int k = 0; k < 3; k++) {
                cin >> x;
                P[j].push_back(x);
            }
        }
        // Direction Vectors: A, B, C. A => Vector from Q-P. B => Vector from R-P. C => Vector from S-A, for coplanarity            
        // P[1] -> A, P[2] -> B, P[3] -> C
        for(int j = 1; j < 4; j++)
            for(int k = 0; k < 3; k++)
                P[j][k] -= P[0][k];
        // Now, take cross product of A and B, we'll call this D. The dot product of C and D has to be zero.
        // Cofactor expansion on general formula yields:
        // u_2*v_3 - v_2*u_3 = x
        // -(u_1*v_3-v_1*u_3) = y
        // u_1*v_2 - v_1*u_2 = z
        vector<int> D; // 0 -> x, 1 -> y, 2 -> z
        D.resize(3);
        D[0] = P[1][1]*P[2][2] - P[2][1]*P[1][2];
        D[1] = -P[1][0]*P[2][2] + P[2][0]*P[1][2];
        D[2] = P[1][0]*P[2][1] - P[2][0]*P[1][1];
        // Dot product => x1 * x2 + y1 * y2 + z1 * z2 = 0 must hold
        int dotres = P[3][0]*D[0] + P[3][1] * D[1] + P[3][2]*D[2];
        if(dotres)
            cout << "NO";
        else
            cout << "YES";
        cout << endl;
    }
    return 0;
}
