package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 上午11:01
 */
public class C11_32_SearchInInterspersedStringsTest extends TestCase {
    public void testSearch() throws Exception {
        String[] strs = new String[]{"at", "","","","ball","","","car","","","dad","",""};
        assertEquals(4, C11_32_SearchInInterspersedStrings.search(strs, "ball"));
        assertEquals(-1, C11_32_SearchInInterspersedStrings.search(strs, "cat"));
    }
}
