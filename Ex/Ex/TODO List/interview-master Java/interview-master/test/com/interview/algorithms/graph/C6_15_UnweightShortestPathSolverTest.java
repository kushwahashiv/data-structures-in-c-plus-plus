package com.interview.algorithms.graph;

import com.interview.basics.model.graph.Graph;
import com.interview.util.TestUtil;
import junit.framework.TestCase;

public class C6_15_UnweightShortestPathSolverTest extends TestCase {

    public void test(){
        Graph g = TestUtil.generateGraph(10, 30, true);
        g.print();

        C6_15_UnweightShortestPathSolver solver = new C6_15_UnweightShortestPathSolver(g);
        int s = TestUtil.generateInt(g.V - 1);
        int t = TestUtil.generateInt(g.V - 1);;
        while(t == s){
            t = TestUtil.generateInt(g.V - 1);
        }
        solver.solve(s, t);
        System.out.printf("Shortest Path of %d to %d: %s\t, Step is: %d", s, t, solver.getPath(), solver.getStep());
        System.out.println();
    }

}