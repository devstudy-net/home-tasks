package net.devstudy.basic.lection7_methods;

import java.util.Arrays;

public class ArraySum {

	public static void main(String[] args) {
		int[] first = { 0, 1, 2, 3, 4, 5 };
		int[] second = { 5, 4, 3, 2, 1, 0 };
		System.out.println("first=" + Arrays.toString(first));
		System.out.println("second=" + Arrays.toString(second));
		System.out.println("sum=" + Arrays.toString(sum(first, second)));
		System.out.println("-------------------");
		System.out.println("sum=" + Arrays.toString(sum(first, new int[1])));
	}

	public static int[] sum(int[] first, int[] second) {
		if (first.length != second.length) {
			System.out.println("Invalid arguments: first.length != second.length");
			return null;
		} else {
			int res[] = new int[first.length];
			for (int i = 0; i < res.length; i++) {
				res[i] = first[i] + second[i];
			}
			return res;
		}
	}
}
