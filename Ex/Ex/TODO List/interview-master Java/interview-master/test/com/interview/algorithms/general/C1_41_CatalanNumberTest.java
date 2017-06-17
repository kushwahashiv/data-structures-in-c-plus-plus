package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_41_CatalanNumberTest extends TestCase {

    public void testCalc() throws Exception {
        for(int i = 0; i < 10; i++){
            System.out.println(C1_41_CatalanNumber.calc(i));
        }
    }
}