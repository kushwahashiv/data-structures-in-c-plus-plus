/**********************************************************************
* Complete the BitCount function below.  The result from the function 
* should equal the number of bits that are set.                       
* For example if 0101 1111 is passed in, the return value = 6          
**********************************************************************/

#include <tchar.h>
#include <iostream>

int BitCount(unsigned char uc);

int _tmain(int argc, _TCHAR* argv[])
{
	unsigned char uc = 0x82;
	
	int iResult = 0;
	iResult = BitCount(uc);
	std::cout << "Bit Count = " << iResult << std::endl;
	
	return 0;
}

int BitCount(unsigned char uc)
{
	int n = 0;

	while (uc) 
	{
		++n;
		uc &= uc - 1;
	}
	
	return n;
}

