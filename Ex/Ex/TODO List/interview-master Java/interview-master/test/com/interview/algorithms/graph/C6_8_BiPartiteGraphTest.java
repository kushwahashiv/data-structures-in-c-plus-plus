package com.interview.algorithms.graph;

import com.interview.basics.model.graph.Graph;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

public class C6_8_BiPartiteGraphTest extends TestCase {
    Graph g = TestUtil.generateGraph(10, 30, true);

    public void testBiPartiteGraphDFS(){
        g.print();

        C6_8_BiPartiteGraphDFS bpg = new C6_8_BiPartiteGraphDFS(g);
        testBiParitionGraph(bpg, g);

        Graph g = TestUtil.generateBiPartitionGraph();
        g.print();
        bpg = new C6_8_BiPartiteGraphDFS(g);
        testBiParitionGraph(bpg, g);
    }

    @Test
    public void testBiPartiteGraphBFS(){
        C6_8_BiPartiteGraphBFS bpg = new C6_8_BiPartiteGraphBFS(g);
        testBiParitionGraph(bpg, g);

        Graph g = TestUtil.generateBiPartitionGraph();
        g.print();
        bpg = new C6_8_BiPartiteGraphBFS(g);
        testBiParitionGraph(bpg, g);
    }

    private void testBiParitionGraph(C6_8_BiPartiteGraph bpg, Graph g){
        bpg.solve();
        boolean isPartition = bpg.isBiPartite();
        System.out.println("Is a graph bipartite? " +  isPartition);
        if(isPartition){
            Set<Integer>[] partition = bpg.getBiPartite();
            for(int i = 0; i < 2; i++){
                System.out.print(i + "th Partition is: ");
                ConsoleWriter.printCollection(partition[i]);
            }
        }
    }

}