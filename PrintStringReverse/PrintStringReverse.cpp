/*****************************************************
* Complete the PrintReverse function below using 
* recursion. The function should print the characters
* in the string in reverse order.         
* For example, 'Hello' entered would output 'olleH'  
******************************************************/

#include <tchar.h>
#include <iostream>

void PrintReverse(const char* aString);

void reverse(char string[])
{
  char temp;
  char* begin = string;
  char* end = string + strlen(string) -1;
  while(begin < end)
  {
    temp = *begin;
    *begin = *end;
    *end = temp;

    ++begin;
    --end;
  }
  std::cout<<std::endl<< string<< std::endl;
}

int _tmain(int argc, _TCHAR* argv[])
{
	char szString[100] = "";

	std::cout << "Enter String: ";

	std::cin.getline(szString, sizeof(szString) - 1);
		
	PrintReverse(szString);
  reverse(szString);

	return 0;
}

void PrintReverse(const char* aString)
{
	if(*aString != '\0' ) 
		PrintReverse(aString + 1);
	
	std::cout<<*aString;
}