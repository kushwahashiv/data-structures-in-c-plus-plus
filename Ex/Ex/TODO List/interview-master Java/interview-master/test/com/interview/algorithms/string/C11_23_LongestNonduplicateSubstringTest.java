package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-7
 * Time: 下午1:55
 */
public class C11_23_LongestNonduplicateSubstringTest extends TestCase {

    public void testFind() throws Exception {
        int length = C11_23_LongestNonduplicateSubstring.find("abcabcbb");
        assertEquals(3, length);
    }

    public void testFind2() throws Exception {
        int length = C11_23_LongestNonduplicateSubstring.find("bbbbb");
        assertEquals(1, length);
    }

    public void testFind3() throws Exception {
        int length = C11_23_LongestNonduplicateSubstring.find("abcbcda");
        assertEquals(4, length);
    }

    public void testFind4() throws Exception {
        int length = C11_23_LongestNonduplicateSubstring.find("axbcdb");
        assertEquals(5, length);
    }
}
