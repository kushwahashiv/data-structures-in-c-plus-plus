package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-29
 * Time: 下午9:04
 */
public class C1_40_ContinuousSequenceCountTest extends TestCase {

    public void testcase1() throws Exception {
        int count = C1_40_ContinuousSequenceCount.count(15);
        assertEquals(3, count);
    }

    public void testcase(){
        int count = C1_40_ContinuousSequenceCount.count(99);
        assertEquals(5, count);
    }
}
