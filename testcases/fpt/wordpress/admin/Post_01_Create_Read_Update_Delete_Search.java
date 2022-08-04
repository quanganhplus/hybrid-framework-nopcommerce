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
import pageObjects.wordpress.user.UserSearchPostPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;

	String adminUsername = "quanganh";
	String adminPassword = "Anh123456";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editTitle = "Edit Title " + randomNumber;
	String editBody = "Edit Body " + randomNumber;
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

		log.info("Pre-condition - Step 02: Enter to Username textbox : " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Enter to Password textbox : " + adminPassword);
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
		adminPostAddNewPage.clickToPublishOrUpdateButton();

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
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithAuthorName(postTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithCurrentDay(postTitle, currentDay));

		log.info("Search_Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09: Verify Post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithAuthorName(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithCurrentDay(postTitle, currentDay));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin Url");
		adminDashboardPage = userPostDetailPage.openAdminUrl(driver, this.urlAdmin);

		log.info("Edit_Post - Step 02: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Edit_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Edit_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - Step 05: Click to Post Title link and navigata to Edit Post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - Step 06: Enter to post title : " + editTitle);
		adminPostAddNewPage.enterToPostTitle(editTitle);

		log.info("Edit_Post - Step 07: Enter to post body : " + editBody);
		adminPostAddNewPage.enterToEditBody(editBody);

		log.info("Edit_Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit_Post - Step 10: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPosstPageUrl(searchPostUrl);

		log.info("Edit_Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);

		log.info("Edit_Post - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - Step 13: Verify Search table contains '" + editTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editTitle));

		log.info("Edit_Post - Step 14: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Edit_Post - Step 15: Open User Url");
		userHomePage = adminPostSearchPage.openUserUrl(driver, this.urlUser);

		log.info("Edit_Post - Step 16: Verify Post info displayed at Home page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(editTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(editTitle, editBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithAuthorName(editTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithCurrentDay(editTitle, currentDay));

		log.info("Edit_Post - Step 17: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editTitle);

		log.info("Edit_Post - Step 18: Verify Post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(editTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(editTitle, editBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithAuthorName(editTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithCurrentDay(editTitle, currentDay));
	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin Url");
		adminDashboardPage = userPostDetailPage.openAdminUrl(driver, this.urlAdmin);

		log.info("Delete_Post - Step 02: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Delete_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);

		log.info("Delete_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete_Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editTitle);

		log.info("Delete_Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectTextItemActionDropdown("Move to Trash");

		log.info("Delete_Post - Step 07: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete_Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

		log.info("Delete_Post - Step 09: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);

		log.info("Delete_Post - Step 10: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete_Post - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostsFoundMessageDisplayed("No posts found."));

		log.info("Delete_Post - Step 12: Open User Url");
		userHomePage = adminPostSearchPage.openUserUrl(driver, this.urlUser);

		log.info("Delete_Post - Step 13: Verify Post title undisplayed at Home page");
		verifyTrue(userHomePage.isPostInfoUnDisplayedWithPostTitle(editTitle));

		log.info("Delete_Post - Step 14: Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editTitle);

		log.info("Delete_Post - Step 15: Click to 'Search' button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		log.info("Delete_Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}