package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午4:42
 */
public class SearchingRotatedArrayWithDuplication {

    public static int minL(int[] array){
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            while(low < high && array[low] == array[high]) high--;  //handle duplication
            int mid = (low + high) / 2;
            if(array[mid] > array[mid + 1]) return array[mid + 1];  //find max, return min
            else if(array[mid] > array[high]) low = mid + 1;
            else high = mid;
        }
        return array[0];
    }

    public static int maxL(int[] array){
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            while(low < high && array[low] == array[high]) low++; //handle duplication
            int mid = (low + high) / 2;
            if(array[mid] > array[mid + 1]) return array[mid];   //return max
            else if(array[mid] > array[high]) low = mid + 1;
            else high = mid;
        }
        return array[array.length - 1];
    }

    public static int findL(int[] array, int target){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            while(low < high && array[low] == array[high]) high--; //if array[low] = array[high] move high to a element not equals to low, to avoid can't determine left or right in the following case
            int mid = (low + high) / 2;
            if(target == array[mid]) return mid;
            if(target < array[mid]){
                if(array[low] <= array[mid] && target < array[low]) low = mid + 1;   //when left part is in order, and target < array[low], should searching in the right part
                else high = mid - 1;  //searching in the left part
            } else {
                if(array[high] >= array[mid] && target > array[high]) high = mid - 1; //when right part is in order, and target > array[high], should searching in the left part
                else low = mid + 1;   //searching in the right part
            }
        }
        return -1;
    }

    public static int minR(int[] array){
        return minR(array, 0, array.length - 1);
    }

    private static int minR(int[] array, int low, int high){
        if(low == high) return array[low];
        int mid = (low + high)/2;
        if(mid > low && array[mid - 1] > array[mid]) return array[mid];  //in a increasing array, if prev > cur, cur is the min
        if(array[mid] == array[high] && array[mid] == array[low]){   //handle duplication: [3 1 3 3 3] or [3 3 3 1 3] can't determine searching in left or right.
            return minR(array, low + 1, high);    //low move 1 step forward
        } else if(array[mid] > array[high]) return minR(array, mid + 1, high);   //if mid >= high, breaking point(min) is at right part
        else return minR(array, low, mid);
    }

    public static int maxR(int[] array){
        return maxR(array, 0, array.length - 1);
    }

    private static int maxR(int[] array, int low, int high){
        if(low == high) return array[low];
        int mid = (low + high)/2;
        if(array[mid] > array[mid + 1]) return array[mid];  //in a increasing array, if next < cur, cur is the max
        if(array[mid] == array[high] && array[mid] == array[low]){   //handle duplication: [1 3 1 1 1] or [1 1 1 3 1] can't determine searching in left or right.
            return maxR(array, low + 1, high);    //low move 1 step forward
        } else if(array[mid] > array[low]) return maxR(array, mid + 1, high);   //if mid >= low, breaking point(max) is not in left part
        else return maxR(array, low, mid);
    }

    public static int findR(int[] array, int target){
        return findR(array, target, 0, array.length - 1);
    }

    private static int findR(int[] array, int target, int low, int high) {
        if(low > high) return -1;
        while(low < high && array[low] == array[high]) high--;    //if array[low] = array[high] move high to a element not equals to low, to avoid can't determine left or right in the following case
        int mid = (low + high) / 2;
        if(target == array[mid]) return mid;   //found target
        else if(target < array[mid]){
            if(array[low] <= array[mid] && target < array[low])
                return findR(array, target, mid + 1, high);  //when left part is in order, and target < array[low], should searching in the right part
            else return findR(array, target, low, mid - 1);   //searching in the left part
        } else {
            if(array[high] >= array[mid] && target > array[high])
                return findR(array, target, low, mid - 1); //when right part is in order, and target > array[high], should searching in the left part
            else return findR(array, target, mid + 1, high);  //searching in the right part
        }
    }
}
