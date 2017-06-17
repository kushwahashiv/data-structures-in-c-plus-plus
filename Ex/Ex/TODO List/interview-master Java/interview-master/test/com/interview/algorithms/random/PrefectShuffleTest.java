package com.interview.algorithms.random;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class PrefectShuffleTest extends TestCase {

    public void testShuffleBySwap() throws Exception {
        PrefectShuffle<Integer> shuffler = new PrefectShuffle<>();
        Integer[] array = new Integer[3];
        for(int i = 0; i < array.length; i++) array[i] = i;
        for(int i = 0; i < 50; i++){
            Integer[] copy = array.clone();
            shuffler.shuffleBySwap(copy);
            ConsoleWriter.printIntArray(copy);
        }
    }

    public void testShuffleByPick() throws Exception {
        PrefectShuffle<Integer> shuffler = new PrefectShuffle<>();
        Integer[] array = new Integer[3];
        for(int i = 0; i < array.length; i++) array[i] = i;
        for(int i = 0; i < 50; i++){
            Integer[] copy = array.clone();
            shuffler.shuffleByPick(copy);
            ConsoleWriter.printIntArray(copy);
        }
    }
}