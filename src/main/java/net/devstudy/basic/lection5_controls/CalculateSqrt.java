package net.devstudy.basic.lection5_controls;

import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class CalculateSqrt {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		while (true) {
			String cmd = new Scanner(System.in).nextLine();
			if (cmd.charAt(0) == 'q') {
				System.out.println("Bye");
				break;
			} else {
				double value = Double.parseDouble(cmd);
				if (value >= 0) {
					System.out.println("sqrt(" + value + ")=" + Math.sqrt(value));
				} else {
					System.out.println("Invalid argument");
				}
			}
		}
	}

}
