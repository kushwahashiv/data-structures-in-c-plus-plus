package com.interview.algorithms.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class C6_3_MSTSolverTest extends TestCase {
    static WeightedGraph g = TestUtil.generateWeightedGraph(10, 15, false);

    @Test
    public void testKruskalMSTSolver(){
        g.print();
        System.out.println("Test KruskalMSTSolver");
        List<WeightedGraph.Edge> MST = C6_3_MSTSolverKruskal.getMST(g);
        verify(MST);
    }


    @Test
    public void testPrimMSTSolver(){
        g.print();
        System.out.println("Test PrimMSTSolver");
        List<WeightedGraph.Edge> MST = C6_3_MSTSolverPrim.getMST(g);
        verify(MST);
    }

    public void verify(List<WeightedGraph.Edge> MST){
        System.out.println("Print the MST: ");
        double weight = 0;
        for(WeightedGraph.Edge edge : MST){
            edge.print();
            weight += edge.w;
            System.out.println();
        }
        System.out.printf("Weight of the MST is: %.3f\n", weight);
    }

}