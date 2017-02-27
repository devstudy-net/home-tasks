package net.devstudy.basic.practics.practic1_controls;
/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class ShowNumberPyramid {

	public static void main(String[] args) {
		int rows = 6;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows - i - 1; j++) {
				System.out.print("   ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print(" " + (i + 1) +" ");
			}
			System.out.println();
		}
	}

}
