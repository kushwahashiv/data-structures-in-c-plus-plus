package com.interview.algorithms.string;

import junit.framework.TestCase;

public class C11_34_UnconcatenateStringTest extends TestCase {

    public void testParse() throws Exception {
        String sens = "乌克兰作为世界上重要的市场之一，是世界上第三大粮食出口国";
        C11_34_UnconcatenateString.Result result = C11_34_UnconcatenateString.parse(sens);
        System.out.println(result.str);
        System.out.println(result.unrecognized);
    }
}