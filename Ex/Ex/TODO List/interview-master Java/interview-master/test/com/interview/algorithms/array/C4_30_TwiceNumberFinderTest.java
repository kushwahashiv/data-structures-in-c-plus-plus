package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-21
 * Time: 下午11:36
 */
public class C4_30_TwiceNumberFinderTest extends TestCase {
    public void testcase(){
        int[] numbers = new int[]{7,3,2,6,5,6,4,1,8,9,10};
        int twiceNumber = C4_30_TwiceNumberFinder.find(numbers, 10);
        assertEquals(6, twiceNumber);
        twiceNumber = C4_30_TwiceNumberFinder.findByXOR(numbers, 10);
        assertEquals(6, twiceNumber);
    }
}
