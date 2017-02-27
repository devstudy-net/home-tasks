package net.devstudy.basic.practics.practic3_methods;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class FindPairCount {

	public static void main(String[] args) {
		int array[] = { 2, 2, 3, 4, 5, 6, 4, 3, 3, 3, 4, 5 };
		int result = 0;
		
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			if(isNumberNotProcessed(number, array, i)) {
				result += calculatePairCount(number, array, i);
			}
		}
		System.out.println(result);
	}

	public static int calculatePairCount(int number, int[] array, int i) {
		int count = 1;
		for (int j = i + 1; j < array.length; j++) {
			if(array[j] == number) {
				count++;
			}
		}
		return count / 2;
	}

	public static boolean isNumberNotProcessed(int number, int[] array, int i) {
		if(i > 0) {
			for (int j = i - 1; j >= 0; j--) {
				if(array[j] == number) {
					return false;
				}
			}
		}
		return true;
	}

}
