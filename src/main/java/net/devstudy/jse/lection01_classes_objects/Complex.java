package net.devstudy.jse.lection01_classes_objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Complex {
	private double x;
	private double y;

	private Complex() {
		//Конструктор нужен для методов add, sub, mul, div, поэтому он private
	}

	public Complex(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getValue() {
		// Строковое представление комплексного числа
		return x + "+i*" + y;
	}

	public Complex add(Complex secondArgument) {
		Complex res = new Complex();
		res.setX(this.x + secondArgument.x);
		res.setY(this.y + secondArgument.y);
		return res;
	}

	public Complex sub(Complex secondArgument) {
		Complex res = new Complex();
		//Для доступа к текущим x и y можно опустить this
		res.setX(x - secondArgument.x);
		res.setY(y - secondArgument.y);
		return res;
	}

	public Complex mul(Complex secondArgument) {
		Complex res = new Complex();
		res.setX(x * secondArgument.x - y * secondArgument.y);
		res.setY(y * secondArgument.x + x * secondArgument.y);
		return res;
	}

	public Complex div(Complex secondArgument) {
		Complex res = new Complex();
		res.setX((x * secondArgument.x + y * secondArgument.y) / (secondArgument.x * secondArgument.x + secondArgument.y * secondArgument.y));
		res.setY((y * secondArgument.x - x * secondArgument.y) / (secondArgument.x * secondArgument.x + secondArgument.y * secondArgument.y));
		return res;
	}

	public static void main(String[] args) {
		Complex a = new Complex(1, 2);
		Complex b = new Complex(1, 2);

		System.out.println(a.getValue() + " + " + b.getValue() + " = " + a.add(b).getValue());
		System.out.println(a.getValue() + " - " + b.getValue() + " = " + a.sub(b).getValue());
		System.out.println(a.getValue() + " * " + b.getValue() + " = " + a.mul(b).getValue());
		System.out.println(a.getValue() + " / " + b.getValue() + " = " + a.div(b).getValue());
	}
}
