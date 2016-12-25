package net.devstudy.basic.lection6_array;

import java.util.Arrays;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class SwapMinAndMaxElements {

	public static void main(String[] args) {
		int array[] = { 11, 2, 4, 7, 1, 0 };
		int minElement = Integer.MAX_VALUE;
		int minIndex = -1;
		int maxElement = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if(minElement > array[i]) {
				minElement = array[i];
				minIndex = i;
			}
			if(maxElement < array[i]) {
				maxElement = array[i];
				maxIndex = i;
			}
		}
		
		if(minIndex > -1 && maxIndex > -1 && minIndex != maxIndex) {
			int temp = array[minIndex];
			array[minIndex] = array[maxIndex];
			array[maxIndex] = temp;
		}
		
		System.out.println(Arrays.toString(array));
	}

}
