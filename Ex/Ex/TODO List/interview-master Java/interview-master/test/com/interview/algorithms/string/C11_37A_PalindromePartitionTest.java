package com.interview.algorithms.string;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-10
 * Time: 下午3:44
 */
public class C11_37A_PalindromePartitionTest extends TestCase {
    public void testPartition() throws Exception {
        List<List<String>> partitons = C11_37A_PalindromePartition.partition("aab");
        assertEquals(2, partitons.size());
    }
}
