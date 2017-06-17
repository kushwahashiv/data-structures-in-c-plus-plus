package com.interview.leetcode.arrays.apps;

import com.interview.leetcode.arrays.apps.BestTimetoBuyandSellStock;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-12
 * Time: 下午9:25
 */
public class BestTimetoBuyandSellStockTest extends TestCase {
    int[] prices = new int[]{3,4,7,9,1,5,2,4,9,7,8};
    public void testOneTrans() throws Exception {
        int profit = BestTimetoBuyandSellStock.oneTrans(prices);
        assertEquals(8, profit);
    }

    public void testMultiTrans() throws Exception {
        int profit = BestTimetoBuyandSellStock.multiTrans(prices);
        assertEquals(18, profit);
    }

    public void testOneOrTwoTrans() throws Exception {
        int profit = BestTimetoBuyandSellStock.oneOrTwoTrans(prices);
        assertEquals(14, profit);
    }
}
