package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-7
 * Time: 下午10:45
 */
public class C1_78_RomaIntegerConverterTest extends TestCase {
    public void testRoma2Int() throws Exception {
        assertEquals(1976, C1_78_RomaIntegerConverter.roma2int("MCMLXXVI"));
        assertEquals(1984, C1_78_RomaIntegerConverter.roma2int("MCMLXXXIV"));
        assertEquals(999, C1_78_RomaIntegerConverter.roma2int("CMXCIX"));
    }

    public void testInt2Roma() throws Exception {
        assertEquals("MCMLXXVI", C1_78_RomaIntegerConverter.int2rome(1976));
        assertEquals("MCMLXXXIV", C1_78_RomaIntegerConverter.int2rome(1984));
        assertEquals("CMXCIX", C1_78_RomaIntegerConverter.int2rome(999));
    }
}
