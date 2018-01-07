// Source : https://leetcode.com/problems/text-justification/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-10-11

/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

#include <math.h>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
For each line, I first figure out which words can fit in. According to the code, these words are words[i] through words[i+k-1].
 Then spaces are added between the words. The trick here is to use mod operation to manage the spaces that can’t be evenly
 distrubuted: the first (L-l) % (k-1) gaps acquire an additional space.
*/

vector<string> fullJustify(vector<string> &words, int L) {
    vector<string> res;
    for(int i = 0, k, l; i < words.size(); i += k) {
        for(k = l = 0; i + k < words.size() and l + words[i+k].size() <= L - k; k++) {
            l += words[i+k].size();
        }
        string tmp = words[i];
        for(int j = 0; j < k - 1; j++) {
            if(i + k >= words.size()) tmp += " ";
            else tmp += string((L - l) / (k - 1) + (j < (L - l) % (k - 1)), ' ');
            tmp += words[i+j+1];
        }
        tmp += string(L - tmp.size(), ' ');
        res.push_back(tmp);
    }
    return res;
}

//
void printVector(vector<string> &words, bool newline=false) {
    for(int i=0; i<words.size(); i++) {
        cout << "\"" << words[i] << "\", ";
        if (newline) cout << endl; 
    }
    cout << endl;
}

void test(const char* A[], int len, int L) {
    vector<string> words(A, A+len);

    printVector(words);

    vector<string> result = fullJustify(words, L);
    cout << endl;
    printVector(result, true);

}

#define TEST(a, L) test(a, sizeof(a)/sizeof(const char*), L)

int main(int argc, char** argv)
{
    const char* w1[]={"This", "is", "an", "example", "of", "text", "justification."};
    TEST(w1, 16);    

    const char* w2[] = {"What","must","be","shall","be."}; 
    TEST(w2, 12);
    
    const char* w3[] = {"My","momma","always","said,","Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
    TEST(w3, 20);

    return 0;
}
