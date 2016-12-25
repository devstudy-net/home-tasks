package net.devstudy.basic.lection5_controls;

import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class SumOfEvenNumbers {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int min = new Scanner(System.in).nextInt();
		int max = new Scanner(System.in).nextInt();
		if (max > min) {
			int sum = 0;
			for (int i = min; i <= max; i++) {
				if (i % 2 == 0) {
					sum += i;
				}
			}
			System.out.println("Sum=" + sum);
		} else {
			System.out.println("Invalid arguments");
		}
	}
}
