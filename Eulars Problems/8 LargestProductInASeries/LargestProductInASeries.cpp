#include <iostream>
#include <vector>
#include <string>
#include <cinttypes>

using namespace std;

int main()
{
  int greatestProduct(0);
  int product(1);

  std::vector<int> arr;
  int T;
  std::cin >> T;

  for (int i = 0; i < T; i++)
  {
    int N, K;
    std::cin >> N >> K;

    std::string number;
    std::cin>>number;

    if (number.size() == N)
    {
      uint64_t product = 1;
      uint64_t max_product;
      std::vector<uint8_t> product_digits(K);
      for (size_t i = 0; i < K; i++) 
      {
        product_digits[i] = number[i] - '0';
        product *= product_digits[i];
      }
      max_product = product;
      int zero_for_next = 0;

      for (size_t i = K; i < number.length(); i++)
      {
        // use the modulo operator to minimize overwrites
        product_digits[i % K] = number[i] - '0';
        if (number[i] == '0') 
        {
          zero_for_next = K;
          continue;
        }
        else if (zero_for_next < 1) 
        {
          product = 1;
          // the order in which the product is taken is not important
          for (uint8_t digit : product_digits) 
          {
            product *= digit;
          }

          if (product > max_product) 
          {
            max_product = product;
          }
        }
        zero_for_next--;
      }
      arr.push_back(max_product);
    }
  }

  for (auto result : arr)
  {
    std::cout<< result << std::endl;
  }


  system("pause");

  return 0;
}

