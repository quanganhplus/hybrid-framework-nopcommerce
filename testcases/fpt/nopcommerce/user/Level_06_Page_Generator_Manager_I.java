package fpt.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, validEmail, validPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		// 1
		homePage = new UserHomePageObject(driver);

		firstName = "quang anh";
		lastName = "trinh";
		invalidEmail = "123@456#%*";
		validEmail = "quanganh" + generateFakeNumber() + "@gmail.com";
		notFoundEmail = "quanganh" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		incorrectPassword = "654321";

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.openRegisterPage();

		// 2
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFistnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message dispalyed");
		Assert.assertEquals(registerPage.getRegisterSucessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();

		// Click logout thì bussiness nó sẽ quay về homePage
		// 3
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();

		// 4
		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();

		// 5
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.openLoginPage();

		// 6
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Emty_Password() {
		homePage.openLoginPage();

		// 7
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.openLoginPage();

		// 8
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);

		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.openLoginPage();

		// 9
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);

		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();

		// 10
		homePage = new UserHomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {

	}

}