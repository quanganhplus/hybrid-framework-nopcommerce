package javaBasic;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 10;
		
		number +=5;
		number = number + 5; 
		System.out.println(number);
		
		//20/5 = 4
		System.out.println(number / 5);
		
		//20%9 = 2 dư 2 lấy phần dư
		System.out.println(number % 9);
		
		System.out.println(number++);
		// In number ra trc : 20
		// ++ = tăng number lên 1 = 21
		
		System.out.println(++number);
		// ++ trc: tăng number lên 1 = 22
		// In number ra = 22
		
		System.out.println(number--);
		
		
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}
		
		String address = "Ho Chi Minh";
		if (address != "Ha Noi") {
			System.out.println("Address is the same");
		}
	}

}
