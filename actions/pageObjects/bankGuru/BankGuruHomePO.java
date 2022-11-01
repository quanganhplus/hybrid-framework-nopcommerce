package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.HomePageUI;

public class BankGuruHomePO extends BasePage {
	WebDriver driver;

	public BankGuruHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.WELCOME_MESSAGE);
	}

}
