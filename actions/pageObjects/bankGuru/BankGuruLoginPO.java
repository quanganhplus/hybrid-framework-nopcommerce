package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.LoginPageUI;

public class BankGuruLoginPO extends BasePage {
	WebDriver driver;

	public BankGuruLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageUrl() {

		return getPageUrl(driver);
	}

	public BankGuruRegisterPO clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return BankGuruPageGeneratorManager.getBankGuruRegisterPage(driver);
	}

	public void inputToUserIDTextbox(String userID) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userID);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public BankGuruHomePO clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return BankGuruPageGeneratorManager.getBankGuruHomePage(driver);
	}

}
