/*
* Created_By: Shiv S. Kushwaha
* Date: 15/11/2014
* Time: 5:20 PM
*
* The problem:
* Given an image represented by an N*N matrix,
* where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
* Can you do this in place?

Example:
/*2th+ ->
[0][0] .....[0][3]
[n][n+i]
[0][0]          1   2   3   4  [n+i][m] [0][3]
\ 1th-        5   6   7   8              \ 1th+
\             9  10  11  12             \
[3][0] [m-i][n] 13  14  15  16          [3][3]
[m][m-i]
[3][0] .....[3][3]
<-2th-
*/




//JAVA code it is 



/*
class C4_1_ArrayRotation 
{
  static void rotateOptimized(int[][] a){
    for (int layer = 0; layer < a.length / 2; layer++){
      int last = a.length - 1 - layer;
      for (int i = 0; i < last - layer; i++){
        int tmp = a[layer][layer + i];
        a[layer][layer + i] = a[last - i][layer];
        a[last - i][layer] = a[last][last - i];
        a[last][last - i] = a[layer + i][last];
        a[layer + i][last] = tmp;
      }
    }
  }

  static void rotate(int[][] array)
  {
    int rows = array.length;
    int cols = array[0].length;
    for (int i = 0; i < rows / 2; i++)
      for (int j = i; j < cols - 1 - j; j++) {
        int tmp = array[i][j];
        array[i][j] = array[rows - 1 - i][j];
        array[rows - 1 - i][j] = array[rows - 1 - i][cols - 1 - j];
        array[rows - 1 - i][cols - 1 - j] = array[i][cols - 1 - j];
        array[i][cols - 1 - j] = tmp;
      }
  }

  static void run(int[][] array)
  {
    C4_1_ArrayRotation rotator = new C4_1_ArrayRotation();
    System.out.println("\nBefore Rotation:");
    ConsoleWriter.printIntArray(array);
    System.out.println("After Rotation:");
    rotator.rotate(array);
    ConsoleWriter.printIntArray(array);
  }

}


int main(String[] args)
{
  int[][] array = { { 1 } };
  run(array);
  array = new int[][] {{1, 2, 3, 4}, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }};
  run(array);
  array = new int[][] {{1, 2, 3}, { 4, 5, 6 }, { 7, 8, 9 }};
  run(array);
}

*/


int main()
{

};