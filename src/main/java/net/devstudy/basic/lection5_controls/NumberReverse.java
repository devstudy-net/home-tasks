package net.devstudy.basic.lection5_controls;

import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class NumberReverse {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input a:");
		int a = new Scanner(System.in).nextInt();
		int result = 0;
		int base = 10;
		while (true) {
			int digit = a % 10;
			result = result * base + digit;
			a /= 10;
			if (a == 0) {
				break;
			}
		}
		System.out.println("Result=" + result);
	}

}
