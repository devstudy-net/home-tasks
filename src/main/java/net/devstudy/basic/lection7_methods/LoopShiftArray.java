package net.devstudy.basic.lection7_methods;

import java.util.Arrays;

public class LoopShiftArray {

	public static void main(String[] args) {
		int array[] = { 0, 1, 2, 3, 4, 5 };
		System.out.println("Test array =\t" + Arrays.toString(array));
		shift(array, 2, true);
		System.out.println("Shift right 2 =\t" + Arrays.toString(array));
		shift(array, 2, false);
		System.out.println("Shift left 2 =\t" + Arrays.toString(array));
		shift(array, array.length, true);
		System.out.println("Shift right " + array.length + " =\t" + Arrays.toString(array));
	}

	public static void shift(int array[], int step, boolean rightDirection) {
		int arrayCopy[] = new int[array.length];
		System.arraycopy(array, 0, arrayCopy, 0, array.length);
		for (int i = 0; i < array.length; i++) {
			int destIndex = i + (rightDirection ? step : -step);
			if (destIndex >= array.length) {
				destIndex = destIndex % array.length;
			} else if (destIndex < 0) {
				destIndex = array.length + destIndex;
			}
			array[destIndex] = arrayCopy[i];
		}
	}
}
