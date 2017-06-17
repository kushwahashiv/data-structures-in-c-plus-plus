package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-4
 * Time: 下午5:37
 *
 *
 */
public class C4_52_RandomGetTest extends TestCase {
    public void testGet() throws Exception {
        Integer[] numbers = new Integer[]{23, 4, 38, 1, 8, 48, 31, 84, 39, 10};
        ConsoleWriter.printIntArray(numbers);

        Numbers n = new Numbers(numbers);

        int[] mark = new int[10];
        for(int i = 0; i < 100000; i++){
            Integer number = C4_52_RandomGet.get(n);
            n.reset();
            int index = find(number, numbers);
            if(index == -1) System.out.println(number);
            else {
                mark[index]++;
            }
        }

        ConsoleWriter.printIntArray(mark);

    }

    public int find(Integer number, Integer[] numbers){
        for(int i = 0; i < numbers.length; i++){
            if(number == numbers[i]) return i;
        }
        return -1;
    }
}
