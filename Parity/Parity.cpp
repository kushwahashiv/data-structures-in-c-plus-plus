/**********************************************************************
* Complete the ParityCheck function below.  The result from the function 
* should equal 1 if the parity is even, 0 if it is odd                       
* For example if 0101 1111 is passed in, the return value = 1          
**********************************************************************/

#include <tchar.h>
#include <iostream>

unsigned char ParityCheck(unsigned char uc);

int _tmain(int argc, _TCHAR* argv[])
{
	unsigned char uc = 0x5F;
	
	unsigned char aResult = 0;
	aResult = ParityCheck(uc);
	std::cout << "Even Parity = " << (aResult != 0) << std::endl;
	
	return 0;
}

unsigned char ParityCheck(unsigned char uc)
{
	int n = 0;

	while (uc) 
	{
		++n;
		uc &= uc - 1;
	}

	return n;
}

