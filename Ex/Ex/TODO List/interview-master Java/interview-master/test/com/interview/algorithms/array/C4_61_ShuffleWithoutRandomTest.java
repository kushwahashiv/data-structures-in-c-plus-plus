package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_61_ShuffleWithoutRandomTest extends TestCase {

    public void testShuffle() throws Exception {
        int[] array = TestUtil.generateIntArray(15, false);
        ConsoleWriter.printIntArray(array);
        int[] input;
        for(int i = 0; i < 20; i++){
            input = array.clone();
            C4_61_ShuffleWithoutRandom.shuffle(input);
            ConsoleWriter.printIntArray(input);
        }
    }
}