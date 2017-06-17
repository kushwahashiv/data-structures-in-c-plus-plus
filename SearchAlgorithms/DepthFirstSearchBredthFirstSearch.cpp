/*

DFS Algorithm:
1. Place the starting node s on the top of the stack.
2. If the stack is empty, return failure and stop.
3. If the element on the stack is goal node g, return success and stop. Otherwise,
4. Remove and expand the first element , and place the children at the top of the stack.
5. Return to step 2.


*/
#include <fstream>
#include <map>
#include <string>
#include <utility>
#include <vector>
#include <algorithm>
#include <cassert>
#include <queue>
#include <set>
#include <iostream>
#include <sstream>


/**
* @class graph.
* @brief Represents undirected graph, with valued edges.
*/
class graph
{
public:
  void add_edge(const std::string& v1, const std::string& v2, double c, bool r);

  bool has_vertex(const std::string& v) const
  {
    return m_indices.find(v) != m_indices.end();
  }

  /// @brief Breadth First Search algorithm on graph.
  void bfs(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const;

  /// @brief Depth First Search algorithm on graph.
  void dfs(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const;

  /// @brief Uniform Cost Search algorithm on graph with reliable edges.
  void ucsr(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const;

  /// @brief Uniform Cost Search algorithm on graph with unreliable edges.
  void ucsu(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const;

  graph()
  {
  }

  ~graph();

private:
  void add_vertex(const std::string& v);
  unsigned get_index(const std::string& v) const;
  double cost(const std::vector<unsigned>& p) const;
  double reliable_cost(unsigned i1, unsigned i2) const;
  double unreliable_cost(unsigned i1, unsigned i2) const;
  void dfs(unsigned i1, unsigned i2, std::ofstream& fl, const std::vector<unsigned>& p, std::vector<unsigned>& fp) const;
  void ucs(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl, double (graph::* cost_f) (unsigned, unsigned) const) const;

private:
  graph(const graph&);
  graph& operator=(const graph&);

private:
  typedef std::map<std::string, unsigned> name_to_index;
  typedef std::vector<std::string> index_to_name;
  name_to_index m_indices;
  index_to_name m_names;

  std::vector<std::vector<unsigned> > m_adjacent_vertices;
  std::map<std::pair<unsigned, unsigned>, std::pair<double, bool> > m_edges;
};


void graph::add_vertex(const std::string& v)
{
  assert(!has_vertex(v));
  unsigned i = m_names.size();
  assert(i == m_indices.size());
  m_names.push_back(v);
  m_indices[v] = i;
  m_adjacent_vertices.push_back(std::vector<unsigned>());
}

unsigned graph::get_index(const std::string& v) const
{
  name_to_index::const_iterator i = m_indices.find(v);
  assert(i != m_indices.end());
  return i->second;
}

void graph::add_edge(const std::string& v1, const std::string& v2, double c, bool r)
{
  if (!has_vertex(v1)) {
    add_vertex(v1);
  }
  if (!has_vertex(v2)) {
    add_vertex(v2);
  }
  unsigned i1 = get_index(v1);
  unsigned i2 = get_index(v2);
  if (i2 < i1) {
    std::swap(i1, i2);
  }
  m_adjacent_vertices[i1].push_back(i2);
  m_adjacent_vertices[i2].push_back(i1);
  m_edges[std::make_pair(i1, i2)] = std::make_pair(c, r);
}

double graph::reliable_cost(unsigned v1, unsigned v2) const
{
  if (v1 > v2) {
    std::swap(v1, v2);
  }
  std::map<std::pair<unsigned, unsigned>, std::pair<double, bool> >::const_iterator x =
    m_edges.find(std::make_pair(v1, v2));
  assert(x != m_edges.end());
  return x->second.first;
}

double graph::unreliable_cost(unsigned v1, unsigned v2) const
{
  if (v1 > v2) {
    std::swap(v1, v2);
  }
  std::map<std::pair<unsigned, unsigned>, std::pair<double, bool> >::const_iterator x =
    m_edges.find(std::make_pair(v1, v2));
  assert(x != m_edges.end());
  return x->second.second ? x->second.first : x->second.first + 0.5;
}

double graph::cost(const std::vector<unsigned>& path) const
{
  double c = 0;
  for (unsigned i = 1; i < path.size(); ++i) {
    c += reliable_cost(path[i - 1], path[i]);
  }
  return c;
}

void graph::bfs(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const
{
  unsigned i1 = get_index(v1);
  unsigned i2 = get_index(v2);
  std::queue<std::pair<unsigned, std::vector<unsigned> > > q;
  q.push(std::make_pair(i1, std::vector<unsigned>(1, i1)));
  std::vector<unsigned> found_path;
  while (!q.empty()) {
    i1 = q.front().first;
    std::vector<unsigned> path = q.front().second;
    fl << m_names[i1] << "\n";
    q.pop();
    if (i2 == i1) {
      if (found_path.empty() || cost(found_path) > cost(path)) {
        found_path = path;
      }
      continue;
    }
    std::vector<unsigned>::const_iterator i;
    for (i = m_adjacent_vertices[i1].begin();
      i != m_adjacent_vertices[i1].end();
      ++i) {
      if (std::find(path.begin(), path.end(), *i) == path.end()) {
        std::vector<unsigned> np(path);
        np.push_back(*i);
        q.push(std::make_pair(*i, np));
      }
    }
  }
  for (unsigned j = 0; j < found_path.size(); ++j) {
    fp << m_names[found_path[j]] << "\n";
  }
}

void graph::dfs(unsigned i1, unsigned i2, std::ofstream& fl, const std::vector<unsigned>& path, std::vector<unsigned>& found_path) const
{
  fl << m_names[i1] << "\n";
  if (i1 == i2) {
    if (found_path.empty() || cost(found_path) > cost(path)) {
      found_path = path;
    }
    return;
  }
  std::vector<unsigned>::const_reverse_iterator i;
  for (i = m_adjacent_vertices[i1].rbegin(); i != m_adjacent_vertices[i1].rend(); ++i) {
    if (std::find(path.begin(), path.end(), *i) == path.end()) {
      std::vector<unsigned> np(path);
      np.push_back(*i);
      dfs(*i, i2, fl, np, found_path);
    }
  }
}

void graph::dfs(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const
{
  std::vector<unsigned> path;
  std::vector<unsigned> found_path;
  unsigned i1 = get_index(v1);
  unsigned i2 = get_index(v2);
  path.push_back(i1);
  dfs(i1, i2, fl, path, found_path);
  for (unsigned j = 0; j < found_path.size(); ++j) {
    fp << m_names[found_path[j]] << "\n";
  }
}

/////////////

namespace 
{
  struct ucs_node
  {
    ucs_node(unsigned v, const std::vector<unsigned>& p, double c)
      : m_vertex(v)
      , m_path(p)
      , m_cost(c)
    {
    }

    unsigned m_vertex;
    std::vector<unsigned> m_path;
    double m_cost;
  };

  struct cost_compare
  {
    bool operator()(const ucs_node& r, const ucs_node& l)
    {
      return r.m_cost < l.m_cost;
    }
  };

  typedef std::multiset<ucs_node, cost_compare> ucs_node_queue;

  ucs_node_queue::iterator find_in_queue(ucs_node_queue& q, unsigned v)
  {
    ucs_node_queue::iterator i = q.begin();
    while (i != q.end()) {
      if (i->m_vertex == v) {
        break;
      }
      ++i;
    }
    return i;
  }

}

void graph::ucsr(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const
{
  ucs(v1, v2, fp, fl, &graph::reliable_cost);
}

void graph::ucsu(const std::string& v1, const std::string& v2, std::ofstream& fp, std::ofstream& fl) const
{
  ucs(v1, v2, fp, fl, &graph::unreliable_cost);
}

void graph::ucs(const std::string& v1, const std::string& v2,
  std::ofstream& fp, std::ofstream& fl,
  double (graph::* cost_f) (unsigned, unsigned) const) const
{
  unsigned i1 = get_index(v1);
  unsigned i2 = get_index(v2);
  ucs_node_queue q;
  std::set<unsigned> e;
  std::vector<unsigned> t(1, i1);
  q.insert(ucs_node(i1, t, 0));
  while (!q.empty()) {
    ucs_node n = *q.begin();
    fl << m_names[n.m_vertex] << "\n";
    q.erase(q.begin());
    if (n.m_vertex == i2) {
      for (unsigned j = 0; j < n.m_path.size(); ++j) {
        fp << m_names[n.m_path[j]] << "\n";
      }
      return;
    }
    e.insert(n.m_vertex);
    std::vector<unsigned>::const_iterator i;
    for (i = m_adjacent_vertices[n.m_vertex].begin(); i != m_adjacent_vertices[n.m_vertex].end(); ++i) {
      if (e.find(*i) == e.end()) {
        ucs_node_queue::iterator qi = find_in_queue(q, *i);
        if (qi == q.end()) {
          std::vector<unsigned> np(n.m_path);
          np.push_back(*i);
          q.insert(ucs_node(*i, np, n.m_cost + (this->*cost_f)(n.m_vertex, *i)));
        }
        else {
          if (n.m_cost + (this->*cost_f)(n.m_vertex, *i) < qi->m_cost) {
            q.erase(qi);
            std::vector<unsigned> np(n.m_path);
            np.push_back(*i);
            q.insert(ucs_node(*i, np, n.m_cost + (this->*cost_f)(n.m_vertex, *i)));
          }
        }
      }
    }
  }
}



//////////////
namespace reader
{
  graph* read_graph(const std::string& f);
}

template <typename T>
T to_numeric(const std::string& v)
{
  std::istringstream ss(v);
  T t;
  ss >> t;
  return t;
}


class bad_args
{
public:
  bad_args(const std::string& w)
    : m_error(w)
  {
  }

  const std::string& get_error() const
  {
    return m_error;
  }

private:
  std::string m_error;
};

enum task {
  bfs = 1,
  dfs = 2,
  ucsr = 3,
  ucsu = 4
};

void check_argument(const std::map<std::string, std::string>& args, const std::string& arg)
{
  if (args.find(arg) == args.end()) {
    throw bad_args(arg + " argument is not specified");
  }
}

void parse_arguments(char** argv, task& t, std::string& v1, std::string& v2, std::string& in,
  std::string& outp, std::string& outl)
{
  std::map<std::string, std::string> args;
  for (unsigned i = 0; i < 6; ++i) {
    args[argv[2 * i + 1]] = argv[2 * i + 2];
  }
  check_argument(args, "-t");
  check_argument(args, "-s");
  check_argument(args, "-g");
  check_argument(args, "-i");
  check_argument(args, "-op");
  check_argument(args, "-ol");
  
  unsigned tv = to_numeric<unsigned>(args["-t"]);
  if (tv > 4 || tv == 0) 
  {
    throw bad_args("Task ID is invalid");
  }

  t = static_cast<task>(tv);
  v1 = args["-s"];
  v2 = args["-g"];
  in = args["-i"];
  outp = args["-op"];
  outl = args["-ol"];
}

int main(int argc, char** argv)
{
  //Execute the command in the following format as given in the specification:-
  //search - t <task> -s <start_node> -g <goal_node> -i <input_file> -op <output_path> -ol <output_log>
  //search -t dfs -s A -g M -i input2.txt -op output.txt -ol ollog.txt

  if (argc != 13) {
    std::cout << "Arguments count is invalid" << std::endl;
    return 1;
  }
  task t;
  std::string v1;
  std::string v2;
  std::string in;
  std::string outp;
  std::string outl;
  try 
  {
    parse_arguments(argv, t, v1, v2, in, outp, outl);
  }
  catch (const bad_args& e) 
  {
    std::cout << e.get_error() << std::endl;
    return 1;
  }

  graph* g = nullptr;//reader::read_graph(in);

  if (!g->has_vertex(v1)) 
  {
    std::cout << "The vertex " << v1 << " does not exist in the graph." << std::endl;
    return 1;
  }
  
  if (!g->has_vertex(v2)) 
  {
    std::cout << "The vertex " << v2 << " does not exist in the graph." << std::endl;
    return 1;
  }
  std::ofstream fp(outp.c_str());
  std::ofstream fl(outl.c_str());
  
  switch (t) 
  {
  case bfs:
    g->bfs(v1, v2, fp, fl);
    break;
  case dfs:
    g->dfs(v1, v2, fp, fl);
    break;
  case ucsr:
    g->ucsr(v1, v2, fp, fl);
    break;
  case ucsu:
    g->ucsu(v1, v2, fp, fl);
    break;
  }


  fp.close();
  fl.close();

  system("pause");

  return 0;
}

