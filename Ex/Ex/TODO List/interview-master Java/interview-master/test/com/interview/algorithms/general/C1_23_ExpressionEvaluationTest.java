package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-23
 * Time: 下午10:41
 */
public class C1_23_ExpressionEvaluationTest extends TestCase {
    C1_23_ExpressionEvaluation evaluater = new C1_23_ExpressionEvaluation();

    public void testEvaluate() throws Exception {
        double result = evaluater.evaluate("(3.9+5.7)");
        assertEquals(9.6, result);

        result = evaluater.evaluate("(2+(1.2+2.3))");
        assertEquals(5.5, result);

        result = evaluater.evaluate("(2 + (1.2+2.3))");
        assertEquals(5.5, result);
    }
}
