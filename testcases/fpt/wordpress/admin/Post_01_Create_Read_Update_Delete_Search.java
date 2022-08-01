package fpt.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageObjects.wordpress.user.UserHomePO;
import pageObjects.wordpress.user.UserPostDetailPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;

	String adminUsername = "quanganh";
	String adminPassword = "Anh123456";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String authorName = "quanganh";
	String urlAdmin, urlUser;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		log.info("Pre-condition - Step 01: Open browser and Admin Url");
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = getBrowserDriver(browserName, this.urlAdmin);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter to Username textbox :" + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Enter to Password textbox :" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click to login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create_Post - Step 02: Get 'Search Post' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create_Post - Step 03: Click to 'Add new' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create_Post - Step 04: Enter to post title :" + postTitle);
		adminPostAddNewPage.enterToPostTitle(postTitle);

		log.info("Create_Post - Step 05: Enter to post body :" + postBody);
		adminPostAddNewPage.enterToPostBody(postBody);

		log.info("Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create_Post - Step 07: Click to 'Pre_Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create_Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPosstPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search_Post - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search_Post - Step 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search_Post - Step 06: Open User Url");
		userHomePage = adminPostSearchPage.openUserUrl(driver, this.urlUser);

		log.info("Search_Post - Step 07: Verify Post info displayed at Home page");
		verifyTrue(userHomePage.isPostInfoDisplayed(postTitle));
		verifyTrue(userHomePage.isPostInfoDisplayed(postBody));
		verifyTrue(userHomePage.isPostInfoDisplayed(authorName));
		verifyTrue(userHomePage.isPostInfoDisplayed(currentDay));

		log.info("Search_Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09: Verify Post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayed(postTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayed(postBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayed(authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayed(currentDay));
	}

	@Test
	public void Post_03_Edit_Post() {

	}

	@Test
	public void Post_04_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}