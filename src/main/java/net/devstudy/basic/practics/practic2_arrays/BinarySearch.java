package net.devstudy.basic.practics.practic2_arrays;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class BinarySearch {

	public static void main(String[] args) {
		int array[] = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		for (int i = -2; i < array.length + 2; i++) {
			int query = i;
			
			int index = -1;
			
			int low = 0;
			int high = array.length - 1;
			while(low <= high) {
				int middleIndex = (low + high) / 2;
				int middleValue = array[middleIndex];
				if(middleValue < query) {
					low = middleIndex + 1;
				} else if(middleValue > query) {
					high = middleIndex - 1;
				} else {
					index = middleIndex;
					break;
				}
			}
			
			System.out.println("Index="+index);
		}
		
	}

}
