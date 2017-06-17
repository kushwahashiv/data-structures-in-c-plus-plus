package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午11:09
 */
public class C4_41A_NonThreeTimeNumberTest extends TestCase {
    public void testSingleNumber() throws Exception {
        int[] numbers = new int[]{1,2,1,4,1,2,2};
        assertEquals(4, C4_41A_NonThreeTimeNumber.singleNumber(numbers));
    }
}
