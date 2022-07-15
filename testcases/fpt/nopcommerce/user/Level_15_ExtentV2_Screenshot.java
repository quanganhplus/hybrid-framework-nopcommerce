package fpt.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_15_ExtentV2_Screenshot extends BaseTest {
	private WebDriver driver;
	String firstName, lastName, emailAddress, validPassword;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "quang anh";
		lastName = "trinh";
		emailAddress = "quanganh" + generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
	}

	@Test
	public void User_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.openRegisterPage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
//		registerPage.inputToFistnameTextbox(firstName);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
//		registerPage.inputToLastNameTextbox(lastName);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
//		registerPage.inputToPasswordTextbox(validPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
//		registerPage.inputToConfirmPasswordTextbox(validPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
//		registerPage.clickToRegisterButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed...");
//		ExtentTestManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_02_Login");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
//		homePage = registerPage.clickToLogoutLink();
//		loginPage = homePage.openLoginPage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
//		loginPage.inputToPasswordTextbox(validPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to 'Login' button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
//		customerInfoPage = homePage.openMyAccountPage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Info' page is displayed");
//		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
//		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}