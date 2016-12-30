package net.devstudy.basic.lection8_recursion;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class FindMaxElementRecursive {

	public static void main(String[] args) {
		int array[] = { 1, 2, 0, -3, 5, 7, -9, 11, 6 };
		System.out.println(findMax(array, 0, Integer.MIN_VALUE));
	}

	public static int findMax(int array[], int index, int maxElement) {
		if (index < array.length) {
			int value = array[index];
			if (value > maxElement) {
				return findMax(array, index + 1, value);
			} else {
				return findMax(array, index + 1, maxElement);
			}
		}
		return maxElement;
	}
}
