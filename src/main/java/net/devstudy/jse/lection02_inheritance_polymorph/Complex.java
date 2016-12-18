package net.devstudy.jse.lection02_inheritance_polymorph;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Complex extends Number{
	private static final long serialVersionUID = -1239472789501205616L;
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

	@Override
	public int intValue() {
		return (int)x; // Отбрасывать нужно мнимую часть, так как все числа int, double, и т.д. являются вещественными
	}

	@Override
	public long longValue() {
		return (long)x;
	}

	@Override
	public float floatValue() {
		return (float) x;
	}

	@Override
	public double doubleValue() {
		return x;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Complex other = (Complex) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getValue();
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
