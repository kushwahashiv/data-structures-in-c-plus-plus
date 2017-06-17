package com.interview.algorithms.graph;

import com.interview.basics.model.graph.Graph;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-5
 * Time: 下午4:20
 */
public class C6_18_GraphPainterTest extends TestCase {
    Graph g = TestUtil.generateGraph(10, 9, false);
    public void testPaint() throws Exception {
        g.print();
        int[] color = C6_18_GraphPainter.paint(g);
        ConsoleWriter.printIntArray(color);
    }
}
