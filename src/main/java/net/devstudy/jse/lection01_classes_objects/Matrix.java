package net.devstudy.jse.lection01_classes_objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Matrix {
	private double[][] data;
	private int rows;
	private int cols;

	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.data = new double[rows][cols];
	}

	public void fill(double value) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = value;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				//метод print не печатает символов перехода на новую строку
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

	public Matrix transpose() {
		//Создаем новый объект матрицы
		Matrix m = new Matrix(cols, rows);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				//меняя местами i и j, получаем доступ к транспонированной версии матрицы
				m.data[j][i] = this.data[i][j];
			}
		}
		return m;
	}

	public static void main(String[] args) {
		Matrix m1 = new Matrix(2, 3);
		m1.fill(5);
		m1.print();
		System.out.println("-------------");
		Matrix m2 = m1.transpose();// Создаем новую матрицу, которая является транспонированной версией начальной матрицы
		System.out.println("m2.rows=" + m2.getRows() + ", m2.cols=" + m2.getCols());
		m2.print();
		System.out.println("-------------");
		m1.print();
	}
}
