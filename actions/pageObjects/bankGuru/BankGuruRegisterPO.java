package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.RegisterPageUI;

public class BankGuruRegisterPO extends BasePage {
	WebDriver driver;

	public BankGuruRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailIDTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDValue() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getElementText(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordValue() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public BankGuruLoginPO openLoginPage(String loginPageUrl) {
		openPageUrl(driver, loginPageUrl);
		return BankGuruPageGeneratorManager.getBankGuruLoginPage(driver);
	}

}
