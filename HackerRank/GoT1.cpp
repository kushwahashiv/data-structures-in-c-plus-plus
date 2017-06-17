#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int find_elem (vector<char> v, char elem) {
    for(int i = 0; i < v.size(); i++) {
        if(elem == v[i])
            return i;
    }
    return -1;
}


int main() {
   
    string s;
    cin>>s;
     
    int flag = 0;
    vector<char> chars;
    vector<int> count;
    for(int i = 0; i < s.length(); i++) {
        if(chars.empty()) { // empty, so just add
            chars.push_back(s[i]);
            count.push_back(1);
        }
        else {
            if(find_elem(chars, s[i]) == -1) { // not yet added to char list
                chars.push_back(s[i]);
                count.push_back(1);
            }
            else { // I already have this character in the char list
                int pos = find_elem(chars, s[i]);
                count[pos]++;
            }
        }
    }
    
    int single = 0;
    for(int i = 0; i < count.size(); i++) {
        if(count[i]%2)
            single++;
    }
    
    if(single < 2) flag |= 1;
    
    if(flag==0)
        cout<<"NO";
    else
        cout<<"YES";
    return 0;
}
// Shorter version -- Improved on previous
/*
#include <iostream>
#include <string>

using namespace std;

int counter[26];

int main() {
  string str; cin >> str;
  for(int i = 0; i < str.length(); i++)
    counter[str[i] - 'a']++;

  bool hasOdd = false;
  string res = "YES";
  for(int i = 0; i < 26; i++) {
    if(counter[i] % 2 != 0) {
      if(hasOdd) { res = "NO"; break; }
      else hasOdd = true; 
    }
  }
  cout << res << endl;
  return 0;
}
*/
