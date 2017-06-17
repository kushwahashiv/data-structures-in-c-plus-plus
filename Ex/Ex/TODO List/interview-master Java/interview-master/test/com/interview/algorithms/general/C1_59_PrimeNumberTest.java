package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-17
 * Time: 下午10:33
 */
public class C1_59_PrimeNumberTest extends TestCase {

    public void testGenerate() throws Exception {
        int[] primes = C1_59_PrimeNumber.generate(100);
        ConsoleWriter.printIntArray(primes);
    }
}
