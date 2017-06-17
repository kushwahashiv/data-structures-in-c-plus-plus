#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
// NEED TEMPLATES AHHH
bool find_in_string(string s, char c) {
    if(!s.length())
        return false;
    for(int i = 0; i < s.length(); i++) {
        if(s[i] == c)
            return true;
    }
    return false;
}

bool find_in_vector(vector<char> v, char c) {
    if(!v.size())
        return false;
    for(int i = 0; i < v.size(); i++) {
        if(v[i] == c)
            return true;
    }
    return false;
}

int find_max_len(vector<string> v) {
    int maxpos = 0;
    int max = v[0].size();
    for(int i = 1; i < v.size(); i++) {
        if(max < v[i].size()) {
            max = v[i].size();
            maxpos = i;
        }
    }
    return maxpos;
}

int main() {
    int n;
    cin >> n;
    vector<string> words;
    for(int i = 0; i < n; i++) {
        string s;
        cin >> s;
        words.push_back(s);
    }
    
    vector<char> unique_chars;
    // I can only compare one string with all of them for unique characters, as they have to be common to all 3
    // find the word with the maximum length there is, max is in algorithm
    int count = 0;
    int maxlenword = find_max_len(words);
    int maxlen = words[maxlenword].length();
    for(int k = 0; k < maxlen; k++) {
        int j = 0;
        int charcount = 0;
        while(j < n) { // iterate over all words for the ith character of the word with largest length
            if(j != maxlenword && !find_in_vector(unique_chars, words[maxlenword][k]) 
               && find_in_string(words[j], words[maxlenword][k]))
                charcount++;
            j++;
        }
        if(charcount == n-1)
            count++;
        unique_chars.push_back(words[maxlenword][k]); // done looking for this character
    }
    cout << count << endl;
    
    return 0;
}
