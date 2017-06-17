package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午3:13
 */
public class C1_82_GasStationTest extends TestCase {
    public void testCanCompleteCircuit() throws Exception {
        int[] gas = new int[]{1,3,2};
        int[] cost = new int[]{3,1,1};
        int start = C1_82_GasStation.canCompleteCircuit(gas, cost);
        assertEquals(1, start);
    }
}
