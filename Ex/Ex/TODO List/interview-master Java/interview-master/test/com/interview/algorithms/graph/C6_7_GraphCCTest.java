package com.interview.algorithms.graph;

import com.interview.basics.model.graph.Graph;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C6_7_GraphCCTest extends TestCase {

    public void testSolve() throws Exception {
        Graph g = TestUtil.generateGraph(10, 30, true);
        g.print();

        testConnectedComponent(g);

        g = TestUtil.generateGraph(10, 15, true);
        g.print();
        testConnectedComponent(g);
    }

    private void testConnectedComponent(Graph g){
        //Graph g = TestUtil.generateGraph(10, 20, false);
        C6_7_GraphCC cc = new C6_7_GraphCC(g);
        cc.solve();
        System.out.println("Find " + cc.count + " Connected Components.");
        for(int i = 1; i <= cc.count; i++){
            System.out.print(i + "th Connected Components: ");
            ConsoleWriter.printCollection(cc.components[i]);
        }
    }
}