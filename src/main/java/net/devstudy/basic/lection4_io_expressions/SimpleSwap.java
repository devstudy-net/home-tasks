package net.devstudy.basic.lection4_io_expressions;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class SimpleSwap {

	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		
		a += b;
		b = a - b;
		a = a - b;
	
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
