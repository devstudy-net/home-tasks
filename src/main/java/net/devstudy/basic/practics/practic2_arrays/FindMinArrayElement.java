package net.devstudy.basic.practics.practic2_arrays;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class FindMinArrayElement {

	public static void main(String[] args) {
		int array[] = {0, -3, 8, 10, -5, 0, 4};
		if(array.length == 0) {
			System.out.println("Min element not found: array is empty");
		} else {
			int minElement = array[0];
			for (int i = 1; i < array.length; i++) {
				if(array[i] < minElement) {
					minElement = array[i];
				}
			}
			System.out.println(minElement);
		}
	}
}
