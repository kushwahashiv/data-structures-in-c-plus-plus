package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_43_FindMidNumberTest extends TestCase {

    public void testFind() throws Exception {
        Integer[] numbers = new Integer[]{1,3,2,4,10,12,20,45,13,21};
        ConsoleWriter.printIntArray(numbers);
        boolean[] answers = C4_43_FindMidNumber.findAnswer(numbers);
        boolean[] marks = C4_43_FindMidNumber.find(numbers);
        ConsoleWriter.printBooleanArray(answers);
        ConsoleWriter.printBooleanArray(marks);
        for(int i = 0; i < answers.length; i++)
            assertEquals(answers[i], marks[i]);

        marks = C4_43_FindMidNumber.findON(numbers);
        ConsoleWriter.printBooleanArray(answers);
        ConsoleWriter.printBooleanArray(marks);
        for(int i = 0; i < answers.length; i++)
            assertEquals(answers[i], marks[i]);
    }
}