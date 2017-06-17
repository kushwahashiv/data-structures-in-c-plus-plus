package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午6:16
 */
public class SearchingVArray {
    public static int minR(int[] array){
        return minR(array, 0, array.length - 1);
    }
    
    private static int minR(int[] array, int low, int high){
        if(low == high) return array[low];
        int mid = (low + high)/2;
        int cmp1 = mid > low? array[mid] - array[mid - 1] : -1;
        int cmp2 = mid < high? array[mid] - array[mid + 1] : -1;
        if(cmp1 < 0 && cmp2 < 0) return array[mid];  //smaller than prev and next, it's the min
        else if(cmp1 > 0){   //larger than prev, mid in the increasing part, search in left
            return minR(array, low, mid - 1);
        } else if(cmp2 > 0){ //larger than next, mid in the decreasing part, search in right
            return minR(array, mid + 1, high);
        } else {  //mid equals with mid+1 and mid-1, move low one step, handle duplication
            return minR(array, low + 1, high);
        }
    }

    public static int findR(int[] array, int target){
        return findR(array, target, 0, array.length - 1);
    }

    private static int findR(int[] array, int target, int low, int high){
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(target == array[mid]) return array[mid];
        else if(target < array[mid]){
            int cmp1 = mid > low? array[mid] - array[mid - 1] : -1;
            int cmp2 = mid < high? array[mid] - array[mid + 1] : -1;
            if(cmp1 < 0 && cmp2 < 0) return -1; //mid is the min;
            else if(cmp1 > 0) return findR(array, target, low, mid - 1); //larger than prev, mid in the increasing part, search in left
            else if(cmp2 > 0) return findR(array, target, mid + 1, high); //larger than next, mid in the decreasing part, search in right
            else return findR(array, target, low + 1, high);   //mid equals with mid+1 and mid-1, move low one step, handle duplication
        } else {
            int found = (array[low] >= target)? findR(array, target, low, mid - 1): -1;  //searching left
            if(found == -1) found = array[high] >= target? findR(array, target, mid + 1, high): -1;  //no found, searching right
            return found;
        }
    }


}
