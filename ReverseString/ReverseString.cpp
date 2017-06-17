/*****************************************************
* Complete the ReverseString function below. The     
* function should reverse a string in place.         
* For example, 'Hello' entered would output 'olleH'  
******************************************************/

#include <tchar.h>
#include <iostream>

void ReverseString(char* const szString);

int _tmain(int argc, _TCHAR* argv[])
{
	char szString[100] = "";

	std::cout << "Enter String: ";

	std::cin.getline(szString, sizeof(szString) - 1);
		
	ReverseString(szString);

	std::cout << "Reversed String: " << szString << std::endl;

	return 0;
}

void ReverseString(char* const szString)
{
	char* Begin = szString;
	char* End = szString + strlen(szString) - 1;
	char TempChar = '\0';

	while(Begin < End)
	{
		TempChar = *Begin;
		*Begin = *End;
		*End = TempChar;

		Begin++;
		End--;
	}
}

