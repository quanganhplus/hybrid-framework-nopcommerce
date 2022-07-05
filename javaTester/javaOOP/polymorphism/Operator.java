package javaOOP.polymorphism;

public class Operator {

	public void sum(int a, int b) {
		System.out.println(a + b);
	}

	public void sum(double a, double b) {
		System.out.println(a + b);
	}

	public void sum(float a, float b) {
		System.out.println(a + b);
	}

	public void sum(long a, long b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {
		Operator opr = new Operator();

		opr.sum(5, 8);
	}
}
