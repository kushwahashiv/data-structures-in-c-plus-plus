package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-23
 * Time: 下午9:40
 */
public class C1_26_BinaryOneCounterTest extends TestCase {
    public void testcase1() throws Exception {
        assertEquals(2,C1_26_BinaryOneCounter.count(3));
        assertEquals(2,C1_26_BinaryOneCounter.countByMode2(3));
        assertEquals(2,C1_26_BinaryOneCounter.countByBitOp(3));
    }

    public void testcase2() throws Exception {
        assertEquals(1,C1_26_BinaryOneCounter.count(1));
        assertEquals(1,C1_26_BinaryOneCounter.countByMode2(1));
        assertEquals(1,C1_26_BinaryOneCounter.countByBitOp(1));
    }

    public void testcase3() throws Exception {
        assertEquals(0,C1_26_BinaryOneCounter.count(0));
        assertEquals(0,C1_26_BinaryOneCounter.countByMode2(0));
        assertEquals(0,C1_26_BinaryOneCounter.countByBitOp(0));
    }

    public void testcase4() throws Exception {
        assertEquals(1,C1_26_BinaryOneCounter.count(8));
        assertEquals(1,C1_26_BinaryOneCounter.countByMode2(8));
        assertEquals(1,C1_26_BinaryOneCounter.countByBitOp(8));
    }
}
