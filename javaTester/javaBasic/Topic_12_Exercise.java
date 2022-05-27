package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Exercise {

	String courseName = "Toa nha FPT - 17 Duy Tan";

	@Test
	public void TC_01() {
		char courseNameArray[] = courseName.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		for (char character : courseNameArray) {
			if (character >= 'A' && character <= 'Z') {
				countUpper++;
			}

			// LowerCase
			if (character >= 'a' && character <= 'z') {
				countLower++;
			}

			// Number
			if (character >= '0' && character <= '9') {
				countNumber++;
			}
		}

		System.out.println("Sum of uppercase = " + countUpper);
		System.out.println("Sum of lowercase = " + countLower);
		System.out.println("Sum of number = " + countNumber);
	}

	@Test
	public void TC_02() {
		char courseNameArray[] = courseName.toCharArray();
		int count = 0;
		for (char c : courseNameArray) {
			if (c == 'a') {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void TC_03() {
		char courseNameArray[] = courseName.toCharArray();

		for (int i = courseNameArray.length - 1; i >= 0; i--) {
			System.out.print(courseNameArray[i]);
		}
	}
}
