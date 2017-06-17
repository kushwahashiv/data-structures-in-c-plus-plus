package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-21
 * Time: 下午1:38
 */
public class C1_60_CountRelationsTest extends TestCase {

    public void testcase1() throws Exception {
        C1_60_CountRelations.Relation r = C1_60_CountRelations.count(1);
        assertEquals(0, r.r1);
        assertEquals(0, r.r2);
    }

    public void testcase2() throws Exception {
        C1_60_CountRelations.Relation r = C1_60_CountRelations.count(2);
        assertEquals(1, r.r1);
        assertEquals(0, r.r2);
    }

    public void testcase3() throws Exception {
        C1_60_CountRelations.Relation r = C1_60_CountRelations.count(3);
        assertEquals(6, r.r1);
        assertEquals(3, r.r2);
    }

    public void testcase4() throws Exception {
        C1_60_CountRelations.Relation r = C1_60_CountRelations.count(4);
        //System.out.println(r.r1 + "\t" + r.r2);
        assertEquals(25, r.r1);
        assertEquals(30, r.r2);
    }

    public void testcase5() throws Exception {
        C1_60_CountRelations.Relation r = C1_60_CountRelations.count(10);
        //System.out.println(r.r1 + "\t" + r.r2);
        assertEquals(28501, r.r1);
        assertEquals(437250, r.r2);

    }
}
