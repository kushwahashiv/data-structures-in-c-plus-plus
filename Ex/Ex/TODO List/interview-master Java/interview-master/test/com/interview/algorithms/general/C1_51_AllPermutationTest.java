package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_51_AllPermutationTest extends TestCase {

    public void testPrintRecursive() throws Exception {
        Character[] chars = new Character[]{'a','b','c','d'};
        C1_51_AllPermutation.printRecursive(chars);
    }

    public void testPrintDicSort() throws Exception {
        Character[] chars = new Character[]{'a','b','c','d'};
        C1_51_AllPermutation.printDicSort(chars);
    }
}