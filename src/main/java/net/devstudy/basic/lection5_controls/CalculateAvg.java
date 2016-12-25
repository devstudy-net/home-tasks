package net.devstudy.basic.lection5_controls;

import java.util.Scanner;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class CalculateAvg {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		while (true) {
			String cmd = new Scanner(System.in).nextLine();
			if (cmd.charAt(0) == '=') {
				if (count > 0) {
					System.out.println("Avg=" + (sum / count));
				} else {
					System.out.println("0");
				}
				break;
			} else {
				int value = Integer.parseInt(cmd);
				sum += value;
				count++;
			}
		}
	}
}
