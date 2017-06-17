package com.interview.algorithms.general;

import com.interview.utils.models.Range;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-6-23
 * Time: 下午10:21
 */
public class C1_10_GreatestOverlapTest extends TestCase {
    public void testGetGreatestOverlap() throws Exception {
        List<Range> rangeList = new ArrayList<Range>();
        rangeList.add(new Range(3,5));
        rangeList.add(new Range(-1,3));
        rangeList.add(new Range(0,6));
        rangeList.add(new Range(-3,-2));

        C1_10_GreatestOverlap.MaxOverlapRange maxOverlapRange = C1_10_GreatestOverlap.getGreatestOverlap(rangeList);
        assertEquals(3, maxOverlapRange.overlap);
        assertEquals(rangeList.get(1), maxOverlapRange.r1);
        assertEquals(rangeList.get(2), maxOverlapRange.r2);
    }
}
