package javaBasic;

public class Topic_15_StringFormat {

	public static void main(String[] args) {
		String text = String.format("xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']", "Customer info");
		System.out.println(text);
	}

}
