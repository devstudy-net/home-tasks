package net.devstudy.basic.lection7_methods;

import java.util.Arrays;
import java.util.Random;

public class Generator {

	public static int[] generateArray(int size, boolean populateRandom) {
		if(size < 0) {
			System.out.println("Invalid size");
			return null;
		} else {
			int[] array = new int [size];
			if(populateRandom) {
				Random r = new Random();
				for(int i=0;i<array.length;i++) {
					array[i] = r.nextInt();
				}
			}
			return array;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateArray(10, false)));
		System.out.println(Arrays.toString(generateArray(10, true)));
		System.out.println(Arrays.toString(generateArray(20, false)));
		System.out.println(Arrays.toString(generateArray(20, true)));
		System.out.println(Arrays.toString(generateArray(0, false)));
		System.out.println(Arrays.toString(generateArray(-3, false)));
	}

}
