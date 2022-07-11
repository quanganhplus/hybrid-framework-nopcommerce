package fpt.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;

	LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		// Nếu 1 hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
		// waitForElementVisible
		// isElementDisplayed
		verifyTrue(loginPage.isEmailAdressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Nếu như mong đợ 1 hàm vừa verify displayed/ undisplayed thì ko đc phép kết hợp wait
		// isElementDisplayed

		// Verify True - mong đợi Confirm Email displayed (true)
		loginPage.enterToEmailAddressTextbox("quanganh.plus@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

		// Verify False - mong đợi Confirm Email là Undisplayed (false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}