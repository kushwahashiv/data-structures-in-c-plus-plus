#include <stdlib.h>
#include <tchar.h>
#include <iostream>

#define Method 1

// Method 1 - Using Simple metod
//----------------------------------------------------------------------------
bool isPalindrome( char* pStr )
{
  if ( pStr == nullptr )
   return false;
 
  char* pEnd = pStr;
  while ( *pEnd != '\0' )
    pEnd++;
 
  pEnd--; /* set pEnd to point to last character*/
 
  while(pEnd > pStr)
  {
    if ( *pEnd != *pStr )
      return false;
 
    pEnd--; 
    pStr++;
  }
 
  return true;
}

// Method 2 - Using Alogorithm
//----------------------------------------------------------------------------
#include <string>
#include <algorithm>
 
bool is_palindrome(std::string const& s)
{
  return std::equal(s.begin(), s.end(), s.rbegin());
}


/*---------------------------------------------------------------------------*/
int _tmain(int argc, _TCHAR* argv[])
{
  char szString[100] = "";
  std::cout << "Enter String: ";
  std::cin.getline(szString, sizeof(szString) - 1);

#if Method
  if(isPalindrome(szString))
#else
  if(is_palindrome(szString))
#endif
  {
    std::cout <<szString<<  "\nString is a palindrom."<< std::endl;
  }
  else
  {
    std::cout <<szString<<  "\nString is NOT a palindrom."<< std::endl;
  }

  system( "pause \"Press any key to continue...\"" );
  return 0;
}


