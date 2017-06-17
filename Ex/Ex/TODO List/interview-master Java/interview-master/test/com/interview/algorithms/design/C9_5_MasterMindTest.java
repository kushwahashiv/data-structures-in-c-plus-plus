package com.interview.algorithms.design;

import com.interview.algorithms.design.C9_5_MasterMind;
import junit.framework.TestCase;

public class C9_5_MasterMindTest extends TestCase {

    public void testResult() throws Exception {
        C9_5_MasterMind.Result result = C9_5_MasterMind.result("RGBY", "GGRR");
        assertEquals(1, result.hit);
        assertEquals(1, result.pseudo_hit);
    }
}