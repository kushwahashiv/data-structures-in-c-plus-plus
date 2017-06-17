package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-23
 * Time: 下午9:51
 */
public class C4_33_PushPopSequenceCheckerTest extends TestCase {

    public void testCheck() throws Exception {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,5,3,2,1};

        assertTrue(C4_33_PushPopSequenceChecker.check(push, pop));
    }

    public void testCheck2(){
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,3,5,1,2};

        assertFalse(C4_33_PushPopSequenceChecker.check(push, pop));
    }
}
