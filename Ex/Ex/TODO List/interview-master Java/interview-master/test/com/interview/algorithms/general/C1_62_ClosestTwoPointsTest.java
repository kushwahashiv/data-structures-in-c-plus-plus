package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import com.interview.utils.models.Point;
import junit.framework.TestCase;

public class C1_62_ClosestTwoPointsTest extends TestCase {

    public void testRandom(){
        for(int i = 1; i < 10; i++) testcase(true);
    }

    private void testcase(boolean debug){
        Point[] points = new Point[10];
        for(int i = 0; i < 10; i++) {
            int x = TestUtil.generateInt(100);
            int y = TestUtil.generateInt(100);
            points[i] = new Point(x, y);
            if (debug)
                System.out.println(points[i].toString());
        }
        test(points, debug);
    }

    private void test(Point[] points, boolean debug){
        Point[] expected = C1_62_ClosestTwoPoints.correct(points);
        if(debug){
            System.out.println("Expected Answer");
            System.out.println(expected[0].toString());
            System.out.println(expected[1].toString());
            System.out.println(C1_62_ClosestTwoPoints.distanceCount);
        }


        C1_62_ClosestTwoPoints.distanceCount = 0;
        Point[] closest = C1_62_ClosestTwoPoints.closest(points);
        if(debug){
            System.out.println("Find Answer");
            System.out.println(closest[0].toString());
            System.out.println(closest[1].toString());
            System.out.println(C1_62_ClosestTwoPoints.distanceCount);
        }

        double disExpected = C1_62_ClosestTwoPoints.distance(expected[0], expected[1]);
        double disActual = C1_62_ClosestTwoPoints.distance(closest[0], closest[1]);
        assertEquals(disExpected, disActual);
    }

    public void testErrorCase(){
        Point[] points = getPoints();
        test(points, true);
    }

    private Point[] getPoints(){
        //int[] a = new int[]{31, 80,10, 98,18, 48,2, 59,95, 0,18, 9,37, 48,13, 14,8, 13,57, 5};
        int[] a = new int[]{57, 90,66, 91,5, 45,53, 42,72, 95,77, 53,8, 70,87, 9,49, 2,4, 92};
        Point[] points = new Point[10];
        for(int i = 0; i < 10; i++){
            points[i] = new Point(a[2 * i], a[2 * i + 1]);
        }
        return points;
    }

}