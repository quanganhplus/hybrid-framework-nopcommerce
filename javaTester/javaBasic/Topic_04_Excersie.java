package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Excersie {

	@Test
	public void swapNumber(){
		int a = 5;
		int b = 6;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("Sau khi hoán đổi : ");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
