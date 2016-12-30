package net.devstudy.basic.lection4_io_expressions;

import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class AvgTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input a:");
		int a = new Scanner(System.in).nextInt();
		System.out.println("Input b:");
		int b = new Scanner(System.in).nextInt();

		System.out.println("Avg=" + (a + b) / 2);
	}

}
