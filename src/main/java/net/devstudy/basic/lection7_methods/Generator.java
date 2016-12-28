package net.devstudy.basic.lection7_methods;

import java.util.Arrays;
import java.util.Random;

public class Generator {

	public static int[] generateArray(int size, boolean populateRandom) {
		if (size < 0) {
			System.out.println("Invalid size: " + size);
			return null;
		} else {
			int[] array = new int[size];
			if (populateRandom) {
				Random r = new Random();
				for (int i = 0; i < array.length; i++) {
					array[i] = r.nextInt();
				}
			}
			return array;
		}
	}

	public static void main(String[] args) {
		int arguments[] = { 10, 10, 20, 20, 0, -3 };
		boolean populateRandom = false;
		for (int i = 0; i < arguments.length; i++) {
			System.out.println("size=" + arguments[i] + ", populateRandom=" + populateRandom + "->" + Arrays.toString(generateArray(arguments[i], populateRandom)));
			populateRandom = !populateRandom;
		}
	}
}
