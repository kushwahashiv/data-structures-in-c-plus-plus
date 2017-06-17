package com.interview.algorithms.string;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created_By: stefanie
 * Date: 14-10-5
 * Time: 下午10:36
 */
public class C11_5A_StringScanerTest extends TestCase {
    public void testFind() throws Exception {
        String s = "abcdefg";
        String[] T = new String[]{"ef","abc","cg"};

        int[] expected = new int[]{3,-1,-1,-1,2,-1,-1};
        int[] offset = C11_5A_StringScaner.find(s, T);

        ConsoleWriter.printIntArray(offset);
        Assert.assertArrayEquals(expected, offset);
    }

    public void testOffset() throws Exception {
        String s = "abcdefg";
        String[] T = new String[]{"ef","abc","cg"};

        int[] expected = new int[]{4,0,-1};
        int[] offset = C11_5A_StringScaner.offset(s, T);

        ConsoleWriter.printIntArray(offset);
        Assert.assertArrayEquals(expected, offset);
    }
}
