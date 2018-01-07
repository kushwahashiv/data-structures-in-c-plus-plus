// Source : https://oj.leetcode.com/problems/lru-cache/
// Author : Shiv S. Kushwaha
// Date   : 2014-10-12

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
Follow up:
Could you do both operations in O(1) time complexity?
Example:
LRUCache cache = new LRUCache( 2  ); // 2 = capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

#include <time.h>
#include <iostream>
#include <map>
using namespace std;

/*
There is a similar example in Java, but I wanted to share my solution using the new C++11 unordered\_map and a list.
The good thing about lists is that iterators are never invalidated by modifiers (unless erasing the element itself).
This way, we can store the iterator to the corresponding LRU queue in the values of the hash map.
Since using erase on a list with an iterator takes constant time, all operations of the LRU cache run in constant time.
*/
class LRUCache {
public:
  LRUCache(int capacity) : _capacity(capacity) {}

  int get(int key) {
    auto it = cache.find(key);
    if (it == cache.end()) return -1;
    touch(it);
    return it->second.first;
  }

  void set(int key, int value) {
    auto it = cache.find(key);
    if (it != cache.end()) touch(it);
    else {
      if (cache.size() == _capacity) {
        cache.erase(used.back());
        used.pop_back();
      }
      used.push_front(key);
    }
    cache[key] = { value, used.begin() };
  }

private:
  typedef list<int> LI;
  typedef pair<int, LI::iterator> PII;
  typedef unordered_map<int, PII> HIPII;

  void touch(HIPII::iterator it) {
    int key = it->first;
    used.erase(it->second.second);
    used.push_front(key);
    it->second.second = used.begin();
  }

  HIPII cache;
  LI used;
  int _capacity;
};

int main(int argc, char** argv)
{
  srand(time(0));

  int capacity = 5;
  int test_loop_times = 10;
  if (argc > 1) {
    capacity = atoi(argv[1]);
  }
  if (argc > 2) {
    test_loop_times = atoi(argv[1]);
  }

  LRUCache cache(capacity);

  int v;
  for (int i = 0; i < test_loop_times; i++) {
    v = i;//rand() % capacity;
    cout << "set " << v << ": ";
    cache.set(v, v);
    cache.print();

    v = rand() % capacity;
    cout << "get " << v << ": " << cache.get(v);
    cache.print();

    cout << endl;
  }
  return 0;
}
