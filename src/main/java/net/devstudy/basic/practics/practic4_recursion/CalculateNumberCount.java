package net.devstudy.basic.practics.practic4_recursion;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class CalculateNumberCount {

	public static void main(String[] args) {
		int array[] = { 1, 2, 1, 1 };
		int number = 1;

		System.out.println(calculateCountIter1(array, number));
		System.out.println(calculateCountIter2(array, number));
		System.out.println(calculateCountRecur1(array, number, 0, 0));
		System.out.println(calculateCountRecur2(array, number, 0));
	}

	public static int calculateCountIter1(int[] array, int number) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				count++;
			}
		}
		return count;
	}

	public static int calculateCountIter2(int[] array, int number) {
		int count = 0;
		for (int i = 0;;) {
			if (i >= array.length) {
				break;
			}
			if (array[i] == number) {
				count++;
			}
			i++;
		}
		return count;
	}
	
	public static int calculateCountRecur1(int[] array, int number, int i, int count) {
		if (i >= array.length) {
			return count;
		}
		if (array[i] == number) {
			count++;
		}
		return calculateCountRecur1(array, number, i + 1, count);
	}
	
	public static int calculateCountRecur2(int[] array, int number, int i) {
		if (i >= array.length) {
			return 0;
		}
		int count = 0;
		if (array[i] == number) {
			count++;
		}
		return count + calculateCountRecur2(array, number, i + 1);
	}

}
