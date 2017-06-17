package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_46_RandomGeneratorTest extends TestCase {

    public void testRand() throws Exception {
        int count_0 = 0;
        int count_1 = 0;
        for(int i = 0; i < 10000; i++){
            int rand = C1_46_RandomGenerator.rand();
            if(rand == 0) count_0++;
            else count_1++;
        }
        float p = count_0/10000.0f;
        float q = count_1/10000.0f;
        System.out.println(p);
        System.out.println(q);
        assertTrue(p > 0.65 && p < 0.67);
        assertTrue(q > 0.32 && q < 0.34);
    }

    public void testRandB(){
        int count_true = 0;
        int count_false = 0;
        for(int i = 0; i < 10000; i++){
            boolean rand = C1_46_RandomGenerator.randB();
            if(rand) count_true++;
            else count_false++;
        }
        float p = count_true/10000.0f;
        float q = count_false/10000.0f;
        System.out.println(p);
        System.out.println(q);
        assertTrue(p > 0.49 && p < 0.51);
        assertTrue(q > 0.49 && q < 0.51);
    }

    public void testRandN(){
        for(int i = 3; i <= 10; i++){
            testRandN(i);
        }
    }

    public void testRandN(int N){
        System.out.printf("Test Random Generation for %d\n", N);
        int[] counts = new int[N + 1];
        for(int i = 0; i < 100000; i++){
            int rand = C1_46_RandomGenerator.rand(N);
            counts[rand]++;
        }
        float max = 1.0f/N * 1.05f;
        float min = 1.0f/N * 0.95f;
        System.out.printf("Max possibility is %f\n", max);
        System.out.printf("Min possibility is %f\n", min);
        for(int i = 1; i <= N; i++){
            float p = counts[i]/100000.0f;
            System.out.printf("Generate %d in possibility %f\n", i, p);
            assertTrue(p > min && p < max);
        }

    }

    public void testRandNP(){
        for(int i = 3; i <= 16; i++){
            testRandNP(i);
        }
    }

    public void testRandNP(int N){
        System.out.printf("Test Random Generation for %d\n", N);
        int[] counts = new int[N + 1];
        for(int i = 0; i < 100000; i++){
            int rand = C1_46_RandomGenerator.randN(N);
            counts[rand]++;
        }
        float max = 1.0f/N * 1.05f;
        float min = 1.0f/N * 0.95f;
        System.out.printf("Max possibility is %f\n", max);
        System.out.printf("Min possibility is %f\n", min);
        for(int i = 1; i <= N; i++){
            float p = counts[i]/100000.0f;
            System.out.printf("Generate %d in possibility %f\n", i, p);
            assertTrue(p > min && p < max);
        }

    }
}