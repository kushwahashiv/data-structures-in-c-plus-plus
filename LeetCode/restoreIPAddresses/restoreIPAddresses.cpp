// Source : https://leetcode.com/problems/restore-ip-addresses/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-08-26

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> restoreIpAddresses(string s) {
  vector<string> ret;
  string ans;

  for (int a = 1; a <= 3; a++)
    for (int b = 1; b <= 3; b++)
      for (int c = 1; c <= 3; c++)
        for (int d = 1; d <= 3; d++)
          if (a + b + c + d == s.length()) {
            int A = stoi(s.substr(0, a));
            int B = stoi(s.substr(a, b));
            int C = stoi(s.substr(a + b, c));
            int D = stoi(s.substr(a + b + c, d));
            if (A <= 255 && B <= 255 && C <= 255 && D <= 255)
              if ((ans = to_string(A) + "." + to_string(B) + "." + to_string(C) + "." + to_string(D)).length() == s.length() + 3)
                ret.push_back(ans);
          }

  return ret;
}


// 2
vector<string> restoreIpAddresses(string s) {
  vector<string> result;
  string ip;
  restoreIpAddressesHelper(s, 0, 0, ip, result);
  return result;
}

void restoreIpAddressesHelper(string& s, int start, int partNum, string ip, vector<string>& result) {

  int len = s.size();
  if (len - start < 4 - partNum || len - start >(4 - partNum) * 3) {
    return;
  }

  if (partNum == 4 && start == len) {
    ip.erase(ip.end() - 1, ip.end());
    result.push_back(ip);
    return;
  }

  int num = 0;
  for (int i = start; i < start + 3; i++) {
    num = num * 10 + s[i] - '0';
    if (num < 256) {
      ip += s[i];
      restoreIpAddressesHelper(s, i + 1, partNum + 1, ip + '.', result);
    }
    //0.0.0.0 valid, but 0.1.010.01 is not
    if (num == 0) {
      break;
    }
  }

}


int main(int argc, char**argv)
{
  string s = "25525511135";
  if (argc > 1) {
    s = argv[1];
  }

  vector<string> result = restoreIpAddresses(s);

  cout << s << endl;
  for (int i = 0; i < result.size(); i++) {
    cout << '\t' << result[i] << endl;
  }
  return 0;
}
