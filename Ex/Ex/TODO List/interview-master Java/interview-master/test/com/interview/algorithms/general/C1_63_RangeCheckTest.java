package com.interview.algorithms.general;

import com.interview.utils.models.Range;
import junit.framework.TestCase;

public class C1_63_RangeCheckTest extends TestCase {

    public void testcase1(){
        Range[] target = new Range[]{new Range(2,3), new Range(1,2), new Range(3,9)};
        Range source = new Range(1,6);

        assertTrue(C1_63_RangeCheck.cover(source, target));
    }

    public void testcase2(){
        Range[] target = new Range[]{new Range(2,3), new Range(1,2), new Range(4,9)};
        Range source = new Range(1,6);

        assertFalse(C1_63_RangeCheck.cover(source, target));
    }

    public void testcase3(){
        Range[] target = new Range[]{new Range(2,3), new Range(1,2), new Range(4,9)};
        Range source = new Range(4,6);

        assertTrue(C1_63_RangeCheck.cover(source, target));
    }
}