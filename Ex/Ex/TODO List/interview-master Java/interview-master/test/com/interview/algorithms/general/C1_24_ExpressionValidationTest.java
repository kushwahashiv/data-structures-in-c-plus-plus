package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-23
 * Time: 下午10:56
 */
public class C1_24_ExpressionValidationTest extends TestCase {
    public void testValidate() throws Exception {
        C1_24_ExpressionValidation validator = new C1_24_ExpressionValidation();
        String expression = "2+5*(2+4)";
        assertEquals(true, validator.validate(expression));

        expression = "2+)5*(2+4)";
        assertEquals(false, validator.validate(expression));

        expression = "2+(5*(2+4)";
        assertEquals(false, validator.validate(expression));

        expression = "2+(5*(2+4))";
        assertEquals(true, validator.validate(expression));

        expression = "5*23";
        assertEquals(true, validator.validate(expression));
    }
}
