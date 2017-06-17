package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-4
 * Time: 下午9:42
 */
public class C11_21_LongestPalindromeTest extends TestCase {

    public void testcase1(){
        String str = "google";
        assertEquals("goog", C11_21_LongestPalindrome.find(str));
        assertEquals("goog", C11_21_LongestPalindrome.findOptimized(str));
    }

    public void testcase2(){
        String str = "abccba";
        assertEquals("abccba", C11_21_LongestPalindrome.find(str));
        assertEquals("abccba", C11_21_LongestPalindrome.findOptimized(str));
    }

    public void testcase3(){
        String str = "augoogle";
        assertEquals("goog", C11_21_LongestPalindrome.find(str));
        assertEquals("goog", C11_21_LongestPalindrome.findOptimized(str));
    }

    public void testcase4(){
        String str = "auacbcale";
        assertEquals("acbca", C11_21_LongestPalindrome.find(str));
        assertEquals("acbca", C11_21_LongestPalindrome.findOptimized(str));
    }
}
