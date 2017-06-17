package com.interview.algorithms.bit;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-10
 * Time: 下午11:13
 */
public class C16_2_BinaryRealTest extends TestCase {
    public void testBinaryString() throws Exception {
        String b = C16_2_BinaryReal.binaryString(0.5);
        System.out.println(b);

        b = C16_2_BinaryReal.binaryString(0.725);
        System.out.println(b);

        b = C16_2_BinaryReal.binaryString(0.625);
        System.out.println(b);

        b = C16_2_BinaryReal.binaryString(0.5625);
        System.out.println(b);

        b = C16_2_BinaryReal.binaryString(0.6875);
        System.out.println(b);
    }

    public void testcase(){
        System.out.println( 1.45f - 1.05f);
    }
}
