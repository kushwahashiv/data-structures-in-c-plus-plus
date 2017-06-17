package com.interview.algorithms.general;

import junit.framework.TestCase;

/**                                  g
 * Created_By: stefanie
 * Date: 14-11-5
 * Time: 下午3:56
 */
public class C1_72_IntegerPalindromeTest extends TestCase {
    public void testcase() {
        assertTrue(C1_72_IntegerPalindrome.isPalindrome(0));
        assertTrue(C1_72_IntegerPalindrome.isPalindrome(101));
        assertTrue(C1_72_IntegerPalindrome.isPalindrome(1001));
        assertFalse(C1_72_IntegerPalindrome.isPalindrome(10));
        assertFalse(C1_72_IntegerPalindrome.isPalindrome(-101));
    }
}
