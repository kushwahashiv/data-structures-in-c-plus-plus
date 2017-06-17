/*
Project Euler #63: Powerful digit counts

The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.

How many n-digit positive integers exist which are also an nth power?

http://blog.dreamshire.com/project-euler-62-solution/
http://www.mathblog.dk/project-euler-63-n-digit-nth-power/

*/

#include<iostream>
#include<math.h>


int numDigits(int number)
{
  int digits = 0;
  if (number < 0) digits = 1; 
  while (number)
  {
    number /= 10;
    digits++;
  }
  return digits;
}


auto main()-> int
{
  int result = 0;
  int lower = 0;

  int power = 2;
  
  for (int base = 2; base< 100; base++)
  {
    int test = int(pow(base, power));
    int testLen = numDigits(test);
    if (testLen == power)
    {
      std::cout << test << std::endl;
    }
    
    if (testLen > power)
      break;
  }

  system("pause");

  return 0;
}