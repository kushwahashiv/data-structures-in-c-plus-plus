package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-8
 * Time: 上午9:46
 */
public class C4_53_SlidingWindowMaximumTest extends TestCase {

    public void testFind() throws Exception {
        int[] a = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int[] expacted = new int[] {3,3,5,5,6,7};
        int[] b = C4_53_SlidingWindowMaximum.find(a, 3);
        for(int i = 0; i < expacted.length; i++)
            assertEquals(expacted[i], b[i]);

    }
}
