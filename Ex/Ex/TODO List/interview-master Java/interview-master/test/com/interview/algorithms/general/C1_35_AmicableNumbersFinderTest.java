package com.interview.algorithms.general;

import com.interview.basics.model.collection.list.List;
import com.interview.utils.models.Pair;
import junit.framework.TestCase;

public class C1_35_AmicableNumbersFinderTest extends TestCase {

    public void testFind() throws Exception {
        List<Pair<Integer>> numbers = C1_35_AmicableNumbersFinder.find(10000);

        for(int i = 0; i < numbers.size(); i++){
            Pair<Integer> number = numbers.get(i);
            System.out.println(number.i + "-" + number.j);
        }

    }
}