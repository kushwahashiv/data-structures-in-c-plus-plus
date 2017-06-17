package com.interview.algorithms.general;

/**
 * Created_By: zouzhile
 * Date: 2/27/14
 * Time: 12:15 PM
 */
public class C1_35_RegexMatch {

    public boolean match(String str, String pattern) {
        int pOffset = 0;
        for(int i=0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            char pCh = pattern.charAt(pOffset);
            if(ch == pCh) {

            } else {

            }
        }
        return false;
    }
}
