package net.devstudy.basic.practics.practic2_arrays;

import java.util.Arrays;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class BubbleSort {

	public static void main(String[] args) {
		int array[] = { 7, 0, -4, 3, 1, -2, 5 };

		// sort
		for (int j = 0; j < array.length; j++) {
			boolean isSorted = true;
			for (int i = array.length - 1; i > j; i--) {
				if (array[i] < array[i - 1]) {
					int temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
					isSorted = false;
				}
			}
			if(isSorted) {
				break;
			}
		}

		System.out.println(Arrays.toString(array));
	}
}
