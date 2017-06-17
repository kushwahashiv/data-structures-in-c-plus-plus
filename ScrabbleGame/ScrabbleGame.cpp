/* File: scrabble.cpp
* Implements scrabble
* -------------------
*/

#include <string>
#include <iostream>

int scrabble(std::string str);


/* Function: scrabble
* Usage: int p = scrabble(std::string str);
* Details: given a word, str, and gives the score it would make in the game
* scrabble.
* -------------------------------------------------------------------------
*/

int scrabble(std::string str) {
  int score = 0;
  for (int i = 0; i < str.length(); i++) {
    char letter = str[i];
    switch (letter) {
    case 'A': case 'E': case 'I': case 'L': case 'N':
    case 'O': case 'R': case 'S': case 'T': case 'U':
      score += 1;
      break;
    case 'D': case 'G':
      score += 2;
      break;
    case 'B': case 'C': case 'M': case 'P':
      score += 3;
      break;
    case 'F': case 'H': case 'V': case 'W': case 'Y':
      score += 4;
      break;
    case 'K':
      score += 5;
      break;
    case 'J': case 'X':
      score += 8;
      break;
    case 'Q': case 'Z':
      score += 10;
      break;
    default:
      break;
    }
  }
  return score;
}

int main() {
  std::string str;

  std::cout << "Enter an world";

  getline(std::cin, str);
  std::cout << "The score is: " << scrabble(str) << "\n";

  system("pause");
}