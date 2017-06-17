package com.interview.util;

import java.util.Arrays;
import java.util.Random;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.graph.Graph;
import com.interview.basics.model.graph.WeightedGraph;

public class TestUtil {
	public static final Random RAND = new Random();
	/**
	 * random generate sample int array
	 */
	public static Integer[] generateIntArray(int size, int max, int min){
		return generateIntegerArray(size, max, min, false);
	}

    public static Integer[] generateIntegerArray(int size, int max, int min, boolean hasNeg){
        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++){
            int randomNum = RAND.nextInt((max - min) + 1) + min;
            if(hasNeg){
                int flag = generateInt(1);
                if(flag == 1){
                    array[i] = randomNum;
                } else {
                    array[i] = 0 - randomNum;
                }
            } else {
                array[i] = randomNum;
            }
        }
        return array;
    }

    public static int[] generateIntArray(int size, int max, int min, boolean hasNeg){
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            int randomNum = RAND.nextInt((max - min) + 1) + min;
            if(hasNeg){
                int flag = generateInt(1);
                if(flag == 1){
                    array[i] = randomNum;
                } else {
                    array[i] = 0 - randomNum;
                }
            } else {
                array[i] = randomNum;
            }
        }
        return array;
    }

    public static int[] generateIntArray(int size, boolean hasNeg){
        return generateIntArray(size, 100, 1, hasNeg);
    }

    public static int[] convert(Integer[] array){
        int[] arr = new int[array.length];
        for(int i = 0; i < array.length; i++) arr[i] = array[i];
        return arr;
    }
	/**
	 * random generate a sample int which between 0-size
	 * @param size
	 * @return
	 */
	public static int generateInt(int size){
		return RAND.nextInt(size + 1);
	}
	
	public static char[] generateCharArray(int length, int type){
		if(length <= 0){
			length = RAND.nextInt(100);
		}
		char[] str = new char[length];
		for(int i = 0; i < length; i++){
			int index = RAND.nextInt(type);
			char rc = (char) ('A' + index);
			str[i] = rc;
		}
		return str;
	}
	
	public static String generateString(){
		return new String(generateCharArray(0, 26));
	}
	
	public static String generateString(int length, int type){
		return new String(generateCharArray(length, type));
	}
	
	public static String[] generateSameLengthString(int length, int num){
		if(length <= 0){
			length = RAND.nextInt(100);
		}
		String[] strs = new String[num];
		for(int i = 0; i < num; i++){
			strs[i] = generateString(length, 7);
		}
		return strs;
	}

	
	/**
	 * return a copy of the input array
	 * @param array
	 * @return
	 */
	public static Integer[] copyArray(Integer[] array){
		Integer[] copiedArray = new Integer[array.length];
		for(int i = 0; i < array.length; i++){
			copiedArray[i] = array[i];
		}
		return copiedArray;
	}
	
	public static Graph generateGraph(int vsize, int esize, boolean ordered){
		Graph g = new Graph(vsize, ordered);
		int node = vsize - 1;
		for(int i = 0; i < esize; i++){
			int v = generateInt(node);
			int w = generateInt(node);
			if(v != w){
				g.addEdge(v, w);
			} else {
				i--;
			}
		}
		return g;
	}
	
//	0-1
//	0-2
//	0-5
//	0-6
//	1-3
//	2-3
//	2-4
//	4-5
//	4-6
	
	public static Graph generateBiPartitionGraph(){
		Graph g = new Graph(7, false);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		return g;
	}
	
//	0��5
//	0��2
//	0��1
//	3��6
//	3��5
//	3��4
//	5��4
//	6��4
//	6��0
//	3��2
//	1��4
	public static Graph generateDAGGraph(){
		Graph g = new Graph(7, true);
		g.addEdge(0, 5);
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(3, 6);
		g.addEdge(3, 5);
		g.addEdge(3, 4);
		g.addEdge(5, 2);
		g.addEdge(6, 4);
		g.addEdge(6, 0);
		g.addEdge(3, 2);
		g.addEdge(1, 4);
		return g;
	}
	
	public static WeightedGraph generateWeightedGraph(int vsize, int esize, boolean ordered){
		WeightedGraph g = new WeightedGraph(vsize, ordered);
		int node = vsize - 1;
		for(int i = 0; i < esize; i++){
			int v = generateInt(node);
			int w = generateInt(node);
			double weight = RAND.nextDouble();
			if(v != w){
				g.addEdge(v, w, weight);
			} else {
				i--;
			}
		}
		return g;
	}

    public static LinkedList generateLinkedList(int size){
        Integer[] array = generateIntArray(size, 100, 0);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < array.length; i++) list.add(array[i]);
        return list;
    }

    public static LinkedList generateCycleLinkedList(int size){
        Integer[] array = generateIntArray(size, 100, 0);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < array.length; i++) list.add(array[i]);

        int cycle = generateInt(size - 1);
        list.getNode(size - 1).next = list.getNode(cycle);
        return list;
    }

    public static int[] generatePartialSortedArray(int size){
        int[] arr1 = TestUtil.generateIntArray(size/2, false);
        int[] arr2 = TestUtil.generateIntArray(size - size/2, false);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] array = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++) array[i] = arr1[i];
        for(int i = 0; i < arr2.length; i++) array[i+arr1.length] = arr2[i];
        return array;
    }
	
}
