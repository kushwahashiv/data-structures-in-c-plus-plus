package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-9
 * Time: 上午12:01
 */
public class C4_1_ArrayRotationTest extends TestCase {
    public void testcase1() throws Exception {
        int[][] array = {{1}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_1_ArrayRotation.rotateOptimized(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();
    }

    public void testcase2(){
        int[][] array = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_1_ArrayRotation.rotateOptimized(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();
    }

    public void testcase3(){
        int[][] array = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_1_ArrayRotation.rotateOptimized(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();
    }

    public void testcase4(){
        int[][] array = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_1_ArrayRotation.rotateOptimized(array);
        ConsoleWriter.printIntArray(array);
        System.out.println();
    }
}
