package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-19
 * Time: 下午2:02
 */
public class C11_18_StringWildcardMatchTest extends TestCase {
    public void testcase1(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("A*", "Ahusdfhaudsfhaf");

        assertTrue(isMatch);

        assertTrue(C11_18_StringWildcardMatch.match("A*", "Ahusdfhaudsfhaf"));
    }

    public void testcase2(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("A*f", "Ahusdfhaudsfhaf");
        assertTrue(isMatch);

        assertTrue(C11_18_StringWildcardMatch.match("A*f", "Ahusdfhaudsfhaf"));
    }

    public void testcase3(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("A*g", "Ahusdfhaudsfhaf");
        assertFalse(isMatch);

        assertFalse(C11_18_StringWildcardMatch.match("A*g", "Ahusdfhaudsfhaf"));
    }

    public void testcase4(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("*g", "Ahusdfhaudsfhaf");
        assertFalse(isMatch);

        assertFalse(C11_18_StringWildcardMatch.match("*g", "Ahusdfhaudsfhaf"));
    }

    public void testcase5(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("*", "Ahusdfhaudsfhaf");
        assertTrue(isMatch);

        assertTrue(C11_18_StringWildcardMatch.match("*", "Ahusdfhaudsfhaf"));
    }

    public void testcase6(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("A*fg", "Ahusdfhaudsfhaf");
        assertFalse(isMatch);

        assertFalse(C11_18_StringWildcardMatch.match("A*fg", "Ahusdfhaudsfhaf"));
    }

    public void testcase7(){
        boolean isMatch = C11_18_StringWildcardMatch.isMatch("ab*d*cf", "abcbdfcgdgcf");
        assertTrue(isMatch);

        assertTrue(C11_18_StringWildcardMatch.match("ab*d*cf", "abcbdfcgdgcf"));
    }
}
