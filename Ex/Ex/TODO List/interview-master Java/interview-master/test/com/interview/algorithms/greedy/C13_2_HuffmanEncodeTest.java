package com.interview.algorithms.greedy;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created_By: stefanie
 * Date: 14-9-21
 * Time: 上午12:08
 */
public class C13_2_HuffmanEncodeTest extends TestCase {
    public void testEncode() throws Exception {
        int[] frequency = new int[] {45,13,12,16,9,5};
        String[] expected = new String[]{"0", "101", "100", "111", "1101", "1100"};

        String[] codes = C13_2_HuffmanEncode.encode(frequency);

        //for(String code : codes) System.out.println(code);
        Assert.assertArrayEquals(expected, codes);
    }
}
