// https://oj.leetcode.com/problems/clone-graph/
// Author : Shiv S. Kushwaha

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

#include<iostream>
#include<vector>
#include<map>
#include<queue>

using namespace std;

//Definition for undirected graph.
struct UndirectedGraphNode
{
  int label;
  vector<UndirectedGraphNode *> neighbors;
  UndirectedGraphNode(int x) : label(x) {};
};

// BFS
class Solution {
public:
  UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
    if (!node) return NULL;
    UndirectedGraphNode* copy = new UndirectedGraphNode(node->label);
    mp[node] = copy;
    queue<UndirectedGraphNode*> toVisit;
    toVisit.push(node);
    while (!toVisit.empty()) {
      UndirectedGraphNode* cur = toVisit.front();
      toVisit.pop();
      for (UndirectedGraphNode* neigh : cur->neighbors) {
        if (mp.find(neigh) == mp.end()) {
          UndirectedGraphNode* neigh_copy = new UndirectedGraphNode(neigh->label);
          mp[neigh] = neigh_copy;
          toVisit.push(neigh);
        }
        mp[cur]->neighbors.push_back(mp[neigh]);
      }
    }
    return copy;
  }
private:
  unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> mp;
};

// DFS
class Solution {
public:
  UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
    if (!node) return NULL;
    if (mp.find(node) == mp.end()) {
      mp[node] = new UndirectedGraphNode(node->label);
      for (UndirectedGraphNode* neigh : node->neighbors)
        mp[node]->neighbors.push_back(cloneGraph(neigh));
    }
    return mp[node];
  }
private:
  unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> mp;
};


int main()
{
  UndirectedGraphNode *node(nullptr);
  UndirectedGraphNode *result = cloneGraph(node);

  system("pause");
  return 0;
}