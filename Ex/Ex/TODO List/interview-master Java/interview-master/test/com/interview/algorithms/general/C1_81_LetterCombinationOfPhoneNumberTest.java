package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午2:17
 */
public class C1_81_LetterCombinationOfPhoneNumberTest extends TestCase {
    public void testLetterCombinations() throws Exception {
        String digtals = "23";
        List<String> words = C1_81_LetterCombinationOfPhoneNumber.letterCombinations(digtals);
        assertEquals(9, words.size());
    }
}
