package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class C4_55_DuplicateRemoverTest extends TestCase {

    public void testRemove() throws Exception {
        Integer[] array = TestUtil.generateIntArray(100, 30, 1);
        ConsoleWriter.printIntArray(array);
        Integer[] cleaned = C4_55_DuplicateRemover.remove(array);
        ConsoleWriter.printIntArray(cleaned);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < array.length; i++) {
            if(cleaned[i] != 0){
                assertFalse(set.contains(cleaned[i]));
                set.add(cleaned[i]);
            }
        }
    }
}