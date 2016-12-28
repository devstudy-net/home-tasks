package net.devstudy.basic.lection7_methods;

import java.util.Arrays;
import java.util.Random;

public class WorkWithArray {

	public static void populate(int[] array, int min, int max) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			int value = r.nextInt(max - min + 1) + min;
			array[i] = value;
		}
	}

	public static int findMin(int[] array) {
		int minElement = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (minElement > array[i]) {
				minElement = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static int findMax(int[] array) {
		int maxElement = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (maxElement < array[i]) {
				maxElement = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int array[] = new int[20];
		populate(array, 1, 10);
		System.out.println("Test array = " + Arrays.toString(array));
		int minIndex = findMin(array);
		int maxIndex = findMax(array);
		if (minIndex != -1) {
			System.out.println("Min element = " + array[minIndex]);
		}
		if (maxIndex != -1) {
			System.out.println("Max element = " + array[maxIndex]);
		}
	}

}
