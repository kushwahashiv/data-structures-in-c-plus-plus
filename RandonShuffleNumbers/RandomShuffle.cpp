/*
Problem:
  Random shuffle the deck.
*/

//1. Using STD random_reshuffle function
/*
#include <iostream>     // std::cout
#include <algorithm>    // std::random_shuffle
#include <vector>       // std::vector
#include <ctime>        // std::time
#include <cstdlib>      // std::rand, std::srand

// random generator function
int myrandom(int i) 
{ 
  return std::rand() % i; 
}

int main() 
{
  std::srand(unsigned(std::time(0)));
  std::vector<int> myvector;

  // set some values:
  for (int i = 1; i < 10; ++i)
  {
    myvector.push_back(i); // 1 2 3 4 5 6 7 8 9
  }

  // using built-in random generator:
  std::random_shuffle(myvector.begin(), myvector.end());

  // using myrandom:
  std::random_shuffle(myvector.begin(), myvector.end(), myrandom);

  // print out content:
  std::cout << "myvector contains:";
  for (std::vector<int>::iterator it = myvector.begin(); it != myvector.end(); ++it)
  {
    std::cout << ' ' << *it;
  }

  std::cout << '\n';

  system("Pause");

  return 0;
}


//Output using std::random_shuffle
//myvector contains: 5 8 9 6 4 7 1 2 3

//Output using myrandom
//myvector contains : 7 8 9 3 4 2 5 6 1

 */

//2. Using STD rand() function



#include<iostream>

#define DECK_SIZE 24

void shuffle(int deck[])
{
  int deckSize = DECK_SIZE, temp;
  while (deckSize > 1)
  {
    long k = rand() % DECK_SIZE;
    deckSize--;
    temp = deck[deckSize];
    deck[deckSize] = deck[k];
    deck[k] = temp;
  }
}


int main(int argc, char **argv)
{
  int deck[DECK_SIZE], i;

  for (i = 0; i < DECK_SIZE; ++i)
  {
    deck[i] = i + 1;
  }

  shuffle(deck);
  for (i = 0; i < DECK_SIZE; ++i)
  {
    std::cout << deck[i] << " ";
  }

  std::cout << std::endl;

  system("pause");

  return 0;
}


//Output
//1 17 19 11 14 16 9 24 2 23 4 15 3 7 10 6 20 13 21 8 5 12 22 18



