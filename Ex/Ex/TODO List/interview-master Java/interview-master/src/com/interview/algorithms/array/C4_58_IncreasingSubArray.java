package com.interview.algorithms.array;

import com.interview.utils.CombinationUtil;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/17/14
 * Time: 2:30 PM
 */
public class C4_58_IncreasingSubArray {
    public static long find(int[] array){
        long count = 0;
        for(int i = 1; i < array.length; i++){
            int smaller = 0;
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]) smaller++;
            }
            count += CombinationUtil.fullCombination(smaller) - 1;
        }
        return count;
    }


}
