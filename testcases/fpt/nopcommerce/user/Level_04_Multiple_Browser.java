package fpt.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, emailAddress, password, lessCharPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters({ "envName", "serverName", "browser", "browserVersion", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("105") String browserVersion, @Optional("localhost") String ipAddress, @Optional("4444") String port, @Optional("Windows") String osName,
			@Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, browserVersion, ipAddress, port, osName, osVersion);

		homePage = new UserHomePageObject(driver);

		firstName = "quang anh";
		lastName = "trinh";
		invalidEmail = "123@456#%*";
		emailAddress = "quanganh" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		lessCharPassword = "123";
		incorrectPassword = "654321";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click to Register link");
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error message dispalyed");
		Assert.assertEquals(registerPage.getErrorMessageAtFistnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_invalid_Email() {
		System.out.println("Register_02 - Step 01: Click to Register link");
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFistnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(invalidEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - Step 04: Verify error message dispalyed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Success() {
		System.out.println("Register_03 - Step 01: Click to Register link");
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFistnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - Step 04: Verify success message dispalyed");
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");

		System.out.println("Register_03 - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Step 01: Click to Register link");
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_04 - Step 02: Input to required fields");
		registerPage.inputToFistnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 04: Verify error message dispalyed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - Step 01: Click to Register link");
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_05 - Step 02: Input to required fields");
		registerPage.inputToFistnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(lessCharPassword);
		registerPage.inputToConfirmPasswordTextbox(lessCharPassword);

		System.out.println("Register_05 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Step 04: Verify error message dispalyed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - Step 01: Click to Register link");
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_06 - Step 02: Input to required fields");
		registerPage.inputToFistnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(incorrectPassword);

		System.out.println("Register_06 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Step 04: Verify error message dispalyed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}