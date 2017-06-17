package com.interview.algorithms.stackqueue;

import junit.framework.TestCase;

import java.util.List;

public class C7_6_HanoiUsingStackTest extends TestCase {

    public void test3Disk() throws Exception {
        C7_6_HanoiUsingStack game = new C7_6_HanoiUsingStack();
        List<C7_6_HanoiUsingStack.Step> steps = game.solve(3);
        assertEquals(7, steps.size());
        for(C7_6_HanoiUsingStack.Step step : steps) System.out.println(step.toString());
    }

    public void test5Disk(){
        C7_6_HanoiUsingStack game = new C7_6_HanoiUsingStack();
        List<C7_6_HanoiUsingStack.Step> steps = game.solve(5);
        assertEquals(31, steps.size());
        for(C7_6_HanoiUsingStack.Step step : steps) System.out.println(step.toString());
    }

}