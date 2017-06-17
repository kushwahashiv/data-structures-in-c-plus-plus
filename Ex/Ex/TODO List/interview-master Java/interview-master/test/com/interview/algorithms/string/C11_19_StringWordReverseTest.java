package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-19
 * Time: 下午4:57
 */
public class C11_19_StringWordReverseTest extends TestCase {

    public void testcase1() throws Exception {
        String output = C11_19_StringWordReverse.wordReverse("I am Stefanie");
        assertEquals("Stefanie am I", output);
    }

    public void testcase2() throws Exception {
        String output = C11_19_StringWordReverse.wordReverse("Oh");
        assertEquals("Oh", output);
    }

    public void testcase3() throws Exception {
        String output = C11_19_StringWordReverse.wordReverse("Good Morning");
        assertEquals("Morning Good", output);
    }
}
