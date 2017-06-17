package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-7
 * Time: 下午10:29
 */
public class C1_77_GreyCodeTest extends TestCase {
    public void testGrayCode2() throws Exception {
        List<Integer> codes = C1_77_GreyCode.grayCode(2);
        int[] expected = new int[]{0,1,3,2};
        for(int i = 0; i < expected.length; i++)
            assertEquals(expected[i], codes.get(i).intValue());
    }

    public void testGrayCode4() throws Exception {
        List<Integer> codes = C1_77_GreyCode.grayCode(4);
        int[] expected = new int[]{0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8};
        for(int i = 0; i < codes.size(); i++)
            //System.out.print(codes.get(i) + ", ");
            assertEquals(expected[i], codes.get(i).intValue());
    }
}
