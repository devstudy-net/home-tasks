package net.devstudy.basic.lection6_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class ReplaceArrayElement {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int array[] = { 0, 1, 2, 3, 4, 5 };

		int index = new Scanner(System.in).nextInt();

		if (index >= 0 && index < array.length && array.length > 0) {
			System.out.println("Before: " + Arrays.toString(array));
			int newValue = 0;
			if (index - 1 >= 0) {
				newValue += array[index - 1];
			}
			if (index + 1 < array.length) {
				newValue += array[index + 1];
			}
			array[index] = newValue;
			System.out.println("After:  " + Arrays.toString(array));
		} else {
			System.out.println("Invalid index: " + index + " or array length: " + array.length);
		}
	}

}
