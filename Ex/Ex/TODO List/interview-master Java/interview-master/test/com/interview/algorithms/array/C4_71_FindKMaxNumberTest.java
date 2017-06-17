package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created_By: stefanie
 * Date: 14-10-24
 * Time: 下午2:39
 */
public class C4_71_FindKMaxNumberTest extends TestCase {
    static int[] array = TestUtil.generateIntArray(20, false);
    static int[] expected = null;
    public void testHeap(){
        int[] kmax = C4_71_FindKMaxNumber_Heap.find(array.clone(), 10);
        testFind(kmax);
    }

    public void testQuickFind(){
        int[] kmax = C4_71_FindKMaxNumber_QuickFind.find(array.clone(), 10);
        testFind(kmax);
    }


    public void testFind(int[] kmax) {
        ConsoleWriter.printIntArray(array);
        ConsoleWriter.printIntArray(kmax);
        if(expected == null){
            int[] clone = array.clone();
            Arrays.sort(clone);
            expected = new int[10];
            for(int i = 0; i < expected.length; i++) expected[expected.length - i - 1] = clone[array.length - i - 1];
            ConsoleWriter.printIntArray(expected);
        }
        for(int i = 0; i < 10; i++){
            assertTrue(Arrays.binarySearch(expected, kmax[i]) >= 0);
        }

    }
}
