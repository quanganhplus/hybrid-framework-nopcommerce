package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Register page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Navigate to Login page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify 'My Account' link to displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Navigate to My Account page")
	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}
}
