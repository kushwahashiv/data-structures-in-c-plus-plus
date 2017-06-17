package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-3
 * Time: 下午10:35
 */
public class C11_3_CheckStringPermutationTest extends TestCase {
    C11_3_CheckStringPermutation checker = new C11_3_CheckStringPermutation();

    public void testcase1(){
        String str1 = "abcde";
        String str2 = "cdbae";
        assertTrue(checker.checkBySort(str1, str2));
        assertTrue(checker.checkByScan(str1, str2));
        assertTrue(checker.checkByScanByIndex(str1, str2));
        assertTrue(checker.checkByPrimeNumber(str1, str2));
    }

    public void testcase2(){
        String str1 = "abcde(bsyy";
        String str2 = "bcydyb(eas";
        assertTrue(checker.checkBySort(str1, str2));
        assertTrue(checker.checkByScan(str1, str2));
        assertTrue(checker.checkByScanByIndex(str1, str2));
    }

    public void testcase3(){
        String str1 = "abcdeabsey";
        String str2 = "bcydybaeas";
        assertFalse(checker.checkBySort(str1, str2));
        assertFalse(checker.checkByScan(str1, str2));
        assertFalse(checker.checkByScanByIndex(str1, str2));
        assertFalse(checker.checkByPrimeNumber(str1, str2));
    }
}
