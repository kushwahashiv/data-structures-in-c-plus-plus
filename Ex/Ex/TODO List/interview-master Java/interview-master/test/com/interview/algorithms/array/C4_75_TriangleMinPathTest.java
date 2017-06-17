package com.interview.algorithms.array;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午6:07
 */
public class C4_75_TriangleMinPathTest extends TestCase {
    public void testMinPath() throws Exception {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> layer = new ArrayList<Integer>();
        layer.add(2);
        triangle.add(layer);
        layer = new ArrayList<Integer>();
        layer.add(1);
        layer.add(5);
        triangle.add(layer);
        layer = new ArrayList<Integer>();
        layer.add(6);
        layer.add(7);
        layer.add(1);
        triangle.add(layer);
        int path = C4_75_TriangleMinPath.minPath(triangle);
        assertEquals(8, path);
        System.out.println(path);
    }
}
