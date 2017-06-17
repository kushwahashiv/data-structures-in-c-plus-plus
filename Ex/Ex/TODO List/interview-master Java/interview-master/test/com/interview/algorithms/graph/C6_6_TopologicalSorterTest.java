package com.interview.algorithms.graph;

import com.interview.basics.model.graph.Graph;
import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

public class C6_6_TopologicalSorterTest extends TestCase {

    @Test
    public void testTopologicalSort(){
        Graph g = TestUtil.generateGraph(10, 30, true);
        g.print();
        testTopologicalSort(g);

        g = TestUtil.generateDAGGraph();
        g.print();
        testTopologicalSort(g);
    }

    private void testTopologicalSort(Graph g){
        C6_6_TopologicalSorter sorter = new C6_6_TopologicalSorter(g);
        boolean canSort = sorter.canSort();
        System.out.println("Can do topological sort: " +  canSort);
        if(canSort){
            sorter.solve();
            System.out.println("Topological sort: " +  sorter.getOrder());
        } else {
            System.out.println("Find a cycle: " + sorter.why());
        }
    }



}