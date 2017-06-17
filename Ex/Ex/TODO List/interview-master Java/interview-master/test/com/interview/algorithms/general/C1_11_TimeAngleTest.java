package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.Date;

/**
 * Created_By: stefanie
 * Date: 14-6-30
 * Time: 下午9:17
 */
public class C1_11_TimeAngleTest extends TestCase {

    public void testcase1() throws Exception {
        Date time = new Date();
        time.setHours(12);
        time.setMinutes(50);
        float angle = C1_11_TimeAngle.angle(time);
        assertEquals(85.0F, angle);
    }

    public void testcase2() throws Exception {
        Date time = new Date();
        time.setHours(5);
        time.setMinutes(15);
        float angle = C1_11_TimeAngle.angle(time);
        assertEquals(67.5F, angle);
    }

    public void testcase3() throws Exception {
        Date time = new Date();
        time.setHours(21);
        time.setMinutes(55);
        float angle = C1_11_TimeAngle.angle(time);
        assertEquals(327.5F, angle);
    }

    public void testcase4() throws Exception {
        Date time = new Date();
        time.setHours(0);
        time.setMinutes(0);
        float angle = C1_11_TimeAngle.angle(time);
        assertEquals(0F, angle);
    }
}
