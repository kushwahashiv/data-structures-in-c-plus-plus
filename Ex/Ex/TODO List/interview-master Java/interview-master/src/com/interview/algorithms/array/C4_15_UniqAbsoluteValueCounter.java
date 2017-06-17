package com.interview.algorithms.array;

import com.interview.utils.ConsoleReader;

/**
 * Find the uniq amount of absolute values in a given sorted array
 * 
 * @author zouzhile
 *
 */
public class C4_15_UniqAbsoluteValueCounter {

    public int count(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int count = 0;
        while(left < right) {
            if(Math.abs(array[left]) == Math.abs(array[right]))
                count += 1;
            else
                count += 2;

            do {
                left ++;
            } while(array[left] == array[left - 1]);

            do {
                right --;
            } while(array[right] == array[right + 1]);
        }

        return count;
    }

	public static void main(String[] args) {
		ConsoleReader reader = new ConsoleReader();
		System.out.println("Count the amount of unique absolute values in the given int array");
		System.out.println("===============================================================================");
		int [] array = reader.readSortedIntItems();
		C4_15_UniqAbsoluteValueCounter counter = new C4_15_UniqAbsoluteValueCounter();
		int count = counter.count(array);
		System.out.println("The amount of unique absolute value: " + count);
	}

}
