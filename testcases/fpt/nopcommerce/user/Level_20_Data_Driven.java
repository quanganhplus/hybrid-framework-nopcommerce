package fpt.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import fpt.nopcommerce.data.UserDataMapper;

import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_20_Data_Driven extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String emailAddress;
	UserDataMapper userData;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + userData.getFirstName() + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + userData.getLastName() + "'");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + userData.getValidPassword() + "'");
		registerPage.inputToTextboxByID(driver, "Password", userData.getValidPassword());

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + userData.getValidPassword() + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getValidPassword());

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");
		showBrowserConsoleLogs(driver);

		log.info("Register - Step 08: Verify Register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		log.info("Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();
		showBrowserConsoleLogs(driver);

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + userData.getValidPassword() + "'");
		loginPage.inputToTextboxByID(driver, "Password", userData.getValidPassword());

		log.info("Login - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_03_My_Account");
		log.info("MyAccount - Step 01: Navigate to 'My Account' page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("MyAccount - Step 02: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

		log.info("MyAccount - Step 03: Verify 'Fist Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), "123456");

		log.info("MyAccount - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());

		log.info("MyAccount - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}