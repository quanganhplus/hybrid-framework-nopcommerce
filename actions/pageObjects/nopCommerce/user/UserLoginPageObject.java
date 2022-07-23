package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Enter to Email textbox value is {0}")
	public void inputToEmailTextbox(String emailAdress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}

	@Step("Enter to Password textbox value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Click to login button")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.UNSUCESSFULL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCESSFULL_ERROR_MESSAGE);
	}

	public UserHomePageObject loginAsUser(String emailAdress, String password) {
		inputToEmailTextbox(emailAdress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	public String getPracticeNameTextboxValue() {
		waitForElementVisible(driver, LoginPageUI.STREET_ADDRESS_TEXTBOX);
		return getElementValueByJsXpath(driver, LoginPageUI.STREET_ADDRESS_TEXTBOX);
	}
}
