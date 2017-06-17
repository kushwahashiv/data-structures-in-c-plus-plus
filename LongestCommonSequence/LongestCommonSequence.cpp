/*
A subsequence is a sequence that can be derived from another sequence by deleting some elements
without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences 
is a subsequence, with maximal length, which is common to both the sequences.

Given two sequence of integers, A=[a1,a2,…,an] and B=[b1,b2,…,bm], find any one longest common subsequence.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.

*/
#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

const int LEFT = -1, UP = -2, ADD = -3;

class data
{
private:
  vector<int> S1;
  vector<int> S2;
  std::vector<std::vector<int>> LCS;
  std::vector<std::vector<int>> ptrs;

public:
  data(vector<int>a, vector<int>b);
  void calc_longest_common_subsequence();
  vector<int> get_longest_common_subsequence();
  int longest_common_subsequence();
};

data::data(vector<int>a, vector<int>b)
{
  S1 = a;
  S2 = b;

  std::vector<std::vector<int>> lcs(a.size() + 1, std::vector<int>(b.size() + 1));
  std::vector<std::vector<int>> ptr(a.size() + 1, std::vector<int>(b.size() + 1));

  for (unsigned int i = 0; i <= a.size(); i++)
  {
    lcs[i][0] = 0;
    ptr[i][0] = UP;
  }

  for (unsigned int i = 0; i <= b.size(); i++)
  {
    lcs[0][i] = 0;
    ptr[0][i] = LEFT;
  }

  LCS = lcs;
  ptrs = ptr;
}

void data::calc_longest_common_subsequence()
{
  longest_common_subsequence();

  vector <int> lcs = get_longest_common_subsequence();
  reverse(lcs.begin(), lcs.end());

  for (auto i : lcs)
    cout << i << " ";
}

vector <int> data::get_longest_common_subsequence()
{
  vector <int> lcs;
  int i = S1.size(), j = S2.size();

  while (i != 0 && j != 0)
  {
    if (ptrs[i][j] == ADD)
    {
      lcs.push_back(S1[i - 1]);
      i--;
      j--;
    }
    else if (ptrs[i][j] == UP)
      i--;
    else
      j--;
  }

  return lcs;
}

int data::longest_common_subsequence()
{
  int max_length = -1;

  for (unsigned int i = 1; i <= S1.size(); i++)
  {
    for (unsigned int j = 1; j <= S2.size(); j++)
    {
      if (S1[i - 1] == S2[j - 1])
      {
        LCS[i][j] = LCS[i - 1][j - 1] + 1;
        ptrs[i][j] = ADD;
      }
      else if (LCS[i - 1][j] > LCS[i][j - 1])
      {
        LCS[i][j] = LCS[i - 1][j];
        ptrs[i][j] = UP;
      }
      else
      {
        LCS[i][j] = LCS[i][j - 1];
        ptrs[i][j] = LEFT;
      }
      max_length = max(max_length, LCS[i][j]);
    }
  }

  return max_length;
}

int main()
{
  vector<int> x = { 1, 2, 3, 4, 1 };
  vector<int> y = { 3, 4, 1, 2, 1, 3 };

  data myData(x, y);
  myData.calc_longest_common_subsequence();

  system("pause");

  return 0;
}


/*
#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

//const int N = 5, M = 6;
const int LEFT = -1, UP = -2, ADD = -3;

class data
{
private:
vector<int> S1;
vector<int> S2;
std::vector<std::vector<int>> LCS;
std::vector<std::vector<int>> ptrs;

public:
data(vector<int>a, vector<int>b);
void calc_longest_common_subsequence();
vector<int> get_longest_common_subsequence();
int longest_common_subsequence();
void print_sequences();
};

data::data(vector<int>a, vector<int>b)
{
S1 = a;
S2 = b;

std::vector<std::vector<int>> lcs(a.size()+1, std::vector<int>(b.size()+1));
std::vector<std::vector<int>> ptr(a.size()+1, std::vector<int>(b.size()+1));

for(int i = 0; i <= a.size(); i++)
{
lcs[i][0] = 0;
ptr[i][0] = UP;

//LCS[i][0] = 0;
//ptrs[i][0] = UP;
}

for (int i = 0; i <= b.size(); i++)
{
lcs[0][i] = 0;
ptr[0][i] = LEFT;
}

LCS = lcs;
ptrs = ptr;
}

void data::calc_longest_common_subsequence()
{
cout << "The length of the longest common subsequence, S3, is " << longest_common_subsequence() << endl;

vector <int> lcs = get_longest_common_subsequence();
reverse(lcs.begin(), lcs.end());

cout << "One longest common subsequence is '";
for (auto i :lcs)
cout << i;
cout << "'" << endl;
}

vector <int> data::get_longest_common_subsequence()
{
vector <int> lcs;
int i = S1.size(), j = S2.size();

while (i != 0 && j != 0)
{
if (ptrs[i][j] == ADD)
{
lcs.push_back(S1[i - 1]);
i--;
j--;
}
else if (ptrs[i][j] == UP)
i--;
else
j--;
}

return lcs;
}

int data::longest_common_subsequence()
{
int max_length = -1;

for (int i = 1; i <= S1.size(); i++)
{
for (int j = 1; j <= S2.size(); j++)
{
if (S1[i - 1] == S2[j - 1])
{
LCS[i][j] = LCS[i - 1][j - 1] + 1;
ptrs[i][j] = ADD;
}
else if (LCS[i - 1][j] > LCS[i][j - 1])
{
LCS[i][j] = LCS[i - 1][j];
ptrs[i][j] = UP;
}
else
{
LCS[i][j] = LCS[i][j - 1];
ptrs[i][j] = LEFT;
}
max_length = max(max_length, LCS[i][j]);
}
}

return max_length;
}

void data::print_sequences()
{
cout << "The sequence, S1, is " << endl;
for (auto i : S1)
cout << i << ' ';
cout << endl;

cout << "The sequence, S2, is " << endl;
for (auto i : S2)
cout << i << ' ';
cout << endl;
}

int main()
{
int m = 5;
int n = 6;

vector<int> x = { 1, 2, 3, 4, 1 };
vector<int> y = { 3, 4, 1, 2, 1, 3 };

data myData(x, y);
myData.calc_longest_common_subsequence();

system("pause");

return 0;
}
*/