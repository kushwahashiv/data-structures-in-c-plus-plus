

/*

Shows vtable abd memory layout

http://mentorembedded.github.io/cxx-abi/cxx-vtable-ex.html


vptr (Virtual Pointer):
--------------------------
> it’s the pointer which contain address of Virtual Table.
> vptr is associated with object, each object is having a different vptr pointing to same 3.
> vptr is been added to object’s memory space only if atleast one virtual function is declared in a class.
> vptr is always been the first private member automatically added in a class by compiler.
> address of vptr is equal to base address of object. So if the base address of object get’s corrupted, 
  invoking virtual function with corrupted object results into application crash.

Virtual Table (VTable):
---------------------------
> it’s a memory space reserved by compiler to place entries of the functions which are declared as virtual. 
  The entries of virtual functions in VTable is according to their declaration in class. 
> virtual table is associated with a class, so there will always been one VTable irrespective of any number of objects 
  created for that class and each object share the same VTable.


Note:
--------
Virtual function tables consist of addresses of virtual methods in the order of their first appearance. 
Addresses of overloaded functions replace addresses of functions from base classes.

*/


#include<iostream>

using namespace std;


class A 
{
public:
  virtual void f ();
  virtual void g ();
  virtual void h ();
  int ia;
};

class B: public virtual A 
{
public:
  void f ();
  void h ();
  int ib;
};

class C: public virtual A 
{
public:
 // void g ();
 // void h ();
 // int ic;
};

class D: public B, public C 
{
public:
  int id;
  void h();
};

auto main() ->int
{
//  A* a1 = new D();
   cout<<"Size of A: "<< sizeof(A)<<endl;
   cout<<"Size of B: "<< sizeof(B)<<endl;
   cout<<"Size of C: "<< sizeof(C)<<endl;
   cout<<"Size of D: "<< sizeof(D)<<endl;

  getchar();
  return 0;
}



/*
//Simple Multiple Inheritance

class A
{
public:
  int a;
  virtual void v();
};

class B
{
public:
  int b;
  virtual void w();
};

class C : public A, public B 
{
public:
  int c;
};


In above case, objects of type C are laid out like this:

                           +-----------------------+
                           |     0 (top_offset)    |
                           +-----------------------+
c --> +----------+         | ptr to typeinfo for C |
      |  vtable  |-------> +-----------------------+
      +----------+         |         A::v()        |
      |     a    |         +-----------------------+
      +----------+         |    -8 (top_offset)    |
      |  vtable  |---+     +-----------------------+
      +----------+   |     | ptr to typeinfo for C |
      |     b    |   +---> +-----------------------+
      +----------+         |         B::w()        |
      |     c    |         +-----------------------+
      +----------+

*/



/*

class A 
{
public:
  int a;
  virtual void v();
};

class B 
{
public:
  int b;
  virtual void w();
};

class C : public A, public B 
{
public:
  int c;
  void w();
};




//C's object layout and vtable now look like this:

                           +-----------------------+
                           |     0 (top_offset)    |
                           +-----------------------+
c --> +----------+         | ptr to typeinfo for C |
      |  vtable  |-------> +-----------------------+
      +----------+         |         A::v()        |
      |     a    |         +-----------------------+
      +----------+         |         C::w()        |
      |  vtable  |---+     +-----------------------+
      +----------+   |     |    -8 (top_offset)    |
      |     b    |   |     +-----------------------+
      +----------+   |     | ptr to typeinfo for C |
      |     c    |   +---> +-----------------------+
      +----------+         |    thunk to C::w()    |
                           +-----------------------+

*/


/*
//The Diamond: Multiple Copies of Base Classes (non-virtual inheritance)

class A 
{
public:
  int a;
  virtual void v();
};

class B : public A 
{
public:
  int b;
  virtual void w();
};

class C : public A 
{
public:
  int c;
  virtual void x();
};

class D : public B, public C 
{
public:
  int d;
  virtual void y();
};



Note that D inherits from both B and C, and B and C both inherit from A.
This means that D has two copies of A in it. 
The object layoutand vtable embedding is what we would expect from the previous sections:

                           +-----------------------+
                           |     0 (top_offset)    |
                           +-----------------------+
d --> +----------+         | ptr to typeinfo for D |
      |  vtable  |-------> +-----------------------+
      +----------+         |         A::v()        |
      |     a    |         +-----------------------+
      +----------+         |         B::w()        |
      |     b    |         +-----------------------+
      +----------+         |         D::y()        |
      |  vtable  |---+     +-----------------------+
      +----------+   |     |   -12 (top_offset)    |
      |     a    |   |     +-----------------------+
      +----------+   |     | ptr to typeinfo for D |
      |     c    |   +---> +-----------------------+
      +----------+         |         A::v()        |
      |     d    |         +-----------------------+
      +----------+         |         C::x()        |
                           +-----------------------+

Of course, we expect A's data (the member a) to exist twicein D's object layout (and it is), 
and we expect A's virtual member functionsto be represented twice in the vtable (and A::v() is indeedthere). 
Okay, nothing new here.
*/



/*
//The Diamond: Single Copies of Virtual Bases

class A 
{
public:
  int a;
  virtual void v();
};

class B : public virtual A
{
public:
  int b;
  virtual void w();
};

class C : public virtual A
{
public:
  int c;
  virtual void x();
};

class D : public B, public C
{
public:
  int d;
  virtual void y();
};


D object's layout

                                   +-----------------------+
                                   |   20 (vbase_offset)   |
                                   +-----------------------+
                                   |     0 (top_offset)    |
                                   +-----------------------+
                                   | ptr to typeinfo for D |
                      +----------> +-----------------------+
d --> +----------+    |            |         B::w()        |
      |  vtable  |----+            +-----------------------+
      +----------+                 |         D::y()        |
      |     b    |                 +-----------------------+
      +----------+                 |   12 (vbase_offset)   |
      |  vtable  |---------+       +-----------------------+
      +----------+         |       |    -8 (top_offset)    |
      |     c    |         |       +-----------------------+
      +----------+         |       | ptr to typeinfo for D |
      |     d    |         +-----> +-----------------------+
      +----------+                 |         C::x()        |
      |  vtable  |----+            +-----------------------+
      +----------+    |            |    0 (vbase_offset)   |
      |     a    |    |            +-----------------------+
      +----------+    |            |   -20 (top_offset)    |
                      |            +-----------------------+
                      |            | ptr to typeinfo for D |
                      +----------> +-----------------------+
                                   |         A::v()        |
                                   +-----------------------+


*/


/*

class A
{
  int a1;
public:
  virtual int A_virt1();
  virtual int A_virt2();
  static void A_static1();
  void A_simple1();
};

class B
{
  int b1;
  int b2;
public:
  virtual int B_virt1();
  virtual int B_virt2();
};

class C : public A, public B
{
  int c1;
public:
  virtual int A_virt2();
  virtual int B_virt2();
};



    class A size(8):
        +---
     0  | {vfptr}
     4  | a1
        +---

    A's vftable:
     0  | &A::A_virt1
     4  | &A::A_virt2


    class B size(12):
        +---
     0  | {vfptr}
     4  | b1
     8  | b2
        +---

    B's vftable:
     0  | &B::B_virt1
     4  | &B::B_virt2

    class C size(24):
        +---
        | +--- (base class A)
     0  | | {vfptr}
     4  | | a1
        | +---
        | +--- (base class B)
     8  | | {vfptr}
    12  | | b1
    16  | | b2
        | +---
    20  | c1
        +---

    C's vftable for A:
     0  | &A::A_virt1
     4  | &C::A_virt2

    C's vftable for B:
     0  | &B::B_virt1
     4  | &C::B_virt2

*/


