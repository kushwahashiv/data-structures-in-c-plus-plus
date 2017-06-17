package com.interview.algorithms.array;

import com.interview.utils.models.Pair;
import junit.framework.TestCase;

import java.util.List;

public class C4_32_PairSumKTest extends TestCase {
    Integer[] a = new Integer[] {4,2,11,5,7,15,1};

    public void testFindPair() throws Exception {
        Pair<Integer> p = C4_32_PairSumK.findPairBySort(a, 18);
        assertNotNull(p);
        assertTrue(p.i == 11 || p.j == 11);
        assertTrue(p.i == 7 || p.j == 7);
    }

    public void testNotFindPair(){
        Pair<Integer> p = C4_32_PairSumK.findPairBySort(a, 10);
        assertNull(p);

        p = C4_32_PairSumK.findPairBySort(a, 40);
        assertNull(p);
    }

    public void testFindPairs(){
        Integer[] a = new Integer[]{1,8,7,2,5,3};

        List<Pair> pairs = C4_32_PairSumK.findPairs(a, 9);
        assertEquals(2, pairs.size());
        for(Pair<Integer> p : pairs) System.out.printf("%d-%d\n", p.i, p.j);

        pairs = C4_32_PairSumK.findPairsON(a, 9);
        assertEquals(4, pairs.size());
        for(Pair<Integer> p : pairs) System.out.printf("%d-%d\n", p.i, p.j);
    }
}