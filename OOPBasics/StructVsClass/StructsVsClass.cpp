/*
Structure vs class in C++
---------------------------------
In C++, a structure is same as class except the following differences :

1) Members of a class are private by default and members of struct are public by default.
For example program 1 fails in compilation and program 2 works fine.
*/





//#define disable

#ifdef disable

#include <stdio.h>

// Program 1
class Test 
{
  int x; // x is private
};

int main()
{
  Test t;
  t.x = 20; // compiler error because x is private
  return 0;
}

// Program 2
struct Test 
{
  int x; // x is public
};

int main()
{
  Test t;
  t.x = 20; // works fine because x is public
  return 0;
}

/*
2) When deriving a struct from a class / struct, default access - specifier for a base class / struct is public.
And when deriving a class, default access specifier is private.
For example program 3 fails in compilation and program 4 works fine.
*/

// Program 3
class Base 
{
public:
  int x;
};

class Derived : Base { }; // is equilalent to class Derived : private Base {}

int main()
{
  Derived d;
  d.x = 20; // compiler error becuase inheritance is private
  return 0;
}

// Program 4
class Base 
{
public:
  int x;
};

struct Derived : Base { }; // is equilalent to struct Derived : public Base {}

int main()
{
  Derived d;
  d.x = 20; // works fine becuase inheritance is public
  return 0;
}

#else
//dummy
int main(){};
#endif