package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-24
 * Time: 下午1:52
 */
public class C11_33_SubStringMatcherTest extends TestCase {
    public void testContainsAllChar() throws Exception {
        assertTrue(C11_33_SubStringMatcher.containsAllChar("ahushhhh", "hus"));
        assertFalse(C11_33_SubStringMatcher.containsAllChar("ahushhhh", "ahb"));
    }
}
