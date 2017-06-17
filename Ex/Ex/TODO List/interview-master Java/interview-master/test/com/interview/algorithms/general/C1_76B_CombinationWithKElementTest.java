package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午4:08
 */
public class C1_76B_CombinationWithKElementTest extends TestCase {
    public void testCombine() throws Exception {
        List<List<Integer>> combinations = C1_76B_CombinationWithKElement.combine(4, 2);
        //ConsoleWriter.print(combinations);
        assertEquals(6, combinations.size());
    }
}
