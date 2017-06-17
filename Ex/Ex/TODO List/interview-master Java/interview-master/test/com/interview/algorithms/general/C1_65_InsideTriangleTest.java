package com.interview.algorithms.general;

import com.interview.utils.models.Point;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-29
 * Time: 上午10:56
 */
public class C1_65_InsideTriangleTest extends TestCase {

    public void testIn() throws Exception {
        Point A = new Point(4,6);
        Point B = new Point(0,0);
        Point C = new Point(10,0);

        Point D = new Point(7, 2);
        assertTrue(C1_65_InsideTriangle.isInside(A, B, C, D));
        assertTrue(C1_65_InsideTriangle.isInsideByArea(A, B, C, D));
    }

    public void testOut(){
        Point A = new Point(4,6);
        Point B = new Point(0,0);
        Point C = new Point(10,0);

        Point D = new Point(8, 4);
        assertFalse(C1_65_InsideTriangle.isInside(A, B, C, D));
        assertFalse(C1_65_InsideTriangle.isInsideByArea(A, B, C, D));
    }
}
