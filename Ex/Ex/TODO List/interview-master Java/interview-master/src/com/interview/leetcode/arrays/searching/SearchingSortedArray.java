package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午4:26
 */
public class SearchingSortedArray {

    public static int findR(int[] array, int target){
        return findR(array, target, 0, array.length - 1);
    }

    private static int findR(int[] array, int target, int low, int high){
        if(low > high) return -1;
        int mid = (low + high)/2;
        if(target == array[mid]) return mid;
        else if(target < array[mid]) return findR(array, target, low, mid - 1);
        else return findR(array, target, mid + 1, high);
    }

    public static int findL(int[] array, int target){
        int lower = 0;
        int higher = array.length - 1;
        while(lower < higher) {
            int mid = (lower + higher) / 2;
            if(array[mid] == target) return mid;  //return when find one
            if (array[mid] < target) lower = mid + 1;
            else higher = mid;
        }
        return array[lower] == target ? lower : -1;
    }
}
