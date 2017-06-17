package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_50_ArrayRearrangeTest extends TestCase {

    public void testcase1() throws Exception {
        int[] numbers = new int[]{1,7,-5,9,-12,-15};
        int[] expected = new int[] {-5,-12,-15,1,7,9};
        numbers = C4_50_ArrayRearrange.arrange(numbers);
        ConsoleWriter.printIntArray(numbers);
        for(int i = 0; i < numbers.length; i++){
            assertEquals(expected[i], numbers[i]);
        }
    }

    public void testcase2() throws Exception {
        int[] numbers = new int[]{1, 7, -5, -6, 9, -12, 15};
        int[] expected = new int[] {-5, -6, -12,1,7,9,15};
        ConsoleWriter.printIntArray(expected);
        numbers = C4_50_ArrayRearrange.arrange(numbers);
        ConsoleWriter.printIntArray(numbers);
        for(int i = 0; i < numbers.length; i++){
            assertEquals(expected[i], numbers[i]);
        }
    }

    public void testcase3() throws Exception {
        int[] numbers = new int[]{83, 0, -2, -83, 87, 51, -98, -3, 73, 94 };
        int[] expected = C4_50_ArrayRearrange.arrangeWithExtraN(numbers.clone());
        ConsoleWriter.printIntArray(expected);
        numbers = C4_50_ArrayRearrange.arrange(numbers);
        ConsoleWriter.printIntArray(numbers);
        for(int i = 0; i < numbers.length; i++){
            assertEquals(expected[i], numbers[i]);
        }
    }

    public void testcase4() throws Exception {
        int[] numbers = new int[]{-69, -51, 23, -79, -92, 45, -26, 95, -65, 24};
        int[] expected = C4_50_ArrayRearrange.arrangeWithExtraN(numbers.clone());
        ConsoleWriter.printIntArray(expected);
        numbers = C4_50_ArrayRearrange.arrange(numbers);
        ConsoleWriter.printIntArray(numbers);
        for(int i = 0; i < numbers.length; i++){
            assertEquals(expected[i], numbers[i]);
        }
    }

    public void testcaseRandom(){
        for(int i = 0; i < 1; i++){
            int[] numbers = TestUtil.generateIntArray(10, true);
            int[] expected = C4_50_ArrayRearrange.arrangeWithExtraN(numbers.clone());
            ConsoleWriter.printIntArray(numbers);
            ConsoleWriter.printIntArray(expected);
            numbers = C4_50_ArrayRearrange.arrange(numbers);
            ConsoleWriter.printIntArray(numbers);
            for(int j = 0; j < numbers.length; j++){
                assertEquals(expected[j], numbers[j]);
            }
        }
    }
}