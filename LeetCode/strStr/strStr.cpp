// Source : https://leetcode.com/problems/implement-strstr/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-07-19

/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/
#include <iosteram>
#include <time.h>

// https://leetcode.com/problems/implement-strstr/discuss/12956
int strStr(string haystack, string needle) {
  int m = haystack.length(), n = needle.length();
  if (!n) return 0;
  for (int i = 0; i < m - n + 1; i++) {
    int j = 0;
    for (; j < n; j++)
      if (haystack[i + j] != needle[j])
        break;
    if (j == n) return i;
  }
  return -1;
}

int main(int argc, char** argv)
{
  srand(time(0));
  const char* haystack = "mississippi";
  const char* needle = "issi";
  printf("%s, %s : %s\n", haystack, needle, strStr((char*)haystack, (char*)needle));

  haystack = "mississippi";
  needle = "issip";
  printf("%s, %s : %s\n", haystack, needle, strStr((char*)haystack, (char*)needle));


  haystack = "babbbbbabb";
  needle = "bbab";
  printf("%s, %s : %s\n", haystack, needle, strStr1((char*)haystack, (char*)needle));

  if (argc > 2) {
    haystack = argv[1];
    needle = argv[2];
    printf("%s, %s : %s\n", haystack, needle, strStr((char*)haystack, (char*)needle));
  }

  return 0;
}
