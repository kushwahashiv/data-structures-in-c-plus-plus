package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-26
 * Time: 下午1:05
 */
public class C1_39_StringConjunctionTest extends TestCase {
    public void testConjoinSuccess() throws Exception {
        String[] strs = new String[] {"aaaab", "aaabb", "aabbb", "abbbb", "bbbbc"};
        String result = C1_39_StringConjunction.conjoin(4, strs);
        assertEquals("aaaabbbbc", result);
    }

    public void testConjoinFail() throws Exception {
        String[] strs = new String[] {"aaaab", "aaabb", "aabba", "abbaa", "bbaaa", "baaaa"};
        String result = C1_39_StringConjunction.conjoin(4, strs);
        //should found a cycle
        assertNull(result);
    }

    public void testConjoin() throws Exception {
        String[] strs = new String[] {"dabbb","aaaab", "aaabb", "aabbb", "abbbb", "bbbbc"};
        String result = C1_39_StringConjunction.conjoin(4, strs);
        assertEquals("aaaabbbbc", result);
    }
}
