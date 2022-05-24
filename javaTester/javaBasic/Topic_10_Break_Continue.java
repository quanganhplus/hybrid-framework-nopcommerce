package javaBasic;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {
		//Nested for
		for (int i = 1; i <= 5; i++) {
			System.out.println("Lần chạy của i (for thứ nhất) = " + i);
			
			//i = 1
			//Mỗi 1 lần chạy của for trên sẽ apply cho tất cả các lần chạy của for dưới này
			for (int j = 1; j <= 5; j++) {
				if (j == 4) {
				continue;
				}
			System.out.println("Lần chạy của j (for thứ 2) = " + j);
			
			for (int x = 1; x <= 5; x++) {
				if (x == 4) {
				continue;
				}
			System.out.println("x = " + x);
		
				}
			}
		}
	}
}