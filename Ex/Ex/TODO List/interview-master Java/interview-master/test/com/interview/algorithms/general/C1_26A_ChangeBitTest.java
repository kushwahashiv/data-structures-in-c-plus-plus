package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 下午4:05
 */
public class C1_26A_ChangeBitTest extends TestCase {

    public void testcase1(){
        assertEquals(1, C1_26A_ChangeBit.find(6, 7));
        assertEquals(1, C1_26A_ChangeBit.find(6, 4));
        assertEquals(2, C1_26A_ChangeBit.find(7, 4));
    }
}
