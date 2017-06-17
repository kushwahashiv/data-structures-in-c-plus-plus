package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_44_RearrangeArrayTest extends TestCase {

    public void testRearrange() throws Exception {
        Integer[] array = TestUtil.generateIntArray(10, 100, 1);
        ConsoleWriter.printIntArray(array);

        C4_44_RearrangeArray.rearrange(array);
        ConsoleWriter.printIntArray(array);

        boolean shouldOdd = true;
        for(int i = 0; i < array.length; i++){
            if(shouldOdd && array[i] % 2 == 0)  shouldOdd = false;
            if(!shouldOdd) assertTrue(array[i] % 2 == 0);
        }
    }
}