package net.devstudy.basic.lection5_controls;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class PythagorasTable {

	public static void main(String[] args) {
		System.out.print('\t');
		for (int j = 1; j <= 10; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "\t");
			for (int j = 1; j <= 10; j++) {
				System.out.print((i * j) + "\t");
			}
			System.out.println();
		}
	}
}
