package com.interview.leetcode.arrays;

import com.interview.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午7:20
 *
 * Given a int[] num, find all the unique the permutation of given numbers.
 * 1. when num doesn't have duplication   {@link #permutationsNoDup}
 * 2. when num have duplication, and need unique subsets   {@link #permutationsWithDup}
 * 3. Given N numbers, assume the permutation sequence rearranges numbers into the lexicographically.
 *    3.1 given one permutation, get it's next permutation, {@link #nextPermutation}
 *        if no next exist, give the lowest possible order (ie, sorted in ascending order).
 *    3.2 return the kth permutation sequence.  {@link #KthPermutation}
 *
 * Tricks:
 *   1. deep dive in the rules of how permutation is generated.
 *          which one is next permutation, how many permutation could generated in current index fixed.
 *   2. use String "123456789" hold the candidates and delete char when the number is selected, easier to handle than list or set, and also sorted.
 */
public class Permutations {
    /**
     * use a boolean[] mark to store if the num is selected.
     * find a permutation when cur is all filled.
     */
    public static List<List<Integer>> permutationsNoDup(int[] num){
        List<List<Integer>> permutations = new ArrayList<>();
        Integer[] cur = new Integer[num.length];
        boolean[] mark = new boolean[num.length];
        permutationsNoDup(num, mark, cur, 0, permutations);
        return permutations;
    }

    private static void permutationsNoDup(int[] num, boolean[] mark, Integer[] cur, int curOffset, List<List<Integer>> permutations){
        if(curOffset == cur.length){
            permutations.add(new ArrayList<>(Arrays.asList(cur)));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(mark[i] == true) continue;
            mark[i] = true;
            cur[curOffset] = num[i];
            permutationsNoDup(num, mark, cur, curOffset + 1, permutations);
            mark[i] = false;
        }
    }

    /**
     * sort the num array, and only create permutation when previous same number all in the permutation.
     */
    public static List<List<Integer>> permutationsWithDup(int[] num){
        Arrays.sort(num);
        List<List<Integer>> permutations = new ArrayList<>();
        Integer[] cur = new Integer[num.length];
        boolean[] mark = new boolean[num.length];
        permutationsWithDup(num, mark, cur, 0, permutations);
        return permutations;
    }

    private static void permutationsWithDup(int[] num, boolean[] mark, Integer[] cur, int curOffset, List<List<Integer>> permutations){
        if(curOffset == cur.length){
            permutations.add(new ArrayList<>(Arrays.asList(cur)));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(mark[i] == true) continue;
            boolean unusedDuplication = false;
            int j = i - 1;
            while(j >= 0 && num[j] == num[i]){       //when select next option, skip the element have same value as last one for this curNum.
                if(!mark[j])  {                      //find the next element not same value as previous value on this offset in current
                    unusedDuplication = true;
                    break;
                }
                j--;
            }
            if(!unusedDuplication){
                mark[i] = true;
                cur[curOffset] = num[i];
                permutationsWithDup(num, mark, cur, curOffset + 1, permutations);
                mark[i] = false;
            }

        }
    }

    /**
     * such as 4,2,0,2,3,2,0, the next one is 4,2,0,3,0,2,2
     * 1. scan backward, at index i, find the min of number larger than num[i] in i+1 ~ end
     * 2. if found, swap(i, min), and sort i+1 ~ end as ascending order.
     *    if not found for all number, sort num in ascending order.
     */
    public static void nextPermutation(int[] num) {
        for(int i = num.length - 2; i >= 0; i--){
            int min = -1;
            for(int j = i + 1; j < num.length; j++){
                if(num[j] > num[i]) {
                    if (min == -1 || num[j] < num[min]) min = j;
                }
            }
            if(min != -1){
                ArrayUtil.swap(num, i, min);
                Arrays.sort(num, i + 1, num.length);
                return;
            }
        }
        Arrays.sort(num, 0, num.length);
    }

    /**
     * 1. calculate the N! for each number.  factor is how many permutation could be found when 0~i-th element is settled.
     * 2. from n - 1 ~ 0,
     *      every time find the index of jth in candidate nums. j is k / factor[i].
     *      add the number in permutation and delete the number in candidate nums.
     *      k = k - j * factor[i]
     */
    public static String KthPermutation(int n, int k){
        if(n > 9 || k <= 0) return "";
        if(n == 1) return "1";

        int[] factors = new int[n + 1];
        factors[0] = 1;
        for(int i = 1; i <= n; i++) factors[i] = factors[i - 1] * i;

        k = k - 1;
        k = k % factors[n];

        StringBuilder nums = new StringBuilder("123456789");
        StringBuilder permutation = new StringBuilder();
        for(int i = n - 1; i >= 0; i--){
            int curNum = k / factors[i];
            permutation.append(nums.charAt(curNum));
            nums.deleteCharAt(curNum);
            k = k - curNum * factors[i];
        }
        return permutation.toString();
    }
}
