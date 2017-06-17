package com.interview.algorithms.general;

import com.interview.algorithms.general.C1_71_MaxProfit;
import junit.framework.TestCase;

public class C1_71_MaxProfitTest extends TestCase {

    public void testFind() throws Exception {
        int[] prices = new int[]{6,8,10,11,14,7,9,2};
        int profile = C1_71_MaxProfit.find(prices);
        assertEquals(10, profile);
    }
}