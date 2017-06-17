package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午10:27
 */
public class C1_80A_MinJumpStepTest extends TestCase {
    public void testMinSteps() throws Exception {
        int[] numbers = new int[]{2,3,1,1,4};
        assertEquals(2, C1_80A_MinJumpStep.minSteps(numbers));
    }
}
