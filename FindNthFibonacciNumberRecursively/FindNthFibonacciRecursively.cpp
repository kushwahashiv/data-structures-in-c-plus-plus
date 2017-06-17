/*
Problem:
Find nth Fibonacci number using recursive templates
*/

#include <iostream>

template< unsigned N >
struct FIB
{
  enum { RESULT = FIB<N - 1>::RESULT + FIB<N - 2>::RESULT };
};

template<>
struct FIB<0> 
{
  enum { RESULT = 0 };
};

template<>
struct FIB<1>
{
  enum { RESULT = 1 };
};

int main()
{
  std::cout << "FIB(10): " << FIB<22>::RESULT << std::endl;

  system("pause");
  return EXIT_SUCCESS;
}