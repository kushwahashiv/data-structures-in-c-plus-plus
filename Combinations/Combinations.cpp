#include<iostream>
#include<ctime>
//#include<cmath>

int n; // input array length
int p; // variable to store choose 'k' for the sake of printing
int count; // variable to store number of permutations/combinations

//print
int visit(int A[], int p)
{
  for (int i = 1; i <= p; i++)
  {
    std::cout << A[i] << " ";
  }
  std::cout << std::endl;

  count++;
  return 0;
}

/*
Function to generate combinations for a set of input. (Uses recursion calls)
Pre condition: Some location of A has already been taken by i+1 to n elements
Post condition: Selects k objects from i to i and assigns to the combination
*/
int combination(int A[], int i, int k)
{
  if (k == 0)
  {
    visit(A, p);
  }
  else if (i < k)
  {
    return 0;
  }
  else 
  {
    A[k] = i;
    combination(A, i - 1, k - 1);
    A[k] = 0;
    combination(A, i - 1, k);
  }
}

//Function to generate the permutations of A - Does so in lexicographic order
void permutation(int A[], int i, int k)
{
  int j = n - 1;
  int l = n;
  if (p > 0 && p != n - 1)
  {
    visit(A, p);
  }

  do 
  {
    if (j == 0) 
      break;
    if (j <= p)
    {
      visit(A, p);
    }

    l = n - 1;
    j = n - 2;
    while ((A[j] >= A[j + 1]) && j > 0)
    {
      j--;
    }
    while ((A[j] >= A[l]) && l > 0)
    {
      l--;
    }

    int temp;
    temp = A[j];
    A[j] = A[l];
    A[l] = temp;

    int k = j + 1;
    l = n - 1;

    while (k < l && l>0) 
    {
      temp = A[k];
      A[k] = A[l];
      A[l] = temp;

      k++;
      l--;
    }

  } while (1);


}

enum Type
{
  CMOBINATION = 0,
  PERMUTATION
} ;


int main()
{
  clock_t start, end;
  int dur = 0;

  start = clock();

  n = 0;
  count = 0;
  int k = 0;

  //n choose r i.e. nCr

  n = 9;  //Combination from 1-9 digits
  k = 3;  //Combinations of 3 digits

  p = k;

  Type v = Type::CMOBINATION; //default calculate combination

  switch (v)
  {
  case Type::CMOBINATION: // Combination
  {
    if (k != 0)
    {
      int* A = new int(n);
      for (int i = 0; i < n; i++)
      {
        A[i] = 0;
      }
      combination(A, n, k);
    }
  }
  break;
  case Type::PERMUTATION: // permutation
  {
    n++;
    int * A = new int(n); //extra memory for the sentinel to be placed first
    for (int i = 1; i < n; i++)
    {
      A[i] = i;
    }
    A[0] = 0;
    permutation(A, n, k);
  }
  break;

  default:
    break;

  }

  end = clock();

  dur = (int)round((double)(end - start) / CLOCKS_PER_SEC * 1000);
  std::cout << count << " " << dur << std::endl;

  std::system("pause");

  return 0;
}