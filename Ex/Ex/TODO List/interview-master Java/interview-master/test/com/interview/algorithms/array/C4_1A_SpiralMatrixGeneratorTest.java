package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 上午12:03
 */
public class C4_1A_SpiralMatrixGeneratorTest extends TestCase {
    public void testGenerateMatrix() throws Exception {
        int[][] matrix = C4_1A_SpiralMatrixGenerator.generateMatrix(1);
        ConsoleWriter.printIntArray(matrix);

        matrix = C4_1A_SpiralMatrixGenerator.generateMatrix(2);
        ConsoleWriter.printIntArray(matrix);

        matrix = C4_1A_SpiralMatrixGenerator.generateMatrix(3);
        ConsoleWriter.printIntArray(matrix);

        matrix = C4_1A_SpiralMatrixGenerator.generateMatrix(4);
        ConsoleWriter.printIntArray(matrix);

        matrix = C4_1A_SpiralMatrixGenerator.generateMatrix(5);
        ConsoleWriter.printIntArray(matrix);
    }
}
