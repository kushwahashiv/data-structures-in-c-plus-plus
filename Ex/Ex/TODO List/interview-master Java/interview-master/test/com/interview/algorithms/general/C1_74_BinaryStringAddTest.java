package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 上午11:18
 */
public class C1_74_BinaryStringAddTest extends TestCase {
    public void testAddBinary() throws Exception {
        assertEquals("1000", C1_74_BinaryStringAdd.addBinary("11", "101"));
        assertEquals("101", C1_74_BinaryStringAdd.addBinary("0", "101"));
        assertEquals("110", C1_74_BinaryStringAdd.addBinary("01", "101"));
        assertEquals("101", C1_74_BinaryStringAdd.addBinary("101", "0"));
        assertEquals("110", C1_74_BinaryStringAdd.addBinary("00001", "101"));
        assertEquals("0", C1_74_BinaryStringAdd.addBinary("0000", "000"));
    }
}
