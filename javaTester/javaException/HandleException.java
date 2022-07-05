package javaException;

public class HandleException {

	public static void main(String[] args) {
		String[] browserName = { "Chrome", "FireFox", "Edge" };
		System.out.println(browserName[0]);
		System.out.println(browserName[1]);
		System.out.println(browserName[2]);

		// System.out.println(browserName[3]);

		int number = 15 / 0;
		System.out.println(number);
	}

}
