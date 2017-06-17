package com.interview.basics.model;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-10
 * Time: 下午5:43
 */
public class BitMapTest extends TestCase {

    public void testcase() throws Exception {
        BitMap map = new BitMap(64);

        map.setBit(10);
        map.print();

        map.setBit(36);
        map.print();

        map.setBit(32);
        map.print();

        map.clearBit(32);
        map.print();

        map.clearLeftBit(20);
        map.print();

        map.clearRightBit(20);
        map.print();

        map.setBit(47);
        map.print();

        assertTrue(map.getBit(47));

        map.updateBit(38, true);
        map.updateBit(47, false);
        map.print();

        assertFalse(map.getBit(47));

        map.flipBit(38);
        map.flipBit(47);
        map.print();
        assertTrue(map.getBit(47));
        assertFalse(map.getBit(38));

        for(int i = 10; i < 50; i++){
            map.setBit(i);
        }

        map.print();

        map.clean(11, 14);
        map.print();

        map.clean(15,40);
        map.print();

        int M = Integer.parseInt("10011", 2);
        map.copy(M, 20, 24);
        map.print();

        M = Integer.parseInt("10011", 2);
        map.copy(M, 30, 34);
        map.print();
    }
}
