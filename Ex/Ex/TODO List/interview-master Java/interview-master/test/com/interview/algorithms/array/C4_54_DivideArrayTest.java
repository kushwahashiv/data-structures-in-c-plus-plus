package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_54_DivideArrayTest extends TestCase {
    public void testRandom(){
        int[] array = TestUtil.generateIntArray(10, 100, 1, false);
        testDivide(array);
    }

    public void testcase1(){
        int[] array = new int[]{70, 70, 75, 83, 89, 54, 28, 97, 67, 81};
        testDivide(array);
    }

    public void testcase2(){
        int[] array = new int[]{98, 21, 50, 35, 54, 20, 1, 5, 87};
        testDivide(array);
    }

    public void testDivide(int[] array) {

        ConsoleWriter.printIntArray(array);
        boolean[] mark = C4_54_DivideArray.divide(array);
        ConsoleWriter.printBooleanArray(mark);
        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < mark.length; i++){
            if(mark[i]) sumA += array[i];
            else sumB += array[i];
        }
        System.out.println(sumA);
        System.out.println(sumB);
        int diff = Math.abs(sumA - sumB);
        System.out.println(diff);
        for(int i = 0; i < array.length; i++){
            assertTrue(diff < array[i] * 2);
        }

    }

    //
    //
}