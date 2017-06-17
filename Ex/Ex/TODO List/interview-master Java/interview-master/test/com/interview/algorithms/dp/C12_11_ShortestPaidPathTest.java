package com.interview.algorithms.dp;

import junit.framework.TestCase;

public class C12_11_ShortestPaidPathTest extends TestCase {
    public int[][] buildSampleGraph(int N) {
        int[][] graph = new int[N][N];
        graph[0][1] = 5;
        graph[0][5] = 1;
        graph[1][2] = 3;
        graph[1][3] = 6;
        graph[1][4] = 16;
        graph[2][3] = 2;
        graph[3][1] = 7;
        graph[3][4] = 5;
        graph[4][0] = 40;
        graph[5][1] = 1;
        return graph;
    }

    public int[] buildSampleGraphVertexWeight(int N, boolean flag){
        int[] S = new int[N];
        S[0] = 1;
        S[1] = 1;
        if(flag)  S[2] = 2;
        else S[2] = 1;
        S[3] = 1;
        S[4] = 1;
        if(flag)  S[5] = 3;
        else  S[5] = 1;
        return S;
    }

    public void testFind() throws Exception {
        int[][] graph = buildSampleGraph(6);
        int[] S = buildSampleGraphVertexWeight(6, false);

        C12_11_ShortestPaidPath.Result r = C12_11_ShortestPaidPath.find(graph, S, 6, 4);
        assertEquals(12,r.weight);
        assertEquals(1,r.left);

        S = buildSampleGraphVertexWeight(6, true);
        r = C12_11_ShortestPaidPath.find(graph, S, 6, 4);
        assertEquals(13,r.weight);
        assertEquals(0,r.left);
    }
}