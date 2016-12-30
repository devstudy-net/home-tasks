package net.devstudy.basic.lection8_recursion;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class ElementSum {

	public static void main(String[] args) {
		int array[] = { 0, 1, 2, 3, 4, 5 };
		System.out.println(sum(array, 0, 0));
	}

	public static int sum(int array[], int index, int sum) {
		if (index < array.length) {
			sum += array[index];
			return sum(array, index + 1, sum);
		}
		return sum;
	}
}
