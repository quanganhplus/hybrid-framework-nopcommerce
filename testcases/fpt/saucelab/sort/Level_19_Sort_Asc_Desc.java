package fpt.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelab.sort.AdminLoginPO;
import pageObjects.saucelab.sort.AdminProductsPO;
import pageObjects.saucelab.sort.PageGeneratorManager;

public class Level_19_Sort_Asc_Desc extends BaseTest {
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminProductsPO adminProductsPage;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminLoginPage.enterToUserNameTextbox("standard_user");
		adminLoginPage.enterToUserPasswordTextbox("secret_sauce");
		adminProductsPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		// Ascending
		adminProductsPage.selectItemInProductsSortDropdown("Name (A to Z)");
		adminProductsPage.sleepInSecond(3);
		Assert.assertTrue(adminProductsPage.isProductsNameSortByAscending());

		// Descending
		adminProductsPage.selectItemInProductsSortDropdown("Name (Z to A)");
		adminProductsPage.sleepInSecond(3);
		Assert.assertTrue(adminProductsPage.isProductsNameSortByDescending());
	}

	@Test
	public void Sort_02_Price() {
		// Ascending
		adminProductsPage.selectItemInProductsSortDropdown("Price (low to high)");
		adminProductsPage.sleepInSecond(3);
		Assert.assertTrue(adminProductsPage.isProductsPriceSortByAscending());

		// Descending
		adminProductsPage.selectItemInProductsSortDropdown("Price (high to low)");
		adminProductsPage.sleepInSecond(3);
		Assert.assertTrue(adminProductsPage.isProductsPriceSortByDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowserAndDriver();
	}

}