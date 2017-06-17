package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-10-23
 * Time: 下午10:55
 */
public class C4_32A_TripleSumKTest extends TestCase {
    public void testSolveTwoWay() throws Exception {
        int[] array = new int[]{10, 6, 9, 19, 12, 12, 17, 10, 19, 8, 9, 7, 6, 11, 4, 15, 11, 6, 14, 1};//TestUtil.generateIntArray(20, 20, 1, false);
        ConsoleWriter.printIntArray(array);
        List<C4_32A_TripleSumK.Triple> triples = C4_32A_TripleSumK.solveTwoWay(array, 16);
        System.out.println("TWO WAY RESULT");
        for(C4_32A_TripleSumK.Triple triple : triples)
            System.out.printf("%d\t%d\t%d\n", triple.x, triple.y, triple.z);

        triples = C4_32A_TripleSumK.solveOneWay(array, 16);
        System.out.println("ONE WAY RESULT");
        for(C4_32A_TripleSumK.Triple triple : triples)
            System.out.printf("%d\t%d\t%d\n", triple.x, triple.y, triple.z);

    }
}
