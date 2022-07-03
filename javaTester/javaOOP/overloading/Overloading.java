package javaOOP.overloading;

public class Overloading {
	private int firstNumber;
	private int secondNumber;

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void sumNumber(int sumNumber) {
		System.out.println(sumNumber + 100);
	}

	public void sumNumber(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(float firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(int firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {
		Overloading over = new Overloading();
		over.sumNumber(15);

	}

}
