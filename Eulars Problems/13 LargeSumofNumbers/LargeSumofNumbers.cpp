/*
Problem Statement

This problem is a programming version of Problem 13 from projecteuler.net

Work out the first ten digits of the sum of N 50-digit numbers.

Input Format
First line contains N, next N lines contain a 50 digit number each.

Output Format
Print only first 10 digit of the final sum

Constraints
1≤N≤103

Sample Input

5
37107287533902102798797998220837590246510135740250
46376937677490009712648124896970078050417018260538
74324986199524741059474233309513058123726617309629
91942213363574161572522430563301811072406154908250
23067588207539346171171980310421047513778063246676


Sample Output
2728190129
*/


#include<iostream>
#include<vector>

template <class T>
int numDigits(T number)
{
  int digits = 0;
  if (number < 0) digits = 1; // remove this line if '-' counts as a digit
  while (number) {
    number /= 10;
    digits++;
  }
  return digits;
}


std::vector<int> AddNumbers(std::vector<int> numbers)
{
  std::vector<int> sumOfNumbers;
  int digitSum = 0;
  bool flag = true;
  int maxNumDigits = 0;

  do
  {
    for (unsigned int j = 0; j < numbers.size(); j++)
    {
      //determine the max digits length
      if (flag)
      {
        int digits = numDigits(numbers[j]);
        if (digits > maxNumDigits)
        {
          maxNumDigits = digits;
        }
      }
      digitSum += numbers[j] % 10;
      numbers[j] /= 10;
      
    }
    sumOfNumbers.push_back(digitSum % 10);
    digitSum /= 10;
    flag = false;
  }
  while (--maxNumDigits);

  std::reverse(sumOfNumbers.begin(), sumOfNumbers.end());
  return sumOfNumbers;
}


int main()
{
  std::vector<int> numbers = { 12323232, 1029};
  auto sum = AddNumbers(numbers);
  for (auto i : sum)
  {
    std::cout << i;
  }

  std::cout << std::endl;

  system("pause");
  
  return 0;
}

/*
sum_of_numbers = []
digit_sum = 0

for i in range(50) :
for j in range(len(numbers)) :
digit_sum += int(numbers[j] % 10)
numbers[j] //= 10
sum_of_numbers.append(digit_sum % 10)
digit_sum //= 10

sum_of_numbers = str(digit_sum) + ''.join([str(x) for x in sum_of_numbers[:: - 1]])
return sum_of_numbers[:10]


if __name__ == "__main__":
N = int(input(""))
count = 0
numbers = []
while count < N :
  n = int(input())
  numbers.append(n)
  count = count + 1
  print(LargestSum(numbers))
*/