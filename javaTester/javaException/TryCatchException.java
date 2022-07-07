package javaException;

public class TryCatchException {

	public static void main(String[] args) {
		int num = 10;

		try {
			// Đúng: chạy hết đoạn code trong try và ko qua catch
			// Gặp exception - nhảy qua catch
			num = num / 0;
		} catch (Exception e) {
			// e.printStackTrace();
		}

		System.out.println(num);

		String[] browserName = { "Chrome", "FireFox", "Edge" };

		try {
			browserName[0] = "Safari";
			browserName[3] = "Safari";

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String browser : browserName) {
			System.out.println(browser);
		}

		sleepInSecond(5);
	}

	public static void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
