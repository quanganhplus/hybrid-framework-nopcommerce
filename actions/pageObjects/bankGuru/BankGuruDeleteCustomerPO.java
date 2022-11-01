package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class BankGuruDeleteCustomerPO extends BasePage {
	WebDriver driver;

	public BankGuruDeleteCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public BankGuruLoginPO clickToLogoutLink() {
		// wait
		// click
		// accept
		return BankGuruPageGeneratorManager.getBankGuruLoginPage(driver);
	}

}
