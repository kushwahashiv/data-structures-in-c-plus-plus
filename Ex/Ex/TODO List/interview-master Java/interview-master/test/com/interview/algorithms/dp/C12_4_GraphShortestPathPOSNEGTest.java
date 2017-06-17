package com.interview.algorithms.dp;

import com.interview.basics.model.graph.WeightedGraph;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-18
 * Time: 下午11:17
 */
public class C12_4_GraphShortestPathPOSNEGTest extends TestCase {

    public void testFind() throws Exception {
        WeightedGraph graph = new WeightedGraph(5, true);
        graph.addDirectEdge(0, 3, 3);
        graph.addDirectEdge(1, 0, -1);
        graph.addDirectEdge(2, 0, 2);
        graph.addDirectEdge(2, 1, 3);
        graph.addDirectEdge(2, 4, -1);
        graph.addDirectEdge(3, 4, 6);
        graph.addDirectEdge(4, 0, 1);

        C12_4_GraphShortestPathPOSNEG.Result result = C12_4_GraphShortestPathPOSNEG.find(graph, 2, 0);

        assertEquals(0.0, result.weight);

        assertEquals(result.path.get(0).intValue(), 0);
        assertEquals(result.path.get(1).intValue(), 4);
        assertEquals(result.path.get(2).intValue(), 2);

    }
}
