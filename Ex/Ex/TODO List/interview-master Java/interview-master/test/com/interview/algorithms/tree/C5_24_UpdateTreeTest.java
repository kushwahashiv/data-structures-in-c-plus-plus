package com.interview.algorithms.tree;

import com.interview.basics.model.graph.WeightedGraph;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 上午9:35
 */
public class C5_24_UpdateTreeTest extends TestCase {
    public void test() throws Exception {
        WeightedGraph graph = new WeightedGraph(6, false);
        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(2, 4, 0);
        graph.addEdge(2, 5, 0);

        C5_24_UpdateTree updater = new C5_24_UpdateTree(graph);

        updater.update(1,4,2,3);
        updater.update(3,4,2,5);

        assertEquals(2, updater.query(4,5));
        assertEquals(4, updater.query(4,3));

    }

}
