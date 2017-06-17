package com.interview.algorithms.dp;

import com.interview.algorithms.dp.C12_1_BooleanKnapsack;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-25
 * Time: 下午12:11
 */
public class C12_1_BooleanKnapsackTest extends TestCase {
    int[] weights = new int[]{2,2,6,5,4};
    int[] values = new int[]{6,3,5,4,6};
    int W = 12;

    public void testGetMaxValueByRecursion() throws Exception {
        int profilt  = C12_1_BooleanKnapsack.getMaxValueByRecursion(weights.length - 1, W, weights, values);
        assertEquals(17, profilt);
    }

    public void testGetMaxValueByDPS1() throws Exception {
        int profilt  = C12_1_BooleanKnapsack.getMaxValueByDPS1(W, weights, values);
        assertEquals(17, profilt);
    }

    public void testGetMaxValueByDPS2() throws Exception {
        int profilt = 0;
        boolean[] solution = C12_1_BooleanKnapsack.getMaxValueByDPS2(W, weights, values);
        for(int i = 0; i < solution.length; i++){
            if(solution[i]) profilt += values[i];
        }
        assertEquals(17, profilt);
        assertEquals(true, solution[0]);
        assertEquals(false, solution[1]);
        assertEquals(true, solution[2]);
        assertEquals(false, solution[3]);
        assertEquals(true, solution[4]);

    }
}
