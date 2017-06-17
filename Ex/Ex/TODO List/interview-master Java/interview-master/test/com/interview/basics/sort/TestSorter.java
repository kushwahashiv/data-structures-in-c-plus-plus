package com.interview.basics.sort;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import com.interview.util.TestUtil;

public class TestSorter extends TestCase {
	public static Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);

	@Test
	public void testSelectSort() {
		Sorter<Integer> sorter = new SelectSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
	}
	
	@Test
	public void testInsertSort(){
		Sorter<Integer> sorter = new InsertSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
	}
	
	@Test
	public void testShellSort(){
		Sorter<Integer> sorter = new ShellSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
	}
	
	@Test
	public void testMergeSort(){
		Sorter<Integer> sorter = new MergeSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
	}

    @Test
    public void testKWayMergeSort(){
        Integer[] array = TestUtil.generateIntArray(48, 100, 0);
        Sorter<Integer> sorter = new MergeSorterKWay<>(5);
        Integer[] sortedArray = sorter.sort(TestUtil.copyArray(array));
        //ConsoleWriter.printIntArray(array);
        //ConsoleWriter.printIntArray(sortedArray);
        assertOrder(sortedArray, true);
    }
	
	@Test
	public void testQuickSort(){
		Sorter<Integer> sorter = new QuickSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
	}

    @Test
    public void testSimplestQuickSort(){
        Sorter<Integer> sorter = new QuickSorterSimplest<>();
        Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
    }

    @Test
    public void testThreeMedianQuickSort(){
        Sorter<Integer> sorter = new QuickSorterThreeMedian<>();
        Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray, true);
    }

    @Test
    public void testThreeWayQuickSort(){
        Sorter<Integer> sorter = new QuickSorterThreeWay<>();
        Integer[] array = TestUtil.generateIntArray(20, 5, 0);
        //ConsoleWriter.printIntArray(array);
        Integer[] sortedArray = sorter.sort(TestUtil.copyArray(array));
        //ConsoleWriter.printIntArray(sortedArray);

        sorter = new QuickSorterSimplest<>();
        Integer[] expected = sorter.sort(TestUtil.copyArray(array));
        //ConsoleWriter.printIntArray(sortedArray);
        Assert.assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testDualPivotsQuickSort(){
        //Integer[] array = new Integer[]{73, 7, 11, 73, 29, 31, 61, 13, 78, 50};
        Sorter<Integer> sorter = new QuickSorterDualPivots<>();
        Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        //ConsoleWriter.printIntArray(testArray);
        //ConsoleWriter.printIntArray(sortedArray);
        assertOrder(sortedArray, true);
    }

	@Test
	public void testHeapUpSort(){
		Sorter<Integer> sorter = new HeapSorter<Integer>();
		Integer[] array = new Integer[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
		Integer[] sortedArray = sorter.sort(array);
        assertOrder(sortedArray, false);
	}
	
	@Test
	public void testHeapDownSort(){
		HeapSorter<Integer> sorter = new HeapSorter<Integer>();
		sorter.up = false;
		Integer[] array = new Integer[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
		Integer[] sortedArray = sorter.sort(array);
        assertOrder(sortedArray, true);
	}

    @Test
    public void testRadixSort(){
        RadixSorter<Integer> sorter = new RadixSorter<>();
        Integer[] array = new Integer[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
        Integer[] sortedArray = sorter.sort(array);
        //ConsoleWriter.printIntArray(sortedArray);
        assertOrder(sortedArray, true);

        array = new Integer[] {166, 32, 73, 32, 505, 33, 30, 16, 40, 213};
        sortedArray = sorter.sort(array);
        //ConsoleWriter.printIntArray(sortedArray);
        assertOrder(sortedArray, true);
    }

    private void assertOrder(Integer[] array, boolean asc){
        for(int i = 0; i < array.length - 1; i++){
            if(asc){
                assertTrue(array[i] <= array[i + 1]);
            } else {
                assertTrue(array[i] >= array[i + 1]);
            }

        }
    }
}
