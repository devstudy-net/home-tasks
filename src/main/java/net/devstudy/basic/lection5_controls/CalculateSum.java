package net.devstudy.basic.lection5_controls;

import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class CalculateSum {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (i + 1);
		}
		System.out.println(sum);
	}
}
