package com.interview.algorithms.graph;

import com.interview.basics.model.graph.Graph;
import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;

public class C6_16_CycleFinderTest extends TestCase {
    @Test
    public void testCycleFinder(){
        Graph g = TestUtil.generateGraph(10, 30, true);
        g.print();
        C6_16_CycleFinder finder = new C6_16_CycleFinder(g);
        finder.solve();
        System.out.println("Find a cycle: " +  finder.getCycle());

        g = TestUtil.generateGraph(10, 15, true);
        g.adj[0] = new HashSet<Integer>();
        g.print();
        finder = new C6_16_CycleFinder(g);
        finder.solve();
        System.out.println("Find a cycle: " +  finder.getCycle());

        g = TestUtil.generateDAGGraph();
        g.print();
        finder = new C6_16_CycleFinder(g);
        finder.solve();
        System.out.println("Find a cycle: " +  finder.getCycle());
    }

}