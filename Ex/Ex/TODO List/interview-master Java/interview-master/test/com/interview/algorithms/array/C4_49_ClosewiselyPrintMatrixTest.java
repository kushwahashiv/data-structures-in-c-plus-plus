package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-26
 * Time: 上午9:17
 */
public class C4_49_ClosewiselyPrintMatrixTest extends TestCase {
    public void testPrint1() throws Exception {
        int[][] array = {{1}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_49_ClosewiselyPrintMatrix.print(array);
    }

    public void testPrint2() throws Exception {
        int[][] array = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_49_ClosewiselyPrintMatrix.print(array);
    }

    public void testPrint3() throws Exception {
        int[][] array = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_49_ClosewiselyPrintMatrix.print(array);
    }

    public void testPrint4() throws Exception {
        int[][] array = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25},{26,27,28,29,30}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_49_ClosewiselyPrintMatrix.print(array);
    }

    public void testPrint5() throws Exception {
        int[][] array = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        ConsoleWriter.printIntArray(array);
        System.out.println();
        C4_49_ClosewiselyPrintMatrix.print(array);
    }
}
