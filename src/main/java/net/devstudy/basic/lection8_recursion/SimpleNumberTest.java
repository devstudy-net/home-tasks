package net.devstudy.basic.lection8_recursion;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class SimpleNumberTest {
	public static boolean recursion(int number, int base) {
		if (number < 2) {
			return false;
		} else if (number == 2) {
			return true;
		} else if (number % base == 0) {
			return false;
		} else if (base < number / 2) {
			return recursion(number, base + 1);
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(recursion(23, 2));
	}
}
