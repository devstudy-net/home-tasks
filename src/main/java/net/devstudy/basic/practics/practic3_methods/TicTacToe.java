package net.devstudy.basic.practics.practic3_methods;

/**
 *
 * @author devstudy
 * @see http://devstudy.net
 */
public class TicTacToe {

	public static char NO_WINNER = 0;
	public static char EMPTY = ' ';
	public static char HUMAN = 'X';
	public static char COMPUTER = 'O';
	public static char[][] gameTable = { { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY } };

	public static char getWinner() {
		char winner = getWinnerByRows();
		if (winner != NO_WINNER) {
			return winner;
		}
		winner = getWinnerByCols();
		if (winner != NO_WINNER) {
			return winner;
		}
		winner = getWinnerByNotMainDiagonal();
		if (winner != NO_WINNER) {
			return winner;
		}
		return getWinnerByMainDiagonal();
	}

	public static char getWinnerByRows() {
		for (int i = 0; i < 3; i++) {
			if (gameTable[i][0] == gameTable[i][1] && gameTable[i][1] == gameTable[i][2] && gameTable[i][2] != EMPTY) {
				return gameTable[i][0];
			}
		}
		return NO_WINNER;
	}

	public static char getWinnerByCols() {
		for (int j = 0; j < 3; j++) {
			if (gameTable[0][j] == gameTable[1][j] && gameTable[1][j] == gameTable[2][j] && gameTable[2][j] != EMPTY) {
				return gameTable[0][j];
			}
		}
		return NO_WINNER;
	}

	public static char getWinnerByNotMainDiagonal() {
		if (gameTable[0][2] == gameTable[1][1] && gameTable[1][1] == gameTable[2][0] && gameTable[2][0] != EMPTY) {
			return gameTable[0][2];
		}
		return NO_WINNER;
	}

	public static char getWinnerByMainDiagonal() {
		if (gameTable[0][0] == gameTable[1][1] && gameTable[1][1] == gameTable[2][2] && gameTable[2][2] != EMPTY) {
			return gameTable[0][0];
		}
		return NO_WINNER;
	}

}
