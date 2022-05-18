package javaBasic;

public class Topic_03_Compare {
	int number = 8;

	public static void main(String[] args) {
		//1 vùng nhớ cho biến x
		int x = 5;
		
		//1 vùng nhớ cho biến y
		int y = x;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		y = 10;
		
		//Kiểu nguyên thủy
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		Topic_03_Compare fistVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = fistVariable;
		
		System.out.println("Before = " + fistVariable.number);
		System.out.println("Before = " + secondVariable.number);
		
		secondVariable.number = 15;
		
		//Kiểu tham chiếu
		System.out.println("After = " + fistVariable.number);
		System.out.println("After = " + secondVariable.number);
		
		
	}

}
