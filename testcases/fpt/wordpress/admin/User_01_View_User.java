package fpt.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminUserPO;
import pageObjects.wordpress.admin.PageGeneratorManager;

public class User_01_View_User extends BaseTest {
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminUserPO adminUserPage;

	String adminUsername = "quanganh";
	String adminPassword = "Anh123456";

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin) {
		log.info("Pre-condition - Step 01: Open browser and Admin Url");

		driver = getBrowserDriver(browserName, urlAdmin);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter to Username textbox : " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Enter to Password textbox : " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click to login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_View_User() {
		log.info("View_User - Step 01: Click to 'User' menu link");
		adminUserPage = adminDashboardPage.clickToUserMenuLink();

		log.info("View_User - Step 02: Get all users from UI");
		int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();
		System.out.println("Total number User on UI = " + totalNumberUserAtUI);

		log.info("View_User - Step 03: Get all users from DB");
		int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();
		System.out.println("Total number User on DB = " + totalNumberUserAtDB);

		log.info("View_User - Step 04: Verify Users matching");
		verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}