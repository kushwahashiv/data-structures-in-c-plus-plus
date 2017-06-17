package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-23
 * Time: 下午11:06
 */
public class C1_25_BetProblemTest extends TestCase {
    public void testGetFinalAmount() throws Exception {
        int result = C1_25_BetProblem.getFinalAmount(15, "LLLWLLLL");
        assertEquals(1, result);

        result = C1_25_BetProblem.getFinalAmount(12, "WWWWWWWW");
        assertEquals(20, result);

        result = C1_25_BetProblem.getFinalAmount(2, "WLLWLLLL");
        assertEquals(0, result);

        result = C1_25_BetProblem.getFinalAmount(2, "LLLWLLLL");
        assertEquals(1, result);

    }
}
