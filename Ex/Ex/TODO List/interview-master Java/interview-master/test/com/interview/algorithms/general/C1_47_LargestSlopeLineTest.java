package com.interview.algorithms.general;

import com.interview.utils.models.Point;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 上午9:55
 */
public class C1_47_LargestSlopeLineTest extends TestCase {

    public void testFind() throws Exception {
        int[][] points = new int[][] {{1,4},{2,1},{4,4},{4,5},{9,1}};
        Point[] pointsArray = getPoints(points);

        Point[] line = C1_47_LargestSlopeLine.findBF(pointsArray);
        System.out.printf("%d,%d-%d,%d\n", line[0].x, line[0].y, line[1].x, line[1].y);

    }

    private Point[] getPoints(int[][] points){
        Point[] pointArray = new Point[points.length];
        int i = 0;
        for(int[] point : points){
            Point p = new Point(point[0], point[1]);
            pointArray[i] = p;
            i++;
        }
        return pointArray;
    }
}
