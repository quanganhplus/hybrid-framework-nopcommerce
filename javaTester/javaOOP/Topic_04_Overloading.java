package javaOOP;

public class Topic_04_Overloading {

	static int plusMethod(int x, int y) {
		return x + y;
	}

	static double plusMethod(double x, double y) {
		return x + y;
	}

	public static void main(String[] args) {
		int myNum1 = plusMethod(6, 8);
		double myNum2 = plusMethod(5.5, 9.5);

		System.out.println("int: " + myNum1);
		System.out.println("double: " + myNum2);
	}

}
