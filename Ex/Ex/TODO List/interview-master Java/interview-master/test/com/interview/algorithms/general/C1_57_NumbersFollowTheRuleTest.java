package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

public class C1_57_NumbersFollowTheRuleTest extends TestCase {

    public void testcase(){
        int A = 1000;
        int B = 10000;
        //int count = C1_57_NumbersFollowTheRule.numbers(A, B);

        List<Integer> numbers = C1_57_NumbersFollowTheRule.correctAnswer(A, B);
        System.out.printf("Found %d numbers follow the rule\n", numbers.size());
        //assertEquals(count, numbers.size());
        for(Integer i : numbers) System.out.println(i);
    }

}