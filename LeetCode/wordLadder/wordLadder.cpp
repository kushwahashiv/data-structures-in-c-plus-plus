// Source : https://leetcode.com/problems/word-ladder/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-10-12

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/


// --------------------------- 
//  BFS non-recursive method
// ---------------------------
//
//    Using BFS instead of DFS is becasue the solution need the shortest transformation path.
//  
//    So, we can change every char in the word one by one, until find all possible transformation.
//
//    Keep this iteration, we will find the shorest path.
//
// For example:
//   
//     start = "hit"
//     end = "cog"
//     dict = ["hot","dot","dog","lot","log","dit","hig", "dig"]
//
//                      +-----+                  
//        +-------------+ hit +--------------+   
//        |             +--+--+              |   
//        |                |                 |   
//     +--v--+          +--v--+           +--v--+
//     | dit |    +-----+ hot +---+       | hig |
//     +--+--+    |     +-----+   |       +--+--+
//        |       |               |          |   
//        |    +--v--+         +--v--+    +--v--+
//        +----> dot |         | lot |    | dig |
//             +--+--+         +--+--+    +--+--+
//                |               |          |   
//             +--v--+         +--v--+       |   
//        +----> dog |         | log |       |   
//        |    +--+--+         +--+--+       |   
//        |       |               |          |   
//        |       |    +--v--+    |          |   
//        |       +--->| cog |<-- +          |   
//        |            +-----+               |   
//        |                                  |   
//        |                                  |   
//        +----------------------------------+   
//     
//     1) queue <==  "hit"
//     2) queue <==  "dit", "hot", "hig"
//     3) queue <==  "dot", "lot", "dig"
//     4) queue <==  "dog", "log" 
// 


#include<iostream>
#include<string>
#include<unordered_set>
#include<queue>
#include<map>

using namespace std;

int ladderLength(string start, string end, unordered_set<string> &dict) {

  // Using a map for two purposes:
  //   1) store the distince so far.
  //   2) remove the duplication
  map<string, int> dis;
  dis[start] = 1;

  queue<string> q;
  q.push(start);

  while (!q.empty()) {

    string word = q.front();
    q.pop();

    if (word == end) {
      break;
    }

    for (int i = 0; i < word.size(); i++) {
      string temp = word;
      for (char c = 'a'; c <= 'z'; c++) {
        temp[i] = c;
        if (dict.count(temp) > 0 && dis.count(temp) == 0) {
          dis[temp] = dis[word] + 1;
          q.push(temp);
        }
      }
    }
  }
  return (dis.count(end) == 0) ? 0 : dis[end];
}


// 2

int ladderLength(string beginWord, string endWord, unordered_set<string>& wordDict) {
  unordered_set<string> head, tail, *phead, *ptail;
  head.insert(beginWord);
  tail.insert(endWord);
  int dist = 2;
  while (!head.empty() && !tail.empty()) {
    if (head.size() < tail.size()) {
      phead = &head;
      ptail = &tail;
    }
    else {
      phead = &tail;
      ptail = &head;
    }
    unordered_set<string> temp;
    for (auto itr = phead->begin(); itr != phead->end(); itr++) {
      string word = *itr;
      wordDict.erase(word);
      for (int p = 0; p < (int)word.length(); p++) {
        char letter = word[p];
        for (int k = 0; k < 26; k++) {
          word[p] = 'a' + k;
          if (ptail->find(word) != ptail->end())
            return dist;
          if (wordDict.find(word) != wordDict.end()) {
            temp.insert(word);
            wordDict.erase(word);
          }
        }
        word[p] = letter;
      }
    }
    dist++;
    swap(*phead, temp);
  }
  return 0;
}


int main()
{
  return 0;
}