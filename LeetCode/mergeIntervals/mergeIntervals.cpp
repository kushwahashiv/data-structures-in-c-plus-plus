// Source : https://leetcode.com/problems/merge-intervals/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-08-26

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Interval {
  int start;
  int end;
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}
};

vector<Interval> merge(vector<Interval>& ins) {
  if (ins.empty()) return vector<Interval>{};
  vector<Interval> res;
  sort(ins.begin(), ins.end(), [](Interval a, Interval b) {return a.start < b.start; });
  res.push_back(ins[0]);
  for (int i = 1; i < ins.size(); i++) {
    if (res.back().end < ins[i].start) res.push_back(ins[i]);
    else
      res.back().end = max(res.back().end, ins[i].end);
  }
  return res;
}

int main(int argc, char**argv)
{
  Interval i1(1, 4);
  Interval i2(0, 2);
  Interval i3(3, 5);
  Interval i4(15, 18);
  vector<Interval> intervals;
  intervals.push_back(i1);
  intervals.push_back(i2);
  intervals.push_back(i3);
  intervals.push_back(i4);

  vector<Interval> r = merge(intervals);

  for (int i = 0; i < r.size(); i++) {
    cout << "[ " << r[i].start << ", " << r[i].end << " ] ";
  }
  cout << endl;

  return 0;
}
