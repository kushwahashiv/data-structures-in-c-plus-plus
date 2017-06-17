package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午1:12
 */
public class C1_80_JumpGameTest extends TestCase {
    public void testCanJump() throws Exception {
        assertTrue(C1_80_JumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(C1_80_JumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
