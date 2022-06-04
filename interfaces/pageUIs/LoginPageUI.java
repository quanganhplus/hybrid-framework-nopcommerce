package pageUIs;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";

	public static final String LOGIN_BUTTON = "//button[contains(text(),'Log in')]";

	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String UNSUCESSFULL_ERROR_MESSAGE = "//div[contains(@class, 'validation-summary-errors')]";
}
