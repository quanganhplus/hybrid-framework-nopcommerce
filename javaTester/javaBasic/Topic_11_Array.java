package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array {

	int number[] = { 5, 8, 101, 9, 15, 60 };

	@Test
	public void TC_01_Find_Max_Number() {

		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x < number[i]) {
				x = number[i];
			}
		}
		System.out.println("Max number = " + x);
		System.out.println("Fist number = " + number[0]);
		System.out.println("Last number = " + number[number.length - 1]);
	}

	@Test
	public void TC_02_Sum_Fist_And_Last_Number() {
		int fistNumber = number[0];
		int lastNumber = number[number.length - 1];
		int sumNumber = fistNumber + lastNumber;
		System.out.println("Tổng 2 số đầu cuối = " + sumNumber);
	}

	@Test
	public void TC_03() {
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println("Số chẵn = " + number[i]);
			}
		}
	}

	@Test
	public void TC_04() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
		}
		System.out.println("Tổng các số = " + sum);
		System.out.println("Tổng trung bình cộng các số = " + sum / number.length);
	}
}
