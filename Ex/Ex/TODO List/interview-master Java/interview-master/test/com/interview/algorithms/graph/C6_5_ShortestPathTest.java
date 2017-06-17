package com.interview.algorithms.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.basics.search.ASearcher;
import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

public class C6_5_ShortestPathTest extends TestCase {
    static WeightedGraph g;
    static int s = -1;
    static int t = -1;

    public void init(){
        if(g == null){
            g = TestUtil.generateWeightedGraph(10, 30, true);
            g.print();
            s = TestUtil.generateInt(g.V - 1);
            t = TestUtil.generateInt(g.V - 1);
        }
    }

    @Test
    public void testC6_5_ShortestPath_Dijkstra2() {
        init();
        C6_5_ShortestPath_Dijkstra2 solver = new C6_5_ShortestPath_Dijkstra2(g);
        solver.solve(s);
        boolean hasPath = solver.hasPathTo(t);
        if (hasPath) {
            System.out.printf("Dijkstra: Shortest Path of %d to %d\n", s, t);
            double weight = solver.distTo(t);
            for (WeightedGraph.Edge edge : solver.pathTo(t)) {
                edge.print();
            }
            System.out.printf("Step is: %.3f\n", weight);
        } else {
            System.out.printf("No Path found of %d to %d\n", s, t);
        }
    }

    @Test
    public void testC6_5_ShortestPath_ASearch() {
        init();
        C6_5_ShortestPath_ASearch solver = new C6_5_ShortestPath_ASearch(g);
        ASearcher.Path path = solver.pathTo(s, t);
        if(path.weight != -1){
            System.out.printf("A* Search: Shortest Path of %d to %d\n", s, t);
            Iterator<Integer> iter = path.path.iterator();
            while(iter.hasNext()) {
                System.out.print(iter.next() + "-");
            }
            System.out.print(s);
            System.out.printf("\tStep is: %.3f\n", path.weight);
        } else {
            System.out.printf("No Path found of %d to %d\n", s, t);
        }
    }

    @Test
    public void testC6_5_ShortestPath_BellmanFord() {
        init();
        C6_5_ShortestPath_BellmanFord solver = new C6_5_ShortestPath_BellmanFord(g);
        solver.solve(s);
        boolean hasPath = solver.hasPathTo(t);
        if (hasPath) {
            System.out.printf("BellmanFord: Shortest Path of %d to %d\n", s, t);
            double weight = solver.distTo(t);
            for (WeightedGraph.Edge edge : solver.pathTo(s, t)) {
                edge.print();
            }
            System.out.printf("Step is: %.3f\n", weight);
        } else {
            System.out.printf("No Path found of %d to %d\n", s, t);
        }
    }

}