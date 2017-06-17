package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-27
 * Time: 下午9:02
 */
public class C1_37_A_CountMFrom0ToNTest extends TestCase {
    public void testCount1() throws Exception {
        int count = C1_37_A_CountMFrom0ToN.count(23, 1);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(23, 1));
        count = C1_37_A_CountMFrom0ToN.count(223, 1);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(223, 1));
        count = C1_37_A_CountMFrom0ToN.count(1223, 1);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(1223, 1));
    }

    public void testCount2() throws Exception {
        int count = C1_37_A_CountMFrom0ToN.count(23, 2);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(23, 2));
        count = C1_37_A_CountMFrom0ToN.count(223, 2);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(223, 2));
        count = C1_37_A_CountMFrom0ToN.count(1223, 2);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(1223, 2));
    }

    public void testCount0() throws Exception {
        int count = C1_37_A_CountMFrom0ToN.count(23, 0);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(23, 0));
        count = C1_37_A_CountMFrom0ToN.count(223, 0);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(223, 0));
        count = C1_37_A_CountMFrom0ToN.count(1223, 2);
        assertEquals(count, C1_37_A_CountMFrom0ToN.answer(1223, 0));
    }
}
