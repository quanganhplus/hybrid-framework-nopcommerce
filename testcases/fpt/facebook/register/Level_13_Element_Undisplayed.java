package fpt.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;

	LoginPageObject loginPage;

	@Parameters({ "envName", "serverName", "browser", "browserVersion", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("105") String browserVersion, @Optional("localhost") String ipAddress, @Optional("4444") String port, @Optional("Windows") String osName,
			@Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, browserVersion, ipAddress, port, osName, osVersion);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		// Nếu 1 hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
		// waitForElementVisible
		// isElementDisplayed

		// Verify True - mong đợi Confirm Email displayed (true)
		loginPage.enterToEmailAddressTextbox("quanganh.plus@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Nếu như mong đợ 1 hàm vừa verify displayed/ undisplayed thì ko đc phép kết hợp wait
		// isElementDisplayed

		// Verify False - mong đợi Confirm Email là Undisplayed (false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		// Case 2 - Element có trong DOM nhưng ko visible/ displayed
		verifyTrue(loginPage.isConfirmEmailAdressTextboxUnDisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);

		// Khi close popup Register đi thì cái element Confirm Email ko còn trong DOM nữa
		// Nên hàm findElement sẽ bị fail vì ko tìm thấy element
		// 1- Nó sẽ chờ hết timeout của implicit: 30s
		// 2- Nó sẽ đánh fail test case tại đúng step này luôn
		// 3- Ko còn chạy các step còn lại nữa
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		// Case 3 - Element ko có trong DOM
		verifyTrue(loginPage.isConfirmEmailAdressTextboxUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}