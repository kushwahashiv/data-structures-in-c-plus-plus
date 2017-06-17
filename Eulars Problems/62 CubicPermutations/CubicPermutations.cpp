#include<iostream>
#include<map>
#include<array>
#include<memory>

class Cube
{
public:
  long N;
  int Perms;
};



long makeLargestPerm(long n)
{
  long k = n;
  std::array<int, 10> digits = {0};

  long retVal = 0;

  while (k > 0)
  {
    digits[k % 10]++;
    k /= 10;
  }

  for (int i = 9; i >= 0; i--)
  {
    for (int j = 0; j < digits[i]; j++)
    {
      retVal = retVal * 10 + i;
    }
  }

  return retVal;
}


int main()
{

  long n = 1000;
  std::map<int, Cube> cubes;

  while (true)
  {
    n++;
    long smallestPerm = makeLargestPerm(n*n*n);

    auto item = cubes.find(smallestPerm);

    if (item != cubes.end())
    {
      Cube* cube = new Cube();
      cube->N = n;
      cube->Perms = 0;
      cubes.insert(std::pair<int, Cube>(smallestPerm, *cube));
    }

    if (++cubes[smallestPerm].Perms == 3) 
    {
      auto result = cubes.find(smallestPerm);
      //result = cubes[smallestPerm];
      break;
    }
  }
}