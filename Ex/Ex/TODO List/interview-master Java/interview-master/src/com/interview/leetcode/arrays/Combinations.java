package com.interview.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午5:30
 *
 * Given a int[] num, find unique the subsets of given numbers.
 * 1. when num doesn't have duplication       {@link #combinationNoDup}
 * 2. when num have duplication, and need unique subsets   {@link #combinationWithDup}
 * 3. only find subsets contains K numbers   {@link #combinationSizeK}
 * 4. subsets sum equals to K, and one element can use only once.  {@link #combinationSumKOnce}
 * 5. subsets sum equals to K, and one element can use several times.  {@link #combinationSumKMulti}
 */
public class Combinations {
    /**
     * when num doesn't have duplication
     *
     * using a int[] cur as the placeholder for a subset,
     * each number in num can be put in the next offset in cur or replace prev num in cur.
     */
    public static List<List<Integer>> combinationNoDup(int[] num){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        int[] cur = new int[num.length];
        combinationNoDup(num, 0, cur, 0, subsets);
        return subsets;
    }

    private static void combinationNoDup(int[] num, int numOffset, int[] cur, int curOffset, List<List<Integer>> subsets){
        if(numOffset == num.length) return;   //return when index out of range
        cur[curOffset] = num[numOffset];
        subsets.add(getOneSubset(cur, 0, curOffset));

        combinationNoDup(num, numOffset + 1, cur, curOffset + 1, subsets);
        combinationNoDup(num, numOffset + 1, cur, curOffset, subsets);
    }

    /**
     * when num have duplication, and need unique subsets
     *
     * when replace prev number in cur, skip the same number to avoid generate duplicate subsets.
     */
    public static List<List<Integer>> combinationWithDup(int[] num){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        int[] cur = new int[num.length];
        Arrays.sort(num);
        combinationWithDup(num, 0, cur, 0, subsets);
        return subsets;
    }

    private static void combinationWithDup(int[] num, int numOffset, int[] cur, int curOffset, List<List<Integer>> subsets){
        if(numOffset == num.length) return; //return when index out of range
        cur[curOffset] = num[numOffset];
        subsets.add(getOneSubset(cur, 0, curOffset));

        combinationWithDup(num, numOffset + 1, cur, curOffset + 1, subsets);
        while(numOffset < num.length - 1 && num[numOffset] == num[numOffset + 1]) numOffset++; //find the next different number
        if(numOffset < num.length - 1) combinationWithDup(num, numOffset + 1, cur, curOffset, subsets);
    }

    /**
     * only find subsets contains K numbers
     *
     * check if the index of current is out of range, directly return,
     * and only create a subset when current is contains K elements
     */
    public static List<List<Integer>> combinationSizeK(int[] num, int K){
        List<List<Integer>> subsets = new ArrayList<>();
        //subsets.add(new ArrayList<Integer>());
        int[] cur = new int[K];
        Arrays.sort(num);
        combinationSizeK(num, 0, cur, 0, subsets);
        return subsets;
    }

    private static void combinationSizeK(int[] num, int numOffset, int[] cur, int curOffset, List<List<Integer>> subsets){
        if(numOffset >= num.length || curOffset >= cur.length) return;    //return when index out of range
        cur[curOffset] = num[numOffset];
        if(curOffset == cur.length - 1) subsets.add(getOneSubset(cur, 0, curOffset));

        combinationSizeK(num, numOffset + 1, cur, curOffset + 1, subsets);
        while(numOffset < num.length - 1 && num[numOffset] == num[numOffset + 1]) numOffset++; //find the next different number
        if(numOffset < num.length - 1) combinationSizeK(num, numOffset + 1, cur, curOffset, subsets);
    }

    /**
     * subsets sum equals to K, and one element can use only once.
     * only create the subset when sum is equals to K
     *
     * if all number is positive, could return when sum > K
     */
    public static List<List<Integer>> combinationSumKOnce(int[] num, int K){
        List<List<Integer>> subsets = new ArrayList<>();
        //subsets.add(new ArrayList<Integer>());
        int[] cur = new int[num.length];
        Arrays.sort(num);
        combinationSumKOnce(num, 0, cur, 0, 0, K, subsets);
        return subsets;
    }

    private static void combinationSumKOnce(int[] num, int numOffset, int[] cur, int curOffset, int sum, int K, List<List<Integer>> subsets){
        if(sum > K || numOffset == num.length) return; //assume all number are positive
        cur[curOffset] = num[numOffset];
        if(sum + num[numOffset] == K) subsets.add(getOneSubset(cur, 0, curOffset));    //sum is equal to K

        combinationSumKOnce(num, numOffset + 1, cur, curOffset + 1, sum + num[numOffset], K, subsets);
        while(numOffset < num.length - 1 && num[numOffset] == num[numOffset + 1]) numOffset++; //find the next different number
        if(numOffset < num.length - 1) combinationSumKOnce(num, numOffset + 1, cur, curOffset, sum, K, subsets);
    }

    /**
     * subsets sum equals to K, and one element can use multiple times.
     * only create the subset when sum is equals to K, and numOffset can stay or increase one.
     *  opt1: numOffset stay, curOffset++
     *  opt2: numOffset++,    curOffset stay
     *  cases of numOffset++, curOffset++ will be covered by [opt1 + opt2]
     *
     */
    public static List<List<Integer>> combinationSumKMulti(int[] num, int K){
        List<List<Integer>> subsets = new ArrayList<>();
        int[] cur = new int[K];
        Arrays.sort(num);
        combinationSumKMulti(num, 0, cur, 0, 0, K, subsets);
        return subsets;
    }

    private static void combinationSumKMulti(int[] num, int numOffset, int[] cur, int curOffset, int sum, int K, List<List<Integer>> subsets){
        if(curOffset >= cur.length || sum > K || numOffset == num.length) return;  //assume all the number in num is positive
        cur[curOffset] = num[numOffset];
        if(sum + num[numOffset] == K) subsets.add(getOneSubset(cur, 0, curOffset));
        combinationSumKMulti(num, numOffset, cur, curOffset + 1, sum + num[numOffset], K, subsets);

        while(numOffset < num.length - 1 && num[numOffset] == num[numOffset + 1]) numOffset++; //find the next different number
        if(numOffset < num.length - 1) combinationSumKMulti(num, numOffset + 1, cur, curOffset, sum, K, subsets);
    }

    private static List<Integer> getOneSubset(int[] cur, int begin, int end){
        List<Integer> subset = new ArrayList<>();
        for(int i = begin; i <= end; i++) subset.add(cur[i]);
        return subset;
    }
}
