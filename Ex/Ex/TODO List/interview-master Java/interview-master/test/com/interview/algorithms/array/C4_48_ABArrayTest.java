package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 下午4:39
 */
public class C4_48_ABArrayTest extends TestCase {

    public void testcase1() throws Exception {
        int[] array = C4_48_ABArray.generate(3,4,6);
        checkAnswer(array, 3, 4, 6);
    }

    public void testcase2() throws Exception {
        int[] array = C4_48_ABArray.generate(2,8,10);
        checkAnswer(array, 2, 8, 10);
    }

    public void checkAnswer(int[] array, int a, int b, int N){
        ConsoleWriter.printIntArray(array);
        assertEquals(N, array.length);
        Set<Integer> hash = new HashSet<Integer>();
        for(int i = 0; i < array.length; i++){
            assertTrue(array[i] % a == 0 || array[i] % b == 0);
            hash.add(array[i]);
        }
        int i = 1;
        int k = 0;
        while(k < N){
            if(i % a == 0 || i % b == 0){
                //System.out.println(i);
                assertTrue(hash.contains(i));
                k++;
            }
            i++;
        }
    }
}
