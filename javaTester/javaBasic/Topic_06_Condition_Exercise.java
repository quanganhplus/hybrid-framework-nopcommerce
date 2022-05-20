package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("Số " + number + " là số chẵn");
		} else {
			System.out.println("Số " + number + " là số lẻ");
		}		
	}
	
	//@Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if (numberA > numberB) {
			System.out.println(numberA + " lớn hơn " + numberB);
		} else if (numberA == numberB) {
			System.out.println(numberA + " bằng " + numberB);
		} else{
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}
	}
	
	//@Test
	public void TC_03() {
		String fistStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		
		//Reference: String
		//Kiểm tra cái value của biến
		//Kiểm tra vị trí của biến trong vùng nhớ
		if (fistStudent.equals(secondStudent)) {
			System.out.println("2sv giống tên nhau");
		} else {
			System.out.println("2sv khác tên nhau");
		}
		
		//Kiểu primitive type
		if (fistStudent == secondStudent) {
			System.out.println("2sv giống tên nhau");
		} else {
			System.out.println("2sv khác tên nhau");
		}
	}
	
	//@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC) {
			System.out.println("Số " + numberA + " là số lớn nhất");
		} else if (numberB > numberC) {
			System.out.println("Số " + numberB + " là số lớn nhất");
		} else{
			System.out.println("Số " + numberC + " là số lớn nhất");
		}
	}
	
	//@Test
	public void TC_05() {
		int numberA = scanner.nextInt();
		
		if (numberA > 10 && numberA < 100) {
			System.out.println(numberA + " nằm trong khoảng (10,100)");
		} else {
			System.out.println(numberA + " không nằm khoảng (10,100)");
		}
	}
	
	//@Test
	public void TC_06() {
		float studentPoint = scanner.nextFloat();
		
//		0 < 5       Điểm D
//		5 < 7.5     Điểm C
//		7.5 < 8.5   Điểm B
//		8.5 - 10    Điểm A
		
		if (studentPoint <= 10 && studentPoint >= 8.5) {
			System.out.println("Điểm A");
		} else if (studentPoint < 8.5 && studentPoint >= 7.5) {
			System.out.println("Điểm B");
		} else if (studentPoint < 7.5 && studentPoint >= 5) {
			System.out.println("Điểm C");
		} else{
			System.out.println("Điểm D");
		}
	}
	
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		
		//1 3 5 7 8 10 12
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Tháng này có 31 ngày");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Tháng này có 30 ngày");
		} else if (month == 2) {
			System.out.println("Tháng này có 28 ngày");
		}
	}
}
