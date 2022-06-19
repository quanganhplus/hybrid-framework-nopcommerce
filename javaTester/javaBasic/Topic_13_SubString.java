package javaBasic;

public class Topic_13_SubString {

	public static void main(String[] args) {
		String fisrtText = "id=Email";
		System.out.println(fisrtText.substring(0, 3));
		System.out.println(fisrtText.substring(3));

		String secondText = "css=input[id='Password']";
		System.out.println(secondText.substring(4));

		String thirdText = "xpath=//button[text()='Log in']";
		System.out.println(thirdText.substring(6));

	}

}
