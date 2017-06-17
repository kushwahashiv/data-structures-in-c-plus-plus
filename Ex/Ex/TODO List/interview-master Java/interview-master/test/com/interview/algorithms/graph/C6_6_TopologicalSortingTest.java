package com.interview.algorithms.graph;

import com.interview.algorithms.graph.C6_6_TopologicalSorting;
import com.interview.basics.model.graph.generic.weighted.Graph;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created_By: zouzhile
 * Date: 4/20/14
 * Time: 8:57 PM
 */
public class C6_6_TopologicalSortingTest {

    @Test
    public void testTopologicalSorting() {
        C6_6_TopologicalSorting test = new C6_6_TopologicalSorting();
        Graph graph = Graph.buildWeightedDAG();
        List<String> order = test.topologicalSort(graph);
/*
        A      B
        ]     / \ 3
        |  6 /   ]
    40  |   /    C
        |  /     /9
        | [     [
        E [--- D
           19
*/
        // B -> C - > D -> E -> A
        Assert.assertEquals(order.get(0), "B");
        Assert.assertEquals(order.get(1), "C");
        Assert.assertEquals(order.get(2), "D");
        Assert.assertEquals(order.get(3), "E");
        Assert.assertEquals(order.get(4), "A");
    }
}
