package net.devstudy.basic.practics.practic4_recursion;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class ShowGrid {

	public static void main(String[] args) {
		int rows = 3;
		int cols = 4;

		printGameTable(rows, cols);
	}

	public static void printGameTable(int rows, int cols) {
		if (rows > 0) {
			//printSpacesWithVerticalLines(cols);
			printLine("   ", "|", cols);
			System.out.println();
			if (rows > 1) {
				//printHorizontalLines(cols);
				printLine("---", "-", cols);
				System.out.println();
			}
			printGameTable(rows - 1, cols);
		}
	}
	/*
	public static void printSpacesWithVerticalLines(int cols) {
		if (cols > 0) {
			System.out.print("   ");
			if (cols > 1) {
				System.out.print("|");
			}
			printSpacesWithVerticalLines(cols - 1);
		}
	}

	public static void printHorizontalLines(int cols) {
		if (cols > 0) {
			System.out.print("---");
			if (cols > 1) {
				System.out.print("-");
			}
			printHorizontalLines(cols - 1);
		}
	}
	*/
	public static void printLine(String mainText, String delimeter, int cols) {
		if (cols > 0) {
			System.out.print(mainText);
			if (cols > 1) {
				System.out.print(delimeter);
			}
			printLine(mainText, delimeter, cols - 1);
		}
	}
}
