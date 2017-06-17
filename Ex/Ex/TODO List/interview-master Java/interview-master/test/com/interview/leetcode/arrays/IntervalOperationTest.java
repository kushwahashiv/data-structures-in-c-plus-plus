package com.interview.leetcode.arrays;

import com.interview.leetcode.utils.Interval;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午7:38
 */
public class IntervalOperationTest extends TestCase {
    public void testMerge() throws Exception {
        List<Interval> intervals = new ArrayList<>();
        //[1,3],[2,6],[8,10],[15,18]
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        intervals = IntervalOperation.merge(intervals);
        assertEquals(3, intervals.size());
    }

    public void testInsert() throws Exception {
        List<Interval> intervals = new ArrayList<>();
        //[1,2],[3,5],[6,7],[8,10],[12,16]
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        intervals = IntervalOperation.insert(intervals, new Interval(4,9));
        assertEquals(3, intervals.size());

        intervals = IntervalOperation.insert(intervals, new Interval(-2, -1));
        assertEquals(4, intervals.size());

        intervals = IntervalOperation.insert(intervals, new Interval(17, 18));
        //Interval.print(intervals);
        assertEquals(5, intervals.size());

    }

    public void testSearch() throws Exception {
        List<Interval> intervals = new ArrayList<>();
        //[1,2],[3,5],[6,7],[8,10],[12,16]
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        Interval found = IntervalOperation.search(intervals, new Interval(9,10));
        assertEquals(8, found.start);
        assertEquals(10, found.end);

        found = IntervalOperation.search(intervals, new Interval(4,6));
        assertNull(found);
    }

}
