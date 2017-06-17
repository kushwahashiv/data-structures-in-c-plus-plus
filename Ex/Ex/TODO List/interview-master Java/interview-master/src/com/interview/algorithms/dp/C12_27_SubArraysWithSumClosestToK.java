package com.interview.algorithms.dp;

/**
 * Given an int array, find the sub arrays sum is equals or closest smaller to a given K
 * @author stefanie
 *
 * Solution:
 * opt[i][k] saves 0~i element sum smaller but closest to K.
 *      opt[i][k] = max{ opt[i-1][k], opt[i-1][k-array[i]]+array[i] if k-array[i]>=0 }
 *
 * backtrace
 *      when not the first and opt[i][j] > opt[i-1][j] means i-th element is selected.
 *      when is the first element, if j = array[i], means i-th element is selected
 */
public class C12_27_SubArraysWithSumClosestToK {

    public static boolean[] find(int[] array, int K){
        int len = array.length;
        boolean[] mark = new boolean[len];

        //if K equals or larger than sum, return all the set
        int sum = 0;
        for (int i = 0; i < len; i++) sum += array[i];
        if(sum <= K) {
            for(int i = 0; i < len; i++) mark[i] = true;
            return mark;
        }

        //opt[i][k] saves 0~i element sum closest to K.
        int[][] opt = new int[len][K + 1];
        for (int i = 0; i < len; i++) {
            for(int k = 0; k < K + 1; k++){
                //previous_no is don't put i-th element in, previous_yes is put i-th element in
                int previous_no = i - 1 < 0? 0 : opt[i-1][k]; //check if is the first element
                if(k >= array[i]){ //i-th element is smaller than j
                    int previous_yes = i - 1 < 0? 0 : opt[i-1][k-array[i]];
                    //find a more close solution
                    opt[i][k] = Math.max(previous_no, previous_yes + array[i]);
                } else
                    opt[i][k] = previous_no;
            }
        }

        //backtrace the solution
        int k = K;
        int i = len - 1;
        while(i >= 0 && k > 0){
            //when not the first and opt[i][j] > opt[i-1][j] means i-th element is selected.
            //when is the first element, if j = array[i], means i-th element is selected
            if(( i > 0 && opt[i][k] > opt[i-1][k]) || (i == 0 && k == array[i])){
                mark[i] = true;
                k -= array[i];
            }
            i--;
        }

        return mark;
    }

}
