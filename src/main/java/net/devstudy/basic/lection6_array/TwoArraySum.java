package net.devstudy.basic.lection6_array;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class TwoArraySum {

	public static void main(String[] args) {
		int array1[] = { 0, 1, 2, 4 };
		int array2[] = { 0, 1, 2 };

		int sum = 0;
		for (int i = 0; i < array1.length && i < array2.length; i++) {
			sum += array1[i] + array2[i];
		}

		if (array1.length != array2.length) {
			int array[];
			int min;
			int max;
			if (array1.length > array2.length) {
				array = array1;
				min = array2.length;
				max = array1.length;
			} else {
				array = array2;
				min = array1.length;
				max = array2.length;
			}
			
			for(int i=min;i<max;i++){
				sum += array[i];
			}
		}
		
		System.out.println(sum);
	}

}
