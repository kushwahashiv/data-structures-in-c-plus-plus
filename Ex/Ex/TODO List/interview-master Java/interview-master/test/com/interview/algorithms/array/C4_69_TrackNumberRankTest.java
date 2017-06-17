package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 下午6:19
 */
public class C4_69_TrackNumberRankTest extends TestCase {
    public void testcase(){
        C4_69_TrackNumberRank tracker = new C4_69_TrackNumberRank();
        tracker.track(5);
        tracker.track(1);
        assertEquals(0, tracker.rank(1));
        assertEquals(1, tracker.rank(5));

        tracker.track(4);
        assertEquals(2, tracker.rank(5));
        tracker.track(4);
        assertEquals(3, tracker.rank(5));

        tracker.track(5);
        assertEquals(3, tracker.rank(5));
        assertEquals(5, tracker.rank(7));

        tracker.track(9);
        tracker.track(7);
        tracker.track(13);
        tracker.track(3);

        assertEquals(1, tracker.rank(3));
        assertEquals(6, tracker.rank(7));
    }
}
