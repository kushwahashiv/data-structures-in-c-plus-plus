package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-7
 * Time: 下午3:02
 */
public class C1_54_RectangeOverlapTest extends TestCase {

    public void testHasOverlap() throws Exception {
        Rectangle r1 = new Rectangle(0, 2, 2, 0);
        Rectangle r2 = new Rectangle(1, 3, 3, 1);

        assertTrue(C1_54_RectangeOverlap.hasOverlap(r1, r2));
    }

    public void testHasOverlap2() throws Exception {
        Rectangle r1 = new Rectangle(0, 2, 2, 0);
        Rectangle r2 = new Rectangle(4, 6, 6, 4);

        assertFalse(C1_54_RectangeOverlap.hasOverlap(r1, r2));
    }
}
