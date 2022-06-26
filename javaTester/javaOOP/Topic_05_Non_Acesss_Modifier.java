package javaOOP;

public final class Topic_05_Non_Acesss_Modifier {
	// Static: Variable/ Method
	// Dùng cho tất cả instance/ object
	// Phạm vi cho toàn bộ system sử dụng nó
	// Có thể override đc
	static String browserName = "Chrome";

	// Non-static
	String severName = "DEV";

	// Hằng số (Constant : ko đổi)
	final String colorCar = "Black";

	final static String REGISTER_BUTTON = "";

	public static void main(String[] args) {
		System.out.println(browserName);

		browserName = "Safari";
		System.out.println(browserName);

		Topic_05_Non_Acesss_Modifier obj = new Topic_05_Non_Acesss_Modifier();
		System.out.println(obj.severName);

		// ko đc phép gán lại
		System.out.println(obj.colorCar);

		obj.clickToElement("Button");

		sendkeyToElement("quang anh trịnh");
	}

	// Non-static
	public void clickToElement(String elementName) {
		System.out.println(elementName);
	}

	// Static
	public static void sendkeyToElement(String elementName) {
		System.out.println(elementName);
	}

	// Final
	public final void setCarName() {

	}
}
