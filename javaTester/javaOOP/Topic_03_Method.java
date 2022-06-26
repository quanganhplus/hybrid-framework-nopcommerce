package javaOOP;

public class Topic_03_Method {
	// Non-static
	void showCarName() {
		System.out.println("Vinfast");
	}

	static void showCarColor() {
		System.out.println("White");
	}

	public static void main(String[] args) {
		// Gọi vào trong 1 hàm static khác đc
		showCarColor();

		// Gọi qua instance/ object
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName();

		// static way
		Topic_03_Method.showCarColor();
	}

}
