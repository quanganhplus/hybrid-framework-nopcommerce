package fpt.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "quanganh6789@gmail.com";
		userPassword = "12345678";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// HomePage -> Customer Info
		userCustomerInfoPage = userHomePage.openMyAccountPage();

		// Customer Info -> click Logout -> HomePage
		userHomePage = userCustomerInfoPage.clickToLogoutLinkUserPage(driver);

		// User HomePage -> Open Admin Page -> LoginPage (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		// Dashboard Page -> click logout -> LoginPage (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login Page (Admin) -> open URL USER PAGE -> HomePage (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// HomePage -> LoginPage
		userLoginPage = userHomePage.openLoginPage();

		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {

	}

}